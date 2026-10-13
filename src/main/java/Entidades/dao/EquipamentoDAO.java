package Entidades.dao;

import Entidade.Equipamento;
import config.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EquipamentoDAO {

    public void salvar(Equipamento e) throws Exception {

        String sql = "INSERT INTO equipamento "
                + "(nome, tipo, marca, quantidade, status_atual) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conexao = Conexao.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, e.getNome());
            stmt.setString(2, e.getTipo());
            stmt.setString(3, e.getMarca());
            stmt.setInt(4, e.getQuantidade());
            stmt.setString(5, e.getStatusAtual());

            stmt.executeUpdate();
        }
    }

    public void editar(Equipamento e) throws Exception {

        String sql = "UPDATE equipamento SET "
                + "nome = ?, "
                + "tipo = ?, "
                + "marca = ?, "
                + "quantidade = ?, "
                + "status_atual = ? "
                + "WHERE id = ?";

        try (Connection conexao = Conexao.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, e.getNome());
            stmt.setString(2, e.getTipo());
            stmt.setString(3, e.getMarca());
            stmt.setInt(4, e.getQuantidade());
            stmt.setString(5, e.getStatusAtual());
            stmt.setInt(6, e.getId());

            stmt.executeUpdate();
        }
    }

    public void excluir(int id) throws Exception {

        String sql = "DELETE FROM equipamento WHERE id = ?";

        try (Connection conexao = Conexao.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public ArrayList<Equipamento> recuperaTodos() throws Exception {

        ArrayList<Equipamento> equipamentos = new ArrayList<>();

        String sql = "SELECT * FROM equipamento";

        try (Connection conexao = Conexao.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet resultado = stmt.executeQuery()) {

            while (resultado.next()) {

                Equipamento e = new Equipamento();

                e.setId(resultado.getInt("id"));
                e.setNome(resultado.getString("nome"));
                e.setTipo(resultado.getString("tipo"));
                e.setMarca(resultado.getString("marca"));
                e.setQuantidade(resultado.getInt("quantidade"));
                e.setStatusAtual(resultado.getString("status_atual"));

                equipamentos.add(e);
            }
        }

        return equipamentos;
    }

    public Equipamento recuperaUm(int id) throws Exception {

        String sql = "SELECT * FROM equipamento WHERE id = ?";

        try (Connection conexao = Conexao.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet resultado = stmt.executeQuery()) {

                if (resultado.next()) {

                    Equipamento e = new Equipamento();

                    e.setId(resultado.getInt("id"));
                    e.setNome(resultado.getString("nome"));
                    e.setTipo(resultado.getString("tipo"));
                    e.setMarca(resultado.getString("marca"));
                    e.setQuantidade(resultado.getInt("quantidade"));
                    e.setStatusAtual(resultado.getString("status_atual"));

                    return e;
                }
            }
        }

        return null;

    }
}
