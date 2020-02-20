/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode.pkg2020;

import java.util.ArrayList;

/**
 *
 * @author Leon
 */
public class Librairie implements Comparable<Librairie>{

    public int id;
    public int N;
    public int T;
    public int M;
    public Integer somme;
    public ArrayList<Livre> livres;
    public ArrayList<Livre> livresScanne;

    public Librairie(int id, int N, int T, int M, ArrayList<Livre> livres) {
        this.id = id;
        this.N = N;
        this.T = T;
        this.M = M;
        this.livres = livres;
        this.livresScanne = new ArrayList<>();
        
        for (int i = 0; i < livres.size(); i++) {
            somme+=livres.get(i).valeur;
        }
    }

    public void print() {
        System.out.println("Librairie " + id);
        for (int i = 0; i < livres.size(); i++) {
            livres.get(i).print();
        }
    }

    @Override
    public int compareTo(Librairie arg0) {
        return this.somme.compareTo(arg0.somme);
    }
    
    
    

}
