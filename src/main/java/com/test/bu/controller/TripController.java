package com.test.bu.controller;

import com.test.bu.entity.Trip;
import com.test.bu.service.interfaces.TripService;
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
@RequestMapping("/trip")
public class TripController {

    private static final Logger logger = Logger.getLogger(TripController.class);

    @Autowired
    private TripService tripService;

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") int id, @RequestParam(value = "edit", required = false) boolean edit, Model model) {
        model.addAttribute("trip", tripService.findById(id));
        if (edit) {
            return "tripEdit";
        } else {
            return "tripShow";
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
            Page<Trip> pages = tripService.findAll(page, size, order);
            totalPages = pages.getTotalPages();
            model.addAttribute("total", totalPages);
            model.addAttribute("users", pages.getContent());
        } else if (!StringUtils.isEmpty(order)) {
            model.addAttribute("trip", tripService.findAll(0, 100, order).getContent());
        } else {
            Collection<Trip> all = tripService.findAll();
            model.addAttribute("trip", all);
            totalPages = all.size() / 2;
        }
        List<Integer> pagesCount = new ArrayList<>();
        for (int i = 0; i < totalPages; i++) {
            pagesCount.add(i);
        }
        model.addAttribute("pages", pagesCount);
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
        tripService.save(trip);
        return "redirect:" + trip.getId() + "?edit=false";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        tripService.delete(id);
        return "redirect:all";
    }
}
