/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redes.criptografia;

public class obtener {
    
    public static void main(String args[]){
        System.out.println(obtenerVerhoeff("15031"));
        
    }
    static int obtenerVerhoeff(String cifra){
        int mul[][]={{0,1,2,3,4,5,6,7,8,9},{1,2,3,4,0,6,7,8,9,5},{2,3,4,0,1,7,8,9,5,6},{3,4,0,1,2,8,9,5,6,7},{4,0,1,2,3,9,5,6,7,8},{5,9,8,7,6,0,4,3,2,1},{6,5,9,8,7,1,0,4,3,2},{7,6,5,9,8,2,1,0,4,3},{8,7,6,5,9,3,2,1,0,4},{9,8,7,6,5,4,3,2,1,0}}; 
        int per[][]={{0,1,2,3,4,5,6,7,8,9},{1,5,7,6,2,8,3,0,9,4},{5,8,0,3,7,9,6,1,4,2},{8,9,1,6,0,4,3,5,2,7},{9,4,5,3,1,2,6,8,7,0},{4,2,8,6,5,7,3,9,0,1},{2,7,9,3,8,0,6,4,1,5},{7,0,4,6,9,1,3,2,5,8}};
        int inv[] = {0,4,3,2,1,5,6,7,8,9};
        int check =0, i;
        String numeroInvertido[];
        numeroInvertido = invierteNumero(cifra);
        
        
        for(i =0; i<=(numeroInvertido.length -1); i++){
            
            check = mul[check][per[((i+1)%8)][aNumero(numeroInvertido[i])]];
            
        }
        return inv[check];
    }
    
    static String[] invierteNumero(String sCadena){
        int aux = sCadena.length();
        String res[]= new String[aux];
        String sCadenaInvertida="";
        for (int x=sCadena.length()-1;x>=0;x--){
		sCadenaInvertida = sCadenaInvertida + sCadena.charAt(x);}
        for(int i=0; i<aux; i++){
            res[i] = sCadenaInvertida.substring(i,i+1);}
        return res;
    }
    
    static int aNumero(String numInv){
        int res= Integer.parseInt(numInv);
        return res;
    }
    
}
