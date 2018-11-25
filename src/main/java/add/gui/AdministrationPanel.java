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

import add.entity.Amministratore;
import add.entity.Utenti;
import add.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

/**
 * 
 * @author giuliobosco
 * @version 1.0
 */
public class AdministrationPanel  extends JPanel {
    // -------------------------------------------------------------------------------------------------------- Costants
    // ------------------------------------------------------------------------------------------------------ Attributes

    private JPanel searchBarPanel;
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JButton searchButton;
    private JScrollPane userScrollPane;
    private JTable userTable;

    // ----------------------------------------------------------------------------------------------- Getters & Setters
    // ---------------------------------------------------------------------------------------------------- Constructors

    public AdministrationPanel() {
        initComponents();
    }

    // ---------------------------------------------------------------------------------------------------- Help Methods

    private void initComponents() {
        this.setLayout(new BorderLayout());

        this.searchBarPanel = new JPanel();
        this.searchBarPanel.setLayout(new BoxLayout(this.searchBarPanel, BoxLayout.LINE_AXIS));

        this.nameLabel = new JLabel();
        this.nameLabel.setText("Name:");
        this.searchBarPanel.add(this.nameLabel);

        this.nameTextField = new JTextField();
        this.searchBarPanel.add(this.nameTextField);

        this.searchButton = new JButton();
        this.searchButton.setText("Search");
        this.searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchButtonActionPerformed(e);
            }
        });
        this.searchBarPanel.add(this.searchButton);

        this.add(this.searchBarPanel, BorderLayout.NORTH);

        this.userTable = new JTable();
        this.userTable.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));

        this.userScrollPane = new JScrollPane();
        this.userScrollPane.setViewportView(this.userTable);

        this.add(this.userScrollPane, BorderLayout.CENTER);
    }

    private void displayResult(ArrayList<Amministratore> resultList) {
        Vector<String> tableHeaders = new Vector<String>();

        Vector tableData = new Vector();
        tableHeaders.add("Name");

        for (Amministratore admin : resultList) {
            Vector<Object> oneRow = new Vector<Object>();
            Utenti a = admin.getUtenti();
            oneRow.add(a.getNome());
            tableData.add(oneRow);
        }

        this.userTable.setModel(new DefaultTableModel(tableData, tableHeaders));
    }

    private void executeHQLQuery() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Criteria q = session.createCriteria(Amministratore.class)
                    .add(Restrictions.like("id", Integer.parseInt(nameTextField.getText())));

            ArrayList<Amministratore> resultList = (ArrayList<Amministratore>) q.list();
            this.displayResult(resultList);

            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }

    private void searchButtonActionPerformed(ActionEvent e) {
        if (!nameTextField.getText().trim().equals("")) {
            this.executeHQLQuery();
        }
    }

    // ------------------------------------------------------------------------------------------------- General Methods
    // ----------------------------------------------------------------------------------------------- Static Components
    
}
