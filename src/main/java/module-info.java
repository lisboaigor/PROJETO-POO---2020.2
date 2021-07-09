module org.openjfx.farmacia {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.openjfx.farmacia to javafx.fxml;
    exports org.openjfx.farmacia;

    opens org.openjfx.farmacia.controller;
    opens org.openjfx.farmacia.controller.view;

    exports org.openjfx.farmacia.controller.produto;
    exports org.openjfx.farmacia.controller;
    exports org.openjfx.farmacia.controller.view;
    opens org.openjfx.farmacia.controller.produto;
    exports org.openjfx.farmacia.controller.cliente;
    opens org.openjfx.farmacia.controller.cliente;
}
