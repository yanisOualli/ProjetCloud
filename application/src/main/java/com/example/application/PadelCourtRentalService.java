package com.example.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PadelCourtRentalService {

    private List<PadelCourt> padelCourts = new ArrayList<>();

    public PadelCourtRentalService() {
        padelCourts.add(new PadelCourt("Court1", "Location A", 20));
        padelCourts.add(new PadelCourt("Court2", "Location B", 25));
        padelCourts.add(new PadelCourt("Yanis OUALLI Internation0al Garden", "Location c", 500));
    }

    @GetMapping("/padel-courts")
    public List<PadelCourt> getListOfPadelCourts() {
        return padelCourts;
    }

    @PostMapping("/padel-courts")
    public void addPadelCourt(@RequestBody PadelCourt padelCourt) {
        System.out.println(padelCourt);
        padelCourts.add(padelCourt);
    }

    @GetMapping("/padel-courts/{courtName}")
    public PadelCourt getPadelCourt(@PathVariable(value = "courtName") String courtName) {
        for (PadelCourt padelCourt : padelCourts) {
            if (padelCourt.getCourtName().equals(courtName)) {
                return padelCourt;
            }
        }
        return null;
    }

    @DeleteMapping("/padel-courts/{courtName}")
public void deletePadelCourt(@PathVariable("courtName") String courtName) {
    PadelCourt courtToRemove = null;
    for (PadelCourt padelCourt : padelCourts) {
        if (padelCourt.getCourtName().equals(courtName)) {
            courtToRemove = padelCourt;
            break;
        }
    }

    if (courtToRemove != null) {
        padelCourts.remove(courtToRemove);
    } else {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Padel Court Not Found");
    }
}

    @PutMapping("/padel-courts/{courtName}")
    public void rentPadelCourt(@PathVariable("courtName") String courtName,
                               @RequestParam(value = "rent", required = true) boolean rented,
                               @RequestBody(required = false) Dates dates) {
        System.out.println(courtName);
        System.out.println(rented);
        System.out.println(dates);
        if (!rented) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Padel Court Not Found");
        }
    }

}
