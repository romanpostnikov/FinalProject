package com.test.bu.controller;

import com.test.bu.entity.User;
import com.test.bu.service.interfaces.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") int id, @RequestParam(value = "edit", required = false) boolean edit, Model model) {
        model.addAttribute("user", userService.findById(id));
        if (edit) {
            return "userEdit";
        } else {
            return "userShow";
        }
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("user", userService.findAll());
        return "userList";
    }

    @GetMapping("/create")
    public String createPage() {
        return "userCreateForm";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:all";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:" + user.getUsername() + "?edit=false";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        userService.delete(id);
        return "redirect:all";
    }
}
