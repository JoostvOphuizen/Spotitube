package nl.han.dea.joost.datasource.login;

import nl.han.dea.joost.datasource.connection.ConnectionService;
import nl.han.dea.joost.resource.login.LoginDTO;

import java.sql.PreparedStatement;

public class LoginSQLStatementBuilder {

    public PreparedStatement buildGetUserPreparedStatement(ConnectionService connectionService, LoginDTO loginDTO){
        String getUserSQLStatement = "SELECT username FROM users WHERE username = ? AND password = ?";
        try {
            PreparedStatement preparedStatement = connectionService.getConnection().prepareStatement(getUserSQLStatement);
            preparedStatement.setString(1, loginDTO.getUser());
            preparedStatement.setString(2, loginDTO.getPassword());
            return preparedStatement;
        } catch (Exception e) {
            // todo: handle: database connection exception
            e.printStackTrace();
        }
        return null;
    }

    public PreparedStatement buildUpdateTokenPreparedStatement(ConnectionService connectionService, String token, LoginDTO loginDTO){
        String updateTokenSQLStatement = "UPDATE users SET token = ? WHERE username = ?";
        try {
            PreparedStatement preparedStatement = connectionService.getConnection().prepareStatement(updateTokenSQLStatement);
            preparedStatement.setString(1, token);
            preparedStatement.setString(2, loginDTO.getUser());
            return preparedStatement;
        } catch (Exception e) {
            // todo: handle: database connection exception
            e.printStackTrace();
        }
        return null;
    }


}
