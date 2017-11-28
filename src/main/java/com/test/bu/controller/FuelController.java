package com.test.bu.controller;

import com.test.bu.entity.Fuel;
import com.test.bu.service.interfaces.FuelService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/fuel")
public class FuelController {

    private static final Logger logger = Logger.getLogger(FuelController.class);

    @Autowired
    FuelService fuelService;

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") int id, @RequestParam(value = "edit", required = false) boolean edit, Model model) {
        model.addAttribute("fuel", fuelService.findById(id));
        if (edit) {
            return "fuelEdit";
        } else {
            return "fuelShow";
        }
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("fuel", fuelService.findAll());
        return "fuelList";
    }

    @GetMapping("/create")
    public String createPage() {
        return "fuelCreateForm";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Fuel fuel) {
        fuelService.save(fuel);
        return "redirect:all";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Fuel fuel) {
        fuelService.save(fuel);
        return "redirect:" + fuel.getFuelType() + "?edit=false";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        fuelService.delete(id);
        return "redirect:/all";
    }
}
