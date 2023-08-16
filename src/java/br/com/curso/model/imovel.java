/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.model;

/**
 *
 * @author FEF
 */
public class Imovel {
    private int idimovel;
    private String descricao;
    private String endereco;
    private Number valoraluguel;

    public Imovel() {
        this.idimovel = 0;
        this.descricao = "";
        this.endereco = "";
        this.valoraluguel = 0;
    }

    public Imovel(int idimovel, String descricao, String endereco, Number valoraluguel) {
        this.idimovel = idimovel;
        this.descricao = descricao;
        this.endereco = endereco;
        this.valoraluguel = valoraluguel;
    }

    public int getIdimovel() {
        return idimovel;
    }

    public void setIdimovel(int idimovel) {
        this.idimovel = idimovel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Number getValoraluguel() {
        return valoraluguel;
    }

    public void setValoraluguel(Number valoraluguel) {
        this.valoraluguel = valoraluguel;
    }
    
    
}
