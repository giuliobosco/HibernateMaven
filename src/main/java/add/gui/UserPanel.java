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
package add.gui;

import add.entity.Utenti;
import add.util.HibernateUtil;
import org.hibernate.Session;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User insertion panel.
 *
 * @author giuliobosco
 * @version 1.0
 */
public class UserPanel extends JPanel {
    // -------------------------------------------------------------------------------------------------------- Costants
    // ------------------------------------------------------------------------------------------------------ Attributes

    /**
     * Page title label
     */
    private JLabel titleLabel;

    /**
     * Empty label for keep right spaces.
     */
    private JLabel emptyLabel;

    /**
     * First name label.
     */
    private JLabel firstNameLabel;

    /**
     * Last name label.
     */
    private JLabel lastNameLabel;

    /**
     * Age label.
     */
    private JLabel ageLabel;

    /**
     * First name text filed.
     */
    private JTextField firstNameTextField;

    /**
     * Last name text field.
     */
    private JTextField lastNameTextField;

    /**
     * Age Spinner.
     */
    private JSpinner ageSpinner;

    /**
     * Send data button.
     */
    private JButton sendButton;

    // ----------------------------------------------------------------------------------------------- Getters & Setters
    // ---------------------------------------------------------------------------------------------------- Constructors

    /**
     * User panel constructor, initialize components.
     */
    public UserPanel() {
        initComponents();
    }

    // ---------------------------------------------------------------------------------------------------- Help Methods

    /**
     * Initialize components.
     */
    private void initComponents() {
        this.setLayout(new GridLayout(5, 2));

        this.titleLabel = new JLabel();
        this.titleLabel.setText("User data");
        this.add(this.titleLabel);

        this.emptyLabel = new JLabel();
        this.add(this.emptyLabel);

        this.firstNameLabel = new JLabel();
        this.firstNameLabel.setText("First name:");
        this.add(this.firstNameLabel);

        this.firstNameTextField = new JTextField();
        this.add(this.firstNameTextField);

        this.lastNameLabel = new JLabel();
        this.lastNameLabel.setText("Last name:");
        this.add(this.lastNameLabel);

        this.lastNameTextField = new JTextField();
        this.add(this.lastNameTextField);

        this.ageLabel = new JLabel();
        this.ageLabel.setText("Age:");
        this.add(this.ageLabel);

        this.ageSpinner = new JSpinner();
        this.add(this.ageSpinner);

        this.sendButton = new JButton();
        this.sendButton.setText("Send");
        this.sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendButtonActionPerformed(e);
            }
        });
        this.add(this.sendButton);
    }

    /**
     * On send button action performed, write data to database.
     *
     * @param e Button action event.
     */
    private void sendButtonActionPerformed(ActionEvent e) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Utenti user = new Utenti();
        user.setNome(this.firstNameTextField.getText());
        user.setCognome(this.lastNameTextField.getText());
        user.setAnni((Integer) (this.ageSpinner.getValue()));

        session.save(user);
        session.getTransaction().commit();
    }

    // ------------------------------------------------------------------------------------------------- General Methods
    // ----------------------------------------------------------------------------------------------- Static Components

}
