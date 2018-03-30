package com.matthewcasperson.decorators;

import com.matthewcasperson.AutomatedBrowser;
import com.matthewcasperson.AutomatedBrowserDecorator;
import com.matthewcasperson.exceptions.SaveException;
import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.regex.Pattern;

public class BrowserMobDecorator extends AutomatedBrowserDecorator {

    private BrowserMobProxy proxy;

    public BrowserMobDecorator(final AutomatedBrowser automatedBrowser) {
        super(automatedBrowser);
    }

    @Override
    public DesiredCapabilities getDesiredCapabilities() {
        proxy = new BrowserMobProxyServer();
        proxy.start(0);

        final DesiredCapabilities desiredCapabilities = automatedBrowser.getDesiredCapabilities();

        final Proxy seleniumProxy = new Proxy();
        final String proxyStr = "localhost:" + proxy.getPort();

        seleniumProxy.setHttpProxy(proxyStr);
        seleniumProxy.setSslProxy(proxyStr);

        desiredCapabilities.setCapability(CapabilityType.PROXY, seleniumProxy);

        return desiredCapabilities;
    }

    @Override
    public void destroy() {
        automatedBrowser.destroy();
        if (proxy != null) {
            proxy.stop();
        }
    }

    @Override
    public void alterRequestTo(String url, int responseCode) {
        proxy.addRequestFilter((request, contents, messageInfo) -> {
            if (Pattern.compile(url).matcher(messageInfo.getOriginalUrl()).matches()) {
                return new DefaultHttpResponse(request.getProtocolVersion(), HttpResponseStatus.valueOf(responseCode));
            }

            return null;
        });

        automatedBrowser.alterRequestTo(url, responseCode);
    }

    @Override
    public void captureHarFile() {
        proxy.newHar();
    }

    @Override
    public void saveHarFile(String file) {
        try {
            proxy.getHar().writeTo(new File(file));
        } catch (final IOException ex) {
            throw new SaveException(ex);
        }
    }
}
