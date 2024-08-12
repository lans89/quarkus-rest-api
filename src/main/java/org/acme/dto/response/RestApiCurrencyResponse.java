package org.acme.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class RestApiCurrencyResponse {
    private Meta meta;
    private Map<String, CurrencyValue> data;
}





