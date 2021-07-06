package org.openjfx.farmacia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import org.openjfx.farmacia.controller.produto.Cesta;
import org.openjfx.farmacia.controller.produto.EstoqueController;

public class App extends Application {
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        EstoqueController estoque = new EstoqueController();
		Cesta cesta = new Cesta();
        
        estoque.inicializarEstoque();
        estoque.imprimirEstoque();
      
    	scene = new Scene(loadFXML("cenaPrincipal"), 800, 500);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        estoque.fecharEstoque();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}