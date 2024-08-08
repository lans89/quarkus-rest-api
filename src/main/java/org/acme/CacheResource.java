package org.acme;

import io.quarkus.cache.CacheInvalidate;
import io.quarkus.cache.CacheInvalidateAll;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.acme.dto.response.CanalDTO;

@Path("/cache")
public class CacheResource {
    @POST
    @Path("/")
    @CacheInvalidateAll(cacheName = "mensajes")
    public void refrescarCache() {
    }
}
