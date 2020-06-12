/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import CONTROLLER.Controlador;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Jose Luis Perez
 */
public class WorkPanel extends JPanel {
    
    private JTable tblAlumnos;
    private AlumnosModel model;
    
    public WorkPanel(Controlador controlador){
        
        super.setBackground(Color.CYAN);
        super.setLayout(new BorderLayout());
        
        model = new AlumnosModel(controlador);
        tblAlumnos = new JTable(model);
        
        super.add(new JScrollPane(tblAlumnos), BorderLayout.CENTER);
        
    }
    
}
