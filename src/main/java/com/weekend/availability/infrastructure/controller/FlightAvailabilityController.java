package com.weekend.availability.infrastructure.controller;

import com.weekend.availability.application.action.FlightAvailabilityAction;
import com.weekend.availability.application.dto.FlightAvailabilityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightAvailabilityController {

    @Autowired
    private FlightAvailabilityAction flightAvailabilityAction;

    @GetMapping("/availability/flight")
    public String getAvailability(
            @RequestParam String flightId,
            @RequestParam String language,
            @RequestParam String market,
            @RequestParam(required = false, defaultValue = "") String offerProvider
    ) {
        FlightAvailabilityDTO flightAvailabilityDTO = FlightAvailabilityDTO.startFromController(flightId, market, language, offerProvider);
        return this.flightAvailabilityAction.getFlightAvailability(flightAvailabilityDTO);

    }
}
