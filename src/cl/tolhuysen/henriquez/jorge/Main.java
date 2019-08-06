package cl.tolhuysen.henriquez.jorge;

import oracle.jdbc.OraclePreparedStatement;

import java.sql.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    private static final String connstr  = "jdbc:oracle:thin:@//192.168.1.253:1521/sistemas.localdomain";
    private static final String user     = "DESAFIO";
    private static final String password = "DesafiO.123456";

    public static void main(String[] args) {
	// write your code here
        String randomNum = String.format("%010d", ThreadLocalRandom.current().nextInt(1, 10000000 + 1));
        String userFistName = String.format("FirstName_Random%s", randomNum);
        String userLastName = String.format("LastName_Random%s", randomNum);
        String userEmail = String.format("user_random%s@gmail.com", randomNum);
        String userPassword = "123456";
        boolean userIsLender = true;
        boolean userIsBorrower = false;
        int retval;
        System.out.printf("First Name: %s, Last Name: %s, e-Mail: %s\n", userFistName, userLastName, userEmail);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con;
            try {
                con = DriverManager.getConnection(connstr, user, password);
                OraclePreparedStatement ops;
                ResultSet rs;
                ops=(OraclePreparedStatement)con.prepareStatement("SELECT COUNT(EMAIL) FROM USERS WHERE UPPER(EMAIL) = ?");
                ops.setString(1, userEmail.toUpperCase());
                rs=ops.executeQuery();
                rs.next();
                int count = rs.getInt(1);
                rs.close();
                if (count==0) {
                    ops=(OraclePreparedStatement)con.prepareStatement("INSERT INTO USERS(EMAIL, PASSWORD, FNAME, LNAME, ISLENDER, ISBORROWER) VALUES(?, ?, ?, ?, ?, ?) RETURNING USERID INTO ?");
                    ops.setString(1, userEmail);
                    ops.setString(2, userPassword);
                    ops.setString(3, userFistName);
                    ops.setString(4, userLastName);
                    ops.setString(5, (userIsLender)?"S":"N");
                    ops.setString(6, (userIsBorrower)?"S":"N");
                    ops.registerReturnParameter(7, Types.INTEGER);
                    ops.execute();
                    rs = ops.getReturnResultSet();
                    rs.next();
                    retval = rs.getInt(1);
                    rs.close();
                }
                else {
                    retval = -10;
                }
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                retval = -3;
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            retval = -4;
        }
        System.out.println(retval);
    }
}
