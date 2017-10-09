package com.test.bu.controller;

import com.test.bu.entity.Fuel;
import com.test.bu.service.interfaces.FuelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/fuel")
public class FuelController {
    @Autowired
    FuelService fuelService;

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") int id, @RequestParam(value = "edit", required = false) boolean edit, Model model) {
        model.addAttribute("fuelList", fuelService.getById(id));
        if (edit) {
            return "editFuel";
        } else {
            return "showFuel";
        }
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("fuelList", fuelService.getAll());
        return "fuelList";
    }

    @GetMapping("/create")
    public String createPage() {
        return "createFuelForm";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Fuel fuel) {
        fuelService.save(fuel);
        return "redirect:all";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Fuel fuel) {
        fuelService.update(fuel);
        return "redirect:" + fuel.getFuelType() + "?edit=false";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        fuelService.delete(id);
        return "redirect:all";
    }
}
