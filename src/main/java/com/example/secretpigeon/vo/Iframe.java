package com.example.secretpigeon.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class Iframe {
    private String name;
    private String path;

    public Iframe(String name, String path) {
        this.name = name;
        this.path = path;
    }
}
