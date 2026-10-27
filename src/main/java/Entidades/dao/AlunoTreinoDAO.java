package Entidades.dao;

import config.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Entidade.AlunoTreino;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AlunoTreinoDAO {

    public void salvar(int alunoId, int treinoId) throws SQLException {

        String sql = "INSERT INTO aluno_treino (aluno_id, treino_id) "
                + "VALUES (?, ?)";

        try (Connection conexao = Conexao.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, alunoId);
            stmt.setInt(2, treinoId);

            stmt.executeUpdate();
        }
    }

    public void excluir(int alunoId, int treinoId) throws SQLException {

        String sql = "DELETE FROM aluno_treino "
                + "WHERE aluno_id = ? AND treino_id = ?";

        try (Connection conexao = Conexao.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, alunoId);
            stmt.setInt(2, treinoId);

            stmt.executeUpdate();
        }
    }

    public ArrayList<AlunoTreino> recuperaTodos() throws SQLException {

        ArrayList<AlunoTreino> associacoes = new ArrayList<>();

        String sql = "SELECT at.aluno_id, at.treino_id, "
                + "a.nome AS aluno_nome, t.nome AS treino_nome "
                + "FROM aluno_treino at "
                + "INNER JOIN aluno a ON at.aluno_id = a.id "
                + "INNER JOIN treino t ON at.treino_id = t.id "
                + "ORDER BY a.nome, t.nome";

        try (Connection conexao = Conexao.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                AlunoTreino associacao = new AlunoTreino(
                        rs.getInt("aluno_id"),
                        rs.getInt("treino_id")
                );

                associacao.setAlunoNome(rs.getString("aluno_nome"));
                associacao.setTreinoNome(rs.getString("treino_nome"));

                associacoes.add(associacao);
            }
        }

        return associacoes;
    }
}
