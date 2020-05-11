package com.example.secretpigeon;

import com.example.secretpigeon.communication.UDPApplication;
import com.example.secretpigeon.entity.KeyPairEntity;
import com.example.secretpigeon.service.AccountService;
import lombok.Getter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SecretPigeonApplication {
    @Getter
    private static ConfigurableApplicationContext run;

    public static void main(String[] args) {
        run = SpringApplication.run(SecretPigeonApplication.class, args);
        run.getBean(AccountService.class).create(3000, new KeyPairEntity());
    }

}
