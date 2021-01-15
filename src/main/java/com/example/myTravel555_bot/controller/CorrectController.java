package com.example.myTravel555_bot.controller;

import com.example.myTravel555_bot.model.Travel;
import com.example.myTravel555_bot.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CorrectController {

    @Autowired
    TravelService travelService;

    @DeleteMapping(value = "/delete/{city}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable("city") String city) {
        travelService.deleteTravelService(city);
        return "City: " + city + " deleted";
    }

    @PostMapping(value = "/addTravel")
    @ResponseStatus(HttpStatus.OK)
    public String addTravel(@RequestBody Travel travel) {
        if (travelService.checkTravel(travel)) {
            return "such a city already exists in the database, choose to update";
        } else {
            travelService.addTravelService(travel);
            return "city added";
        }
    }

    @PutMapping(value = "/updateTravel")
    @ResponseStatus(HttpStatus.OK)
    public String updateTravel(@RequestBody Travel travel) {
        if (travelService.checkTravel(travel)) {
            travelService.updateTravelService(travel);
            return "city updated";
        } else {
            return "there is no such city in the database, so you cannot update it";
        }
    }

    @GetMapping(value = "/getTravels")
    @ResponseStatus(HttpStatus.OK)
    public List<Travel> getTravels() {
        return travelService.getTravelService();
    }
}

