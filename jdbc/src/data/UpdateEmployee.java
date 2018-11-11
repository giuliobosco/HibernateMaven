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
import help.Employee;

import java.sql.*;

/**
 * Update an employee in the employees table of the demo database.
 * If the code not works and there is any problem with the timezone use: "../../sql/fix_cest_timezone.sql".
 *
 * @author giuliobosco
 * @version 1.1
 */
public class UpdateEmployee {
    // -------------------------------------------------------------------------------------------------------- Costants
    // ------------------------------------------------------------------------------------------------------ Attributes
    // ----------------------------------------------------------------------------------------------- Getters & Setters
    // ---------------------------------------------------------------------------------------------------- Constructors
    // ---------------------------------------------------------------------------------------------------- Help Methods
    // ------------------------------------------------------------------------------------------------- General Methods
    // ----------------------------------------------------------------------------------------------- Static Components

    /**
     * Update an employee in the employees table of the demo database.
     *
     * @param args Command line arguments.
     * @throws SQLException Error while using MySQL server.
     */
    public static void main(String[] args) throws SQLException {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DbConnection.get("demo");

            statement = connection.createStatement();

            System.out.println("Initials employee------------------");
            System.out.println(Employee.toString(connection, "Doe", "John"));

            int rowsAffected = statement.executeUpdate(
                    "update employees " +
                            "set email='john.doe@luv2code.com' " +
                            "where last_name='Doe' and first_name='John'");

            System.out.println("Final employee--------------------");
            System.out.println(Employee.toString(connection, "Doe", "John"));

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            DbConnection.close(connection, statement, resultSet);
        }
    }
}
