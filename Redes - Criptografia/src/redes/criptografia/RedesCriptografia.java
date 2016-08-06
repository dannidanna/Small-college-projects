/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redes.criptografia;

import java.util.Scanner;

/**
 *
 * @author danni
 */
public class RedesCriptografia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // TODO code application logic here
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
            index1 = (index1 + 1) % llave.length;
        }
        for(i=0; i<=(mensaje.length-1); i++ ){
            x = (x+1)%256;
            y = (state[x]+y) %256;
            aux = state[x];
            state[x] = state[y];
            state[y] = aux;
            nMen = (mensaje.charAt(i))^ state[(state[x]+state[y])% 256];
            mensajeCifrado = mensajeCifrado +"-"+ RellenaCero(ConvierteAHexadecimal(nMen));
        }
        
        return mensajeCifrado.substring(1, mensajeCifrado.length()-1);
        
        
    }
    
    static String ObtenerBase64(int numero){
        char diccionario[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9','A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J','K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T','U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd','e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n','o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x','y', 'z', '+', '/' };
        int cociente =1, resto;
        String palabra = "";
        
        while(cociente>0){
            cociente = numero/64;
            resto = numero % 64;
            palabra = diccionario[resto] + palabra;
            numero = cociente;
        }
        
        return palabra;
    }
    
    static int obtenerVerhoeff(String cifra){
        int mul[][]={{0,1,2,3,4,5,6,7,8,9},{1,2,3,4,0,6,7,8,9,5},{2,3,4,0,1,7,8,9,5,6},{3,4,0,1,2,8,9,5,6,7},{4,0,1,2,3,9,5,6,7,8},{5,9,8,7,6,0,4,3,2,1},{6,5,9,8,7,1,0,4,3,2},{7,6,5,9,8,2,1,0,4,3},{8,7,6,5,9,3,2,1,0,4},{9,8,7,6,5,4,3,2,1,0}}; 
        int per[][]={{0,1,2,3,4,5,6,7,8,9},{1,5,7,6,2,8,3,0,9,4},{5,8,0,3,7,9,6,1,4,2},{8,9,1,6,0,4,3,5,2,7},{9,4,5,3,1,2,6,8,7,0},{4,2,8,6,5,7,3,9,0,1},{2,7,9,3,8,0,6,4,1,5},{7,0,4,6,9,1,3,2,5,8}};
        int inv[] = {0,4,3,2,1,5,6,7,8,9};
        int check =0, i;
        String numeroInvertido[];
        numeroInvertido[i] = invierteNumero(cifra);
        for(i =0; i<=(numeroInvertido.length -1); i++){
            check = mul[check, per[((i+1)%8),a_Numero(numeroInvertido[i])]];
            
        }
        return inv[check];
    }
    
    static String invierteNumero(String numero){
        if((null==numero)||(numero.length()<=1)){
            return numero;
        }
        return new StringBuffer(numero).reverse().toString();
    }
    
    static int a_Numero(String numInv){
        int res= Integer.parseInt(numInv);
        return res;
    }
    
    static String RellenaCero(String num){
        String res;
        if(num.length()==1){
            res = '0'+num;
        }
        else res = num;
        return res;
    }
    
   /* static int cantDigitos(String numInvertido){
        int res = 0;
        while(numInvertido!=0){
            numInvertido = numInvertido/10;
            res++;
        }
        return res;
    }*/
}
