package com.example.secretpigeon.controler;

import com.example.secretpigeon.service.FriendService;
import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 好友管理
 */
@Log4j2
@Controller
@RequestMapping("/friend")
public class FriendController {

    @Resource
    private FriendService friendService;

    @GetMapping("index.html")
    public String index(Model model,
                        @RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "10") int size,
                        String name) {
        model.addAttribute("dataPage", friendService.list(page, size, name));
        return "friend/index";
    }

    @PostMapping("/add")
    @ResponseBody
    public Object create(String hash) {
        friendService.add(hash);
        return null;
    }

    @PostMapping("/update")
    @ResponseBody
    public Object update(String id) {
        friendService.connect(id);
        return "正在更新中，请稍等";
    }

    @PostMapping("/del")
    @ResponseBody
    public Object del(String id) {
        return null;
    }
}
