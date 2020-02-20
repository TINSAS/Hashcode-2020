/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode.pkg2020;

/**
 *
 * @author Leon
 */
public class Livre implements Comparable<Livre>{
    public int id;
    public Integer valeur;

    public Livre(int id, int valeur) {
        this.id = id;
        this.valeur = valeur;
    }

    void print() {
        System.out.println("    Livre "+id+" de valeur "+valeur);
    }

    @Override
    public int compareTo(Livre arg0) {
        return this.valeur.compareTo(arg0.valeur);
    }
}
