package nl.han.dea.joost.resource.login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginDTOTest {

    private LoginDTO sut;

    @BeforeEach
    void setUp() {
        sut = new LoginDTO();
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

    @Test
    void getPassword() {
        //arrange
        var expected = "password";
        sut.setPassword(expected);

        //act
        var result = sut.getPassword();

        //assert
        assertEquals(expected, result);
    }

    @Test
    void setPassword() {
        //arrange
        var expected = "password";

        //act
        sut.setPassword(expected);

        //assert
        assertEquals(expected, sut.getPassword());
    }
}