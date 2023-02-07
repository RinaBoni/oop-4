module com.example.energyinterface {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;


    opens com.example.energyinterface to javafx.fxml;
    exports com.example.energyinterface;
}