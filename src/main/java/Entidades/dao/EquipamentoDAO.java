package Entidades.dao;

import Entidade.Equipamento;
import java.util.ArrayList;

public interface EquipamentoDAO {

    void salvar(Equipamento e) throws Exception;

    void editar(Equipamento e) throws Exception;

    void excluir(int id) throws Exception;

    ArrayList<Equipamento> recuperaTodos() throws Exception;

    Equipamento recuperaUm(int id) throws Exception;
}
