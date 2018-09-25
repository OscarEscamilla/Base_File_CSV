/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.ModelBase;
import views.ViewBase;
/**
 *
 * @author Oscar
 */
public class ControllerBase {
    
    ModelBase modelbase;
    ViewBase viewbase;

    public ControllerBase(ModelBase modelbase, ViewBase viewbase) {
        this.modelbase = modelbase;
        this.viewbase = viewbase;
        this.viewbase.jb_guardar.addActionListener(actionlistener);
        this.viewbase.jb_limpiar.addActionListener(actionlistener);
        initComponents();
        
    }
    
    ActionListener actionlistener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == viewbase.jb_guardar){
                enviarDatos();
                guardarDatos();
            }else if(e.getSource() == viewbase.jb_limpiar){
                limpiarCajas();
            }
            
        }
    };
    
       public void guardarDatos() {
           
        //ArrayList<ModelBase> contactos = new ArrayList();//nuevas lineas
        try {
            File file = new File(modelbase.getPath());
            FileWriter filewriter = new FileWriter(file, true);
            StringBuilder contenido = new StringBuilder();
            try(PrintWriter printwriter = new PrintWriter(filewriter)){
                contenido.append(viewbase.jtf_nombre.getText()+ ","+ viewbase.jtf_correo.getText());
                //contenido.append("\n");
                printwriter.println(contenido);  
                JOptionPane.showMessageDialog(null,"Datos Guardados...");
            }
            /*
            escritor = new FileWriter(archivo);
            escritor.write(notas.getText());*/
            
        } catch (FileNotFoundException err) {
            System.err.println("File not found: " + err.getMessage());
        } catch (IOException err) {
            System.err.println("Error on I/O operation: " + err.getMessage());
        }
}
       
       
       
       
       
     
   public void limpiarCajas(){
       viewbase.jtf_correo.setText("");
       viewbase.jtf_nombre.setText("");
   }
    
    public void enviarDatos(){
        modelbase.setNombre(viewbase.jtf_nombre.getText());
        modelbase.setCorreo(viewbase.jtf_correo.getText());
    }
   
   public void initComponents(){
       viewbase.setVisible(true);
   }
}
