package cl.llanquihuetourapp.data;

import cl.llanquihuetourapp.model.Tour;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class GestorDatos {

    public ArrayList <Tour> cargarTours (Path rutaArchivo) throws IOException {

        ArrayList <Tour> listaDeTours = new ArrayList();

        try (BufferedReader lector = Files.newBufferedReader(rutaArchivo, StandardCharsets.UTF_8)) {
            String linea;
            int numeroLinea = 0;

            while ((linea = lector.readLine()) != null) {
                numeroLinea++;
                if (linea.isBlank()) {
                    continue;
                }

                String[] campos = linea.split(";", -1);
                if (campos.length != 4) {
                    System.err.println("Se omite linea " + numeroLinea + ": esesperabamos 4 campos");
                }

                try {
                    String nombre = campos[0];
                    String tipo = campos[1];
                    int duracionHoras = Integer.parseInt(campos[2]);
                    int precio = Integer.parseInt(campos[3]);

                    Tour tour = new Tour(nombre, tipo, duracionHoras, precio);
                    listaDeTours.add(tour);
                }  catch (IllegalArgumentException e) {
                    System.err.println("Se omite linea " + numeroLinea + ": " + e.getMessage());
                }



            }
        }

        return listaDeTours;
    }


}
