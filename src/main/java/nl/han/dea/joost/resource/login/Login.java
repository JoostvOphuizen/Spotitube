package nl.han.dea.joost.resource.login;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import nl.han.dea.joost.service.login.LoginService;


@Path("/login")
public class Login {

    private LoginService loginService;

    @Inject
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginDTO loginDTO) throws Exception {
        return loginService.login(loginDTO);
    }


    // todo: getLoginService is only used for testing, find a better way to test this
    public LoginService getLoginService() {
        return loginService;
    }
}
