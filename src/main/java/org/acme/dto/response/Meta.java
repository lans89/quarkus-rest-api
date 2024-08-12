package org.acme.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Meta{
    @JsonProperty(value = "last_updated_at")
    private String lastUpdatedAt;
}