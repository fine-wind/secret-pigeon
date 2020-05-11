package com.example.secretpigeon.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 好友地址
 */
@Entity
@Data
@Accessors(chain = true)
@Table(indexes = {
        @Index(columnList = "fid"),
})
public class FriendAddressEntity {
    /**
     * 是好友的md5
     * {@link KeyPairEntity#getHash()} ()}
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    /**
     * {@link FriendEntity#getId()}
     */
    private String fid;
    /**
     * 通讯地址
     */
    private String address;
    /**
     * 通讯端口
     */
    private Integer port;

}
