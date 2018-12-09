package com.weekend.availability.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Map;

@Getter
public class FlightSearchParameterDTO {

    private String flightId;

    private String outboundFlightId;

    private String inboundFlightId;

    private String outboundFlightCode;

    private String inboundFlightCode;

    private String outboundCabinClass;

    private String inboundCabinClass;

    private ZonedDateTime outboundDepartureTime;

    private ZonedDateTime inboundDepartureTime;

    private String outboundFlightNumber;

    private String inboundFlightNumber;

    private String departureAirportIata;

    private String destinationAirportIata;

    private int adults;

    private int children;

    private int infants;

    private String costumerId;

    private int staticId;

    private String language;

    private String market;

    private int linkScope;

    public static FlightSearchParameterDTO fromFlightIdMapRequest(Map<String, String> flightIdMap) {

        FlightSearchParameterDTO flightSearchParameterDTO = new FlightSearchParameterDTO();

        flightSearchParameterDTO.departureAirportIata = flightIdMap.get("origin_airport_code");
        flightSearchParameterDTO.outboundFlightCode = flightIdMap.get("outbound_flight_code");
        flightSearchParameterDTO.outboundCabinClass = flightIdMap.get("outbound_flight_class");

        flightSearchParameterDTO.outboundDepartureTime =
                ZonedDateTime.from(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(flightIdMap.get("outbound_flight_departure")));

        flightSearchParameterDTO.outboundCabinClass = flightIdMap.get("destination_airport_code");
        flightSearchParameterDTO.outboundCabinClass = flightIdMap.get("inbound_flight_code");
        flightSearchParameterDTO.outboundCabinClass = flightIdMap.get("inbound_flight_class");

        flightSearchParameterDTO.inboundDepartureTime =
                ZonedDateTime.from(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(flightIdMap.get("inbound_flight_departure")));

        flightSearchParameterDTO.outboundCabinClass = flightIdMap.get("adults");
        flightSearchParameterDTO.outboundCabinClass = flightIdMap.get("children");
        flightSearchParameterDTO.outboundCabinClass = flightIdMap.get("infants");
        flightSearchParameterDTO.outboundCabinClass = flightIdMap.get("outbound_flight_number");
        flightSearchParameterDTO.outboundCabinClass = flightIdMap.get("inbound_flight_number");
        flightSearchParameterDTO.outboundCabinClass = flightIdMap.get("staticId");


//        2019-01-11T16:40:00+01:00

//        flightIdMap.put("origin_airport_code", flightIdArray[0]);
//        flightIdMap.put("outbound_flight_code", flightIdArray[1]);
//        flightIdMap.put("outbound_flight_class", flightIdArray[2]);
//        flightIdMap.put("outbound_flight_departure", flightIdArray[3]);
//        flightIdMap.put("destination_airport_code", flightIdArray[4]);
//        flightIdMap.put("inbound_flight_code", flightIdArray[5]);
//        flightIdMap.put("inbound_flight_class", flightIdArray[6]);
//        flightIdMap.put("inbound_flight_departure", flightIdArray[7]);
//        flightIdMap.put("adults", flightIdArray[8]);
//        flightIdMap.put("children", flightIdArray[9]);
//        flightIdMap.put("infants", flightIdArray[10]);
//        flightIdMap.put("outbound_flight_number", flightIdArray[11]);
//        flightIdMap.put("inbound_flight_number", flightIdArray[12]);
//        flightIdMap.put("staticId", flightIdArray[13]);


        return flightSearchParameterDTO;
    }
}
