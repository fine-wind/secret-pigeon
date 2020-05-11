package com.example.secretpigeon.config;

public class AppConfig {
    /**
     * 当前账户唯一标识
     */
    private static String hash;
    private static Integer udpPort;
    public final static int udpPortStart = 49999;
    public final static int udpPortEnd = 59999;

    public static String getHash() {
        return hash;
    }

    public static void setHash(String hash) {
        AppConfig.hash = hash;
    }

    public static Integer getUdpPort() {
        return udpPort;
    }

    public static void setUdpPort(Integer udpPort) {
        AppConfig.udpPort = udpPort;
    }
}
