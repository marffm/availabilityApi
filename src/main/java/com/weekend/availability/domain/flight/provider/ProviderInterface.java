package com.weekend.availability.domain.flight.provider;

import com.weekend.availability.application.dto.FlightSearchParameterDTO;

public interface ProviderInterface {

    String checkFlightAvailability(final FlightSearchParameterDTO flightId);

    String getName();

}
