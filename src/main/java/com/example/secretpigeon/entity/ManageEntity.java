package com.example.secretpigeon.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 消息实体
 */
@Entity
@Data
@Accessors(chain = true)
@Table(indexes = {
        @Index(columnList = "come"),
        @Index(columnList = "sort"),
        @Index(columnList = "sendDt"),
        @Index(columnList = "toDt"),
})
public class ManageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    /**
     * 分组id
     */
    private String g;
    private String come;
    /**
     * 发送人的sort
     */
    private Long sort;
    /**
     * 消息发送时间
     */
    private Date sendDt;
    /**
     * 此消息入本地库的时间
     */
    private Date toDt;
    /**
     * 消息
     */
    private String msg;
    /**
     * 文件路径
     */
    private String path;
}
