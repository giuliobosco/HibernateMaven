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
 * @author giuliobosco
 * @version 1.0
 */
public class AddForm3Maven extends JFrame {
    // -------------------------------------------------------------------------------------------------------- Costants
    // ------------------------------------------------------------------------------------------------------ Attributes

    private JTabbedPane tabbedPane = new JTabbedPane();

    private JPanel usersPanel;
    private JLabel uTitleLabel;
    private JLabel uEmpty;
    private JLabel uNameLabel;
    private JLabel uSurnameLabel;
    private JLabel uEtaLabel;
    private JTextField uNameTextFiled;
    private JTextField uSurnameTextFiled;
    private JSpinner uEtaSpinner;
    private JButton uSendButton;
    private JLabel testLabel;

    private JPanel administrationPanel;
    private JLabel aNameLabel;
    private JTextField aNameTextField;
    private JButton aSearchButton;
    private JScrollPane aUserScrollPane;
    private JTable aUserTable;

    // ----------------------------------------------------------------------------------------------- Getters & Setters
    // ---------------------------------------------------------------------------------------------------- Constructors

    public AddForm3Maven() {
        initComponents();
    }

    // ---------------------------------------------------------------------------------------------------- Help Methods

    private void initComponents() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(300, 200));

        tabbedPane = new JTabbedPane();

        usersPanel = new JPanel();
        usersPanel.setPreferredSize(new Dimension(415, 270));
        usersPanel.setLayout(new GridLayout(5, 2));

        uTitleLabel = new JLabel();
        uTitleLabel.setText("User Data");
        usersPanel.add(this.uTitleLabel);

        this.uEmpty = new JLabel();
        this.uEmpty.setText("empty");
        usersPanel.add(this.uEmpty);

        this.uNameLabel = new JLabel();
        this.uNameLabel.setText("Name:");
        this.usersPanel.add(this.uNameLabel);

        this.uNameTextFiled = new JTextField();
        this.uNameTextFiled.setText("name");
        this.usersPanel.add(this.uNameTextFiled);

        this.uSurnameLabel = new JLabel();
        this.uSurnameLabel.setText("Surname:");
        this.usersPanel.add(this.uSurnameLabel);

        this.uSurnameTextFiled = new JTextField();
        this.uSurnameTextFiled.setText("surname");
        this.usersPanel.add(this.uSurnameTextFiled);

        this.uEtaLabel = new JLabel();
        this.uEtaLabel.setText("eta:");
        this.usersPanel.add(this.uEtaLabel);

        this.uEtaSpinner = new JSpinner();
        this.usersPanel.add(this.uEtaSpinner );

        this.uSendButton = new JButton();
        this.uSendButton.setText("Send");
        this.uSendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                uSendButtonActionPerformed(evt);
            }
        });
        this.usersPanel.add(this.uSendButton);

        this.tabbedPane.addTab("User", null, this.usersPanel, "");

        this.getContentPane().add(this.tabbedPane);

        pack();
    }

    private void uSendButtonActionPerformed(ActionEvent e) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Utenti user = new Utenti();
        user.setNome(this.uNameTextFiled.getText());
        user.setCognome(this.uSurnameTextFiled.getText());
        user.setAnni((Integer) (uEtaSpinner.getValue()));

        session.save(user);
        session.getTransaction().commit();
    }

    // ------------------------------------------------------------------------------------------------- General Methods
    // ----------------------------------------------------------------------------------------------- Static Components

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddForm3Maven.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddForm3Maven.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddForm3Maven.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddForm3Maven.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddForm3Maven().setVisible(true);
            }
        });
    }
}
