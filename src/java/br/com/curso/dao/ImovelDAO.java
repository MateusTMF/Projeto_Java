/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.dao;

import br.com.curso.model.Imovel;
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
public class ImovelDAO implements GenericDAO {

    public Connection conexao;

    public ImovelDAO() throws Exception {
        conexao = SingleConnection.getConnection();
    }

    @Override
    public Boolean cadastrar(Object objeto) {
        Imovel oImovel = (Imovel) objeto;
        Boolean retorno = false;
        if (oImovel.getIdimovel() == 0) {
            retorno = this.inserir(oImovel);
        } else {
            retorno = this.alterar(oImovel);
        }
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
        Imovel oImovel = (Imovel) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into imovel (descricao,endereco,valoraluguel)values(?,?,?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oImovel.getDescricao());
            stmt.setString(2, oImovel.getEndereco());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao cadastrar a imovel: " + ex.getMessage());
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
        Imovel oImovel = (Imovel) objeto;
        PreparedStatement stmt = null;
        String sql = "update imovel set descricao=?,endereco=?,valoraluguel=? where idimovel = ?;";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oImovel.getDescricao());
            stmt.setString(2, oImovel.getEndereco());
            stmt.setInt(4, oImovel.getIdimovel());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao alterar imovel. Erro: " + ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            } catch (Exception e) {
                System.out.println("Erro" + e.getMessage());
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Boolean excluir(int numero) {
        int idimovel = numero;
        PreparedStatement stmt = null;
        String sql = "delete from imovel where idimovel = ?;";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idimovel);
            stmt.execute();
            conexao.commit();
            return true;
        }catch(Exception ex){
            try{
                System.out.println(""+ex.getMessage());
            }catch(Exception e){
                System.out.println(""+e.getMessage());
                e.printStackTrace();
            }
        }return false;
    }

    @Override
    public Object carregar(int numero) {
        int idimovel = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Imovel oImovel = null;
        String sql = "select * from imovel where idestado=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idimovel);
            rs = stmt.executeQuery();
            while (rs.next()) {
                oImovel = new Imovel();
                oImovel.setIdimovel(rs.getInt("idimovel"));
                oImovel.setDescricao(rs.getString("descricao"));
                oImovel.setEndereco(rs.getString("endereco"));
                oImovel.setValoraluguel(rs.getFloat("valoraluguel"));
            }
            return oImovel;
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar Imovel. Erro:" + ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from imovel order by idimovel";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Imovel oImovel = new Imovel();
                oImovel.setIdimovel(rs.getInt("idimovel"));
                oImovel.setDescricao(rs.getString("descricao"));
                oImovel.setEndereco(rs.getString("endereco"));
                oImovel.setValoraluguel(rs.getFloat("valoraluguel"));
                resultado.add(oImovel);
            }
        } catch (SQLException ex) {
            System.out.println("problemas ao listar Imovel. Erro: " + ex.getMessage());
        }
        return resultado;
    }

}
