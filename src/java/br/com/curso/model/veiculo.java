/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.model;

/**
 *
 * @author HOME
 */
public class Veiculo {
    private int idveiculo;
    private String marcaveiculo;
    private String modeloveiculo;

    public Veiculo() {
        this.idveiculo = 0;
        this.marcaveiculo = "";
        this.modeloveiculo = "";
    }

    public Veiculo(int idveiculo, String marcaveiculo, String modeloveiculo) {
        this.idveiculo = idveiculo;
        this.marcaveiculo = marcaveiculo;
        this.modeloveiculo = modeloveiculo;
    }

    public int getIdveiculo() {
        return idveiculo;
    }

    public void setIdveiculo(int idveiculo) {
        this.idveiculo = idveiculo;
    }

    public String getMarcaveiculo() {
        return marcaveiculo;
    }

    public void setMarcaveiculo(String marcaveiculo) {
        this.marcaveiculo = marcaveiculo;
    }

    public String getModeloveiculo() {
        return modeloveiculo;
    }

    public void setModeloveiculo(String modeloveiculo) {
        this.modeloveiculo = modeloveiculo;
    }
    
    
}
