package org.openjfx.farmacia.controller.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CenaPrincipalController {
    @FXML
    public Button irParaCesta;
    @FXML
    public Button adicionarCesta;

    public void adicionarProdutoCesta(Button adicionarCesta) {
        System.out.println("Produto adicionado!");
    }
}
