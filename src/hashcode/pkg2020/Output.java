/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode.pkg2020;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Benoît
 */
public class Output {

    public static void output(ArrayList<Librairie> list) {

        File output = new File("output.in");
        try {
            FileWriter fw = new FileWriter(output);
            
            fw.write(list.size() + "\n"); //Nombre de lib scannées
            for (int i = 0; i < list.size(); i++) { //on boucle sur les lib scannées
                fw.write(list.get(i).id + " "+list.get(i).livresScanne.size()+"\n"); //ID de la lib en cours + nb livres scannés
                    for(int j=0; j<list.get(i).livresScanne.size();j++){
                      fw.write(list.get(i).livresScanne.get(j).id + " "); //ID de chaque livre scanné
                    }
                    fw.write("\n"); //lib suivante
            }
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Output.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
