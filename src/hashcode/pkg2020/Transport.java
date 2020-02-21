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
class Transport {

    public int D;
    public ArrayList<Librairie> ListLibrairies;
    public ArrayList<Livre> ListeLivres;

    public Transport(int N, ArrayList<Librairie> list1, ArrayList<Livre> ListeLivres) {
        this.D = N;
        this.ListLibrairies = list1;
        this.ListeLivres = ListeLivres;
        
    }

}
