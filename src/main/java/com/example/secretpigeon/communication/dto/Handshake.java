package com.example.secretpigeon.communication.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Handshake {
    /**
     * 用户全球唯一标识
     */
    private String hash;
    private Integer udpPort;
    /**
     * 当前的软件版本
     */
    private String appVersion;
}
