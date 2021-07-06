module org.openjfx.farmacia {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.openjfx.farmacia to javafx.fxml;
    exports org.openjfx.farmacia;

    opens org.openjfx.farmacia.controller.viewController;
    exports org.openjfx.farmacia.controller.viewController to javafx.fxml;

    exports org.openjfx.farmacia.controller.produto;
}
