package org.acme.utils;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import org.acme.service.IMensajeService;
import org.acme.service.MensajeService;
import org.acme.utils.valids.ErrorMensaje;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Singleton
public class Respuestas {
    @Inject
    @Named("mensaje-service")
    private IMensajeService mensajeService;

    public List<ErrorMensaje> armarListaErrores(List<String> codigos, String idioma){
        List<ErrorMensaje> errores = new LinkedList<>();
        Map<String, ErrorMensaje> mapaMensajes = mensajeService.mapaMensajesErrores();
        codigos.forEach(codigo ->{
            ErrorMensaje error = mapaMensajes.getOrDefault(codigo+idioma, ErrorMensaje.builder()
                    .codigo(codigo)
                    .mensaje("mensaje no configurado").build());
            errores.add(error);
        });
        return errores;
    }

}
