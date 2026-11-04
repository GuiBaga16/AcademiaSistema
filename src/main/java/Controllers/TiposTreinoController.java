package Controllers;

import Entidade.TipoTreino;
import Entidades.dao.TipoTreinoDAO;
import Entidades.dao.TipoTreinoDAOjdbc;
import java.util.ArrayList;

public class TiposTreinoController {

    private static final TipoTreinoDAO dao = new TipoTreinoDAOjdbc();

    public static boolean salvar(TipoTreino tipoTreino) {
        return dao.salvar(tipoTreino);
    }

    public static boolean editar(TipoTreino tipoTreino) {
        return dao.editar(tipoTreino);
    }

    public static boolean excluir(int id) {
        return dao.excluir(id);
    }

    public static ArrayList<TipoTreino> recuperaTodos() {
        return dao.recuperaTodos();
    }

    public static TipoTreino recuperaUm(int id) {
        return dao.recuperaUm(id);
    }
}
