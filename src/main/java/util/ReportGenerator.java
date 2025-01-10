/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import database.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author pavani
 */
public class ReportGenerator {
    public void generateReport() {
        try {
            // Step 1: Load and compile the JRXML file
            String reportPath = "D:\\Users\\PAVANI\\Documents\\NetBeansProjects\\StudentAttendanceMS\\reports\\AMS.jrxml"; // Path to your JRXML file
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);

            // Step 2: Establish database connection
            Connection connection = DBConnection.getInstance().getConnection();

            // Step 3: Define report parameters (if any)
            HashMap<String, Object> parameters = new HashMap<>();
            // Add parameters to the HashMap if your report requires them, e.g., 
            // parameters.put("PARAMETER_NAME", value);

            // Step 4: Fill the report with data
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);

            // Step 5: Display the report using JasperViewer
            JasperViewer.viewReport(jasperPrint, false);

        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Error generating report: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Unexpected error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
