package Controllers;

import Entidade.Exercicio;
import Entidades.dao.ExercicioDAO;
import Entidades.dao.ExercicioDAOjdbc;
import java.util.ArrayList;

public class ExerciciosController {

    private static final ExercicioDAO dao = new ExercicioDAOjdbc();

    public static boolean salvar(Exercicio exercicio) {
        try {
            dao.salvar(exercicio);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean editar(Exercicio exercicio) {
        try {
            dao.editar(exercicio);
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

    public static ArrayList<Exercicio> recuperaTodos() {
        try {
            return dao.recuperaTodos();
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return new ArrayList<>();
        }
    }

    public static Exercicio recuperaUm(int id) {
        try {
            return dao.recuperaUm(id);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
}
