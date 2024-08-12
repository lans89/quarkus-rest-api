package org.acme.dto.response;

import lombok.Data;

import java.util.Map;

@Data
public class Datas{
    private Map<String, CurrencyValue> currency;
}