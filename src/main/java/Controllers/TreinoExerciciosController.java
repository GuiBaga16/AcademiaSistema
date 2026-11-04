package Controllers;

import Entidade.TreinoExercicio;
import Entidades.dao.TreinoExercicioDAO;
import Entidades.dao.TreinoExercicioDAOjdbc;
import java.util.ArrayList;

public class TreinoExerciciosController {

    private static final TreinoExercicioDAO dao = new TreinoExercicioDAOjdbc();

    public static boolean salvar(TreinoExercicio item) {
        try {
            dao.salvar(item);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean editar(TreinoExercicio item) {
        try {
            dao.editar(item);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean excluir(int treinoId, int exercicioId) {
        try {
            dao.excluir(treinoId, exercicioId);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static ArrayList<TreinoExercicio> recuperaTodos(int treinoId) {
        try {
            return dao.recuperaTodos(treinoId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static TreinoExercicio recuperaUm(
            int treinoId, int exercicioId) {
        try {
            return dao.recuperaUm(treinoId, exercicioId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
