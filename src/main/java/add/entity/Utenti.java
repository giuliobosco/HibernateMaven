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
package add.entity;

import java.util.Set;
import java.util.HashSet;

/**
 * 
 * @author giuliobosco
 * @version 1.0
 */
public class Utenti implements java.io.Serializable {
    // -------------------------------------------------------------------------------------------------------- Costants
    // ------------------------------------------------------------------------------------------------------ Attributes

    private Integer id;
    private String nome;
    private String cognome;
    private Integer anni;
    private Set amministratores = new HashSet(0);

    // ----------------------------------------------------------------------------------------------- Getters & Setters

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return this.cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public Integer getAnni() {
        return this.anni;
    }

    public void setAnni(Integer anni) {
        this.anni = anni;
    }
    public Set getAmministratores() {
        return this.amministratores;
    }

    public void setAmministratores(Set amministratores) {
        this.amministratores = amministratores;
    }

    // ---------------------------------------------------------------------------------------------------- Constructors

    public Utenti() {
    }

    public Utenti(String nome, String cognome, Integer anni, Set amministratores) {
        this.nome = nome;
        this.cognome = cognome;
        this.anni = anni;
        this.amministratores = amministratores;
    }

    // ---------------------------------------------------------------------------------------------------- Help Methods
    // ------------------------------------------------------------------------------------------------- General Methods
    // ----------------------------------------------------------------------------------------------- Static Components
    
}
