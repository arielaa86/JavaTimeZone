/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ariel
 */
public class Calendario {

    public Calendario() {
    }
    
    
    public DefaultTableModel getTodasZonasHorarias() {

        // todas las zonas horarias
        Set<String> listaIdZona = ZoneId.getAvailableZoneIds();
        
        
        // creando el modelo de mi tabla donde voy a mostrar las zonas
        
        // Columnas de mi tabla 
        String columnas[] = {"Zona Horaria"};

        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        
        // Creo una fila que va a ser un arreglo con la cantidad de columnas que tenga
        Object fila[] = new Object[1];
        
        for (String zona : listaIdZona) {
            
                 fila[0] = zona;
                 
                 modelo.addRow(fila);
         
        }
        
        
        return modelo;

    }
    
    
    

    public DefaultTableModel getZonasHorarias(String texto) {

        // todas las zonas horarias
        Set<String> listaIdZona = ZoneId.getAvailableZoneIds();
        
        
        // creando el modelo de mi tabla donde voy a mostrar las zonas que contengan el texto
        
        // Columnas de mi tabla 
        String columnas[] = {"Zona Horaria"};

        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        
        // Creo una fila que va a ser un arreglo con la cantidad de columnas que tenga
        Object fila[] = new Object[1];
        
        for (String zona : listaIdZona) {
            
            
            // comparo todo en mayúsculas para que filtre no importa com o escribas
            if(zona.toUpperCase().contains(texto.toUpperCase())){
                
                 fila[0] = zona;
                 
                 modelo.addRow(fila);
                
            }
           
        }
        
        
        if(texto == null)
            return getTodasZonasHorarias();
        
        
        
        return modelo;

    }

    public String horaActual() {

        Calendar instance = Calendar.getInstance();

        DateFormat formatter = new SimpleDateFormat("hh:mm:ss a");

        return formatter.format(instance.getTime());

    }

    public String horaActualZona(String zonaHoraria) {

        if (zonaHoraria != null) {

            Calendar instance = Calendar.getInstance();

            DateFormat formatter = new SimpleDateFormat("hh:mm:ss a");

            GregorianCalendar instance2 = new GregorianCalendar(TimeZone.getTimeZone(zonaHoraria));
            instance2.setTime(instance.getTime());

            formatter.setTimeZone(TimeZone.getTimeZone(zonaHoraria));

            return formatter.format(instance2.getTime());

        }
        
        
        return null;

    }

}
