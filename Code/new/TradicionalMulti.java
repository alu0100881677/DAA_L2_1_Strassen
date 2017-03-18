/**
* Asignatura: Diseño y Análisis de Algoritmos
* Práctica:   Presentación de Trabajo
* E-mail:     alu0100881677@ull.edu.es alu0100892833@ull.edu.es alu0100893267@ull.edu.es
* Fecha       16/3/2017
* Programa:  Este fichero contiene la definción de la clase MultiplicacionTracional que define una estructura
* 			 de datos y una serie de métodos que nos permiten multiplicar dos matrices.
* @author Guillermo Esquivel González, Eduardo de la Paz Gonález, Óscar Darias Plasencia
* @version 1.0.0
*/
import java.io.*;

public class TradicionalMulti {

	private static int npasos = 0;

	/**
    * Método de la clase que multiplica dos matrices por el método tradicional
    * @param Matriz matriz con multiplicando
	* @param Matriz matriz con multiplicador
    * @return Matriz la función devuelve un objeto Matriz con el resultado de la multiplicación
    */
	public static Matriz Multi(Matriz m1, Matriz m2){

		Matriz resultado  = new Matriz(m1.getSize());

		for(int i = 0; i < m1.getN(); i++){
			for(int k = 0; k < m1.getN(); k++){
				for(int j = 0; j < m1.getN(); j++){
					resultado.set(i, j, (m1.get(i,k)) *(m2.get(k,j)) + resultado.get(i,j));
					npasos++;
				}
			}
		}
		
		return resultado;
	}

	/**
	* Método getnpasos
	* @param npasos Número de pasos que ha llevado el algorimto
	*/
	public static int getnpasos(){
		return npasos;
	}
}
