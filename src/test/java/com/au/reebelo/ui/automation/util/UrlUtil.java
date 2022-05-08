package com.au.reebelo.ui.automation.util;


import org.apache.http.client.utils.URIBuilder;
import java.net.URISyntaxException;

public class UrlUtil {

    public static String cleanUrl(String malformedUrl) {
        try {
            URIBuilder uriBuilder = new URIBuilder(malformedUrl);
            return new URIBuilder()
                    .setScheme(uriBuilder.getScheme())
                    .setPort(uriBuilder.getPort())
                    .setHost(uriBuilder.getHost())
                    .setPath(uriBuilder.getPath())
                    .addParameters(uriBuilder.getQueryParams())
                    .build().toString();

        } catch (URISyntaxException ex) {
            System.err.printf("Unable to form url: %s%n", malformedUrl);
        }
        return malformedUrl;

    }

}
