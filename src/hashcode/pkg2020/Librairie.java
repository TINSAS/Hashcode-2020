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
    public int id;
    public int N;
    public int T;
    public int M;
    public ArrayList<Livre> livres;
    public ArrayList<Livre> livresScanne;

    public Librairie(int id, int N, int T, int M, ArrayList<Livre> livres) {
        this.id = id;
        this.N = N;
        this.T = T;
        this.M = M;
        this.livres = livres;
        this.livresScanne = new ArrayList<>();
    }
    
    
}
