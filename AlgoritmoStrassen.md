## EL ALGORITMO DE STRASSEN

### INTRODUCCIÓN

En la disciplina matemática del álgebra lineal, el algoritmo de Strassen es un algoritmo utilizado para la multiplicación de matrices. Es asintóticamente más rápido que el algoritmo tradicional para multiplicación de matrices, pero no es el más rápido conocido.

Volker Strassen fue el primero en conseguir que la complejidad de un algoritmo de multiplicación de matrices descendiera por debajo de O(n^3), y a partir de ahí se inició una "carrera" por ver quién es capaz de diseñar el algoritmo más rápido. Actualmente, el récord lo tiene Virginia Vassilevska Williams, una experta en ciencias de la computación teóricas de la Universidad de Berkeley, con un algoritmo de complejidad O(n^2.3737).

El algoritmo de Strassen se basa en el paradigma de programación Divide y Vencerás, que como ya sabemos siguen tres pasos fundamentales:

1. Dividir el problema original en subproblemas del mismo tipo pero más pequeños.
2. Resolver esos subproblemas de manera recursiva. Proporcionar la solución trivial si son lo suficientemente pequeños.
3. Combinar las soluciones de los subproblemas para obtener la solución del problema original.

Un algoritmo recursivo de multiplicación de matrices llevaría a cabo estos pasos de la siguiente manera:

1. Dividir las matrices originales en cuatro submatrices cada una, de tamaño `n/2` x `n/2`.
2. Calcular los ocho productos necesarios de forma recursiva.
3. Combinar esos ocho productos mediante las cuatro sumas necesarias.

Entonces, para cada matriz, tenemos que calcular ocho submatrices, y luego combinarlas por medio de ocho productos y cuatro sumas. El número de operaciones para combinar, entonces, es proporcional al número de entradas que tiene la matriz original, es decir, Θ(n^2), dos por cada posición de la matriz, porque hay dos productos. La fórmula de recurrencia sería:

> Mostrar la fórmula de recurrencia del primer algoritmo recursivo.

Mediante el método maestro, podemos afirmar que la complejidad de este algoritmo es Θ(n^3). Esta complejidad es la misma que la del algoritmo iterativo tradicional, y por eso se pensó que lograr una complejidad subcúbica no era posible. Strassen demostró lo contrario.

Strassen simplifica un poco las cosas. Concretamente, sigue las pautas del paradigma Divide y Vencerás de la siguiente manera:

1. Dividir las matrices originales en siete submatrices, elegidas de manera inteligente, de tamaño `n/2` x `n/2`.
2. Resolver esas siete submatrices de forma recursiva.
3. Combinar estas submatrices calculadas por medio sumas y restas, también inteligentemente escogidas.

> Mostrar y explicar aquí el procedimiento de cómo se realizan las sumas y las restas de las que estamos hablando

Entonces, sabemos que para cada par de matrices, obtendremos siempre siete submatrices. Esas submatrices tienen un tamaño exactamente igual a la mitad de las matrices originales de las que proceden.

* El tiempo invertido en dividir las matrices originales en submatrices lo consideramos constante, Θ(1).
* A eso le tenemos que sumar el tiempo necesario para calcular recursivamente el resto de matrices (7T(n/2)).
* Y el tiempo invertido en combinar las soluciones de las submatrices equivale a realizar sumas y restas (complejidad Θ(1)), para cada una de las posiciones de la matriz "grande". Puesto que esta tiene dimensiones nxn, la complejidad total para realizar las sumas y restas en todas sus posiciones es Θ(n^2).

Sabiendo todo esto, formamos la fórmula de recurrencia.

> Mostrar la fórmula de la recurrencia

Por el método maestro, obtenemos entonces que la complejidad de este algoritmo es Θ(n^log7). Esta es una complejidad subcúbica, cuyo "truco" reside en que en lugar de llevar a cabo ocho productos, realiza solo siete productos.

Puesto que no podemos demostrar ahora el método maestro, lo que vamos a hacer es analizar la complejidad del algoritmo de Strassen utilizando el árbol de recursividad.

> Mostrar diapositiva para el árbol de recursividad

> Explicar el árbol de recursividad que está 

> Realizar comparativa de los algoritmos ejecutándolos



















---
