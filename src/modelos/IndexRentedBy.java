/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.Comparator;

/**
 *
 * @author Lants
 */
public class IndexRentedBy {
    protected int rentendBy;
    protected int indice;

    public IndexRentedBy(int rentendBy, int indice) {
        this.rentendBy = rentendBy;
        this.indice = indice;
    }

    public int getRentendBy() {
        return rentendBy;
    }

    public void setRentendBy(int rentendBy) {
        this.rentendBy = rentendBy;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    
    public static Comparator<IndexRentedBy> compararRented = new Comparator<IndexRentedBy>() {

        public int compare(IndexRentedBy s1, IndexRentedBy s2) {
            int nums1 = s1.getRentendBy();
            int nums2 = s2.getRentendBy();

            return nums1-nums2;
        }
        
    };
    
}
