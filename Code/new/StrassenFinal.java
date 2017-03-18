/**
* Asignatura: Diseño y Análisis de Algoritmos
* Práctica:   Presentación de Trabajo
* E-mail:     alu0100881677@ull.edu.es alu0100892833@ull.edu.es alu0100893267@ull.edu.es
* Fecha       16/3/2017
* Programa:  Este fichero contiene la definción de la clase StrassenFinal que define una estructura
* 			 de datos y una serie de métodos que nos permiten multiplicar dos matrices.
* @author Guillermo Esquivel González, Eduardo de la Paz Gonález, Óscar Darias Plasencia
* @version 1.0.0
*/
import java.io.*;

public class StrassenFinal{

	private static int npasos = 0;

	/**
    * Método de la clase que multiplica dos matrices por el método de Strassen
    * @param Matriz matriz con multiplicando
	* @param Matriz matriz con multiplicador
    * @return Matriz la función devuelve un objeto Matriz con el resultado de la multiplicación
    */
	public static Matriz StrassenMul(Matriz m1, Matriz m2, boolean print){

		int size = m1.getN();
		int tamanio = size / 2;
		Matriz resultado;

		if(tamanio == 1){
			resultado = new Matriz(size*2);
			int a = m1.get(0, 0); int b = m1.get(0, 1); int c = m1.get(1, 0); int d = m1.get(1, 1);
			int e = m2.get(0, 0); int f = m2.get(0, 1); int g = m2.get(1, 0); int h = m2.get(1, 1);
			//Creamos las 7 reglas
			int p1 = a * (f -h);
			int p2 = (a + b) * h;
			int p3 = (c + d) * e;
			int p4 = d * (g - e);
			int p5 = (a + d)*(e + h);
			int p6 = (b - d)*(g + h);
			int p7 = (a - c)*(e + f);

			resultado.set(0, 0, (p5 + p4 - p2 + p6));
			resultado.set(0, 1, (p1 + p2));
			resultado.set(1, 0, (p3 + p4));
			resultado.set(1, 1, (p1 + p5 - p3 - p7));

			npasos += 7;

			if(print)
				System.out.println("Caso base: \n" + resultado);
		
		}
		else{
			Matriz a = new Matriz((int) Math.pow(2, tamanio));
			Matriz b = new Matriz((int) Math.pow(2, tamanio));
			Matriz c = new Matriz((int) Math.pow(2, tamanio));			//4 submatrices para la matriz m1
			Matriz d = new Matriz((int) Math.pow(2, tamanio));

			Matriz e = new Matriz((int) Math.pow(2, tamanio));
			Matriz f = new Matriz((int) Math.pow(2, tamanio));
			Matriz g = new Matriz((int) Math.pow(2, tamanio));			//4 submatrices para la matriz m2
			Matriz h = new Matriz((int) Math.pow(2, tamanio));


			for(int i = 0; i < tamanio; i++){
				for(int j = 0; j < tamanio; j++){
					a.set(i, j, m1.get(i,j));
					b.set(i, j, m1.get(i,j + tamanio));					//Se rellenan las 8 submatrices a la vez
					c.set(i, j, m1.get(i + tamanio,j));
					d.set(i, j, m1.get(i + tamanio,j + tamanio));

					e.set(i, j, m2.get(i,j));
					f.set(i, j, m2.get(i,j + tamanio));
					g.set(i, j, m2.get(i + tamanio,j));
					h.set(i, j, m2.get(i + tamanio,j + tamanio));
				}
			}
			if(print){
				System.out.println("Entrada: \n");
				System.out.println("M1\n" + m1);
				System.out.println("M2\n" + m2);
				System.out.println("Divisiones: \n");
				System.out.println("A\n" + a);
				System.out.println("B\n" + b);
				System.out.println("C\n" + c);
				System.out.println("D\n" + d);

				System.out.println("E\n" + e);
				System.out.println("F\n" + f);
				System.out.println("G\n" + g);
				System.out.println("H\n" + h);
			}

			Matriz auxiliar = new Matriz();
			Matriz auxiliar2 = new Matriz();

			// P1
			auxiliar = Matriz.resta(f, h);
			Matriz p1 = new Matriz(StrassenMul(a, auxiliar, print));
			if(print)
				System.out.println("P1\n" + p1 + "\n");

			// P2
			auxiliar = Matriz.suma(a, b);
			Matriz p2 = new Matriz(StrassenMul(auxiliar, h, print));
			if(print)
				System.out.println("P2\n" + p2 + "\n");

			// P3
			auxiliar = Matriz.suma(c, d);
			Matriz p3 = new Matriz(StrassenMul(auxiliar, e, print));
			if(print)
				System.out.println("P3\n" + p3 + "\n");

			// P4
			auxiliar = Matriz.resta(g, e);
			Matriz p4 = new Matriz(StrassenMul(d, auxiliar, print));
			if(print)
				System.out.println("P4\n" + p4 + "\n");

			//P5
			auxiliar =  Matriz.suma(a, d);
			auxiliar2 = Matriz.suma(e, h);
			Matriz p5 = new Matriz(StrassenMul(auxiliar, auxiliar2, print));
			if(print)
				System.out.println("P5\n" + p5 + "\n");

			//P6
			auxiliar =  Matriz.resta(b, d);
			auxiliar2 = Matriz.suma(g, h);
			Matriz p6 = new Matriz(StrassenMul(auxiliar, auxiliar2, print));
			if(print)
				System.out.println("P6\n" + p6 + "\n");

			//P7
			auxiliar =  Matriz.resta(a, c);
			auxiliar2 = Matriz.suma(e, f);
			Matriz p7 = new Matriz(StrassenMul(auxiliar, auxiliar2, print));
			if(print)
				System.out.println("P7\n" + p7 + "\n");

			//*************************************************

			// SubMatriz11
			auxiliar = new Matriz(Matriz.suma(p5, p4));
			auxiliar2 = new Matriz(Matriz.suma(auxiliar, p6));
			Matriz subMatriz11 = new Matriz(Matriz.resta(auxiliar2, p2));
			if(print)
				System.out.println("C11\n" + subMatriz11 + "\n");

			// SubMatriz12
			Matriz subMatriz12 = new Matriz(Matriz.suma(p1, p2));
			if(print)
				System.out.println("C12\n" + subMatriz12 + "\n");

			// SubMatriz21
			Matriz subMatriz21 = new Matriz(Matriz.suma(p3, p4));
			if(print)
				System.out.println("C21\n" + subMatriz21 + "\n");

			// SubMatriz22
			auxiliar = new Matriz(Matriz.suma(p1,p5));
			auxiliar2 = new Matriz(Matriz.resta(auxiliar, p3));
			Matriz subMatriz22 = new Matriz(Matriz.resta(auxiliar2,p7));
			if(print)
				System.out.println("C22\n" + subMatriz22 + "\n");

			resultado = new Matriz(subMatriz11, subMatriz12, subMatriz21, subMatriz22);

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
