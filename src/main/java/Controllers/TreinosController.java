package Controllers;

import Entidade.Treino;
import Entidades.dao.TreinoDAO;
import Entidades.dao.TreinoDAOjdbc;
import java.util.ArrayList;

public class TreinosController {

    private static final TreinoDAO dao = new TreinoDAOjdbc();

    public static boolean salvar(Treino treino) {
        try {
            dao.salvar(treino);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean editar(Treino treino) {
        try {
            dao.editar(treino);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public static boolean excluir(int id) {
        try {
            dao.excluir(id);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public static ArrayList<Treino> recuperaTodos() {
        try {
            return dao.recuperaTodos();
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return new ArrayList<>();
        }
    }

    public static Treino recuperaUm(int id) {
        try {
            return dao.recuperaUm(id);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
}
