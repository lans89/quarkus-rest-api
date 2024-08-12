package org.acme;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.dto.request.ConsultaTasaCambioDTO;
import org.acme.dto.response.CambioDTO;
import org.acme.service.ITasaCambioService;

@Path("/tasa-cambio")
public class TasaCambioResource {

    @Inject
    @Named("tasaCambioService")
    private ITasaCambioService tasaCambioService;


    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public CambioDTO consultaTasaCambio(ConsultaTasaCambioDTO request){
        return  tasaCambioService.obtenerTasaCambio(request).orElse(CambioDTO.builder().build());
    }

}
