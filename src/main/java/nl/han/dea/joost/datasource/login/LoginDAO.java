package nl.han.dea.joost.datasource.login;

import jakarta.inject.Inject;
import nl.han.dea.joost.datasource.TokenGeneration;
import nl.han.dea.joost.datasource.connection.ConnectionService;
import nl.han.dea.joost.resource.login.AuthenticatedUserDTO;
import nl.han.dea.joost.resource.login.LoginDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    private ConnectionService connectionService;
    private TokenGeneration tokenGeneration;
    private LoginSQLStatementBuilder loginSQLStatementBuilder;


    private ResultSet getUserFromDatabase(LoginDTO loginDTO) throws SQLException {
        connectionService.initializeConnection();
        var statement = loginSQLStatementBuilder.buildGetUserPreparedStatement(connectionService, loginDTO);
        return statement.executeQuery();
    }

    public AuthenticatedUserDTO makeAuthenticatedUser(LoginDTO loginDTO) {
        AuthenticatedUserDTO authenticatedUserDTO = new AuthenticatedUserDTO();
        try {
            ResultSet resultSet = getUserFromDatabase(loginDTO);
            if(resultSet != null && resultSet.next()){
                authenticatedUserDTO.setUser(resultSet.getString("username"));
            }else {
                // todo: throw exception: user not found
            }
        } catch (SQLException e) {
            // todo: handle: sql exception
            e.printStackTrace();
        }

        handleToken(loginDTO, authenticatedUserDTO);

        return authenticatedUserDTO;
    }

    private void handleToken(LoginDTO loginDTO, AuthenticatedUserDTO authenticatedUserDTO) {
        String token = tokenGeneration.generateToken();
        authenticatedUserDTO.setToken(token);
        updateTokenFromUserIntoDatabase(token, loginDTO, connectionService);
    }

    public void updateTokenFromUserIntoDatabase(String token, LoginDTO loginDTO, ConnectionService connectionService) {
        try {
            var statement = loginSQLStatementBuilder.buildUpdateTokenPreparedStatement(connectionService, token, loginDTO);
            statement.executeUpdate();
        } catch (SQLException e) {
            // todo: handle: sql exception
            e.printStackTrace();
        }
    }

    @Inject
    public void setLoginSQLStatementBuilder(LoginSQLStatementBuilder loginSQLStatementBuilder) {
        this.loginSQLStatementBuilder = loginSQLStatementBuilder;
    }
    @Inject
    public void setTokenGeneration(TokenGeneration tokenGeneration) {
        this.tokenGeneration = tokenGeneration;
    }
    @Inject
    public void setConnectionService(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }
}




















