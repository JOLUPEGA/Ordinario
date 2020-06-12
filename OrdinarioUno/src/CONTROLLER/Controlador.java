/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import OBJECTS.Alumno;
import excepciones.AlumnoExistenteException;
import excepciones.AlumnoInexistenteException;
import java.util.ArrayList;

/**
 *
 * @author Jose Luis Perez
 */
public class Controlador {
    
    private ArrayList<Alumno> alumnos;
    
    public Controlador(){
        
        alumnos = new ArrayList<>();
        
    }
    
    public void addAlumno(Alumno alumno) throws AlumnoExistenteException{
        
        if(alumnos.contains(alumno)){
            throw new AlumnoExistenteException();
        }
        alumnos.add(alumno);
        
    }
    
    public ArrayList<Alumno> getAlumnos(){
        
        return alumnos;
        
    }
    
    public Alumno getAlumno(String matricula) throws AlumnoInexistenteException{
        
        int index = alumnos.indexOf(new Alumno(matricula));
        if(index < 0){
            throw new AlumnoInexistenteException();
        }
        return alumnos.get(index);
    }
    
    public Alumno getAlumno(int index){
        return alumnos.get(index);
    }
    
    public int getAlumnosCon(){
        return alumnos.size();
    }
    
}
