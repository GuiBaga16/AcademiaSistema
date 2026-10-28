package Entidades.dao;

import Entidade.Exercicio;
import config.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExercicioDAO {

    public void salvar(Exercicio exercicio) throws SQLException {
        String sql = "INSERT INTO exercicio "
                + "(nome, descricao, equipamento_id) "
                + "VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, exercicio.getNome());
            stmt.setString(2, exercicio.getDescricao());
            stmt.setInt(3, exercicio.getEquipamentoId());

            stmt.executeUpdate();
        }
    }

    public void editar(Exercicio exercicio) throws SQLException {
        String sql = "UPDATE exercicio SET "
                + "nome = ?, descricao = ?, equipamento_id = ? "
                + "WHERE id = ?";

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, exercicio.getNome());
            stmt.setString(2, exercicio.getDescricao());
            stmt.setInt(3, exercicio.getEquipamentoId());
            stmt.setInt(4, exercicio.getId());

            stmt.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM exercicio WHERE id = ?";

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public ArrayList<Exercicio> recuperaTodos() throws SQLException {
        ArrayList<Exercicio> exercicios = new ArrayList<>();

        String sql = "SELECT "
                + "e.id, "
                + "e.nome, "
                + "e.equipamento_id, "
                + "eq.nome AS equipamento_nome, "
                + "e.descricao "
                + "FROM exercicio e "
                + "INNER JOIN equipamento eq "
                + "ON e.equipamento_id = eq.id "
                + "ORDER BY e.id";

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Exercicio exercicio = new Exercicio(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getInt("equipamento_id")
                );

                exercicio.setEquipamentoNome(
                        rs.getString("equipamento_nome")
                );

                exercicios.add(exercicio);
            }
        }

        return exercicios;
    }

    public Exercicio recuperaUm(int id) throws SQLException {
        String sql = "SELECT id, nome, descricao, equipamento_id "
                + "FROM exercicio WHERE id = ?";

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Exercicio(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("descricao"),
                            rs.getInt("equipamento_id")
                    );
                }
            }
        }

        return null;
    }
}
