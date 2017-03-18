/**
* Asignatura: Diseño y Análisis de Algoritmos
* Práctica:   Presentación de Trabajo
* E-mail:     alu0100881677@ull.edu.es alu0100892833@ull.edu.es alu0100893267@ull.edu.es
* Fecha       16/3/2017
* Programa:  Este fichero contiene la definción de la clase Matriz que define una estructura
* 			 de datos que almacena matrices, la clase ha sido creada especialmente para matrices
*		     con las que trabaja el algoritmo Strassen, por lo que tiene ciertas restricciones en cuanto
* 			 a dimensiones y demás.
* @author Guillermo Esquivel González, Eduardo de la Paz Gonález, Óscar Darias Plasencia
* @version 1.0.0
*/
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.lang.*;
import java.io.FileNotFoundException;

public class Matriz {
	//Atributos privados de la clase
	private ArrayList<Integer> matriz ;
	private int m = 0;
	private int n = 0;

	/**
    * Constructor de un objeto de tipo Matriz
    * @param String String con el fichero que contiene la definción de la matriz
	* @throws FileNotFoundException
	* @throws IOException
    */
	public Matriz(String filename) throws FileNotFoundException, IOException{

		String linea;
		FileReader fich = new FileReader(filename);
		BufferedReader bf = new BufferedReader(fich);
		matriz = new ArrayList<Integer>();
		this.m = Integer.parseInt(linea = bf.readLine());
		this.n = Integer.parseInt(linea = bf.readLine());

		//las matriz es cuadrada y de dimensión par
		if((m != n) && (m % 2 == 1)){
			throw new IllegalArgumentException("Las Matrices no pueden ser multiplicadas por Strassen");
		}

		while((linea = bf.readLine())!=null) {
			if(!linea.trim().equals("")){
				String valores [] = linea.split("\\s+");
				for(int j = 0; j < this.n; j++){
					matriz.add(Integer.parseInt(valores[j]));
				}
			}
		}
		if (null != fich){
    		bf.close();
		}
	}

	/**
    * Constructor de un objeto de tipo Matriz
    * @param ArrayList<Integer> array con todos los elementos de la matriz
    */
	public Matriz(ArrayList<Integer> array){

		matriz = new ArrayList<Integer>();
		for(int i = 0; i < array.size(); i++){
			matriz.add(array.get(i));
		}

		double a = Math.log(array.size()) / Math.log(2);
		this.setM((int) a);
		this.setN((int) a);

	}
	/**
    * Constructor copia de un objeto de tipo Matriz
    * @param Matriz matriz que será copiada
    */
	public Matriz(Matriz auxiliar){
		this.m = auxiliar.getM();
		this.n = auxiliar.getN();

		matriz = new ArrayList(auxiliar.getSize());

		for(int i = 0; i < auxiliar.getSize(); i++){
			matriz.add(auxiliar.getValor(i));
		}

	}
	/**
	* Constructor por defecto de la clase
	*/

	public Matriz(){
		matriz = new ArrayList<Integer>();
	}

	/**
    * Constructor de un objeto de tipo Matriz
    * @param Matriz SubMatriz11
	* @param Matriz SubMatriz12
	* @param Matriz SubMatriz21
	* @param Matriz SubMatriz22
    */
	public Matriz(Matriz sub11, Matriz sub12, Matriz sub21, Matriz sub22){
		matriz = new ArrayList<Integer>();
		this.setM(sub11.getN()*2);
		this.setN(sub11.getN()*2);
		for(int mm = 0; mm < sub11.getM() * 2 ; mm++){
			for(int nn = 0; nn < sub11.getN() * 2; nn++){

				//está en el primer cuadrante
				if((mm < sub11.getM()) && (nn < sub11.getN())){
					matriz.add(sub11.get(mm, nn));
				}
				//está en el segundo cuadrante
				else if((mm < sub12.getM()) && (nn >= sub12.getN())){
					matriz.add(sub12.get(mm, nn - sub12.getN()));
				}
				//está en el tercer cuadrante
				else if((mm >= sub21.getM()) && (nn < sub21.getN())){
					matriz.add(sub21.get(mm - sub21.getM(), nn));
				}
				//está en el cuarto cuadrante
				else if((mm >= sub22.getM()) && (nn >= sub22.getN())){
					matriz.add(sub22.get(mm - sub22.getM(), nn - sub22.getN()));
				}
			}
		}
	}

