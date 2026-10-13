package Entidades.dao;

import Entidade.TipoTreino;
import config.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TipoTreinoDAO {

    // Listar todos os tipos de treino
    public ArrayList<TipoTreino> recuperaTodos() {
        ArrayList<TipoTreino> tipos = new ArrayList<>();

        String sql = "SELECT id, nome, descricao "
                + "FROM tipo_treino ORDER BY nome";

        try (Connection conexao = Conexao.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                TipoTreino tipo = new TipoTreino(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("descricao")
                );

                tipos.add(tipo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tipos;
    }

    // Buscar um tipo de treino pelo ID
    public TipoTreino recuperaUm(int id) {
        String sql = "SELECT id, nome, descricao "
                + "FROM tipo_treino WHERE id = ?";

        try (Connection conexao = Conexao.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new TipoTreino(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("descricao")
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // Cadastrar um tipo de treino
    public boolean salvar(TipoTreino tipo) {
        String sql = "INSERT INTO tipo_treino (nome, descricao) "
                + "VALUES (?, ?)";

        try (Connection conexao = Conexao.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, tipo.getNome());
            stmt.setString(2, tipo.getDescricao());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Editar um tipo de treino
    public boolean editar(TipoTreino tipo) {
        String sql = "UPDATE tipo_treino "
                + "SET nome = ?, descricao = ? "
                + "WHERE id = ?";

        try (Connection conexao = Conexao.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, tipo.getNome());
            stmt.setString(2, tipo.getDescricao());
            stmt.setInt(3, tipo.getId());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Excluir um tipo de treino pelo ID
    public boolean excluir(int id) {
        String sql = "DELETE FROM tipo_treino WHERE id = ?";

        try (Connection conexao = Conexao.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
