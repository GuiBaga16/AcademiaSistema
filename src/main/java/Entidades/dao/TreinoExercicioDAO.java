package Entidades.dao;

import Entidade.TreinoExercicio;
import config.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TreinoExercicioDAO {

    public void salvar(TreinoExercicio item) throws Exception {
        String sql = "INSERT INTO treino_exercicio "
                + "(treino_id, exercicio_id, series, repeticoes, carga) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conexao = Conexao.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, item.getTreinoId());
            stmt.setInt(2, item.getExercicioId());
            stmt.setInt(3, item.getSeries());
            stmt.setInt(4, item.getRepeticoes());
            stmt.setDouble(5, item.getCarga());

            stmt.executeUpdate();
        }
    }

    public void editar(TreinoExercicio item) throws Exception {
        String sql = "UPDATE treino_exercicio "
                + "SET series = ?, repeticoes = ?, carga = ? "
                + "WHERE treino_id = ? AND exercicio_id = ?";

        try (Connection conexao = Conexao.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, item.getSeries());
            stmt.setInt(2, item.getRepeticoes());
            stmt.setDouble(3, item.getCarga());
            stmt.setInt(4, item.getTreinoId());
            stmt.setInt(5, item.getExercicioId());

            stmt.executeUpdate();
        }
    }

    public void excluir(int treinoId, int exercicioId)
            throws Exception {
        String sql = "DELETE FROM treino_exercicio "
                + "WHERE treino_id = ? AND exercicio_id = ?";

        try (Connection conexao = Conexao.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, treinoId);
            stmt.setInt(2, exercicioId);

            stmt.executeUpdate();
        }
    }

    public ArrayList<TreinoExercicio> recuperaTodos(int treinoId)
            throws Exception {
        ArrayList<TreinoExercicio> lista = new ArrayList<>();

        String sql = "SELECT treino_id, exercicio_id, series, "
                + "repeticoes, carga FROM treino_exercicio "
                + "WHERE treino_id = ? ORDER BY exercicio_id";

        try (Connection conexao = Conexao.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, treinoId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    TreinoExercicio item = new TreinoExercicio(
                            rs.getInt("treino_id"),
                            rs.getInt("exercicio_id"),
                            rs.getInt("series"),
                            rs.getInt("repeticoes"),
                            rs.getDouble("carga")
                    );

                    lista.add(item);
                }
            }
        }

        return lista;
    }

    public TreinoExercicio recuperaUm(
            int treinoId, int exercicioId) throws Exception {

        String sql = "SELECT treino_id, exercicio_id, series, "
                + "repeticoes, carga FROM treino_exercicio "
                + "WHERE treino_id = ? AND exercicio_id = ?";

        try (Connection conexao = Conexao.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, treinoId);
            stmt.setInt(2, exercicioId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new TreinoExercicio(
                            rs.getInt("treino_id"),
                            rs.getInt("exercicio_id"),
                            rs.getInt("series"),
                            rs.getInt("repeticoes"),
                            rs.getDouble("carga")
                    );
                }
            }
        }

        return null;
    }
}
