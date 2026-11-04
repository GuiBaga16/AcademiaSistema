package Entidades.dao;

import Entidade.TipoTreino;
import java.util.ArrayList;

public interface TipoTreinoDAO {

    ArrayList<TipoTreino> recuperaTodos();

    TipoTreino recuperaUm(int id);

    boolean salvar(TipoTreino tipo);

    boolean editar(TipoTreino tipo);

    boolean excluir(int id);
}
