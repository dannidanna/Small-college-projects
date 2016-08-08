/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redes.criptografia;

/**
 *
 * @author danni
 */
public class cifrar {
    
    public static void main(String args[]){
        System.out.println(CifrarMensajeRC4("290400110079rCB7Sv4150312X24189179011589d)5k7N2007070201%3a250031b8", "9rCB7Sv4X29d)5k7N%3ab89p-3(5[A71621"));
    }
    
    static String CifrarMensajeRC4(String mensaje, String llave){
        int state[]= new int[256];
        int x=0, y=0, index1=0, index2=0, nMen, i, aux;
        String mensajeCifrado = "";
        
        for(i=0; i<=255; i++ ){
            state[i] = i;
        }
        for(i=0; i<=255; i++ ){
            index2 = (llave.charAt(index1)+state[i]+index2) % 256;
            aux = state[i];
            state[i]= state[index2];
            state[index2] = aux;
            index1 = (index1 + 1) % llave.length();
        }
        for(i=0; i<=(mensaje.length()-1); i++ ){
            x = (x+1)%256;
            y = (state[x]+y) %256;
            aux = state[x];
            state[x] = state[y];
            state[y] = aux;
            nMen = (mensaje.charAt(i))^ state[(state[x]+state[y])% 256];
            mensajeCifrado = mensajeCifrado +'-'+ RellenaCero(ConvierteAHexadecimal(nMen));
        }
        
        String resp= mensajeCifrado.substring(1, mensajeCifrado.length());
        String resp1 = resp.replace("-", "");
        return resp1.toUpperCase();
        
        
    }
    
    static String ConvierteAHexadecimal(int nMen){
        String res = "";
        res = Integer.toHexString(nMen);
        return res;
    }
    
    static String RellenaCero(String num){
        String res="";
        if(num.length()==1){
            res = '0'+num;
        }
        else res = num;
        return res;
    }
    
}
