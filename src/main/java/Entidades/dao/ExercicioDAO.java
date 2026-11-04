package Entidades.dao;

import Entidade.Exercicio;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ExercicioDAO {

    void salvar(Exercicio exercicio) throws SQLException;

    void editar(Exercicio exercicio) throws SQLException;

    void excluir(int id) throws SQLException;

    ArrayList<Exercicio> recuperaTodos() throws SQLException;

    Exercicio recuperaUm(int id) throws SQLException;
}
