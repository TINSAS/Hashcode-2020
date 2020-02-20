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
public class Librairie {
    int N;
    int T;
    int M;
    ArrayList<Livre> livres;
    ArrayList<Livre> livresScanne;

    public Librairie(int N, int T, int M, ArrayList<Livre> livres) {
        this.N = N;
        this.T = T;
        this.M = M;
        this.livres = livres;
        this.livresScanne = new ArrayList<>();
    }
    
    
}
