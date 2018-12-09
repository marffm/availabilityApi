package com.weekend.availability.application.helper;

import com.weekend.availability.application.dto.FlightSearchParameterDTO;
import com.weekend.availability.domain.flight.helper.FlightSearchParameterGeneratorInterface;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class FlightSearchParameterGenerator implements FlightSearchParameterGeneratorInterface {

    private static final String[] attList = {"origin_airport_code", "outbound_flight_code", "outbound_flight_class", "outbound_flight_departure",
            "destination_airport_code", "inbound_flight_code", "inbound_flight_class", "inbound_flight_departure", "adults", "children", "infants",
            "outbound_flight_number", "inbound_flight_number", "staticId"};

    public FlightSearchParameterDTO parseRequestFlightIdIntoFlightSearchParamenter(String flightId) {
        String flightIdString = this.parse64IntoString(flightId);
        return this.parseDecodedRequestFlightId(flightIdString);
    }

    private String parse64IntoString(String flightId) {
        byte[] decoded = Base64.getDecoder().decode(flightId);
        return new String(decoded);
    }

    private FlightSearchParameterDTO parseDecodedRequestFlightId(
            String flightIdDecoded
    ) {

        String[] flightIdArray = flightIdDecoded.split("\\|");

        Map<String, String> flightIdMap = IntStream.range(0, attList.length).boxed()
                .collect(Collectors.toMap(i -> attList[i], i -> flightIdArray[i]));

        return FlightSearchParameterDTO.fromFlightIdMapRequest(flightIdMap);
    }
}
