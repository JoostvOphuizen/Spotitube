package nl.han.dea.joost.datasource.authentication;

import nl.han.dea.joost.datasource.connection.ConnectionService;

import java.sql.PreparedStatement;

public class AuthenticateSQLStatementBuilder {

    public PreparedStatement buildCheckTokenPreparedStatement(ConnectionService connectionService, String token) {
        String checkTokenSQLStatement = "SELECT token, username FROM users WHERE token = ?";
        try {
            PreparedStatement preparedStatement = connectionService.getConnection().prepareStatement(checkTokenSQLStatement);
            preparedStatement.setString(1, token);
            return preparedStatement;
        } catch (Exception e) {
            // todo: handle: database connection exception
            e.printStackTrace();
        }
        return null;
    }


}
