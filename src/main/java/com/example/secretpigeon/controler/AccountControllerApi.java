package com.example.secretpigeon.controler;

import com.example.secretpigeon.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(AccountControllerApi.BASE_PATH)
public class AccountControllerApi {

    public final static String BASE_PATH = "/account";
    public final static String INDEX_HTML = "/index.html";
    public final static String INDEX_HTML_MAPPING = BASE_PATH + INDEX_HTML;

    @Resource
    private AccountService accountService;

    @GetMapping(INDEX_HTML)
    public String account(Model model) {
        model.addAttribute("myAccount", accountService.my());
        return "account/index";
    }

    @PostMapping("/my/update")
    @ResponseBody
    public Object create(String name) {
        accountService.update(name);
        return null;
    }
}
