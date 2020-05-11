package com.example.secretpigeon.unit;

import com.example.secretpigeon.entity.KeyPairEntity;
import lombok.SneakyThrows;
import org.springframework.util.DigestUtils;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.util.Base64;

public class KeyPairUtil {
    @SneakyThrows
    public static KeyPairEntity create(int keySize) {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(Math.max(keySize, 1024)); // 设置密钥长度
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        String publicKey = Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded());
        String privateKey = Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded());

        return new KeyPairEntity()
                .setPublicKey(publicKey)
                .setPrivateKey(privateKey)
                ;
    }

//    @SneakyThrows
//    public static void en(int keysize) {
//        String plainText = "Hello, world!";
//        Cipher cipher = Cipher.getInstance("RSA");
//        cipher.init(Cipher.ENCRYPT_MODE, new byte[]{});
//        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
//    }
//
//    @SneakyThrows
//    public static void de() {
//        Cipher cipher = Cipher.getInstance("RSA");
//        cipher.init(Cipher.DECRYPT_MODE, "privateKey");
//        byte[] decryptedBytes = cipher.doFinal(new byte[]{});
//        String decryptedText = new String(decryptedBytes);
//    }
}
