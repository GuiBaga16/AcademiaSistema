package Entidades.dao;

import Entidade.Aluno;
import java.util.ArrayList;

public interface AlunoDAO {

    void salvar(Aluno a) throws Exception;

    void editar(Aluno a) throws Exception;

    void excluir(int id) throws Exception;

    ArrayList<Aluno> recuperaTodos() throws Exception;

    Aluno recuperaUm(int id) throws Exception;
}
