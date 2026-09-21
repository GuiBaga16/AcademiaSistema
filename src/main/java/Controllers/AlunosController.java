package Controllers;

/**
 *
 * @author guilherme.bagatini
 */
import Entidade.Aluno;
import Entidades.dao.AlunoDAO;

import java.util.ArrayList;

public class AlunosController {

    public static boolean salvar(Aluno aluno) {
        try {
            AlunoDAO dao = new AlunoDAO();
            dao.salvar(aluno);
            return true;

        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public static boolean excluir(int codigo) {
        try {
            AlunoDAO dao = new AlunoDAO();
            dao.excluir(codigo);
            return true;

        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public static Aluno recuperaUm(int codigo) {
        try {
            AlunoDAO dao = new AlunoDAO();
            return dao.recuperaUm(codigo);

        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    public static ArrayList<Aluno> recuperaTodos() {
        try {
            AlunoDAO dao = new AlunoDAO();
            return dao.recuperaTodos();

        } catch (Exception ex) {
            System.out.println(ex.toString());
            return new ArrayList<>();
        }
    }

    public static boolean editar(Aluno aluno) {
        try {
            AlunoDAO dao = new AlunoDAO();
            dao.editar(aluno);
            return true;

        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }
}
