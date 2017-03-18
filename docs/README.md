## EL ALGORITMO DE STRASSEN

Tradicionalmente, la multiplicación de matrices "a mano" se llevó siempre a cabo multiplicando y sumando los elementos de cada fila y cada columna, obteniendo el valor de aquel elemento que perteneciera a la fila y a la columna en cuestión. Así, el elemento en la posición (2, 3) de una matriz resultado, se obtenía multiplicando cada elemento de la fila 2 del multiplicando por cada elemento de la columna 3 del multiplicador, y sumándolos. Nunca hubo ningún problema con este algoritmo hasta la llegada de las ciencias de la computación, y la búsqueda por encontrar el algoritmo más rápido posible, es decir, un algoritmo de menor complejidad.

El algoritmo de multiplicación de matrices tradicional tenía una complejidad de Θ(n^3). El surgimiento de diversas técnicas de programación llevó al intento de lograr un algoritmo de una complejidad menor aplicando esas técnicas, pues el manejo de matrices es una parte fundamental de la informática. Por ejemplo, el tratamiento de imágenes, computacionalmente hablando, es el tratamiento de matrices de enormes dimensiones. 

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
		R12 = MA11 * MB12
		R21 = 
		R22 =
		R = fusion(R11, R12, R21, R22)
		return R
```





































---