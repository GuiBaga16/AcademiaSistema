package Controllers;

import Entidade.TreinoExercicio;
import Entidades.dao.TreinoExercicioDAO;
import java.util.ArrayList;

public class TreinoExerciciosController {

    public static boolean salvar(TreinoExercicio item) {
        try {
            new TreinoExercicioDAO().salvar(item);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean editar(TreinoExercicio item) {
        try {
            new TreinoExercicioDAO().editar(item);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean excluir(int treinoId, int exercicioId) {
        try {
            new TreinoExercicioDAO().excluir(treinoId, exercicioId);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static ArrayList<TreinoExercicio> recuperaTodos(int treinoId) {
        try {
            return new TreinoExercicioDAO().recuperaTodos(treinoId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static TreinoExercicio recuperaUm(
            int treinoId, int exercicioId) {
        try {
            return new TreinoExercicioDAO().recuperaUm(
                    treinoId, exercicioId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
