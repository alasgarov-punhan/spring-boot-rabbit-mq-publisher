package com.codelearning.springrabbitmq.util;

public enum  Constants {

    EXCHANGE("direct-exchange"),
    ROUTING_KEY("user");

    private final String keyString;

    Constants(String keyString) {
        this.keyString = keyString;
    }

    public String get() {
        return keyString;
    }
}
