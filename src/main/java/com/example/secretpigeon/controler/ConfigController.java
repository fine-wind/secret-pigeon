package com.example.secretpigeon.controler;

import com.example.secretpigeon.enums.FormInputEnum;
import com.example.secretpigeon.service.AccountService;
import com.example.secretpigeon.service.ManageService;
import com.example.secretpigeon.vo.*;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/config")
public class ConfigController {

    @Resource
    private AccountService accountService;

    @Resource
    private ManageService manageService;

    @GetMapping("index.html")
    public String index(Model model) {
        model.addAttribute("dataList", accountService.my());
        ArrayList<Iframe> attributeValue = new ArrayList<>();
        attributeValue.add(new Iframe("我的账号", AccountControllerApi.INDEX_HTML_MAPPING));
        attributeValue.add(new Iframe("系统配置", "/config/sys.html"));
        model.addAttribute("menus", attributeValue);

        return "config/index";
    }

    //    @GetMapping("group.html")
//    @GetMapping("index.html")
    @GetMapping("sys.html")
    public String sys(Model model) {
        model.addAttribute("dataList", accountService.my());
        return "config/sys";
    }


}
