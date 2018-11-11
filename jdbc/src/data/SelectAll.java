/*
 * The MIT License
 *
 * Copyright 2018 giuliobosco.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package data;

import java.sql.*;

/**
 * Select all from the employees table of the demo db.
 * If the code not works and there is any problem with the timezone use: "../../sql/fix_cest_timezone.sql".
 *
 * @author giuliobosco
 * @version 1.0
 */
public class SelectAll {
    // -------------------------------------------------------------------------------------------------------- Costants
    // ------------------------------------------------------------------------------------------------------ Attributes
    // ----------------------------------------------------------------------------------------------- Getters & Setters
    // ---------------------------------------------------------------------------------------------------- Constructors
    // ---------------------------------------------------------------------------------------------------- Help Methods
    // ------------------------------------------------------------------------------------------------- General Methods
    // ----------------------------------------------------------------------------------------------- Static Components

    /**
     * Select all from the employees table of the demo db.
     *
     * @param args Command line arguments.
     * @throws SQLException Error while using MySQL server.
     */
    public static void main(String[] args) throws SQLException {
        // Connection to the db
        Connection conn = null;
        // Statement for execute queries.
        Statement stmt = null;
        // Result of the query.
        ResultSet rs = null;

        // URL for coonect to the MySQL Server.
        String url = "jdbc:mysql://localhost:3306/demo";
        // MySQL Server username.
        String user = "root";
        // MySQL Server password.
        String pass = "1234qwer";

        try {
            // Create the connection to the db.
            conn = DriverManager.getConnection(url, user, pass);

            // Create the statement of the connection.
            stmt = conn.createStatement();

            // Execute the query
            rs = stmt.executeQuery("SELECT * FROM demo.employees");

            // Process the result
            while (rs.next()) {
                // print each line of the result.
                System.out.println(rs.getString("last_name") + ", " + rs.getString("first_name"));
            }
        } catch (SQLException sqle) {
            // Error while using MySQL.
            sqle.printStackTrace();
        } finally {
            // check and close the result of the query.
            if (rs != null) {
                rs.close();
            }

            // check and close the statement.
            if (stmt != null) {
                stmt.close();
            }

            // Check and close the connection.
            if (conn != null) {
                conn.close();
            }
        }
    }
}