package org.acme.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrencyValue{
    private String code;
    private BigDecimal value;
}