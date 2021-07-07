module org.openjfx.farmacia {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.openjfx.farmacia to javafx.fxml;
    exports org.openjfx.farmacia;

    opens org.openjfx.farmacia.controller.view;
    exports org.openjfx.farmacia.controller.view to javafx.fxml;

    exports org.openjfx.farmacia.controller.produto;
}