	/**
    * Constructor de un objeto de tipo Matriz con todos sus elementos a cero
    * @param int tamaño del vector que almacena la matriz
    */
	public Matriz(int size){

		double a = Math.log(size) / Math.log(2);
		this.setM((int) a);
		this.setN((int) a);

		matriz = new ArrayList(size);
		for(int i = 0; i < size; i++){
			matriz.add(0);
		}
	}

	/**
    * Getter del ArrayList que almacena la matriz
    * @return ArrayList<Integer>
    */
	public ArrayList<Integer> getMatriz(){
		return matriz;
	}

	/**
    * Setter del ArrayList que almacena la matriz
    * @param ArrayList<Integer>
    */
	public void setMatriz(ArrayList<Integer> matriz){
		this.matriz = matriz;
	}

	/**
    * Getter del numero de filas de la matriz
    * @return int
    */
	public int getM(){
		return this.m;
	}

	/**
    * Getter del numero de columnas que tiene la matriz
    * @return int
    */
	public int getN(){
		return this.n;
	}

	/**
    * Setter del número de filas la matriz
    * @param int
    */
	public void setM(int m){
		this.m = m;
	}

	/**
	* Setter del número de columnas la matriz
	* @param int
	*/
	public void setN(int n){
		this.n = n;
	}

	/**
	* Getter del numero de elementos de la matriz
	* @return int
	*/
	public int getSize(){
		return matriz.size();
	}

	/**
    * Getter de la posición dentro del vector de un posición i,j virtual
	* @param int i posición de la fila
	* @param int j posición de la columna
    * @return int
    */
	public int getPos(int i, int j){
		return(i*this.n + j);
	}

	/**
    * Getter del valor de un elemento de la matriz
	* @param int indez indice dentro del vector del valor que queremos coger
    * @return int
    */
	public int getValor(int index){
		return(matriz.get(index));
	}

	/**
    * Getter del valor de un elemento i,j virtual
	* @param int i posición de la fila
	* @param int j posición de la columna
    * @return int
    */
	public int get(int i, int j){
		return(matriz.get(getPos(i, j)));
	}

	/**
	* Setter del valor de un elemento i,j virtual
	* @param int i posición de la fila
	* @param int j posición de la columna
	* @param int valor
	*/
	public void set(int i, int j, int valor){
		matriz.set(getPos(i, j), valor);
	}

	/**
    * Formateo de la salida por pantalla de un instancia de la clase
    * @return String salida por pantalla
    */
	public String toString(){
		String salida = "";
		salida = salida + this.getM() + " x " + this.getN() + "\n";

		for(int i = 0; i < this.getM(); i++){
			for(int j = 0; j < this.getN(); j++){
				salida = salida + matriz.get(getPos(i, j)) + " ";
			}
			salida += "\n";
		}
		return salida;

	}

	/**
    * Método de clase que se encarga de sumar dos matrices y devolver la matriz resultante
	* @param Matriz matriz para sumar
	* @param Matriz matriz para sumar
    * @return Matriz con el resultado
    */
	public static Matriz suma(Matriz a, Matriz b){
		ArrayList<Integer> auxiliar = new ArrayList<Integer>();
		for(int i = 0; i < a.getM(); i++){
			for(int j = 0; j < a.getN(); j++){
				auxiliar.add(a.get(i, j) + b.get(i,j));
			}
		}

		Matriz c = new Matriz(auxiliar);
		return c;
	}

	/**
    * Método de clase que se encarga de restar dos matrices y devolver la matriz resultante
	* @param Matriz matriz a la que se le resta
	* @param Matriz matriz para restar
    * @return Matriz con el resultado
    */
	public static Matriz resta(Matriz a, Matriz b){
		ArrayList<Integer> auxiliar = new ArrayList<Integer>();
		for(int i = 0; i < a.getM(); i++){
			for(int j = 0; j < a.getN(); j++){
				auxiliar.add(a.get(i, j) - b.get(i,j));
			}
		}
		Matriz c = new Matriz(auxiliar);
		return c;
	}
}
