package com.example.secretpigeon.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 密钥信息
 */
@Data
@Entity
@Table(indexes = {
        @Index(columnList = "hash"),
})
@Accessors(chain = true)
public class KeyPairEntity {

    @Id
    private String id;
    /**
     * todo 这个的作用
     */
    private Date dt;
    /**
     * 公钥
     */
    @Column(columnDefinition = "text")
    private String publicKey;
    /**
     * 私钥
     */
    @Column(columnDefinition = "text")
    private String privateKey;
    /**
     * 名称
     */
    private String name;
    /**
     * 唯一hash
     */
    private String hash;
}
