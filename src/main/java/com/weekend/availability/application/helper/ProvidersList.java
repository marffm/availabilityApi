package com.weekend.availability.application.helper;

import com.weekend.availability.domain.flight.provider.ProviderInterface;
import java.util.Set;

import com.weekend.availability.domain.flight.provider.ProviderListInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Class responsible to register flight providers.
 */
@Component
public class ProvidersList implements ProviderListInterface {

    /**
     * Set of ProviderInterface.
     */
    private final Set<ProviderInterface> flightProviders;

    /**
     * FlightsProviderList contructor.
     * @param flightProviders Set
     */
    @Autowired
    public ProvidersList(
            final Set<ProviderInterface> flightProviders
    ) {
        this.flightProviders = flightProviders;
    }

    /**
     * Returns Flight Provider.
     * @param name String with provider name
     * @return ProviderInterface
     */
    public ProviderInterface getFlightProviders(final String name) {
        return flightProviders.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst().orElse(null);
    }
}
