package com.example.secretpigeon.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class FormVo {
    /**
     * 提交路径
     */
    private String path;
    private String text;
    /**
     * 类型
     */
    private List<FormInputVo> inputs = new ArrayList<>();

    public FormVo addInputs(FormInputVo input) {
        this.inputs.add(input);
        return this;
    }
}
