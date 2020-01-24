package net.bit.databaseExamples.jdbc;

import java.sql.*;

public class JDCB_Intro {
    public static void main(String[] args) {
        String URL="jdbc:mysql://localhost/academia?serverTimezone=UTC";
        final String USER = "dev";
        final String PASSWORD ="mysqlpassword";
        final String ALL_AGENTS = "SELECT id, firstname, lastname from AGENT";
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("connected!");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(ALL_AGENTS);
            while(rs.next()) {
                System.out.printf ("%s %s %s", rs.getString("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"));

            }




        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
