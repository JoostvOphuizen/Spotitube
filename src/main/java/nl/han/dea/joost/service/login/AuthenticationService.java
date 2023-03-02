package nl.han.dea.joost.service.login;

import nl.han.dea.joost.resource.login.LoginDTO;

public class AuthenticationService {

    static public boolean authenticateToken(String token) {
        return token.equals("1234-1234-1234");
    }

    public boolean authenticate(LoginDTO loginDTO) {
        return loginDTO.getUser().equals("meron") && loginDTO.getPassword().equals("MySuperSecretPassword12341");
    }

}
