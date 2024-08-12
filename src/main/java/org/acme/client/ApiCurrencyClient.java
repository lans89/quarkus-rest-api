package org.acme.client;

import io.quarkus.rest.client.reactive.ClientQueryParam;
import jakarta.inject.Singleton;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.acme.dto.response.RestApiCurrencyResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@Singleton
@RegisterRestClient(configKey="currency-api")
@ClientQueryParam(name = "apikey", value = "${quarkus.rest-client.currency-api.apikey}")
public interface ApiCurrencyClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/historical")
    RestApiCurrencyResponse getCurrencyConverter(
            @QueryParam("base_currency") String baseCurrency,
            @QueryParam("currencies") String currencies,
            @QueryParam("date") String date);

}
