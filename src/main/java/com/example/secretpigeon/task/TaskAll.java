package com.example.secretpigeon.task;

import com.example.secretpigeon.communication.dto.Handshake;
import com.example.secretpigeon.config.AppConfig;
import com.example.secretpigeon.service.AccountService;
import com.example.secretpigeon.unit.IpUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Slf4j()
@Component
@AllArgsConstructor
public class TaskAll {
    @Scheduled(cron = "0/5 * * * * ?")
    public void uploadConnectionInformation() {
//        ServerProperties bean = SecretPigeonApplication.getRun().getBean(ServerProperties.class);
//        bean.getPort();

//        List<String> myAllIp = IpUtil.getMyAllIp();
        // todo 向公共地址发送本机的连接方式
//        myAllIp.forEach(log::debug);

        Handshake handshake = new Handshake();

        handshake.setHash(AppConfig.getHash()).setUdpPort(AppConfig.getUdpPort());

        IpUtil.broadcast(handshake);
        System.out.println("1111112121--------");
    }

}
