package Entidades.dao;

import Entidade.Treino;
import java.sql.SQLException;
import java.util.ArrayList;

public interface TreinoDAO {

    void salvar(Treino treino) throws SQLException;

    void editar(Treino treino) throws SQLException;

    void excluir(int id) throws SQLException;

    ArrayList<Treino> recuperaTodos() throws SQLException;

    Treino recuperaUm(int id) throws SQLException;
}
