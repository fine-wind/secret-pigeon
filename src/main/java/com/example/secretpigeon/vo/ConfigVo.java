package com.example.secretpigeon.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class ConfigVo {
    private String name;
    private String path;
    private FormVo form = new FormVo();
    /**
     * 操作
     */
    private List<OperateVo> operate = new ArrayList<>();


    public ConfigVo(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public ConfigVo addOperate(OperateVo operate) {
        this.operate.add(operate);
        return this;
    }
}
