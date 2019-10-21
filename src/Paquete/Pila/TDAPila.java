package Paquete.Pila;

public class TDAPila {
    public int TAM=10;
    private Double[] arreglo;
    private int pos;

    public TDAPila(){
        arreglo = new Double[TAM];
        pos = -1;
    }
    
    public TDAPila(int n){
        arreglo = new Double[n];
        pos = -1;
        TAM = n;
    }
    
    public boolean esVacia(){
        boolean estado = false;
        if (pos == -1)
            estado = true;
        return estado;
    }
    
    public boolean estaLlena(){
        boolean estado = false;
        if (pos == TAM-1)
            estado = true;
        return estado;
    }
    
    public void apilar(Double item){
        if (!estaLlena()){
            pos++;
            arreglo[pos] = item;
        }else{
            System.out.println("Pila Llena!!");
        }
    }
    
    public Double desapilar(){
        Double elementoSacado = arreglo[pos];
        pos--;
        return elementoSacado;
    }
    
    public Double cima(){
        return arreglo[pos];
    }
}
