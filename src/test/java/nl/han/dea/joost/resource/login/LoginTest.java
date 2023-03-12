package nl.han.dea.joost.resource.login;

import jakarta.ws.rs.core.Response;
import nl.han.dea.joost.service.login.LoginService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LoginTest {

    private LoginService mockedLoginService;

    @Test
    void setLoginServiceTest() {
        //arrange
        var sut = new Login();
        mockedLoginService = Mockito.mock(LoginService.class);
        sut.setLoginService(mockedLoginService);

        //act
        var result = sut.getLoginService();

        //assert
        Assertions.assertEquals(mockedLoginService, result);
    }

    @Test
    void loginTest() throws Exception {
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