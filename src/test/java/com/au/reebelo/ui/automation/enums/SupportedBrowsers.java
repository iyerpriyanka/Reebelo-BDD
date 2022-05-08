package com.au.reebelo.ui.automation.enums;


public enum SupportedBrowsers {

    CHROME("chrome"),

    IE("ie"),

    FIREFOX("firefox"),

    SAFARI("safari");

    final String name;

    String getName() {
        return this.name;
    }

    SupportedBrowsers(String name) {
        this.name = name;
    }

    public static SupportedBrowsers getBrowser(String name) {
        for (SupportedBrowsers sb : values()) {
            if (sb.getName().equalsIgnoreCase(name)) {
                return sb;
            }
        }
        return null;
    }

}
