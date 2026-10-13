package Controllers;

import Entidade.Equipamento;
import Entidades.dao.EquipamentoDAO;

import java.util.ArrayList;

public class EquipamentosController {

    public static boolean salvar(Equipamento equipamento) {
        try {
            EquipamentoDAO dao = new EquipamentoDAO();
            dao.salvar(equipamento);
            return true;

        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public static boolean excluir(int codigo) {
        try {
            EquipamentoDAO dao = new EquipamentoDAO();
            dao.excluir(codigo);
            return true;

        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public static Equipamento recuperaUm(int codigo) {
        try {
            EquipamentoDAO dao = new EquipamentoDAO();
            return dao.recuperaUm(codigo);

        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    public static ArrayList<Equipamento> recuperaTodos() {
        try {
            EquipamentoDAO dao = new EquipamentoDAO();
            return dao.recuperaTodos();

        } catch (Exception ex) {
            System.out.println(ex.toString());
            return new ArrayList<>();
        }
    }

    public static boolean editar(Equipamento equipamento) {
        try {
            EquipamentoDAO dao = new EquipamentoDAO();
            dao.editar(equipamento);
            return true;

        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }
}