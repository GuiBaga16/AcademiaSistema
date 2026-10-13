package Controllers;

import Entidade.Treino;
import Entidades.dao.TreinoDAO;
import java.util.ArrayList;

public class TreinosController {

    public static boolean salvar(Treino treino) {
        try {
            new TreinoDAO().salvar(treino);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean editar(Treino treino) {
        try {
            new TreinoDAO().editar(treino);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public static boolean excluir(int id) {
        try {
            new TreinoDAO().excluir(id);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public static ArrayList<Treino> recuperaTodos() {
        try {
            return new TreinoDAO().recuperaTodos();
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return new ArrayList<>();
        }
    }

    public static Treino recuperaUm(int id) {
        try {
            return new TreinoDAO().recuperaUm(id);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
}
