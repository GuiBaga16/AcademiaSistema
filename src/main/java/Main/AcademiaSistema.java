/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Main;

import config.Conexao;
import java.sql.Connection;

/**
 *
 * @author guilherme.bagatini
 */
public class AcademiaSistema {

    public static void main(String[] args) {
        try {
            Connection conexao = Conexao.conectar();

            System.out.println("Conexão realizada com sucesso!");

            conexao.close();

        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco:");
            e.printStackTrace();
        }
    }
}
