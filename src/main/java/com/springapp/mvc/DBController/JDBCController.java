package com.springapp.mvc.DBController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.*;

@Controller

public class JDBCController {


    @RequestMapping(value = "/jdbcTest", method = RequestMethod.GET)
    public String getDBData() throws SQLException {

        String username = "root";
        String password = "letmein";

        //defines object which can connect java applications to a JDBC driver
        Connection con = DriverManager.getConnection("jdbc:myDriver:myDatabase", username, password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT a, b, c FROM Table1");

        while(rs.next()){
            int x = rs.getInt("a");
            String s = rs.getString("b");
            float f = rs.getFloat("c");

            System.out.println(x + " " + s + " " + f + " ");
        }



        return "test.html";
    }


}
