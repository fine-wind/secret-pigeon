package com.example.secretpigeon.enums;

import lombok.Getter;

public enum FormInputEnum {
    text("text"),
    number("number"),
    ;
    @Getter
    final String code;

    FormInputEnum(String code) {
        this.code = code;
    }
}
