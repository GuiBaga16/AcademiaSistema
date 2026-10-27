package Controllers;

import Entidades.dao.AlunoTreinoDAO;
import Entidade.AlunoTreino;
import java.util.ArrayList;

public class AlunoTreinoController {

    public static boolean salvar(int alunoId, int treinoId) {
        try {
            AlunoTreinoDAO dao = new AlunoTreinoDAO();
            dao.salvar(alunoId, treinoId);
            return true;

        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public static boolean excluir(int alunoId, int treinoId) {
        try {
            AlunoTreinoDAO dao = new AlunoTreinoDAO();
            dao.excluir(alunoId, treinoId);
            return true;

        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public static ArrayList<AlunoTreino> recuperaTodos() {
        try {
            AlunoTreinoDAO dao = new AlunoTreinoDAO();
            return dao.recuperaTodos();

        } catch (Exception ex) {
            System.out.println(ex.toString());
            return new ArrayList<>();
        }
    }
}
