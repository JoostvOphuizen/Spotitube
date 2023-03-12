package nl.han.dea.joost.service.login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LoginServiceTest {

    private LoginService sut;

    @BeforeEach
    void setUp() {
        sut = new LoginService();
    }


    @Test
    void setAuthenticationService() {
        //arrange
        AuthenticationService mockedAuthenticationService = Mockito.mock(AuthenticationService.class);
        sut.setAuthenticationService(mockedAuthenticationService);

        //act
        var result = sut.getAuthenticationService();

        //assert
        Assertions.assertEquals(mockedAuthenticationService, result);
    }

    @Test
    void loginIfAuthenticateIsFalseTest() throws Exception {
        //arrange
        var fixture = Mockito.mock(AuthenticationService.class);
        Mockito.when(fixture.authenticate(Mockito.any())).thenReturn(false);

        //act
        sut.setAuthenticationService(fixture);
        var response = sut.login(null);

        //assert
        Assertions.assertEquals(401, response.getStatus());
    }

    @Test
    void loginIfAuthenticateIsTrueTest() throws Exception {
        //arrange
        var fixture = Mockito.mock(AuthenticationService.class);
        Mockito.when(fixture.authenticate(Mockito.any())).thenReturn(true);

        //act
        sut.setAuthenticationService(fixture);
        var response = sut.login(null);

        //assert
        Assertions.assertEquals(200, response.getStatus());
    }

}