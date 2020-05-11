package com.example.secretpigeon.communication;

import com.example.secretpigeon.communication.dto.Handshake;
import com.example.secretpigeon.config.AppConfig;
import com.example.secretpigeon.entity.FriendAddressEntity;
import com.example.secretpigeon.service.FriendService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Objects;

@Component
@AllArgsConstructor
public class UDPApplication implements CommandLineRunner {

    private final FriendService friendService;

    public void run(String... args) {
        Thread.startVirtualThread(() -> {
            int i = AppConfig.udpPortStart;
            boolean exception;
            do {
                exception = false;
                i = i++ < AppConfig.udpPortEnd ? i + 1 : AppConfig.udpPortStart;
                try {
                    this.udp(i);
                } catch (SocketException e) {
                    exception = true;
                }
                AppConfig.setUdpPort(i);
            } while (exception);
        });
    }

    public void udp(int port) throws SocketException {
        try (DatagramSocket socket = new DatagramSocket(port)) {
            while (true) {
                DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
                try {
                    socket.receive(packet);
                } catch (IOException e) {
                    return;
                }
                this.aaaaaa(packet);
            }
        }
    }

    /**
     * 处理udp接受到的信息
     */
    private void aaaaaa(DatagramPacket packet) {
        String message = new String(packet.getData(), 0, packet.getLength());
        String address = packet.getAddress().getHostAddress();

        ObjectMapper objectMapper = new ObjectMapper();
        Thread.startVirtualThread(() -> {
            Handshake handshake;
            try {
                handshake = objectMapper.readValue(message, Handshake.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            if (Objects.equals(AppConfig.getHash(), handshake.getHash())) {
                return;
            }
            FriendAddressEntity address1 = new FriendAddressEntity().setAddress(address).setPort(handshake.getUdpPort());
            friendService.address(handshake.getHash(), address1);
        });
    }
}
