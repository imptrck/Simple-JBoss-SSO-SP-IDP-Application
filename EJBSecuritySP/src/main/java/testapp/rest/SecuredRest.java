package testapp.rest;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import testapp.ejb.SecuredStatelessBean;



@RequestScoped
@Path("test")
public class SecuredRest implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	SecuredStatelessBean secEjb ;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@Context SecurityContext securityContext) {
		System.out.println("Roles: " + securityContext.getUserPrincipal().getName());
		System.out.println("Authentication Scheme: " + securityContext.getAuthenticationScheme());
		System.out.println("User in role? " + securityContext.isUserInRole("All"));
		
		secEjb.testMethod();
		return Response.ok().build();
		
	}

}
