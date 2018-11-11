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

import java.sql.*;

/**
 * Default data for connect the mysql server.
 * If the code not works and there is any problem with the timezone use: "../../sql/fix_cest_timezone.sql".
 *
 * @author giuliobosco
 * @version 1.1
 */
public class DbConnection {
    // -------------------------------------------------------------------------------------------------------- Costants

    /**
     * Default MySQL server hostname.
     */
    public static final String HOST = "localhost";

    /**
     * Default MySQL server port.
     */
    public static final int PORT = 3306;

    /**
     * Default MySQL server username.
     */
    public static final String USERNAME = "root";

    /**
     * Default MySQL server password.
     */
    public static final String PASSWORD = "1234qwer";

    // ------------------------------------------------------------------------------------------------------ Attributes
    // ----------------------------------------------------------------------------------------------- Getters & Setters
    // ---------------------------------------------------------------------------------------------------- Constructors
    // ---------------------------------------------------------------------------------------------------- Help Methods
    // ------------------------------------------------------------------------------------------------- General Methods
    // ----------------------------------------------------------------------------------------------- Static Components

    /**
     * Getter for the url.
     *
     * @param database Database to connect.
     * @return URL for connect to MySQL server.
     */
    public static String getUrl(String database) {
        return "jdbc:mysql://" + HOST + ":" + PORT + "/" + database;
    }

    /**
     * Get the connection to the database.
     *
     * @param database Database to connect.
     * @return The connection to the database.
     * @throws SQLException Error with the MySQL server.
     */
    public static Connection get(String database) throws SQLException {
        return DriverManager.getConnection(getUrl(database), USERNAME, PASSWORD);
    }

    /**
     * Close an connection, an statement and an result set.
     *
     * @param connection Connection to close.
     * @param statement Statement to close.
     * @param resultSet Result set to close.
     * @throws SQLException Errors while using MySQL server.
     */
    public static void close(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }

        if (statement != null) {
            statement.close();
        }

        if (connection != null) {
            connection.close();
        }
    }

    /**
     * Close an connection and an statement.
     *
     * @param statement Statement to close.
     * @param resultset Result set to close.
     * @throws SQLException Errors while using MySQL server.
     */
    public static void close(Statement statement, ResultSet resultset) throws SQLException {
        close(null, statement, resultset);
    }
}