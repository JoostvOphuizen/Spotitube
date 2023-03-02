package nl.han.dea.joost.service.login;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import nl.han.dea.joost.resource.login.AuthenticatedUserDTO;
import nl.han.dea.joost.resource.login.LoginDTO;

public class LoginService {


    private AuthenticationService authenticationService;

    @Inject
    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public Response login(LoginDTO loginDTO) {
        if(!authenticationService.authenticate(loginDTO)){
            return Response.status(401).build();
        }

        AuthenticatedUserDTO authenticatedUserDTO = new AuthenticatedUserDTO();

        authenticatedUserDTO.setUser("Meron Brouwer");
        authenticatedUserDTO.setToken("1234-1234-1234");

        return Response.status(201).entity(authenticatedUserDTO).build();
    }


}
