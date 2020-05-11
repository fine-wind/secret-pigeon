package com.example.secretpigeon.vo;

import com.example.secretpigeon.enums.FormInputEnum;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class FormInputVo {
    /**
     * 显示值
     */
    private String title;
    /**
     * 名称
     */
    private String name;
    /**
     * 类型
     */
    private String type;
    /**
     * 默认值
     */
    private String value;

    public FormInputVo(String title, String name, FormInputEnum type, String value) {
        this.title = title;
        this.name = name;
        this.type = type.getCode();
        this.value = value;
    }
}
