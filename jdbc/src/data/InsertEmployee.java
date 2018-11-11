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

import help.DbConnection;

import java.sql.*;

/**
 * Insert an employee in the employees table of the demo database.
 * If the code not works and there is any problem with the timezone use: "../../sql/fix_cest_timezone.sql".
 *
 * @author giuliobosco
 * @version 1.0
 */
public class InsertEmployee {
    // -------------------------------------------------------------------------------------------------------- Costants
    // ------------------------------------------------------------------------------------------------------ Attributes
    // ----------------------------------------------------------------------------------------------- Getters & Setters
    // ---------------------------------------------------------------------------------------------------- Constructors
    // ---------------------------------------------------------------------------------------------------- Help Methods
    // ------------------------------------------------------------------------------------------------- General Methods
    // ----------------------------------------------------------------------------------------------- Static Components

    /**
     * Insert an employee in the employees table of the demo database.
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

        try {
            // Create the connection to the db.
            conn = DbConnection.get("demo");

            // Create the statement of the connection.
            stmt = conn.createStatement();

            // Insert a new employee in the employees table.
            int rowsAffected = stmt.executeUpdate(
                    "INSERT INTO demo.employees" +
                            "(last_name, first_name, email, department, salary) " +
                            "VALUES " +
                            "('Wright', 'Eric', 'eric.wright@foo.com', 'HR', 33000.00)"
            );

            // Select the employee with "Wright" as last_name.
            rs = stmt.executeQuery("SELECT * FROM demo.employees WHERE employees.last_name LIKE 'Wright'");

            // Process the result
            while (rs.next()) {
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
