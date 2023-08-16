/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.model;

/**
 *
 * @author FEF
 */
public class Estado {
    private int idestado;
    private String nomestado;
    private String siglaestado;

    public Estado() {
        this.idestado = 0;
        this.nomestado = "";
        this.siglaestado = "";
    }

    public Estado(int idestado, String nomestado, String siglaestado) {
        this.idestado = idestado;
        this.nomestado = nomestado;
        this.siglaestado = siglaestado;
    }

    public int getIdestado() {
        return idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    public String getNomestado() {
        return nomestado;
    }

    public void setNomestado(String nomestado) {
        this.nomestado = nomestado;
    }

    public String getSiglaestado() {
        return siglaestado;
    }

    public void setSiglaestado(String siglaestado) {
        this.siglaestado = siglaestado;
    }
    
    
}
