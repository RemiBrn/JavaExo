package org.example.exo03recette.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDAO<T> {

    protected Connection connection;
    protected String request;
    protected ResultSet resultSet;
    protected PreparedStatement statement;

    public BaseDAO() {

    }

    public abstract T create (T element) throws SQLException;
    public abstract boolean delete (T element) throws SQLException;
    public abstract T update (T element) throws SQLException;
    public abstract T get (int id) throws SQLException;
    public abstract List<T> get () throws SQLException;

    protected void close() throws SQLException {
        if(resultSet != null && !resultSet.isClosed()){
            resultSet.close();
        }
        if (statement != null && !statement.isClosed()){
            statement.close();
        }
        if (connection != null && !connection.isClosed()){
            connection.close();
        }
    }
}
