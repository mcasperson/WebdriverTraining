package com.matthewcasperson.decorators;

import com.matthewcasperson.AutomatedBrowser;
import com.matthewcasperson.AutomatedBrowserDecorator;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

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

        final Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
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
                return new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.valueOf(responseCode));
            }

            return null;
        });

        automatedBrowser.alterRequestTo(url, responseCode);
    }
}
