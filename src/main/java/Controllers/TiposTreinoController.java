package Controllers;

import Entidade.TipoTreino;
import Entidades.dao.TipoTreinoDAO;
import java.util.ArrayList;

public class TiposTreinoController {

    public static boolean salvar(TipoTreino tipoTreino) {
        try {
            new TipoTreinoDAO().salvar(tipoTreino);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean editar(TipoTreino tipoTreino) {
        try {
            new TipoTreinoDAO().editar(tipoTreino);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public static boolean excluir(int id) {
        try {
            new TipoTreinoDAO().excluir(id);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public static ArrayList<TipoTreino> recuperaTodos() {
        try {
            return new TipoTreinoDAO().recuperaTodos();
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return new ArrayList<>();
        }
    }

    public static TipoTreino recuperaUm(int id) {
        try {
            return new TipoTreinoDAO().recuperaUm(id);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
}
