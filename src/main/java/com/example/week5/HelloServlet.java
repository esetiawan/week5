package com.example.week5;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private String nama, nrp;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        boolean login;
        Connection conn = new Koneksi().conn;
        String query = "select * from mahasiswa";
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                login = true;
                nama = rs.getString("nama");
                nrp = rs.getString("nrp");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + nama + "</h1>");
        out.println("<h1>" + nrp + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}