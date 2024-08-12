package org.acme.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ConsultaTasaCambioDTO {
    private String deMoneda;
    @JsonProperty("aMoneda")
    private String aMoneda;
    private String fecha;
}
