package ru.gaz_is.javaapi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserUserServiceImpl implements UserService<User, String> {
    private DataBaseProperties dataBaseProperties;
    private String query;
    private Statement statement;

    public UserUserServiceImpl() throws SQLException {
        this.dataBaseProperties = new DataBaseProperties();
    }

    public User getFor(String name) throws SQLException {
        this.statement = dataBaseProperties.getConnection().createStatement();
        query = "SELECT * FROM users WHERE username LIKE '%" + name + "%'";
        final ResultSet resultSet = statement.executeQuery(query);
        User result = new User();
        while(resultSet.next()){
            result.setId(resultSet.getInt("id"));
            result.setName(resultSet.getString("name"));
            result.setSurname(resultSet.getString("surname"));
            result.setSurname(resultSet.getString("username"));
        }
        return result;
    }

    public void updateFor(User user) throws SQLException {
    if(user.getId() > 0){
        query = "SELECT * FROM users WHERE username LIKE '%" + user.getUsername() +"%' ";
        statement = dataBaseProperties.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                                        ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.first();
        resultSet.updateString("surname", user.getSurname());
        resultSet.updateRow();
    }
    }
}
