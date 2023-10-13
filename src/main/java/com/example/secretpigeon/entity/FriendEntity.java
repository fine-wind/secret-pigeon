package com.example.secretpigeon.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 好友
 */
@Entity
@Data
@Table(indexes = {
        @Index(columnList = "id"),
})
@Accessors(chain = true)
public class FriendEntity {
    /**
     * 是好友的哈希
     * {@link KeyPairEntity#getHash()}
     */
    @Id
    private String id;
    /**
     * 名称
     */
    private String name;
    /**
     * 用户的version
     */
    private Date version;
    /**
     * 公钥
     */
    @Column(columnDefinition = "text")
    private String publicKey;

}
