package nl.han.dea.joost.service.login;

import nl.han.dea.joost.resource.login.LoginDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AuthenticationServiceTest {

    //arrange
    private AuthenticationService sut;


    @BeforeEach
    void setUp() {
        sut = new AuthenticationService();
    }

    @Test
    void authenticateBadToken() {
        //act
        var result = sut.authenticateToken("");

        //assert
        Assertions.assertEquals(false, result);
    }

    @Test
    void authenticateGoodToken() {
        //act
        var result = sut.authenticateToken("1234-1234-1234");

        //assert
        Assertions.assertEquals(true, result);
    }

    @Test
    void authenticateGoodDTO() {
        //arrange
        var loginDTO = new LoginDTO();
        loginDTO.setUser("meron");
        loginDTO.setPassword("MySuperSecretPassword12341");

        //act
        var result = sut.authenticate(loginDTO);

        //assert
        Assertions.assertEquals(true, result);
    }

    @Test
    void authenticateBadDTO() {
        //arrange
        var loginDTO = new LoginDTO();
        loginDTO.setUser("");
        loginDTO.setPassword("");

        //act
        var result = sut.authenticate(loginDTO);

        //assert
        Assertions.assertEquals(false, result);
    }

}