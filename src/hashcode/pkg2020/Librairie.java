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
    public Integer scoreLib;
    public ArrayList<Livre> livres;
    public ArrayList<Livre> livresScanne;
    public int jourDebut;

    public Librairie(int id, int N, int T, int M, ArrayList<Livre> livres) {
        this.id = id;
        this.N = N;
        this.T = T;
        this.M = M;
        this.livres = livres;
        this.livresScanne = new ArrayList<>();
        this.scoreLib=0;
        
        for (int i = 0; i < livres.size(); i++) {
            scoreLib+=livres.get(i).valeur;
        }
        System.out.println("Score Lib :"+scoreLib);
        scoreLib/=T*T*T*T*T*T;
        System.out.println("    Score Lib :"+scoreLib);
    }

    public void print() {
        System.out.println("Librairie " + id);
        for (int i = 0; i < livres.size(); i++) {
            livres.get(i).print();
        }
    }

    public void printSoluc() {
        System.out.println("Librairie " + id);
        for (int i = 0; i < livresScanne.size(); i++) {
            livresScanne.get(i).print();
        }
    }

    @Override
    public int compareTo(Librairie arg0) {
        return this.scoreLib.compareTo(arg0.scoreLib);
    }
    
    
    

}
