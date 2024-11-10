package org.example.hellojasper7;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {

        try (Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Astronomia", "root", "pass")) {

            // JasperReport jr = JasperCompileManager.compileReport("report.jrxml");

            JasperPrint jp = JasperFillManager.fillReport("Blank_A4.jasper",new HashMap<>(0),c);

            // JasperPrint jp = JasperFillManager.fillReport(jr,new HashMap<>(0),c);

            JasperViewer.viewReport(jp);

            JasperExportManager.exportReportToPdfFile(jp, "report_example.pdf");

        } catch (SQLException | JRException e) {
            throw new RuntimeException(e);
        }


    }
}