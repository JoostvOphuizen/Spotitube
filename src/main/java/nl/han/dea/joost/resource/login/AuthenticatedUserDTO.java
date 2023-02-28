package nl.han.dea.joost.resource.login;

public class AuthenticatedUserDTO {

    private TokenDTO token;
    private String user;

    public TokenDTO getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = new TokenDTO();
        this.token.setToken(token);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
