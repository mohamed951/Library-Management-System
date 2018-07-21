/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import LMS.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Remon
 */
public class LogTest {

    public LogTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Cannot load JDBC Driver!");
        }
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setComponent method, of class Log.
     */
 //   @Test
//    public void testSetComponent() {
//        System.out.println("setComponent");
//        Log instance = new Log();
//        instance.setComponent();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of main method, of class Log.
     */
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        Log.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    @Test
    public void TestLogin() {
        Log frame = new Log();
        frame.UserName1.setText("m1m");
        frame.Password1.setText("1234");
        frame.LogIn.doClick();

        Connection con = null;
        Statement stmt = null;
        ResultSet results = null;
        try {
            //Thread.sleep(2000);
            final String url = "jdbc:sqlserver://localhost\\scvmm;databaseName=LMS;integratedSecurity=true;";
            con = DriverManager.getConnection(url);
            stmt = con.createStatement();
            String sql = "SELECT * FROM Login WHERE Name ='" + frame.UserName1.getText()+"' "
            + ""
                    + "AND Password = '"+frame.Password1.getText()+"'";
            results = stmt.executeQuery(sql);

            assertTrue(results.next());

          
        } catch (Exception ex) {
            fail(ex.getMessage());
        } finally {
            if (results != null) {
                try {
                    results.close();
                } catch (Exception ex) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception ex) {
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception ex) {
                }
            }
        }
    }

 
    }
