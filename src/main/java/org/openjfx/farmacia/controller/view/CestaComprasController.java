package org.openjfx.farmacia.controller.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.openjfx.farmacia.controller.produto.ProdutoCesta;

import java.util.ArrayList;

public class CestaComprasController {
    ArrayList<ProdutoCesta> cestaCompras;

    public CestaComprasController() {
        this.cestaCompras = cestaCompras = new ArrayList<>();
    }

    public ArrayList<ProdutoCesta> getCestaCompras() {
        return cestaCompras;
    }

    @SuppressWarnings("unused")
    public void setCestaCompras(ArrayList<ProdutoCesta> cestaCompras) {
        this.cestaCompras = cestaCompras;
    }

    public void abrirCesta() {
        Label secondLabel = new Label("I'm a Label on new Window");

        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().add(secondLabel);

        Scene secondScene = new Scene(secondaryLayout, 230, 100);

        // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setTitle("Second Stage");
        newWindow.setScene(secondScene);
        newWindow.show();
    }
}
