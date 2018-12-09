package com.weekend.availability.infrastructure.provider.flight;

import com.weekend.availability.application.dto.FlightSearchParameterDTO;
import com.weekend.availability.application.helper.FlightSearchParameterGenerator;
import com.weekend.availability.application.helper.ProviderNameParser;
import com.weekend.availability.domain.flight.provider.ProviderInterface;
import com.weekend.availability.infrastructure.httpclient.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

/**
 * This is a Eurowings provider.
 */
@Component
public class EurowingsFlightProvider implements ProviderInterface {

    /**
     * Class ProviderNameParser.
     */
    @Autowired
    private ProviderNameParser nameParser;

    /**
     * Class RestClient
     */
    @Autowired
    private RestClient restClient;

    @Autowired
    private FlightSearchParameterGenerator flightSearchParameterGenerator;

    @Value("${providers.flight.eurowings.url}")
    private String url;

    @Value("${providers.flight.eurowings.custid}")
    private String custid;

    @Value("${providers.flight.eurowings.custkey}")
    private String custkey;

    @Value("${providers.flight.eurowings.custname}")
    private String custname;

    /**
     * @param flightSearchParameterDTO flight search values
     * @return String
     */
    public String checkFlightAvailability(
            final FlightSearchParameterDTO flightSearchParameterDTO
    ) {

        String url = this.getRequestUri(flightSearchParameterDTO);

        this.restClient.setContentType("application/x-www-form-urlencoded");
        String response = this.restClient.fetchRequest(
                url,
                RestClient.POST,
                "custid=" + this.custid + "&custkey=" + this.custkey
        );
        return response;
    }

    /**
     * @return String
     */
    private String getRequestUri(FlightSearchParameterDTO flightSearchParameterDTO) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ISO_LOCAL_DATE;

        String uri = "?o="+ flightSearchParameterDTO.getDepartureAirportIata();
        uri += "&d=" + flightSearchParameterDTO.getDestinationAirportIata();
        uri += "&t=r";

        uri += "&od=" + flightSearchParameterDTO.getOutboundDepartureTime().format(dateFormat);

        uri += "&rd=" + flightSearchParameterDTO.getInboundDepartureTime().format(dateFormat);

        uri += "adt=" + flightSearchParameterDTO.getAdults();
        uri += "chd=" + flightSearchParameterDTO.getChildren();
        uri += "inf=" + flightSearchParameterDTO.getInfants();
        uri += "lng=" + flightSearchParameterDTO.getLanguage() + "-" + flightSearchParameterDTO.getMarket();
        uri += "out=xml";
        uri += "custname=" + this.custname;

//        String parameters = "?o=DUS&d=CPH&t=r&od=2019-01-11&rd=2019-01-13&adt=2&lng=de&out=xml&custname=weekengo";
        return this.url + uri;
    }

    /**
     * Return provider name.
     * @return String
     */
    @Override
    public String getName() {
        String className = EurowingsFlightProvider.class.getSimpleName();
        return nameParser.getSimpleName(
                className,
                ProviderNameParser.FLIGHT_PROVIDERS_SUFIX
        );
    }
}
