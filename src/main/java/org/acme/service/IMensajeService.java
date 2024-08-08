package org.acme.service;

import org.acme.utils.valids.ErrorMensaje;

import java.util.Map;

public interface IMensajeService {
    Map<String, ErrorMensaje> mapaMensajesErrores();
}
