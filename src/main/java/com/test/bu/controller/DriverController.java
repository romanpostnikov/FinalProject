package com.test.bu.controller;

import com.test.bu.entity.Driver;
import com.test.bu.service.interfaces.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") int id, @RequestParam(value = "edit", required = false) boolean edit, Model model) {
        model.addAttribute("driverList", driverService.getById(id));
        if (edit) {
            return "driverEdit";
        } else {
            return "driverShow";
        }
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("driverList", driverService.getAll());
        return "driverList";
    }

    @GetMapping("/create")
    public String createPage() {
        return "driverCreateForm";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Driver driver) {
        driverService.save(driver);
        return "redirect:all";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Driver driver) {
        driverService.update(driver);
        return "redirect:" + driver.getId() + "?edit=false";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        driverService.delete(id);
        return "redirect:all";
    }


}
