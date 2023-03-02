package nl.han.dea.joost.presentation.login;

import jakarta.ws.rs.core.Response;
import nl.han.dea.joost.service.login.LoginService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LoginTest {



    @Test
    void setLoginService() {
        //arrange
        var returnValue = Mockito.mock(Response.class);
        var fixture = Mockito.mock(LoginService.class);
        Mockito.when(fixture.login(Mockito.any())).thenReturn(returnValue);

        //act
        var sut = new Login();
        sut.setLoginService(fixture);
        var result = sut.login(null);

        //assert
        Mockito.verify(fixture).login(Mockito.any());
    }

    @Test
    void login() {
        //arrange
        var returnValue = Mockito.mock(Response.class);
        var fixture = Mockito.mock(LoginService.class);
        Mockito.when(fixture.login(Mockito.any())).thenReturn(returnValue);

        //act
        var sut = new Login();
        sut.setLoginService(fixture);
        var result = sut.login(null);

        //assert
        Assertions.assertEquals(returnValue, result);
    }
}