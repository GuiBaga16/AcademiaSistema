package Entidades.dao;

import Entidade.TreinoExercicio;
import java.util.ArrayList;

public interface TreinoExercicioDAO {

    void salvar(TreinoExercicio item) throws Exception;

    void editar(TreinoExercicio item) throws Exception;

    void excluir(int treinoId, int exercicioId) throws Exception;

    ArrayList<TreinoExercicio> recuperaTodos(int treinoId) throws Exception;

    TreinoExercicio recuperaUm(int treinoId, int exercicioId) throws Exception;
}
