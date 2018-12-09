package com.weekend.availability.application.dto;

import com.weekend.availability.domain.flight.dto.FlightAvailabilityDTOInterface;

public class FlightAvailabilityDTO implements FlightAvailabilityDTOInterface {

    private String flightId;
    private String market;
    private String language;
    private String offerProvider;

    /**
     * Start new FlightAvailabilityDTO
     * @param flightId String with flight Id
     * @param market String with market
     * @param language String with language
     */
    private FlightAvailabilityDTO(
            String flightId,
            String market,
            String language,
            String offerProvider
    ) {
        this.flightId = flightId;
        this.market = market;
        this.language = language;
        this.offerProvider = offerProvider;
    }

    /**
     * @return String flightId
     */
    public String getFlightId() {
        return flightId;
    }

    /**
     * @return String market
     */
    public String getMarket()
    {
        return market;
    }

    /**
     * @return String language
     */
    public String getLanguage()
    {
        return language;
    }

    /**
     * @return String offerProvider
     */
    public String getOfferProvider() {
        return offerProvider;
    }

    /**
     *
     * @param flightId String of flight id
     * @param market String of market
     * @param language String of language
     * @return FlightAvailabilityDTO
     */
    public static FlightAvailabilityDTO startFromController(
            String flightId,
            String market,
            String language,
            String offerProvider
    ) {
        return new FlightAvailabilityDTO(
                flightId,
                market,
                language,
                offerProvider.length() == 0 ? null : offerProvider
        );
    }
}
