package org.abi.characters.boundary;

import jakarta.inject.Inject;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import org.abi.characters.control.CharacterBean;
import org.abi.characters.entity.Character;
import org.jboss.resteasy.annotations.Query;

@Path("/characters")
public class CharactersResource {

    @Inject
    CharacterBean characterBean;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCharacter() {

        return characterBean.getCharacter();
    }

    @GET
    @Path("/specific")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSpecificCharacter(@QueryParam("name") String name) {

        return characterBean.getSpecificCharacter(name);
    }

}
