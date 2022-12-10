package models;

import java.sql.SQLException;

import javax.swing.*;

import database.Database;

public class Acc extends Database {
    public Acc() throws ClassNotFoundException, SQLException {
        super();
    }

    public boolean authentication(String us, String pw) throws SQLException {
        String sql = String.format("SELECT * FROM user WHERE username = '%s' AND password = '%s'", us, pw);
        this.setQuery(sql);
        this.take();
        
        while(this.value.next()) {
            if(this.value.getString("username") != null) {
                return true;
            }
        }
        
        return false;
    }
}
