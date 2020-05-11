package com.example.secretpigeon.unit;

import com.example.secretpigeon.communication.dto.Handshake;
import com.example.secretpigeon.config.AppConfig;
import com.example.secretpigeon.entity.KeyPairEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.net.*;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Base64;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IpUtil {
    public static List<String> getMyAllIp() {
        List<String> ipAll = new LinkedList<>();
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress address = addresses.nextElement();
                    if (!address.isLoopbackAddress() && address.isSiteLocalAddress()) {
                        ipAll.add(address.getHostAddress());
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return ipAll;
    }

    /**
     * 广播
     */
    @SneakyThrows
    public static void broadcast(Handshake handshake) {
        ObjectMapper objectMapper = new ObjectMapper();
        String msg = objectMapper.writeValueAsString(handshake);

        InetAddress addr = InetAddress.getByName("255.255.255.255");

        byte[] message = msg.getBytes();

        try (DatagramSocket socket = new DatagramSocket()) {
            socket.setBroadcast(true);
            for (int port = AppConfig.udpPortStart; port < AppConfig.udpPortEnd; port++) {
                socket.send(new DatagramPacket(message, message.length, addr, port));
                // System.out.println("Broadcast message sent.");
            }

        }
    }

}
