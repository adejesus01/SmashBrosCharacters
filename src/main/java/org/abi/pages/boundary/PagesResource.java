package org.abi.pages.boundary;

import org.abi.pages.control.PagesBean;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("")
public class PagesResource {

    @Inject
    PagesBean pagesBean;
    
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getLandingPage() {

        return pagesBean.getLandingPage();
    }

}
