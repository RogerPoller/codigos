package Paquete.Calculadora;

import java.util.StringTokenizer;

public class TDA_pila {
    final static int MAX_ELEMENTOS = 100; 
    private int error;
    private int cima; 
    private char elemento[];
    public TDA_pila() {
        error = 0;
        cima = -1;
        elemento = new char [MAX_ELEMENTOS];  
    }
    public void apilar(char d) {  
        if (!pilaLlena()) elemento[++cima]= d; 
        else   
            error = 1;   
    } 
    public char desapilar() { 
        if (!esVacia()) return elemento[cima--]; 
        else {
            error = 2; 
            return ' '; 
        }     
    }         
    public boolean esVacia() { 
        if (cima == -1)return true; 
        else 
            return false;   
    } 
    public boolean pilaLlena() { 
        if (cima == (MAX_ELEMENTOS - 1))return true; 
        else 
            return false;
    }     
    public int muestraError() {
        return error;
    } 
    public boolean Basico(char op){
        boolean r=false;
        if(op=='+') r=true;
        if(op=='-') r=true;
        if(op=='*') r=true;
        if(op=='/') r=true;
        if(op=='^') r=true;
        return r;
    }
    public boolean esOperador(char op){
        boolean r =Basico(op);
        switch (op){
            case '(':
            case ')': r=true;break;
        }
        return r;
    }
    public boolean Precedencia(char op, char op2){
        boolean r=false;
        if(op=='^' && Basico(op2)) r=true;
        if(op=='*' || op=='/' && Basico(op2) && op2!='^') r=true;
        if(op=='+' || op=='-' && op2=='+' || op2=='-') r=true;
        if(Basico(op) && op2==')')r=true;
        return r;
    }
    public char Cima(){
        return elemento [cima];
    }
    
   /* private void CargarToken() {
        StringTokenizer token = new StringTokenizer(cad, " ^+*-/()", true);
        while (token.hasMoreElements()) {
            String t = token.nextToken();
            expresion.Encolar(t);
        }
    }*/
}