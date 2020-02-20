/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode.pkg2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Leon
 */
public class Hashcode2020 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Transport transport = Input.input();

        int d=transport.D;
        ArrayList<Librairie> monde = transport.ListLibrairies;
        System.out.println(""+monde);
        System.out.println(""+d);
        int l = monde.size();
        /*ArrayList<Librairie> monde = new ArrayList<>();
        int d = 7;
        int l = 2;

        ArrayList<Livre> lib1 = new ArrayList<>();
        lib1.add(new Livre(0, 1));
        lib1.add(new Livre(1, 2));
        lib1.add(new Livre(2, 3));
        lib1.add(new Livre(3, 6));
        lib1.add(new Livre(4, 5));
        monde.add(new Librairie(0, 5, 2, 2, lib1));

        ArrayList<Livre> lib2 = new ArrayList<>();
        lib2.add(new Livre(3, 6));
        lib2.add(new Livre(2, 3));
        lib2.add(new Livre(5, 4));
        lib2.add(new Livre(0, 1));
        monde.add(new Librairie(1, 4, 3, 1, lib2));*/

        /*System.out.println("Monde : ");
        for (int i = 0; i < monde.size(); i++) {
            monde.get(i).print();
        }
        System.out.println("Fin Monde");*/

        ArrayList<Librairie> soluc = trouveSolution(monde, d, l);

        /*System.out.println("Soluc : ");
        for (int i = 0; i < soluc.size(); i++) {
            soluc.get(i).printSoluc();
        }
        System.out.println("Fin Soluc");*/

        System.out.println("Score : "+Score.score(soluc, d));
        Output.output(soluc);
    }

    public static ArrayList<Librairie> trouveSolution(ArrayList<Librairie> monde, int d, int l) {
        ArrayList<Librairie> soluc = new ArrayList<>();
        Collections.sort(monde, Collections.reverseOrder());

        int jour = 0;
        int counter = 0;
        Librairie tmp;
        while (jour < d && counter < l) {
            tmp = monde.get(counter);
            tmp.jourDebut=jour;
            soluc.add(tmp);
            counter++;
            jour += tmp.T;
            //System.out.println("" + jour);
        }
        if (jour > d) {
            soluc.remove(soluc.size() - 1);
        }
        
        for (int i = 0; i < soluc.size(); i++) {
            tmp = soluc.get(i);
            Collections.sort(tmp.livres);
            int jour2 = tmp.jourDebut;
            int counter2=0;
            while (jour2<d && counter2<tmp.livres.size()) { 
                for(int j=0;j<tmp.M;j++){
                   if(tmp.livres.get(counter2).Scanne==false){
                    tmp.livresScanne.add(tmp.livres.get(counter2));
                    tmp.livres.get(counter2).Scanne=true;
                }
                counter2++; 
                }
                
                jour2+=1;
            }
        }
        return soluc;
    }

}
