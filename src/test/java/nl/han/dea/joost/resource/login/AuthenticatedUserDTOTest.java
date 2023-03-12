package nl.han.dea.joost.resource.login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticatedUserDTOTest {

    private AuthenticatedUserDTO sut;

    @BeforeEach
    void setUp() {
        sut = new AuthenticatedUserDTO();
    }

    @Test
    void getToken() {
        //arrange
        var expected = "token";
        sut.setToken(expected);

        //act
        var result = sut.getToken();

        //assert
        assertEquals(expected, result);
    }

    @Test
    void setToken() {
        //arrange
        var expected = "token";

        //act
        sut.setToken(expected);

        //assert
        assertEquals(expected, sut.getToken());
    }

    @Test
    void getUser() {
        //arrange
        var expected = "user";
        sut.setUser(expected);

        //act
        var result = sut.getUser();

        //assert
        assertEquals(expected, result);
    }

    @Test
    void setUser() {
        //arrange
        var expected = "user";

        //act
        sut.setUser(expected);

        //assert
        assertEquals(expected, sut.getUser());
    }
}