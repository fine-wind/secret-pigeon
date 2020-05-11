package com.example.secretpigeon.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/file")
public class FileController {
    @GetMapping("index.html")
    public String index() {
        return "file/index";
    }

    @GetMapping("/{path}.html")
    public String massage(@PathVariable("path") String path) {
        return path;
    }
}
