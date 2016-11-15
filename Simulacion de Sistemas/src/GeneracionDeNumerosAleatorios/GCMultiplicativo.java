/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneracionDeNumerosAleatorios;

import java.util.Scanner;

/**
 *
 * @author danni
 */
public class GCMultiplicativo {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int xo= scan.nextInt();
        int a= scan.nextInt();
        int m= scan.nextInt();
        int respuestas[] = new int[m];
        respuestas[0] = xo;
        int resp=0; 
        resp = (a*xo)%m;
        int cont = 1;
        for(int i=1; i<m && respuestas[0]!=resp; i++){
            respuestas[i]=resp;
            xo=resp;
            resp= (a*xo)%m;
            cont++;
        }
        System.out.println(cont);
    } 
    
}
