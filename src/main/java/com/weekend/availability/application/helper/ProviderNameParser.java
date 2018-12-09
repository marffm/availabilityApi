package com.weekend.availability.application.helper;

import org.springframework.stereotype.Component;

/**
 * Class which the onlu responsibility is to parse the name of the providers.
 */
@Component
public class ProviderNameParser {

    /**
     * Variable with the default sufix to flight providers.
     */
    public static final String FLIGHT_PROVIDERS_SUFIX = "FlightProvider";

    /**
     * Variable with the default sufix to hotel providers.
     */
    public static final String HOTEL_PROVIDERS_SUFIX = "HotelProvider";

    /**
     * @param className String with the full provider name
     * @param providerSufix String which is responsivle to specify the provider
     * @return String
     */
    public String getSimpleName(
            final String className,
            final String providerSufix
    ) {
        return className.replace(providerSufix, "");
    }
}
