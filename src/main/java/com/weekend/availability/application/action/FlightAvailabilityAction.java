package com.weekend.availability.application.action;

import com.weekend.availability.domain.flight.service.CheckFlightAvailability;
import com.weekend.availability.domain.flight.dto.FlightAvailabilityDTOInterface;
import org.springframework.stereotype.Component;

/**
 * Action to check flight Availibility.
 */
@Component
public class FlightAvailabilityAction {

    /**
     * Service from Domain Responsible to check Flight availability.
     */
    private CheckFlightAvailability checkFlightAvailabilityService;

    /**
     * @param checkFlightAvailability Service Class
     */
    public FlightAvailabilityAction(
            final CheckFlightAvailability checkFlightAvailability
    ) {
        this.checkFlightAvailabilityService = checkFlightAvailability;
    }

    /**
     * @param flightAvailabilityDTO DTO from controller
     * @return String
     */
    public String getFlightAvailability(
            final FlightAvailabilityDTOInterface flightAvailabilityDTO
    ) {
        return this.checkFlightAvailabilityService.check(flightAvailabilityDTO);
    }
}
