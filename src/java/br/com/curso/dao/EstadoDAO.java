/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.dao;

import br.com.curso.model.Estado;
import br.com.curso.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FEF
 */
public class EstadoDAO implements GenericDAO {

    private Connection conexao;

    public EstadoDAO() throws Exception {
        conexao = SingleConnection.getConnection();
    }

    @Override
    public Boolean cadastrar(Object objeto) {
        Estado oEstado = (Estado) objeto;
        Boolean retorno = false;
        if (oEstado.getIdestado() == 0) {
            retorno = this.inserir(oEstado);
        } else {
            retorno = this.alterar(oEstado);
        }
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
        Estado oEstado = (Estado) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into estado (nomestado,siglaestado) values (?,?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oEstado.getNomestado());
            stmt.setString(2, oEstado.getSiglaestado());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao cadastrar a Estado: " + ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

        return false;
    }

    @Override
    public Boolean alterar(Object objeto) {
        Estado oEstado = (Estado) objeto;
        PreparedStatement stmt = null;
        String sql = "update estado set nomestado=?,siglaestado=? where idestado=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oEstado.getNomestado());
            stmt.setString(2, oEstado.getSiglaestado());
            stmt.setInt(3, oEstado.getIdestado());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao alterar estado, erro: " + ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            } catch (Exception e) {
                System.out.println("rro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Boolean excluir(int numero) {
        int idestado = numero;
        PreparedStatement stmt = null;
        String sql = "delete from estado where idestado=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idestado);
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir estad. Erro: " + ex.getMessage());
            try {
                conexao.rollback();
            } catch (Exception e) {
                System.out.println("Erro no rollback: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Object carregar(int numero) {
        int idestado = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Estado oEstado = null;
        String sql = "select * from estado where idestado=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idestado);
            rs = stmt.executeQuery();
            while (rs.next()) {
                oEstado = new Estado();
                oEstado.setIdestado(rs.getInt("idestado"));
                oEstado.setNomestado(rs.getString("nomestado"));
                oEstado.setSiglaestado(rs.getString("siglaestado"));
            }
            return oEstado;
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar estados. Erro:" + ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from estado order by idestado";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Estado oEstado = new Estado();
                oEstado.setIdestado(rs.getInt("idestado"));
                oEstado.setNomestado(rs.getString("nomestado"));
                oEstado.setSiglaestado(rs.getString("siglaestado"));
                resultado.add(oEstado);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Estado! Erro: " + ex.getMessage());
        }
        return resultado;
    }

}
