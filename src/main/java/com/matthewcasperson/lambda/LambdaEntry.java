package com.matthewcasperson.lambda;

import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.services.lambda.runtime.Context;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class LambdaEntry extends RequestHandler2 {
    private static final String CHROME_HEADLESS_PACKAGE = "https://s3.amazonaws.com/webdriver-tests/headless-chromium-64.0.3242.2-amazonlinux-2017-03.zip";
    private static final String CHROME_DRIVER = "https://s3.amazonaws.com/webdriver-tests/chromedriver_linux64.zip";

    public boolean runCucumber(String feature, Context context) throws Throwable {

        final File chromeDirectory = downloadChromeHeadless();
        final File driverDirectory = downloadChromeDriver();

        try {
            final File featureFile = writeFeatureToFile(feature);
            return cucumber.api.cli.Main.run(
                    new String[]{"--glue", "com.matthewcasperson.decoratorbase", featureFile.getAbsolutePath()},
                    Thread.currentThread().getContextClassLoader()) == 0;
        } finally {
            FileUtils.deleteQuietly(driverDirectory);
            FileUtils.deleteQuietly(chromeDirectory);
        }
    }

    private File downloadChromeDriver() throws IOException {
        final File downloadedFile = File.createTempFile("chrome_driver", ".zip");
        try {
            FileUtils.copyURLToFile(new URL(CHROME_DRIVER), downloadedFile);
            final File extractedDir = Files.createTempDirectory("chrome_driver").toFile();
            unzipFile(downloadedFile.getAbsolutePath(), extractedDir.getAbsolutePath());
            System.setProperty("webdriver.chrome.driver", extractedDir.getAbsolutePath() + "/chromedriver");
            new File(extractedDir.getAbsolutePath() + "/chromedriver").setExecutable(true);
            return extractedDir;
        } finally {
            FileUtils.deleteQuietly(downloadedFile);
        }

    }

    private File downloadChromeHeadless() throws IOException {
        final File downloadedFile = File.createTempFile("chrome_headless", ".zip");
        try {
            FileUtils.copyURLToFile(new URL(CHROME_HEADLESS_PACKAGE), downloadedFile);
            final File extractedDir = Files.createTempDirectory("chrome_headless").toFile();
            unzipFile(downloadedFile.getAbsolutePath(), extractedDir.getAbsolutePath());
            System.setProperty("chrome.binary", extractedDir.getAbsolutePath() + "/headless_shell");
            new File(extractedDir.getAbsolutePath() + "/headless_shell").setExecutable(true);
            return extractedDir;
        } finally {
            FileUtils.deleteQuietly(downloadedFile);
        }
    }

    /**
     * http://www.baeldung.com/java-compress-and-uncompress
     */
    private void unzipFile(String fileZip, String outputDirectory) throws IOException {
        final byte[] buffer = new byte[1024];
        try (final ZipInputStream zis = new ZipInputStream(new FileInputStream(fileZip))) {
            ZipEntry zipEntry = zis.getNextEntry();
            while (zipEntry != null) {
                final String fileName = zipEntry.getName();
                final File newFile = new File(outputDirectory + "/" + fileName);
                try (final FileOutputStream fos = new FileOutputStream(newFile)) {
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                }
                zipEntry = zis.getNextEntry();
            }
            zis.closeEntry();
        }
    }

    private File writeFeatureToFile(String feature) throws IOException {
        final File featureFile = File.createTempFile("cucumber", ".feature");
        try {
            final URL url = new URL(feature);
            FileUtils.copyURLToFile(url, featureFile);
        } catch (final MalformedURLException ex) {
            try (PrintWriter out = new PrintWriter(featureFile)) {
                out.println(feature);
            }
        }

        return featureFile;
    }
}
