/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author sosag
 */
public class metodosDeBusqueda {

    int busquedaBinaria(ArrayList<Integer> arr, int izq, int der, int x) {
        if (der >= izq) {
            int med = izq + (der - izq) / 2;
            //Si el elemento esta en el medio
            if (arr.get(med) == x) {
                return med;
            }
            //Si es menor entonces solo puede estar en el subarray izquierdo
            if (arr.get(med) > x) {
                return busquedaBinaria(arr, izq, med - 1, x);
            }
            //Si es mayor entonces solo puede estar en el subarray derecho
            return busquedaBinaria(arr, med + 1, der, x);
        }
        //Si no entonces no se encuentra en el array y retornara -1
        return -1;
    }

    int busquedaBinariaString(ArrayList<String> arr, String x) {
        int izq = 0, der = arr.size() - 1;
        while (izq <= der) {
            int med = izq + (der - izq) / 2;
            int res = x.compareTo(arr.get(med));
            // Revisa si x esta en el medio
            if (res == 0) {
                return med;
            }
            // Si x es mayor, ignora la mitad izquierda del array
            if (res > 0) {
                izq = med + 1;
            } // Si x es menor, ignora la mitad derecha del array
            else {
                der = med - 1;
            }
        }
        //Si no entonces no se encuentra en el array y retornara -1
        return -1;
    }
}
