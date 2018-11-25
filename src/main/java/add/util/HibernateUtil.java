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
package add.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.File;

/**
 *
 * @author giuliobosco
 * @version 1.0
 */
public class HibernateUtil {
    // -------------------------------------------------------------------------------------------------------- Costants
    // ------------------------------------------------------------------------------------------------------ Attributes
    // ----------------------------------------------------------------------------------------------- Getters & Setters
    // ---------------------------------------------------------------------------------------------------- Constructors
    // ---------------------------------------------------------------------------------------------------- Help Methods
    // ------------------------------------------------------------------------------------------------- General Methods
    // ----------------------------------------------------------------------------------------------- Static Components

    private static final SessionFactory sessionFactory;
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml)
            // config file.
             //sessionFactory = new Configuration().configure("target/classes/hibernate.cfg.xml").buildSessionFactory();
            //sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

            String hibernatePropsFilePath = "target/classes/hibernate.cfg.xml";
            File hibernatePropsFile = new File(hibernatePropsFilePath);

            Configuration configuration = new Configuration();
            configuration.configure(hibernatePropsFile);

            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            // Log the exception.
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
