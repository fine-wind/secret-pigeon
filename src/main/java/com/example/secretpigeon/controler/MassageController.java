package com.example.secretpigeon.controler;

import com.example.secretpigeon.service.AccountService;
import com.example.secretpigeon.service.ManageService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/massage")
public class MassageController {

    @Resource
    private ManageService manageService;
    @Resource
    private AccountService accountService;

    @GetMapping("/{group}/{id}")
    public String massage(@PathVariable("group") String group, @PathVariable("id") String myId, Model model) {
        model.addAttribute("groupList", manageService.myGroupAll());
        model.addAttribute("myAccountList", accountService.my());
        model.addAttribute("massageList", manageService.group(1, group, myId));
        return "massage/index";
    }

    /**
     * 发送信息
     */
    @PostMapping("/send/massage/{group}/{me}")
    @ResponseBody
    public String send(@PathVariable("group") String group, @PathVariable("me") String me, @RequestBody String msg) {
        manageService.sendMsg(me, group, msg);
        return "success";
    }

    /**
     * 其他人获取信息
     */
    @GetMapping("/getGroup")
    @ResponseBody
    public Map<String, Date> get(@RequestParam(defaultValue = "") String[] groups) {
        return manageService.getGroup(groups);
    }
}
