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
public class base {
    
    public static void main(String args[]){
        String allenFinal = "6ADC530514";
        char allen[] = allenFinal.toCharArray();
        String codigoFinal="";
        int aux = allenFinal.length()/2 -1;
        int aux2 = allenFinal.length()+aux;
        char allenT[] = new char[aux2];
              for(int h=0; h<=aux2; h=h+2){
                  if(h-2<= aux2){
                  allenT[h] = allen[h];
                  allenT[h+1] = allen[h+1];
                  allenT[h+2] ='-';}
              }
              for(int i=0; i<allen.length; i++){
        System.out.print(allen[i]);}
              System.out.print(aux + "suma");
              System.out.print(aux2 + "suma");
    }
   static int suma(String mensajeRc4){
       int aux;
       int sumPar[]=new int[5];
                int sum = 1;
               int p=0;
               int x=0;
               for(int k=0; k<5 ; k++){
                   int res=0;
                   while(x<mensajeRc4.length()){
                   aux = mensajeRc4.charAt(x);
                   res = res +aux;
                   x=x+5;
                   }
                   sumPar[k]=res;
                   x=0;
                   x=x+k+1;
                   
               }
        return sumPar[3];
   }
    
    static int obtenerAscii(String mensaje){
        int res=0;
        int resT = 0;
        for (int x=0;x<mensaje.length();x++){
            res = mensaje.charAt(x);
            resT = resT + res;
        }
        return resT;
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
    
}
