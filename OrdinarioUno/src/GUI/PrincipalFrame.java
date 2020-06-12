/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import CONTROLLER.Controlador;
import OBJECTS.Alumno;
import OBJECTS.Carrera;
import OBJECTS.Fecha;
import excepciones.AlumnoExistenteException;
import interfaces.AlumnoListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose Luis Perez
 */
public class PrincipalFrame extends JFrame {
    
    private EncabezadoPanel pnlEncabezado;
    private WorkPanel pnlWork;
    private BusquedaPanel pnlBusqueda;
    
    private Controlador controlador;
    
    private AlumnoDialog dlgAlumno;
    
    public PrincipalFrame(){
        
        super("Control Escolar");
        super.setLayout(new BorderLayout());
        super.setSize(800, 500);
        super.setLocationRelativeTo(null);
        
        dlgAlumno = new AlumnoDialog(this);
        dlgAlumno.setListener(new AlumnoListener() {
            @Override
            public void aceptarButtonClick(Alumno alumno) {
                try{
                controlador.addAlumno(alumno);
                dlgAlumno.setVisible(false);
                }catch(AlumnoExistenteException ex){
                    JOptionPane.showMessageDialog(PrincipalFrame.this,
                                                  "La matricula ya ha sido insertada anteriormente",
                                                  "Matricula Invalida",
                                                  JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        controlador = new Controlador();
        cargaInicial();
        
        pnlEncabezado = new EncabezadoPanel();
        pnlWork = new WorkPanel(controlador);
        pnlBusqueda = new BusquedaPanel();
        
        super.setJMenuBar(createMenu());
        
        super.add(pnlEncabezado, BorderLayout.NORTH);
        super.add(pnlBusqueda, BorderLayout.SOUTH);
        super.add(pnlWork, BorderLayout.CENTER);        
        
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
        
    }
    
    private void cargaInicial(){
        
        Alumno a = new Alumno("014422535", "Jose Luis", "Perez", "Garcia", new Fecha(15, 6, 2001), Carrera.ELECTRONICA);
        Alumno b = new Alumno("b");
        Alumno c = new Alumno("c");
        Alumno d = new Alumno("d");
        Alumno e = new Alumno("e");        
        
        try{
        controlador.addAlumno(a);
        controlador.addAlumno(b);
        controlador.addAlumno(c);
        controlador.addAlumno(d);
        controlador.addAlumno(e);
        }catch(AlumnoExistenteException ex){
            ex.printStackTrace();
        }
    }
 
    private JMenuBar createMenu(){
        
        JMenuBar mbMain = new JMenuBar();
        
        JMenu mmArchivo = new JMenu("Archivo");     
        JMenuItem  miNuevo = new JMenuItem("Nuevo Alumno");
        miNuevo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dlgAlumno.setVisible(true);
            }
        });
        JMenuItem miSalir = new JMenuItem ("Salir");
        miSalir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        JMenu mmAyuda = new JMenu("Ayuda");
        JMenuItem miAcerca = new JMenuItem("Acerca de...");
        
        mbMain.add(mmArchivo);
        mbMain.add(mmAyuda);
        mmArchivo.add(miNuevo);
        mmArchivo.addSeparator();
        mmArchivo.add(miSalir);
        mmAyuda.add(miAcerca);
        
        return mbMain;
        
    }
    
}
