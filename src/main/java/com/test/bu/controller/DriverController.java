package com.test.bu.controller;

import com.test.bu.entity.Driver;
import com.test.bu.service.interfaces.DriverService;
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
    public String getById(@PathVariable("id") int id, @RequestParam(value = "edit", required = false) boolean edit, Model model) {
        model.addAttribute("driver", driverService.findById(id));
        if (edit) {
            return "driverEdit";
        } else {
            return "driverShow";
        }
    }

    @GetMapping("/all")
    public String getAll(Model model,
                         @RequestParam(value = "page", required = false) Integer page,
                         @RequestParam(value = "size", required = false) Integer size,
                         @RequestParam(value = "order", required = false) String order) {
        int totalPages = 0;
        if (page != null) {
            size = 10;
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
        driverService.save(driver);
        return "redirect:" + driver.getId() + "?edit=false";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        driverService.delete(id);
        return "redirect:all";
    }


}
