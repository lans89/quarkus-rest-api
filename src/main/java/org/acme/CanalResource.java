package org.acme;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.dto.response.CanalDTO;
import org.acme.dto.response.ResultadoDTO;
import org.acme.service.ICanalService;

import java.util.List;

@Path("/canales")
public class CanalResource {

    @Inject
    @Named("canal-service")
    private ICanalService canalService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/todos")
    public List<CanalDTO> listar() {
        return canalService.listarCanalesActivos();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public CanalDTO consultar(@PathParam("id") String id) {
        return canalService.consultarCanal(id).orElse(CanalDTO.builder().build());
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public ResultadoDTO agregar(CanalDTO canal) {
        return canalService.agregarCanal(canal);
    }
}
