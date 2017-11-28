package com.test.bu.controller;

import com.test.bu.entity.Driver;
import com.test.bu.service.interfaces.DriverService;
import com.test.bu.utils.Utils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/driver")
public class DriverController {

    private static final Logger logger = Logger.getLogger(DriverController.class);

    @Autowired
    private DriverService driverService;

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") int id, Model model) {
        model.addAttribute("driver", driverService.findById(id));
            return "driverEdit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Driver driver) {
        driverService.save(driver);
        return "redirect:/driver/all";
    }

    @GetMapping("/all")
    public String getAll(Model model,
                         @RequestParam(value = "page", required = false) Integer page,
                         @RequestParam(value = "size", required = false) Integer size,
                         @RequestParam(value = "order", required = false) String order) {
        int totalPages = 0;
        if (page != null) {
            size = 4;
            Page<Driver> pages = driverService.findAll(page, size, order);
            totalPages = pages.getTotalPages();
            model.addAttribute("total", totalPages);
            model.addAttribute("users", pages.getContent());
        } else if (!StringUtils.isEmpty(order)) {
            model.addAttribute("driver", driverService.findAll(0, 100, order).getContent());
        } else {
            Collection<Driver> all = driverService.findAll();
            model.addAttribute("driver", all);
            totalPages = all.size() / 2;
        }
        List<Integer> pagesCount = new ArrayList<>();
        for (int i = 0; i < totalPages; i++) {
            pagesCount.add(i);
        }
        model.addAttribute("pages", pagesCount);
        return "driverList";
    }

    @GetMapping("/create")
    public String createPage(@RequestParam(value = "message", required = false) String message,
                             Model model) {
        if (message != null) {
            model.addAttribute("message", message);
        }
        return "driverCreateForm";
    }

    @PostMapping("/create")
    public String createDriver(@ModelAttribute Driver driver, Model model) {
        List<String> errors = Utils.validate(driver);
        if (!errors.isEmpty()) {
            model.addAttribute("errors", errors);
            return "driverCreateForm";
        }
        driverService.save(driver);
        return "redirect:all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        driverService.delete(id);
        return "redirect:/driver/all";
    }


}
