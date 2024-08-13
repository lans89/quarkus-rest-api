package org.acme.config;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "app.tasacambio")
public interface ConfigAppTasaCambio {
    String formatDate();
    Integer decimalsPlace();
}
