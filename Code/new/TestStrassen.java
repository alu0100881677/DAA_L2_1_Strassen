/**
* Asignatura: Diseño y Análisis de Algoritmos
* Práctica:   Presentación de Trabajo
* E-mail:     alu0100881677@ull.edu.es
* Fecha       16/3/2017
* Programa:  Este fichero contiene la definción de la clase TestStrassen donde se define el programa principal
* @author Guillermo Esquivel González, Eduardo de la Paz Gonález, Óscar Darias Plasencia
* @version 1.0.0
*/
import java.io.*;
public class TestStrassen{

    public static void main(String[] args) throws IOException, FileNotFoundException{
        Matriz a = new Matriz(args[0]);
        Matriz b = new Matriz(args[1]);
        boolean printmode = false;

        if(args[2].equals("1"))
            printmode = true;

        //Comprobamos que las matrices son multiplicables
        if(b.getN() != a.getN()){
            throw new IllegalArgumentException("Las Matrices no se pueden multiplicar");
        }
        Matriz resultado; 
        
        if(printmode){
            resultado = StrassenFinal.StrassenMul(a, b, printmode);
            System.out.println("Resultado final: \n" + resultado);
        }
        else{
            resultado = StrassenFinal.StrassenMul(a, b, printmode);
            Matriz tradicional = TradicionalMulti.Multi(a, b);
            
            System.out.println("\t\t\tStrassen\t Tradicional");
            System.out.println("Número de pasos: \t" + StrassenFinal.getnpasos() + " \t\t\t" + TradicionalMulti.getnpasos());
        }        


        String fichero = "salida.txt";
        if(args.length == 4) fichero = args[4];
        WriteResultToFich(fichero, resultado);
    }

    /**
    * Función que escribe en el fichero luna Matriz
    * @param String cadena a escribir en el fichero
    * @param Matriz matriz a escribir
    */
    public static void WriteResultToFich(String fichero, Matriz resultado)throws IOException, FileNotFoundException{
        FileWriter fw = new FileWriter(fichero,false);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(resultado.toString());
        bw.close();
    }
}
