package nl.han.dea.joost.service.login;

import jakarta.inject.Inject;
import nl.han.dea.joost.datasource.authentication.AuthenticationDAO;
import nl.han.dea.joost.datasource.exceptions.TokenIsNotValidException;
import nl.han.dea.joost.resource.login.LoginDTO;

import java.sql.SQLException;

public class AuthenticationService {

    private AuthenticationDAO authenticationDAO;

    public void authenticateToken(String token) throws TokenIsNotValidException {
        try {
            if (authenticationDAO.getAuthenticatedUser(token) == null) {
                throw new TokenIsNotValidException();
            }
        } catch (SQLException e) {
            throw new TokenIsNotValidException();
        }
    }


    public boolean authenticate(LoginDTO loginDTO) {
        return loginDTO.getUser().equals("meron") && loginDTO.getPassword().equals("MySuperSecretPassword12341");
    }

    @Inject
    public void setAuthenticationDAO(AuthenticationDAO authenticationDAO) {
        this.authenticationDAO = authenticationDAO;
    }

}
