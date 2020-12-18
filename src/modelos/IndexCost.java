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
public class IndexCost {
    protected int cost;
    protected int indice;

    public IndexCost(int cost, int indice) {
        this.cost = cost;
        this.indice = indice;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    
    public static Comparator<IndexCost> compararCost = new Comparator<IndexCost>() {

        public int compare(IndexCost s1, IndexCost s2) {
            int cost1 = s1.getCost();
            int cost2 = s2.getCost();

            return cost1-cost2;
        }
        
    };
    
}
