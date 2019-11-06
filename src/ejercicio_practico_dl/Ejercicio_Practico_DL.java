/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_practico_dl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Ejercicio_Practico_DL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int test_cases = pedirCantCasos();

        String arr[] = cargarArr(test_cases);

        for (String string : arr) {

            System.out.println(revisar(string));
            
        }

    }

    public static int revisar(String a) {
        int r=0;
        for (int i = 0; i < a.length(); i++) {
            String x=a.substring(i);
            for (int j = 0; j < x.length(); j++) {
                if(x.charAt(j)==a.charAt(j)){
                r++;
                }
                else{break;}
            }
        }
        return r;
    }

    public static String[] cargarArr(int cant_casos) {
        String arr[] = new String[cant_casos];
        String x;
        Pattern p = Pattern.compile("(\\W)|(\\d)");

        for (int i = 0; i < cant_casos; i++) {
            x = JOptionPane.showInputDialog(null, "Ingrese un string a comparar", "Ingrese un string", JOptionPane.QUESTION_MESSAGE);

            if (x == null || x.isEmpty()) {
                i--;
                JOptionPane.showMessageDialog(null, "Ingrese un string", "Error", JOptionPane.WARNING_MESSAGE);
                continue;
            }

            Matcher m = p.matcher(x);
            if (m.find()) {
                i--;
                JOptionPane.showMessageDialog(null, "Ingrese un string que contenga solo a-z", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                arr[i] = x;
            }
        }
        return arr;
    }

    public static int pedirCantCasos() {
        int x = 0;
        while (true) {
            try {
                x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de casos: (0 para salir)", 3));
                if (x == 0) {
                    System.exit(0);
                }
                if (x < 1 || x > 10) {
                    JOptionPane.showMessageDialog(null, "Ingrese un numero entre 1 y 10", "Error", JOptionPane.WARNING_MESSAGE);
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un numero por favor", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
        return x;
    }

}
