/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.dao;

import br.com.curso.model.Veiculo;
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
public class VeiculoDAO implements GenericDAO {

    private Connection conexao;

    public VeiculoDAO() throws Exception {
        conexao = SingleConnection.getConnection();
    }

    @Override
    public Boolean cadastrar(Object objeto) {
        Veiculo oVeiculo = (Veiculo) objeto;
        Boolean retorno = false;
        if (oVeiculo.getIdveiculo() == 0) {
            retorno = this.inserir(oVeiculo);
        } else {
            retorno = this.alterar(oVeiculo);
        }
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
        Veiculo oVeiculo = (Veiculo) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into veiculo (marcaveiculo,modeloveiculo) values (?,?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oVeiculo.getMarcaveiculo());
            stmt.setString(2, oVeiculo.getModeloveiculo());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao cadastrar veiculo. Erro:" + ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Boolean alterar(Object objeto) {
        Veiculo oVeiculo = (Veiculo) objeto;
        PreparedStatement stmt = null;
        String sql ="update veiculo set marcaveiculo=?,modeloveiculo=? where idveiculo=?";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oVeiculo.getMarcaveiculo());
            stmt.setString(2, oVeiculo.getModeloveiculo());
            stmt.setInt(3, oVeiculo.getIdveiculo());
            stmt.execute();
            conexao.commit();
            return true;
        }catch(Exception ex){
            try{
                System.out.println("Problemas ao alterar veiculo. Erro: "+ ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            }catch(Exception e){
                System.out.println("Erro: "+e.getMessage());
                ex.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean excluir(int numero) {
        int idveiculo = numero;
        PreparedStatement stmt = null;
        String sql = "delete from veiculo where idveiculo=?";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idveiculo);
            stmt.execute();
            conexao.commit();
            return true;
        }catch(Exception ex){
            System.out.println("Problemas ao excluir veiculo. Erro: "+ ex.getMessage());
            try{
                conexao.rollback();
            }catch(Exception e){
                System.out.println("Erro no rollback: "+ e.getMessage());
                e.printStackTrace();
            }
        }return false;
    }

    @Override
    public Object carregar(int numero) {
        int idveiculo = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Veiculo oVeiculo = null;
        String sql = "select * from veiculo where idveiculo=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idveiculo);
            rs = stmt.executeQuery();
            while (rs.next()) {
                oVeiculo = new Veiculo();
                oVeiculo.setIdveiculo(rs.getInt("idveiculo"));
                oVeiculo.setMarcaveiculo(rs.getString("marcaveiculo"));
                oVeiculo.setModeloveiculo(rs.getString("modeloveiculo"));
            }
            return oVeiculo;
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar Veiculo. Erro:" + ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from veiculo order by idveiculo";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Veiculo oVeiculo = new Veiculo();
                oVeiculo.setIdveiculo(rs.getInt("idveiculo"));
                oVeiculo.setMarcaveiculo(rs.getString("marcaveiculo"));
                oVeiculo.setModeloveiculo(rs.getString("modeloveiculo"));
                resultado.add(oVeiculo);
            }
        } catch (SQLException ex) {
            System.out.println("problemas ao listar Imovel. Erro: " + ex.getMessage());
        }
        return resultado;
    }

}
