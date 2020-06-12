/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import OBJECTS.Alumno;
import OBJECTS.Carrera;
import OBJECTS.Fecha;
import interfaces.AlumnoListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jose Luis Perez
 */
public class AlumnoDialog extends JDialog{
    
    private JPanel pnWork;
    private JPanel pnBotones;
    
    private JButton btnAceptar;
    private JButton btnCancelar;
    
    private AlumnoListener listener;
    
    public AlumnoDialog(JFrame owner){
        
        super(owner, "Datos del Alumno", true);
        super.setSize(400, 300);
        super.setLayout(new BorderLayout());
        super.setLocationRelativeTo(owner);
        
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Alumno alumno = new Alumno("535224410", "Ana Gabriela", "Perez", "Garcia", new Fecha(29, 5, 1994), Carrera.GASTRONOMIA);
                listener.aceptarButtonClick(alumno);
            }
        });
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                AlumnoDialog.this.setVisible(false);
            }  
        });
        
        pnWork = new JPanel();
        pnBotones = new JPanel();
        pnBotones.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pnBotones.setBackground(Color.red);
        pnBotones.add(btnAceptar);
        pnBotones.add(btnCancelar);

        super.add(pnBotones, BorderLayout.SOUTH);
        super.add(pnWork, BorderLayout.CENTER);
        
        super.setVisible(false);
        
    }
    
    public void setListener(AlumnoListener listener){
        
        this.listener = listener;
        
    }
    
}
