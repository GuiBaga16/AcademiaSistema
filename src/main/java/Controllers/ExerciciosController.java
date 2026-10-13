package Controllers;

import Entidade.Exercicio;
import Entidades.dao.ExercicioDAO;
import java.util.ArrayList;

public class ExerciciosController {

    public static boolean salvar(Exercicio exercicio) {
        try {
            new ExercicioDAO().salvar(exercicio);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean editar(Exercicio exercicio) {
        try {
            new ExercicioDAO().editar(exercicio);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public static boolean excluir(int id) {
        try {
            new ExercicioDAO().excluir(id);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public static ArrayList<Exercicio> recuperaTodos() {
        try {
            return new ExercicioDAO().recuperaTodos();
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return new ArrayList<>();
        }
    }

    public static Exercicio recuperaUm(int id) {
        try {
            return new ExercicioDAO().recuperaUm(id);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
}
