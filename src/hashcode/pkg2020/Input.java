package hashcode.pkg2020;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Benoît
 */
public class Input {


    public static Transport input() {
        ArrayList<Livre> ListeLivres = new ArrayList<>();
            ArrayList<Librairie> ListeLibrairies = new ArrayList<>();
        //Tri : Collections.sort(ArrayList);
        //Copie : newArrayList = (ArrayList<Integer>)ArrayList.clone();
        //Ajout : ArrayList.add(element);

        /*Lecture fichier : 
            BufferedReader reader = new BufferedReader(new FileReader("nomFichier.in"));
            String S = S = reader.readLine();
         */
        //Conversion String->int : Integer.valueOf(str);
        int B = 0, L = 0, D = 0;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("f_libraries_of_the_world.txt"));
            String S = reader.readLine();
            String Tab[] = S.split(" ");
            B = Integer.valueOf(Tab[0]);
            L = Integer.valueOf(Tab[1]);
            D = Integer.valueOf(Tab[2]);

            
            S = reader.readLine();
            String Tab2[] = S.split(" ");
            for (int i = 0; i < B; i++) {
                ListeLivres.add(new Livre(i, Integer.valueOf(Tab2[i])));
            }
            for (int i = 0; i < L; i++) {
                int N = 0, T = 0, M = 0;
                S = reader.readLine();
                String Tab3[] = S.split(" ");
                S = reader.readLine();
                String Tab4[] = S.split(" ");
                ArrayList<Livre> Livres = new ArrayList<>();
                for (int j = 0; j < Tab4.length; j++) {
                    Livres.add(ListeLivres.get(Integer.valueOf(Tab4[j])));
                }
                ListeLibrairies.add(new Librairie(i,Integer.valueOf(Tab3[0]), Integer.valueOf(Tab3[1]), Integer.valueOf(Tab3[2]), Livres));
            }
            /*for (int i = 0; i < ListeLibrairies.size(); i++) {
                for (int j = 0; j < ListeLibrairies.get(i).livres.size(); j++) {
                    System.out.print(ListeLibrairies.get(i).livres.get(j).id + " ");
                }
                System.out.println("");
            }*/

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
        }

//        BufferedReader reader = null;
//        try {
//            reader = new BufferedReader(new FileReader("d_quite_big.in"));
//            
//            String S = reader.readLine();
//            String T1[] = S.split(" ");
//            M = Integer.valueOf(T1[0]);
//            N = Integer.valueOf(T1[0]);
//            
//            S = reader.readLine();
//            String T2[] = S.split(" ");
//            for (int i = 0; i < N; i++) {
//                Pizza.add(Integer.valueOf(T2[i]));
//            }   
//            
//            
//
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                reader.close();
//            } catch (IOException ex) {
//                Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
System.out.println(""+ListeLibrairies);
        return new Transport(D, ListeLibrairies);
    }
}
