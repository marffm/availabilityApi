package com.weekend.availability.domain.flight.helper;

import com.weekend.availability.application.dto.FlightSearchParameterDTO;

public interface FlightSearchParameterGeneratorInterface {

    FlightSearchParameterDTO parseRequestFlightIdIntoFlightSearchParamenter(
            String flightId
    );

}
