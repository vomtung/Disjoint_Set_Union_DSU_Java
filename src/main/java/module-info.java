module com.advancedalgorithms.asigment {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.advancedalgorithms.asigment to javafx.fxml;
    exports com.advancedalgorithms.asigment;
}