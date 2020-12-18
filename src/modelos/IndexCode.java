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
public class IndexCode {
    
    protected int code;
    protected int indice;

    public IndexCode(int code, int indice) {
        this.code = code;
        this.indice = indice;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    
    public static Comparator<IndexCode> compararCode = new Comparator<IndexCode>() {

        public int compare(IndexCode s1, IndexCode s2) {
            int code1 = s1.getCode();
            int code2 = s2.getCode();

            return code1-code2;
        }
        
    };
    
}
