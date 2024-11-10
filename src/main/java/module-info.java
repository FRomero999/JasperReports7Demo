module org.example.hellojasper7 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires net.sf.jasperreports.core;


    opens org.example.hellojasper7 to javafx.fxml;
    exports org.example.hellojasper7;
}