package com.test.bu.controller;

import com.test.bu.entity.Trip;
import com.test.bu.service.interfaces.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/trip")
public class TripController {
    @Autowired
    TripService tripService;

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") int id, @RequestParam(value = "edit", required = false) boolean edit, Model model) {
        model.addAttribute("tripList", tripService.getById(id));
        if (edit) {
            return "tripEdit";
        } else {
            return "tripShow";
        }
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("tripList", tripService.getAll());
        return "tripList";
    }

    @GetMapping("/create")
    public String createPage() {
        return "tripCreateForm";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Trip trip) {
        tripService.save(trip);
        return "redirect:all";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Trip trip) {
        tripService.update(trip);
        return "redirect:" + trip.getId() + "?edit=false";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        tripService.delete(id);
        return "redirect:all";
    }
}
