package com.test.bu.controller;

import com.test.bu.entity.Vehicle;
import com.test.bu.service.interfaces.VehicleService;
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
@RequestMapping("/vehicle")
public class VehicleController {

    private static final Logger logger = Logger.getLogger(VehicleController.class);

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") int id, @RequestParam(value = "edit", required = false) boolean edit, Model model) {
        model.addAttribute("vehicle", vehicleService.findById(id));
        if (edit) {
            return "vehicleEdit";
        } else {
            return "vehicleShow";
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
            Page<Vehicle> pages = vehicleService.findAll(page, size, order);
            totalPages = pages.getTotalPages();
            model.addAttribute("total", totalPages);
            model.addAttribute("users", pages.getContent());
        } else if (!StringUtils.isEmpty(order)) {
            model.addAttribute("vehicle", vehicleService.findAll(0, 100, order).getContent());
        } else {
            Collection<Vehicle> all = vehicleService.findAll();
            model.addAttribute("vehicle", all);
            totalPages = all.size() / 2;
        }
        List<Integer> pagesCount = new ArrayList<>();
        for (int i = 0; i < totalPages; i++) {
            pagesCount.add(i);
        }
        model.addAttribute("pages", pagesCount);
        return "vehicleList";
    }

    @GetMapping("/create")
    public String createPage() {
        return "vehicleCreateForm";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:all";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:" + vehicle.getId() + "?edit=false";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        vehicleService.delete(id);
        return "redirect:all";
    }
}
