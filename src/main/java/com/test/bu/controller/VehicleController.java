package com.test.bu.controller;

import com.test.bu.entity.Vehicle;
import com.test.bu.service.interfaces.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    VehicleService vehicleService;

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") int id, @RequestParam(value = "edit", required = false) boolean edit, Model model) {
        model.addAttribute("vehicleList", vehicleService.getById(id));
        if (edit) {
            return "editVehicle";
        } else {
            return "showVehicle";
        }
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("vehicleList", vehicleService.getAll());
        return "vehicleList";
    }

    @GetMapping("/create")
    public String createPage() {
        return "createVehicleForm";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:all";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Vehicle vehicle) {
        vehicleService.update(vehicle);
        return "redirect:" + vehicle.getId() + "?edit=false";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        vehicleService.delete(id);
        return "redirect:all";
    }
}
