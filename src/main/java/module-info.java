module org.openjfx.farmacia {
    requires javafx.controls;
    requires javafx.fxml;
	requires junit;

    opens org.openjfx.farmacia to javafx.fxml;
    exports org.openjfx.farmacia;

    exports org.openjfx.farmacia.controller;
    opens org.openjfx.farmacia.controller;

    exports org.openjfx.farmacia.produto;
    opens org.openjfx.farmacia.produto;

    exports org.openjfx.farmacia.cliente;
    opens org.openjfx.farmacia.cliente;
    exports org.openjfx.farmacia.model.clientes;
    opens org.openjfx.farmacia.model.clientes;

    exports org.openjfx.farmacia.venda;
    opens org.openjfx.farmacia.model.vendas;

    exports org.openjfx.farmacia.model.estoque;
    opens org.openjfx.farmacia.model.estoque;
}
