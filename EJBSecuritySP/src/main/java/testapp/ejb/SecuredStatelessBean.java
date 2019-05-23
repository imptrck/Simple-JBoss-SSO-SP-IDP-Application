package testapp.ejb;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import org.jboss.ejb3.annotation.SecurityDomain;

@Stateless
@SecurityDomain("sp")
public class SecuredStatelessBean {

	@Resource
	private SessionContext ctx;

	@RolesAllowed("All")
	public void testMethod() {
		System.out.println("User authenticated: " + ctx.getCallerPrincipal());
		System.out.println("Rest Side, is it in the All role?" + ctx.isCallerInRole("All"));
		System.out.println("EJB method invoked with success");
	}
}
