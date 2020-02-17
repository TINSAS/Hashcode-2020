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
        
        int n=transport.N;
        ArrayList<Integer> list = transport.list1;

        System.out.println("Liste :" + Arrays.toString(list.toArray()));
        
        ArrayList<Integer> soluc = trouveSolution(list, n);
        System.out.println("Solution : " + Arrays.toString(soluc.toArray()));
        System.out.println("Score : "+Score.score(soluc));
        Output.output(soluc);
    }
    
    public static ArrayList<Integer> trouveSolution(ArrayList<Integer> parts, int n){
        ArrayList<Integer> soluc = new ArrayList<>();
        return soluc;
    }

}
