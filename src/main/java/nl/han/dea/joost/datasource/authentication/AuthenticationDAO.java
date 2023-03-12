package nl.han.dea.joost.datasource.authentication;

import jakarta.inject.Inject;
import nl.han.dea.joost.datasource.connection.ConnectionService;
import nl.han.dea.joost.resource.login.AuthenticatedUserDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthenticationDAO {

    private ConnectionService connectionService;

    private AuthenticateSQLStatementBuilder authenticateSQLStatementBuilder;


    public ResultSet checkTokenInDatabase(String token) throws SQLException {
        connectionService.initializeConnection();
        var statement = authenticateSQLStatementBuilder.buildCheckTokenPreparedStatement(connectionService, token);
        return statement.executeQuery();
    }

    public boolean isTokenValid(ResultSet resultSet, String token) throws SQLException {
        if(resultSet != null && resultSet.next()){
            return resultSet.getString("token").equals(token);
        }
        return false;
    }

    public boolean authenticateToken(String token) {
        try {
            return isTokenValid(checkTokenInDatabase(token), token);
        } catch (SQLException e) {
            return false;
        }
    }

    public AuthenticatedUserDTO getAuthenticatedUser(String token) throws SQLException {
        AuthenticatedUserDTO authenticatedUserDTO = new AuthenticatedUserDTO();
        var resultSet = checkTokenInDatabase(token);
        if(resultSet != null && resultSet.next()) {
            authenticatedUserDTO.setUser(resultSet.getString("username"));
        }
        return authenticatedUserDTO;
    }


    @Inject
    public void setAuthenticateSQLStatementBuilder(AuthenticateSQLStatementBuilder authenticateSQLStatementBuilder) {
        this.authenticateSQLStatementBuilder = authenticateSQLStatementBuilder;
    }
    @Inject
    public void setConnectionService(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

}
