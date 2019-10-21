/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paquete.Calculadora;

import javax.swing.JOptionPane;

/**
 *
 * @author redes
 */
public class Postfija {
    public static void main(String[] args) {
        String Expresion, postfija="";  
        int i=0;
        TDA_pila Pila = new TDA_pila();
        Expresion = JOptionPane.showInputDialog("Teclear la expresión a validar:"); 
        char simbolo,elemento;
        while(i<Expresion.length()){
            simbolo=Expresion.charAt(i);
            if(!Pila.esOperador(simbolo))
                postfija+=simbolo;
            else{
                while(!Pila.esVacia() &&
                        Pila.Precedencia(Pila.Cima(), simbolo) ){
                    elemento=Pila.desapilar();
                    postfija += elemento;
                }
                if (simbolo != ')') 
                    Pila.apilar(simbolo);  
                else           
                    Pila.desapilar();
            }
            i++;
        }
        while(!Pila.esVacia()){
            elemento = Pila.desapilar();
            postfija += elemento;
        }
        JOptionPane.showMessageDialog(null, postfija);
    } 
}
