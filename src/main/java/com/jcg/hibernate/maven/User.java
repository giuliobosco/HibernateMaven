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
package com.jcg.hibernate.maven;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * HibernateMaven Database tables user object.
 *
 * @author giuliobosco
 * @version 1.0
 */
@Entity
@Table(name = "user_table")
public class User {
    // -------------------------------------------------------------------------------------------------------- Costants
    // ------------------------------------------------------------------------------------------------------ Attributes

    /**
     * User id.
     */
    @Id
    @Column(name = "user_id")
    private int userid;

    /**
     * Username.
     */
    @Column(name = "user_name")
    private String username;

    /**
     * Created by user.
     */
    @Column(name = "created_by")
    private String createdBy;

    /**
     * Creation date.
     */
    @Column(name = "created_date")
    private Date createdDate;

    // ----------------------------------------------------------------------------------------------- Getters & Setters

    /**
     * Get the user id.
     *
     * @return User id.
     */
    public int getUserid() {
        return userid;
    }

    /**
     * Set the user id.
     *
     * @param userid User id.
     */
    public void setUserid(int userid) {
        this.userid = userid;
    }

    /**
     * Get the username.
     *
     * @return Username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the username.
     *
     * @param username Username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the created by user.
     *
     * @return Created by user.
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Set the created by user.
     *
     * @param createdBy Created by User.
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Get the creation date.
     *
     * @return Creation date.
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * Set the creation date.
     *
     * @param createdDate Creation date.
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    // ---------------------------------------------------------------------------------------------------- Constructors
    // ---------------------------------------------------------------------------------------------------- Help Methods
    // ------------------------------------------------------------------------------------------------- General Methods
    // ----------------------------------------------------------------------------------------------- Static Components
    
}
