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
public class IndexTitle {

    protected String title;
    protected int indice;

    public IndexTitle(String title, int indice) {
        this.title = title;
        this.indice = indice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public static Comparator<IndexTitle> comparaTitulo = new Comparator<IndexTitle>() {

        public int compare(IndexTitle s1, IndexTitle s2) {
            String title1 = s1.getTitle().toUpperCase();
            String title2 = s2.getTitle().toUpperCase();

            return title1.compareTo(title2);

        }
    };

}
