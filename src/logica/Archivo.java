/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Pelicula;

/**
 *
 * @author sosag
 */
public class Archivo {


    public void EscribirListaEnTxt(ArrayList<Pelicula> lista) {
        File archivo;
        PrintWriter escribir;
        archivo = new File("PeliculasGuardadas.txt");

        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                escribir = new PrintWriter(archivo, "utf-8");
                escribir.println();
                escribir.close();
            } catch (IOException ex) {
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                escribir = new PrintWriter(archivo, "utf-8");
                for (Pelicula pelicula : lista) {
                    //escribe los datos en el archivo
                    escribir.println(pelicula.getCode() + "," + pelicula.getTitle() + "," + pelicula.getCost()
                            + "," + pelicula.getNumSocio() + "," + pelicula.isBitMuerto());
                }
                escribir.close();
            } catch (FileNotFoundException | UnsupportedEncodingException ex) {
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //crea el archivo en disco, retorna la lista de estudiantes
    public ArrayList<Pelicula> leerArchivo() {
        // crea el flujo para leer desde el archivo
        File archivo;
        archivo = new File("PeliculasGuardadas.txt");
        Scanner scanner;
        ArrayList<Pelicula> listaDePeliculas = new ArrayList<>();
        try {
            //se pasa el flujo al objeto scanner
            scanner = new Scanner(archivo);
            while (scanner.hasNextLine()) {
                // el objeto scanner lee linea a linea desde el archivo
                String linea = scanner.nextLine();
                Scanner delimitar = new Scanner(linea);
                //se usa una expresión regular
                //que valida que antes o despues de una coma (,) exista cualquier cosa
                //parte la cadena recibida cada vez que encuentre una coma				
                delimitar.useDelimiter("\\s*,\\s*");
                int code = Integer.parseInt(delimitar.next());
                String title = delimitar.next();
                int cost = Integer.parseInt(delimitar.next());
                int numSocio = Integer.parseInt(delimitar.next());
                boolean bitMuerto = Boolean.parseBoolean(delimitar.next());
                listaDePeliculas.add(new Pelicula(code, title, cost, numSocio, bitMuerto));
            }
            //se cierra el ojeto scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listaDePeliculas;
    }

}
