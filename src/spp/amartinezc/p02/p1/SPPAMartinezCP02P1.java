/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spp.amartinezc.p02.p1;
import java.util.Scanner;
/**
 *
 * @author andres
 */
public class SPPAMartinezCP02P1 {
    public static void main(String[] args) {
       Scanner kb=new Scanner(System.in);
        System.out.println("Multiplicador, sumador y restador de 2 matrices");
        System.out.println("Introduce el tamaño n las matrices cuadradas(nxn)");
        int n=kb.nextInt();    
        
        
        int[][] A=matriz(n,"A"); //LLamo al método matriz igualandolo a la matriz A
        int[][] B=matriz(n,"B"); //lLamo al método matriz igualandolo a la matriz B
        
        System.out.println("\n¿Qué desea hacer?"); 
        System.out.println("\n[1]Sumar\n[2]Restar\n[3]Multiplicar AxB\n[4]Multiplicar BxA\n[Presione un número diferente para salir\n"); //Despliego menú para que el usuario introduzca la operación a realizar
        int seleccion=kb.nextInt();
        switch(seleccion){ //utilizo "switch" para el menú y en cada caso se llamará al metodo correspondiente utilizando las matrices creadas por el usuario
                case 1:
                    System.out.println("\nA+B= \n");
                    suma(A,B,n);
                    System.exit(0);
                case 2:
                    System.out.println("\nA-B= \n");
                    resta(A,B,n);
                    System.exit(0);
                case 3:
                    System.out.println("\nAxB= \n");
                    multiplicacionAxB(A,B,n);
                    System.exit(0);
                case 4:
                    System.out.println("\nBxA= \n");
                    multiplicacionBxA(A,B,n);
                    System.exit(0);
                default:
                    System.out.println("Adiós");
                    System.exit(0);
        
        }      
    }
    public static int solicitarentero(){ //Método para introducir números enteros
        Scanner kb=new Scanner(System.in);
        int n=0;
        boolean flag; 
        do{
            try{ //Try & catch para errores de introducción de datos por teclado
                n=kb.nextInt();
                flag=true;
            }catch (Exception ex) {
                flag=false;
                System.out.println("Dato no válido");
                kb.nextLine();
            }
        }while(flag==false);
         return n;
    }
    public static int[][] matriz(int n,String nombre){//Método que devuelve matrices cuadradas con los valores introducidos por el usuario 
        int[][] matriz=new int[n][n];//Declaro la matriz cuadrada
        System.out.println("\nIntroduce los valores de la matriz: "+nombre+"\n");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j]=solicitarentero(); //Introducción de valores para de la matriz utilizando dos for para recorrer cada espacio de la matriz 
            }
        }
        return matriz; //Regreso la matriz con valores 
    }
    public static void suma(int[][]A,int[][]B,int n){//Método para la suma de matrices 
        int[][] sumamatriz=new int[n][n];//Declaro una matriz que será la que obtenga las sumas de los valores de las matrices "A" y "B"
        for (int i = 0; i < sumamatriz.length; i++) {
            for (int j = 0; j < sumamatriz.length; j++) {
                sumamatriz[i][j]=A[i][j]+B[i][j];//Se utilizan dos "for" para recorrer cada espacio de la matriz, en los cuales se sumaran los valores correspondientes de las matrices "A" y "B"
                System.out.print(sumamatriz[i][j]+" "); //Se imprime en consola el valor de cada espacio resultado de las sumas más un espacio para separar los valores entre sí (Dependiendo del tamaño de "j")
            }
            System.out.println(""); //brinco de renglón para la siguiente fila de la matriz (Dependiendo de tamaño de "i")  
        }
       
    }
    public static void resta(int[][]A,int[][]B,int n){//Método para la resta de las matrices, es igual que el de la suma pero cambiando el operador 
       int[][] restamatriz=new int[n][n];
        for (int i = 0; i < restamatriz.length; i++) {
            for (int j = 0; j < restamatriz.length; j++) {
                restamatriz[i][j]=A[i][j]-B[i][j];
                System.out.print(restamatriz[i][j]+" ");
            }
            System.out.println("");
        } 
    } 
    public static void multiplicacionAxB(int[][]A,int[][]B,int n){//Método para la multiplicación de matrices AxB
        int[][]multiplicacion=new int[n][n];//Declaro la matriz multiplicación 
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[i].length; j++) {//Se utilizan dos "for" para recorrer los valores de los espacios de las matrices a multiplicar  
                for (int k = 0; k < multiplicacion[j].length; k++) {//Se usa un "for" para poder multiplicar y sumar los valores de las matrices a multiplicar
                multiplicacion[i][j]=multiplicacion[i][j]+A[i][k]*B[k][j];//Cada valor se sumará a las multiplicaciones correspondientes según el producto punto para multiplicar matrices
            }
                    System.out.print(multiplicacion[i][j]+" ");//Se imprime el valor de cada espacio de la matriz obtenida por la multiplicación con un espacio(Dependiendo del tamaño de j)
        }
            System.out.println("");//Se imprime un salto de línea (dependiendo del tamaño de i)
    }
}
    public static void multiplicacionBxA(int[][]A,int[][]B,int n){//Método de multiplicación de BxA que es igual al método anterior pero cambiando de posición a las matrices
        int[][] multiplicacion=new int[n][n];
        for (int i = 0; i < A.length; i++) {
            for(int j = 0; j<B[i].length;j++){
                for (int k = 0; k < multiplicacion[j].length; k++) {
                multiplicacion[i][j]=multiplicacion[i][j]+B[i][k]*A[k][j];
                }
             System.out.print(multiplicacion[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
