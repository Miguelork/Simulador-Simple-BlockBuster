package logica;

import modelos.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Lants
 */
public class Manager {

    public ArrayList<Pelicula> listPeli = new ArrayList<>();
    ArrayList<IndexCode> listCode = new ArrayList<>();
    ArrayList<IndexTitle> listTitle = new ArrayList<>();
    ArrayList<IndexCost> listCost = new ArrayList<>();
    ArrayList<IndexRentedBy> listRentedby = new ArrayList<>();
    public ArrayList<Usuario> listClient = new ArrayList<>();
    int i;
    public Usuario selected;
    metodosDeBusqueda busqueda = new metodosDeBusqueda();
    Archivo archivo = new Archivo();

    public void aggPeli(int code, String title, int cost, int numSocio, boolean bitMuerto) {
        listPeli.add(new Pelicula(code, title, cost, numSocio, false));
        refreshIndex();
        archivo.EscribirListaEnTxt(listPeli);
    }

    public void cargarPeliculas() {
        ArrayList<Pelicula> lista = archivo.leerArchivo();
        for (Pelicula peli : lista) {
            listPeli.add(new Pelicula(peli.getCode(), peli.getTitle(), peli.getCost(), peli.getNumSocio(), peli.isBitMuerto()));
        }
    }

    public void eliminarPeliculaPorCodigo(int code) {
        Pelicula pelicula_eliminar = buscarPorCodigo(code);
        pelicula_eliminar.bitMuerto = true;
    }

    public void eliminarPeliculaPorTitulo(String title) {
        Pelicula pelicula_eliminar = buscarPorTitulo(title);
        pelicula_eliminar.bitMuerto = true;
    }

    public void eliminarPorRented(int rented) {
        Pelicula pelicula_eliminar = buscarPorRented(rented);
        pelicula_eliminar.bitMuerto = true;
    }

    public Pelicula buscarPorCodigo(int codigo_buscar) {
        ArrayList<Integer> temporal = new ArrayList<>();
        for (i = 0; i < listCode.size(); i++) {
            temporal.add(listCode.get(i).getCode());
        }
        int result = busqueda.busquedaBinaria(temporal, 0, temporal.size() - 1, codigo_buscar);
        int indice = listCode.get(result).getIndice();
        if (listPeli.get(indice).bitMuerto == true) {
            eliminarPelicula(indice);
            return null;
        } else {
            return listPeli.get(indice);
        }
    }

    public Pelicula buscarPorTitulo(String titulo_buscar) {
        ArrayList<String> temporal = new ArrayList<>();
        for (int i = 0; i < listTitle.size(); i++) {
            temporal.add(listTitle.get(i).getTitle());
        }
        int result = busqueda.busquedaBinariaString(temporal, titulo_buscar);
        int indice = listTitle.get(result).getIndice();
        if (listPeli.get(indice).bitMuerto == true) {
            eliminarPelicula(indice);
            return null;
        } else {
            return listPeli.get(indice);
        }
    }

    public int obtenerIndex(String titulo_buscar) {
        ArrayList<String> temporal = new ArrayList<>();
        for (int i = 0; i < listTitle.size(); i++) {
            temporal.add(listTitle.get(i).getTitle());
        }
        int result = busqueda.busquedaBinariaString(temporal, titulo_buscar);
        int indice = listTitle.get(result).getIndice();
        return indice;
    }

    public Pelicula buscarPorRented(int rented_buscar) {
        ArrayList<Integer> temporal = new ArrayList<>();
        for (int i = 0; i < listRentedby.size(); i++) {
            temporal.add(listRentedby.get(i).getRentendBy());
        }
        int result = busqueda.busquedaBinaria(temporal, 0, temporal.size() - 1, rented_buscar);
        int indice = listRentedby.get(result).getIndice();
        if (listPeli.get(indice).bitMuerto == true) {
            eliminarPelicula(indice);
            return null;
        } else {
            return listPeli.get(indice);
        }
    }

    public void marcaParaEliminar(int indice) {
        listPeli.get(indice).bitMuerto = true;
    }

    public void marcaParaAlquilar(int indice, int n) {
        listPeli.get(indice).numSocio = n;
        archivo.EscribirListaEnTxt(listPeli);
        refreshIndex();
    }

    public void marcaParaDevolver(int indice) {
        listPeli.get(indice).numSocio = 0;
        archivo.EscribirListaEnTxt(listPeli);
        refreshIndex();
    }

    public void eliminarPelicula(int indice) {
        listPeli.remove(indice);
        System.out.println("La pelicula que busca no se encuentra disponible");
    }

    public void refreshIndex() {
        listCode.clear();
        listTitle.clear();
        listCost.clear();
        listRentedby.clear();

        for (int i = 0; i < listPeli.size(); i++) {
            listCode.add(new IndexCode(listPeli.get(i).code, i));
            listTitle.add(new IndexTitle(listPeli.get(i).title, i));
            listCost.add(new IndexCost(listPeli.get(i).cost, i));
            listRentedby.add(new IndexRentedBy(listPeli.get(i).numSocio, i));
        }

        Collections.sort(listCode, IndexCode.compararCode);
        Collections.sort(listTitle, IndexTitle.comparaTitulo);
        Collections.sort(listCost, IndexCost.compararCost);
        Collections.sort(listRentedby, IndexRentedBy.compararRented);
    }

    public void mostrarInfo(ArrayList<Pelicula> array) {
        for (int i = 0; i < array.size(); i++) {
            array.get(i).printPelicula();
        }
    }

    public void nuevoCliente(int numSocio, String username) {
        listClient.add(new Usuario(numSocio, username));
    }

    public void reindexador() {
        ArrayList<Pelicula> lista_eliminados = new ArrayList<>();
        for (Pelicula peli : listPeli) {
            if (peli.bitMuerto == false) {
                lista_eliminados.add(peli);
            }
        }
        listPeli = lista_eliminados;
        archivo.EscribirListaEnTxt(listPeli);
        refreshIndex();
    }

    public int codeGenerator() {
        int min = 100000;
        int max = 1000000;
        int code = (int) (Math.random() * (max - min + 1) + min);
        return code;
    }

}
