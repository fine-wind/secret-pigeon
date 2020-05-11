package com.example.secretpigeon.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class OperateVo {
    private String name;
    private String path;

    public OperateVo(String name, String path) {
        this.name = name;
        this.path = path;
    }
}
