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

/*
 * Demo database.
 *
 * @author giuliobosco
 * @version 1.0
 */

/*
 * Drop the demo database if exist.
 * Every data in the demo database will be lost.
 */
DROP DATABASE IF EXISTS demo;

/*
 * Create the demo database.
 */
CREATE DATABASE demo;

/*
 * Create the employees table in demo database.
 * As an InnoDB table.
 */
CREATE TABLE demo.`employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(64) DEFAULT NULL,
  `first_name` varchar(64) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `department` varchar(64) DEFAULT NULL,
  `salary` DECIMAL(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

/*
 * Insert some data for tests.
 */
INSERT INTO demo.`employees` (`id`,`last_name`,`first_name`,`email`, `department`, `salary`) VALUES
		(1,'Doe','John','john.doe@foo.com', 'HR', 55000.00),
		(2,'Public','Mary','mary.public@foo.com', 'Engineering', 75000.00),
		(2,'Public','Mary','mary.public@foo.com', 'Engineering', 75000.00),
		(3,'Queue','Susan','susan.queue@foo.com', 'Legal', 130000.00),
		(4,'Williams','David','david.williams@foo.com', 'HR', 120000.00),
		(5,'Johnson','Lisa','lisa.johnson@foo.com', 'Engineering', 50000.00),
		(6,'Smith','Paul','paul.smith@foo.com', 'Legal', 100000.00),
		(7,'Adams','Carl','carl.adams@foo.com', 'HR', 50000.00),
		(8,'Brown','Bill','bill.brown@foo.com', 'Engineering', 50000.00),
		(9,'Thomas','Susan','susan.thomas@foo.com', 'Legal', 80000.00),
		(10,'Davis','John','john.davis@foo.com', 'HR', 45000.00),
		(11,'Fowler','Mary','mary.fowler@foo.com', 'Engineering', 65000.00),
		(12,'Waters','David','david.waters@foo.com', 'Legal', 90000.00);
