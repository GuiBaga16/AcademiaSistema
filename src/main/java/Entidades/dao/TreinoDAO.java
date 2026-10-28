package Entidades.dao;

import Entidade.Treino;
import config.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TreinoDAO {

    public void salvar(Treino treino) throws SQLException {
        String sql = "INSERT INTO treino "
                + "(nome, descricao, tipo_treino_id) "
                + "VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, treino.getNome());
            stmt.setString(2, treino.getDescricao());
            stmt.setInt(3, treino.getTipoTreinoId());

            stmt.executeUpdate();
        }
    }

    public void editar(Treino treino) throws SQLException {
        String sql = "UPDATE treino SET "
                + "nome = ?, descricao = ?, tipo_treino_id = ? "
                + "WHERE id = ?";

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, treino.getNome());
            stmt.setString(2, treino.getDescricao());
            stmt.setInt(3, treino.getTipoTreinoId());
            stmt.setInt(4, treino.getId());

            stmt.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM treino WHERE id = ?";

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public ArrayList<Treino> recuperaTodos() throws SQLException {
        ArrayList<Treino> treinos = new ArrayList<>();

        String sql = "SELECT\n"
                + "    t.id,\n"
                + "    t.nome,\n"
                + "    t.tipo_treino_id,\n"
                + "    tt.nome AS tipo_treino_nome,\n"
                + "    t.descricao\n"
                + "FROM treino t\n"
                + "INNER JOIN tipo_treino tt\n"
                + "    ON t.tipo_treino_id = tt.id\n"
                + "ORDER BY t.id;";

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Treino treino = new Treino(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getInt("tipo_treino_id")
                );

                treino.setTipoTreinoNome(rs.getString("tipo_treino_nome"));

                treinos.add(treino);
            }
        }

        return treinos;
    }

    public Treino recuperaUm(int id) throws SQLException {
        String sql = "SELECT id, nome, descricao, tipo_treino_id "
                + "FROM treino WHERE id = ?";

        try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Treino(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("descricao"),
                            rs.getInt("tipo_treino_id")
                    );
                }
            }
        }

        return null;
    }
}
