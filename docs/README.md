## EL ALGORITMO DE STRASSEN

Tradicionalmente, la multiplicación de matrices "a mano" se llevó siempre a cabo multiplicando y sumando los elementos de cada fila y cada columna, obteniendo el valor de aquel elemento que perteneciera a la fila y a la columna en cuestión. Así, el elemento en la posición (2, 3) de una matriz resultado, se obtenía multiplicando cada elemento de la fila 2 del multiplicando por cada elemento de la columna 3 del multiplicador, y sumándolos. Nunca hubo ningún problema con este algoritmo hasta la llegada de las ciencias de la computación, y la búsqueda por encontrar el algoritmo más rápido posible, es decir, un algoritmo de menor complejidad.

El algoritmo de multiplicación de matrices tradicional tenía una complejidad de Θ($$ n^3 $$). El surgimiento de diversas técnicas de programación llevó al intento de lograr un algoritmo de una complejidad menor aplicando esas técnicas, pues el manejo de matrices es una parte fundamental de la informática. Por ejemplo, el tratamiento de imágenes, computacionalmente hablando, es el tratamiento de matrices de enormes dimensiones. 

---

### La llegada de Divide y Vencerás

En la cultura popular, divide y vencerás hace referencia a un refrán que implica resolver un problema difícil dividiéndolo en partes tan simples tantas veces como sea necesario, hasta que la solución de las partes se torna obvia. La solución del problema principal se construye a partir de las soluciones encontradas. 

Esta misma técnica trató de aplicarse al campo de los algoritmos, cobrando muchísima importancia en el mismo a mediados del siglo XX, aunque ya siglos antes se había aplicado esta técnica para resolver algunos algoritmos matemáticos "a mano". El método se basaba en la resolución recursiva de un problema dividiéndolo en dos o más subproblemas de igual tipo o similar. El proceso continúa hasta que éstos llegan a ser lo suficientemente sencillos como para que se resuelvan directamente. Al final, las soluciones a cada uno de los subproblemas se combinan para dar una solución al problema original.

Esta técnica trató de aplicarse a la multiplicación de matrices. Se dividían el multiplicando y el multiplicador en submatrices de forma sucesiva, hasta que estas fueran lo suficientemente pequeñas como para resolverse de manera sencilla. Luego, empezaban a combinarse hasta obtener el producto final. El algoritmo en cuestión es el siguiente:

```
Product(MA, MB)
	
	ad_hoc 		// Caso base cuando las matrices tienen tamaño 2 x 2
		// Las matrices se dividen en cuatro números cada una
		R11 = MA11 * MB11 + MA12 * MB21
		R12 = MA11 * MB12 + MA12 * MB22
		R21 = MA21 * MB11 + MA22 * MB21
		R22 = MA21 * MB12 + MA22 * MB22
		R = fusion(R11, R12, R21, R22)
		return R
	
	else			// Resto de casos
		// Las matrices se dividen en cuatro submatrices cada una
		A = sub(MA, 11)		E = sub(MB, 11)
		B = sub(MA, 12)		F = sub(MB, 12)
		C = sub(MA, 21)		G = sub(MB, 21)
		D = sub(MA, 22)		H = sub(MB, 22)
		// Operamos con las submatrices
		R11 = AE + BG
		R12 = AF + BH
		R21 = CE + DG
		R22 = CF + DH
		R = fusion(R11, R12, R21, R22)
		return R
```

Como vemos, este algoritmo efectivamente sigue las pautas marcadas por el paradigma de programación Divide y Vencerás. Sin embargo, no reduce la complejidad del algoritmo tradicional de multiplicación de matrices. En cada invocación recursiva, lleva a cabo ocho productos nuevos, y luego tiene que combinarlos. Esto último tiene una complejidad equivalente al número de entradas de la matriz, es decir, Θ($$ n^2 $$). Sabiendo que cada problema se divide en ocho subproblemas, y que cada subproblema reduce el tamaño de su padre a la mitad:

	T(n) = Θ(1) 						si n = 1
	T(n) = 8T(n/2) + Θ(n^2)				en el resto

Por el método maestro, podemos afirmar que la complejidad de este algoritmo es Θ($$ n^3 $$), exactamente la misma que la del algoritmo tradicional. Por tanto, pese a aplicar las pautas de Divide y Vencerás, este algoritmo recursivo no supone una mejora. Esto llevó a pensar que no era posible diseñar un algoritmo de multiplicación de matrices con una complejidad menor.

Fue Volker Strassen en 1969 quien señaló que este enfoque tradicional definitivamente no era el óptimo. Aunque solo es ligeramente más rápido que el algoritmo estándar para la multiplicación de matrices, su artículo comenzó la búsqueda de algoritmos aún más rápidos, como el complejo algoritmo de Coppersmith–Winograd de Shmuel Winograd en 2010.

¿Cómo logró Strassen hacer que la complejidad de su algoritmo fuera subcúbica? La razón principal radica en que, en cada nivel de recursividad, tan solo requiere de siete multiplicaciones. El resto de los aspectos del algoritmo tienen aproximadamente la misma complejidad, como el coste de combinar las submatrices. Más adelante, explicaremos todo esto con más detalles.

---