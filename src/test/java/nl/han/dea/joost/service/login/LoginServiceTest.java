package nl.han.dea.joost.service.login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LoginServiceTest {

    private LoginService sut;
    @BeforeEach
    void setUp() {
        var sut = new LoginService();
    }


    @Test
    void setAuthenticationService() {
        //arrange
        var fixture = Mockito.mock(AuthenticationService.class);
        Mockito.when(fixture.authenticate(Mockito.any())).thenReturn(true);

        //act
        sut.setAuthenticationService(fixture);

        //assert
        Mockito.verify(fixture).authenticate(Mockito.any());
    }

    @Test
    void login() {
    }
}