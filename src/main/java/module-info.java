module com.example.lab6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab6 to javafx.fxml;
    exports com.example.lab6;
    exports com.example.lab6.geometry2d;
    exports com.example.lab6.exceptions;
}