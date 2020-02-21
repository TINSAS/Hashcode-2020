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
        double ind = 0;
        Transport transport = Input.input();

        int d = transport.D;
        ArrayList<Librairie> monde = transport.ListLibrairies;
        ArrayList<Livre> livres = transport.ListeLivres;
        //System.out.println("" + monde);
        // System.out.println("" + d);
        int l = monde.size();

        ArrayList<Librairie> soluc = new ArrayList<Librairie>();
        soluc = trouveSolution(monde, d, l, 0, livres);
        //System.out.println("Score : " + Score.score(soluc, d));
        Max = 0;
        for (int i = 0; i <= 10; i++) {
            soluc = trouveSolution(monde, d, l, i, livres);
            //System.out.println("Score : " + Score.score(soluc, d));
            if (Score.score(soluc, d) > Max) {
                Max = Score.score(soluc, d);
                ind = i;
            }
        }
        soluc = trouveSolution(monde, d, l, ind, livres);
        System.out.println("Score final: " + Score.score(soluc, d));

        Max = 0;
        double indFinal = 0;
        for (int i = -5; i <= 5; i++) {
            if(ind + 0.1 * i<0) continue;
            soluc = trouveSolution(monde, d, l, ind + 0.1 * i, livres);
            //System.out.println("Score : " + Score.score(soluc, d));
            if (Score.score(soluc, d) > Max) {
                Max = Score.score(soluc, d);
                indFinal = ind + 0.1 * i;
            }
        }
        //System.out.println(ind);

        soluc = trouveSolution(monde, d, l, indFinal, livres);
        System.out.println("Score final: " + Score.score(soluc, d));

        /*System.out.println("Soluc : ");
        for (int i = 0; i < soluc.size(); i++) {
            soluc.get(i).printSoluc();
        }
        System.out.println("Fin Soluc");*/
        Output.output(soluc);
    }

    public static ArrayList<Librairie> trouveSolution(ArrayList<Librairie> monde, int d, int l, double power, ArrayList<Livre> livres) {
        for (int j = 0; j < livres.size(); j++) {
            livres.get(j).Scanne = false;
        }
        for (int i = 0; i < monde.size(); i++) {
            monde.get(i).livresScanne.clear();
        }

        monde = (ArrayList<Librairie>) monde.clone();
        ArrayList<Librairie> soluc = new ArrayList<>();
        for (int i = 0; i < monde.size(); i++) {
            monde.get(i).calculScorLib(power);
        }
        Collections.sort(monde, Collections.reverseOrder());

        int jour = 0;
        //int counter = 0;
        Librairie tmp;
        while (jour < d && !monde.isEmpty()) {
            tmp = monde.get(0);
            tmp.calculScorLib(power);
            if ((d - jour - tmp.T - 1) > 0 && tmp.scoreLib!=0) {
                tmp.jourDebut = jour;
                soluc.add(tmp);
                monde.remove(0);
                //counter++;
                jour += tmp.T;
                /*for (int i = 0; i < monde.size(); i++) {
                    monde.get(i).calculScorLib(power);
                }*/
                //Collections.sort(monde, Collections.reverseOrder());


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
                monde.remove(0);
                //counter++;
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
