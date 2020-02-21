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
        int power = 1, Max;
        double ind=0;
        Transport transport = Input.input();

        int d = transport.D;
        ArrayList<Librairie> monde = transport.ListLibrairies;
        int l = monde.size();

        ArrayList<Librairie> soluc = new ArrayList<Librairie>();
        soluc = trouveSolution(monde, d, l, 0);

        Max = Score.score(soluc, d);
        for (int i = 1; i <= 10; i++) {
            soluc = trouveSolution(monde, d, l, i);

            if(Score.score(soluc, d)>Max){
                Max=Score.score(soluc, d);
                ind =i;

            }
        }
        for (int i = 1; i <= 10; i++) {
            soluc = trouveSolution(monde, d, l, ind+0.1*i);

            if(Score.score(soluc, d)>Max){
                Max=Score.score(soluc, d);
                ind =ind+0.1*i;
            }
        }

        
        soluc = trouveSolution(monde, d, l, ind);
        System.out.println("Score : " + Score.score(soluc, d));
        Output.output(soluc);
    }

    public static ArrayList<Librairie> trouveSolution(ArrayList<Librairie> monde, int d, int l, double power) {
        ArrayList<Librairie> soluc = new ArrayList<>();
        for (int i = 0; i < monde.size(); i++) {
            monde.get(i).calculScorLib(power);
        }
        Collections.sort(monde, Collections.reverseOrder());
        
        int jour = 0;
        int counter = 0;
        Librairie tmp;
        while (jour < d && counter < l){
            tmp = monde.get(counter);
            if ((d - jour - tmp.T - 1) > 0) {
                tmp.jourDebut = jour;
                soluc.add(tmp);
                counter++;
                jour += tmp.T;
                
            Collections.sort(tmp.livres, Collections.reverseOrder());
            int jour2 = tmp.jourDebut;
            int counter2 = 0;
            while (jour2 < d && counter2 < tmp.livres.size()) {
                for (int j = 0; j < tmp.M; j++) {
                    if (counter2 >= tmp.livres.size()) {
                        break;
                    }
                    if (tmp.livres.get(counter2).Scanne == false) {
                        tmp.livresScanne.add(tmp.livres.get(counter2));
                        tmp.livres.get(counter2).Scanne = true;
                    }
                    counter2++;
                }
                jour2 += 1;
            }

            } else {
                counter++;
            }
        }
        if (jour > d) {
            soluc.remove(soluc.size() - 1);
        }

        for (int i = 0; i < soluc.size(); i++) {
            tmp = soluc.get(i);

        }
        return soluc;
    }

}
