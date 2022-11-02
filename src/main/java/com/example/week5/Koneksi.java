package com.example.week5;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Koneksi {
        public static Connection conn = null;
        private String URL = "x";
        private String username = "admindb";
        private String password = "admindb";

        public Koneksi(){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try {
                    conn = DriverManager.getConnection(URL, username, password);
                } catch (SQLException ex) {
                    Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }


