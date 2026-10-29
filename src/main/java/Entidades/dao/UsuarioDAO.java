package Entidades.dao;

import Entidade.Usuario;
import java.sql.SQLException;

public interface UsuarioDAO {

    Usuario autenticar(String login, String senha) throws SQLException;

    void salvar(String nome, String login, String senha) throws SQLException;
}
