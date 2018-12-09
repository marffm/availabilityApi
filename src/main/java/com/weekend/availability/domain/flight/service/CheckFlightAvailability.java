package com.weekend.availability.domain.flight.service;

import com.weekend.availability.application.dto.FlightSearchParameterDTO;
import com.weekend.availability.application.helper.FlightSearchParameterGenerator;
import com.weekend.availability.domain.flight.dto.FlightAvailabilityDTOInterface;
import com.weekend.availability.domain.flight.helper.FlightSearchParameterGeneratorInterface;
import com.weekend.availability.domain.flight.provider.ProviderInterface;
import com.weekend.availability.domain.flight.provider.ProviderListInterface;
import org.springframework.stereotype.Service;

/**
 * Service CheckFlightAvailability class.
 */
@Service
public class CheckFlightAvailability {

    /**
     * List of Providers.
     */
    private ProviderListInterface providersList;

    /**
     * flightId Parser
     */
    private FlightSearchParameterGeneratorInterface flightSearchParameterGenerator;

    /**
     * Constructor of CheckFlightAvailability service.
     *
     * @param flightProviderList List of flight providers
     */
    public CheckFlightAvailability(
            final ProviderListInterface flightProviderList,
            final FlightSearchParameterGeneratorInterface flightSearchParameterGenerator
    ) {
        this.providersList = flightProviderList;
        this.flightSearchParameterGenerator = flightSearchParameterGenerator;
    }

    /**
     * @return String
     */
    public String check(
            FlightAvailabilityDTOInterface flightAvailabilityDTO
    ) {
        ProviderInterface provider = this.providersList
                .getFlightProviders(flightAvailabilityDTO.getOfferProvider());

        if (provider == null) {
            return "no provider";
        }

        FlightSearchParameterDTO flightSearchParameterDTO =
                flightSearchParameterGenerator
                        .parseRequestFlightIdIntoFlightSearchParamenter(
                                flightAvailabilityDTO.getFlightId()
                        );

        return provider.checkFlightAvailability(flightSearchParameterDTO);
    }
}
