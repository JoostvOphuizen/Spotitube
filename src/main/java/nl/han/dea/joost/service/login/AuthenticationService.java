package nl.han.dea.joost.service.login;

import nl.han.dea.joost.resource.login.LoginDTO;

public class AuthenticationService {


    public boolean authenticate(LoginDTO loginDTO) {
        return loginDTO.getUser().equals("meron") && loginDTO.getPassword().equals("MySuperSecretPassword12341");
    }

}
