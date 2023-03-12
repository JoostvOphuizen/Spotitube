package nl.han.dea.joost.datasource;

import jakarta.inject.Inject;
import nl.han.dea.joost.datasource.connection.ConnectionService;
import nl.han.dea.joost.datasource.exceptions.DatabaseConnectionException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;


//  todo: try to make a signed token aka: make a hash based on the users credentials.
public class TokenGeneration {

    private String token;
    private ConnectionService connectionService;

    @Inject
    public void setConnectionService(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    private String[] getTokens() throws SQLException {
        String GET_TOKENS = "SELECT token FROM tokens";
        String[] tokens = new String[0];
        try {
            connectionService.initializeConnection();
        } catch (DatabaseConnectionException e) {
            e.printStackTrace();
        }
        var statement = connectionService.getConnection().prepareStatement(GET_TOKENS);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            tokens = Arrays.copyOf(tokens, tokens.length + 1);
            tokens[tokens.length - 1] = resultSet.getString("token");
        }
        return tokens;
    }

    public String generateRandomToken() {
        String possibleCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
        StringBuilder token = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                token.append(possibleCharacters.charAt((int) Math.floor(Math.random() * possibleCharacters.length())));
            }
            if (i < 2) {
                token.append("-");
            }
        }
        return token.toString();
    }

    public boolean isTokenUnique(String token, String[] tokens) {
        for (String t : tokens) {
            if (t.equals(token)) {
                return false;
            }
        }
        return true;
    }


    public String generateToken() {
        String[] tokens = new String[0];
        try {
            tokens = getTokens();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String token = generateRandomToken();
        while (!isTokenUnique(token, tokens)) {
            token = generateRandomToken();
        }
        return token;
    }

}
