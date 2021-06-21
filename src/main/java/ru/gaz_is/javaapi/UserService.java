package ru.gaz_is.javaapi;

import java.sql.SQLException;

public interface UserService<T,V> {
    T getFor(V name) throws SQLException;

    void updateFor(T user) throws SQLException;
}
