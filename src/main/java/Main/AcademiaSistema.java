package Main;

import Telas.TelaLogin;

public class AcademiaSistema {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {
            TelaLogin telaLogin = new TelaLogin();
            telaLogin.setVisible(true);
        });
    }
}
