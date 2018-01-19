package main.com.yuliiakulyk.app.c.exceptions;

import javax.swing.JOptionPane;
/**
 * Created by Yuliia Kulyk on 18.01.2018.
 */
public class Window {
    public static void main(String[] args) {
        double a;
        for(;;){
            try{
                a=Double.valueOf(JOptionPane.showInputDialog("Input double number"));
                break;
            } catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Error number format");
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Cancel. Set default value = 0");
            }
        }System.out.println(a);
    }

}
