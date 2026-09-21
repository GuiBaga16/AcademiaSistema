package Entidades.dao;

import Entidade.Aluno;
import config.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AlunoDAO {

    public void salvar(Aluno a) throws Exception {

        String sql = "INSERT INTO aluno "
                + "(nome, documento, email, telefone, data_nascimento) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conexao = Conexao.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getDocumento());
            stmt.setString(3, a.getEmail());
            stmt.setString(4, a.getTelefone());

            if (a.getDataNascimento() != null) {
                stmt.setDate(5,
                        java.sql.Date.valueOf(a.getDataNascimento()));
            } else {
                stmt.setNull(5, java.sql.Types.DATE);
            }

            stmt.executeUpdate();
        }
    }

    public void editar(Aluno a) throws Exception {

        String sql = "UPDATE aluno SET "
                + "nome = ?, "
                + "documento = ?, "
                + "email = ?, "
                + "telefone = ?, "
                + "data_nascimento = ? "
                + "WHERE id = ?";

        try (Connection conexao = Conexao.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getDocumento());
            stmt.setString(3, a.getEmail());
            stmt.setString(4, a.getTelefone());

            if (a.getDataNascimento() != null) {
                stmt.setDate(5,
                        java.sql.Date.valueOf(a.getDataNascimento()));
            } else {
                stmt.setNull(5, java.sql.Types.DATE);
            }

            stmt.setInt(6, a.getId());

            stmt.executeUpdate();
        }
    }

    public void excluir(int id) throws Exception {

        String sql = "DELETE FROM aluno WHERE id = ?";

        try (Connection conexao = Conexao.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public ArrayList<Aluno> recuperaTodos() throws Exception {

        ArrayList<Aluno> alunos = new ArrayList<>();

        String sql = "SELECT * FROM aluno";

        try (Connection conexao = Conexao.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql); ResultSet resultado = stmt.executeQuery()) {

            while (resultado.next()) {

                Aluno a = new Aluno();

                a.setId(resultado.getInt("id"));
                a.setNome(resultado.getString("nome"));
                a.setDocumento(resultado.getString("documento"));
                a.setEmail(resultado.getString("email"));
                a.setTelefone(resultado.getString("telefone"));

                if (resultado.getDate("data_nascimento") != null) {
                    a.setDataNascimento(
                            resultado.getDate("data_nascimento").toLocalDate()
                    );
                }

                alunos.add(a);
            }
        }

        return alunos;
    }

    public Aluno recuperaUm(int id) throws Exception {

        String sql = "SELECT * FROM aluno WHERE id = ?";

        try (Connection conexao = Conexao.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet resultado = stmt.executeQuery()) {

                if (resultado.next()) {

                    Aluno a = new Aluno();

                    a.setId(resultado.getInt("id"));
                    a.setNome(resultado.getString("nome"));
                    a.setDocumento(resultado.getString("documento"));
                    a.setEmail(resultado.getString("email"));
                    a.setTelefone(resultado.getString("telefone"));

                    if (resultado.getDate("data_nascimento") != null) {
                        a.setDataNascimento(
                                resultado.getDate("data_nascimento").toLocalDate()
                        );
                    }

                    return a;
                }
            }
        }

        return null;
    }
}
