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
package help;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Example Employee.
 *
 * @author giuliobosco
 * @version 1.1
 */
public class Employee {
    // -------------------------------------------------------------------------------------------------------- Costants
    // ------------------------------------------------------------------------------------------------------ Attributes
    // ----------------------------------------------------------------------------------------------- Getters & Setters
    // ---------------------------------------------------------------------------------------------------- Constructors
    // ---------------------------------------------------------------------------------------------------- Help Methods
    // ------------------------------------------------------------------------------------------------- General Methods
    // ----------------------------------------------------------------------------------------------- Static Components

    /**
     * Get the employees with the last name and first name, like the parameter, in the database connection parameter.
     * Search in the employee table of the demo database.
     *
     * @param conn Connectiont to the database.
     * @param lastName Last name to search in the table.
     * @param firstName First name to search in the table.
     * @return The last name, the first name and the email of the employees.
     */
    public static String toString(Connection conn, String lastName, String firstName) throws SQLException {
        // Prepared statement for the query.
        PreparedStatement stmt = null;
        // Result set of the query.
        ResultSet rs = null;
        // Result string, analysis of the result set.
        String result = null;

        try {
            // Initialize query statement.
            stmt = conn.prepareStatement("SELECT employees.last_name, employees.first_name, employees.email FROM demo.employees WHERE employees.last_name = ? AND employees.first_name = ?");

            // Query statement parameters data insertion
            stmt.setString(1, lastName);
            stmt.setString(2, firstName);

            // Execute the query.
            rs = stmt.executeQuery();
            // Initialize the result string.
            result = "";

            // Initialize found flag.
            boolean found = false;

            // analysis of the query result.
            while (rs.next()) {
                // Write data in the result string.
                result += rs.getString("last_name") + ", ";
                result += rs.getString("first_name") + ", ";
                result += rs.getString("email") + "\n";

                // set the found flag.
                found = true;
            }

            // if no employee found set the result string to "No Employee Found".
            if (!found) {
                result = "No Employee Found";
            }

            // Return the result.
            return result;
        } catch (SQLException sqle) {
            // Error while operation on MySQL Server.
            sqle.printStackTrace();
        } finally {
            // Close the statement and the result set.
            DbConnection.close(stmt, rs);
            return result;
        }
    }
}
