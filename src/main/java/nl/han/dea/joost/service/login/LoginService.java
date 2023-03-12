package nl.han.dea.joost.service.login;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import nl.han.dea.joost.datasource.login.LoginDAO;
import nl.han.dea.joost.resource.login.AuthenticatedUserDTO;
import nl.han.dea.joost.resource.login.LoginDTO;

public class LoginService {


    private LoginDAO loginDAO;
    private AuthenticationService authenticationService;


    public Response login(LoginDTO loginDTO) throws Exception {
        // todo: change this authentication, it should use a exception
        if(!authenticationService.authenticate(loginDTO)){
            return Response.status(401).build();
        }

        AuthenticatedUserDTO authenticatedUserDTO = loginDAO.makeAuthenticatedUser(loginDTO);
        return Response.status(200).entity(authenticatedUserDTO).build();
    }


    // todo: get is only used for testing, find a better way to test this
    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }

    @Inject
    public void setLoginDAO(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }
    @Inject
    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
}
