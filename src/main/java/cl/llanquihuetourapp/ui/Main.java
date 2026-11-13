package cl.llanquihuetourapp.ui;

import cl.llanquihuetourapp.data.GestorDatos;
import cl.llanquihuetourapp.model.Tour;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Path ruta = Path.of("src/main/resources/tours.txt");
        GestorDatos gestor = new GestorDatos();

        try {
            ArrayList <Tour> laListaDeTours = gestor.cargarTours(ruta);
            System.out.println("==============");
            System.out.println("LISTA DE TOURS");
            System.out.println("==============");
            System.out.println("TOURS CARGADOS: " + laListaDeTours.size());

            System.out.println("\n1. TODOS LOS TOURS: ");
            for(Tour tour : laListaDeTours){
                System.out.println(tour);
            }

            System.out.println("\n2. TOURS CON PRECIOS SUPERIOR A $40.000: ");
            boolean hayToursCaros = false;
            for(Tour tour : laListaDeTours){
                if(tour.getPrecio() > 40000){
                    System.out.println(tour);
                    hayToursCaros = true;
                }
            }

        }catch (IOException e){
            System.err.println("No se pudo leer el archivo " + ruta.toAbsolutePath());
            System.err.println("Detalle: " + e.getMessage());
        }

    }
}
