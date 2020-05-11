package com.example.secretpigeon.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.Objects;

/**
 * 聊天分组
 */
@Data
@Entity
@Accessors(chain = true)
@Table(indexes = {
        @Index(columnList = "sort"),
})
public class GroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    /**
     * 分组名称
     */
    private String name;
    /**
     * 所有者
     */
    private String main;

    /**
     * 各自服务的分组排序
     */
    private Long sort;
    /**
     * 分组版本
     */
    private Date version;

    public GroupEntity addVersion() {
        this.version = new Date();
        return this;
    }
}
