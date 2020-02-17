package hashcode.pkg2020;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Benoît
 */
public class Input {

    public static Transport input(){
        //Tri : Collections.sort(ArrayList);
        //Copie : newArrayList = (ArrayList<Integer>)ArrayList.clone();
        //Ajout : ArrayList.add(element);
        
        
        /*Lecture fichier : 
            BufferedReader reader = new BufferedReader(new FileReader("nomFichier.in"));
            String S = S = reader.readLine();
        */
        
        //Conversion String->int : Integer.valueOf(str);

        
        int N=-1,M=-1;
        ArrayList<Integer> Pizza = new ArrayList<>();
        
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("d_quite_big.in"));
            
            String S = reader.readLine();
            String T1[] = S.split(" ");
            M = Integer.valueOf(T1[0]);
            N = Integer.valueOf(T1[0]);
            
            S = reader.readLine();
            String T2[] = S.split(" ");
            for (int i = 0; i < N; i++) {
                Pizza.add(Integer.valueOf(T2[i]));
            }   
            
            

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        return new Transport(0,Pizza);
    }
}
