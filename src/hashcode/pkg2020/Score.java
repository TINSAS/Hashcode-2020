/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode.pkg2020;

import java.util.ArrayList;

/**
 *
 * @author Benoît
 */
public class Score {

    public static int score(ArrayList<Librairie> Librairies, int day) {
        int score = 0; // Score final
        int score_d = 0 ; //Score après les D-1 jours
        int signup = 0 ; //Compter le nombre de jour d'enregistrements
        ArrayList<Integer> books = new ArrayList(); //ArrayList des livres déjà traités
        
        ArrayList<Livre> livresScanne;
        
        for (int i = 0; i < Librairies.size(); i++) { //On parcourt chaque librairie
            signup = signup  + Librairies.get(i).T ;
            livresScanne = Librairies.get(i).livresScanne;
            for (int j = 0; j < livresScanne.size(); j++) { //On parcourt les livres scannés par chaque librairie
                if ((books.contains(livresScanne.get(j).id)) == false) { //Si l'ID n'a pas été traité, on l'ajoute au score
                    score = score + livresScanne.get(j).valeur; //incrémentation du score
                    books.add(livresScanne.get(j).id); //On ajoute l'ID du livre à la liste des traités
                }
                if(signup == day-1){
                    score_d = score ;
                }
            }
        }
       // System.out.println("Jour utilisé " +signup);
       // if(score_d != score){
         //   System.err.println("SCORE FINAL DIFFERENT DU SCORE REEL T NUL LEON");
       // }
        return (score);
    }
}
