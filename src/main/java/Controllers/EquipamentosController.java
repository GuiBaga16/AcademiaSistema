package Controllers;

import Entidade.Equipamento;
import Entidades.dao.EquipamentoDAO;
import Entidades.dao.EquipamentoDAOjdbc;
import java.util.ArrayList;

public class EquipamentosController {

    private static final EquipamentoDAO dao = new EquipamentoDAOjdbc();

    public static boolean salvar(Equipamento equipamento) {
        try {
            dao.salvar(equipamento);
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

    public static Equipamento recuperaUm(int codigo) {
        try {
            return dao.recuperaUm(codigo);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    public static ArrayList<Equipamento> recuperaTodos() {
        try {
            return dao.recuperaTodos();
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return new ArrayList<>();
        }
    }

    public static boolean editar(Equipamento equipamento) {
        try {
            dao.editar(equipamento);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }
}
