package Entidades.dao;

import Entidade.Treino;
import config.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TreinoDAOjdbc implements TreinoDAO {

    @Override
    public void salvar(Treino treino) throws SQLException {

        String sql = "INSERT INTO treino "
                + "(nome, descricao, tipo_treino_id) "
                + "VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, treino.getNome());
            stmt.setString(2, treino.getDescricao());
            stmt.setInt(3, treino.getTipoTreinoId());

            stmt.executeUpdate();
        }
    }

    @Override
    public void editar(Treino treino) throws SQLException {

        String sql = "UPDATE treino SET "
                + "nome = ?, descricao = ?, tipo_treino_id = ? "
                + "WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, treino.getNome());
            stmt.setString(2, treino.getDescricao());
            stmt.setInt(3, treino.getTipoTreinoId());
            stmt.setInt(4, treino.getId());

            stmt.executeUpdate();
        }
    }

    @Override
    public void excluir(int id) throws SQLException {

        String sql = "DELETE FROM treino WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public ArrayList<Treino> recuperaTodos() throws SQLException {

        ArrayList<Treino> treinos = new ArrayList<>();

        String sql = "SELECT "
                + "t.id, t.nome, t.tipo_treino_id, "
                + "tt.nome AS tipo_treino_nome, t.descricao "
                + "FROM treino t "
                + "INNER JOIN tipo_treino tt "
                + "ON t.tipo_treino_id = tt.id "
                + "ORDER BY t.id";

        try (Connection conn = Conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Treino treino = new Treino(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getInt("tipo_treino_id")
                );

                treino.setTipoTreinoNome(
                        rs.getString("tipo_treino_nome")
                );

                treinos.add(treino);
            }
        }

        return treinos;
    }

    @Override
    public Treino recuperaUm(int id) throws SQLException {

        String sql = "SELECT id, nome, descricao, tipo_treino_id "
                + "FROM treino WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

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
