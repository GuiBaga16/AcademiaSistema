package Controllers;

import Entidade.Aluno;
import Entidades.dao.AlunoDAO;
import Entidades.dao.AlunoDAOjdbc;
import java.util.ArrayList;

public class AlunosController {

    private static final AlunoDAO dao = new AlunoDAOjdbc();

    public static boolean salvar(Aluno aluno) {
        try {
            dao.salvar(aluno);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public static boolean excluir(int codigo) {
        try {
            dao.excluir(codigo);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public static Aluno recuperaUm(int codigo) {
        try {
            return dao.recuperaUm(codigo);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    public static ArrayList<Aluno> recuperaTodos() {
        try {
            return dao.recuperaTodos();
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return new ArrayList<>();
        }
    }

    public static boolean editar(Aluno aluno) {
        try {
            dao.editar(aluno);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }
}
