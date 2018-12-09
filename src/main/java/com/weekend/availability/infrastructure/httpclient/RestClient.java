package com.weekend.availability.infrastructure.httpclient;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {

    public final static String POST = "POST";
    public final static String GET = "GET";
    public final static String PUT = "PUT";
    public final static String DELETE = "DELETE";

    private String defaultContentType = "application/json";
    private RestTemplate rest;
    private HttpHeaders headers;
    private HttpStatus status;

    public RestClient() {
        this.rest = new RestTemplate();
        this.headers = new HttpHeaders();
        this.headers.add("Content-Type", this.defaultContentType);
    }

    /**
     * This method does the request.
     * @param uri String
     * @param method String
     * @param body String
     * @return String
     */
    public String fetchRequest(String uri, String method, String body) {
        if (body == null) {
            body = "";
        }
        HttpEntity<String> requestEntity = new HttpEntity<>(body, this.headers);
        ResponseEntity<String> responseEntity = this.rest.exchange(
                uri,
                this.getHttpMethod(method),
                requestEntity,
                String.class
        );
        this.setStatus(responseEntity.getStatusCode());
        return responseEntity.getBody();
    }

    /**
     * Change the default content-type value
     * @param contentType String with new content-type
     */
    public void setContentType(String contentType) {
        this.headers.set("Content-Type", contentType);
    }

    /**
     * @return HttpStatus status
     */
    public HttpStatus getStatus() {
        return status;
    }

    /**
     * @param status Status of request
     */
    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    /**
     * @param method String with the http method
     * @return HttpMethod
     */
    private HttpMethod getHttpMethod(String method) {
        switch (method) {
            case RestClient.POST:
                return HttpMethod.POST;
            case RestClient.PUT:
                return HttpMethod.PUT;
            case RestClient.DELETE:
                return HttpMethod.DELETE;
            default:
                return HttpMethod.GET;
        }
    }
}
