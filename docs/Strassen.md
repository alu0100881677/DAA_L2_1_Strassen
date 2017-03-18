## EXPLICACIÓN DEL ALGORITMO

---
```
Strassen (MA, MB)

    ad_hoc
        // Dividimos las matrices MA y MB en cuatro componentes cada una
        // Se generan los números A, B, C, D, E, F, G y H
        P1 = A * (F - H)
        P2 = (A + B) * H
        P3 = (C + D) * E
        P4 = D * (G - E)
        P5 = (A + D) * (E + H)
        P6 = (B -D) * (G + H)
        P7 = (A - C) * (E + F)

        // Creamos los cuatro elementos de la solución
        R11 = P5 + P4 - P2 + P6
        R12 = P1 + P2
        R21 = P3 + P4
        R22 = P1 + P5 - P3 - P7

        R = fusion(R11, R12, R21, R22);
        return R;

    else
        // Dividimos las matrices MA y MB en cuatro cuadrantes cada una
        // Se generan las submatrices A, B, C, D, E, F, G y H

        P1 = Strassen(A, (F - H));
        P2 = Strassen((A + B), H);
        P3 = Strassen((C + D), E);
        P4 = Strassen(D, (G - E));
        P5 = Strassen((A + D), (E + H));
        P6 = Strassen((B -D), (G + H));
        P7 = Strassen((A - C), (E + F));

        // Creamos los cuatro elementos de la solución
        R11 = P5 + P4 - P2 + P6
        R12 = P1 + P2
        R21 = P3 + P4
        R22 = P1 + P5 - P3 - P7

        R = fusion(R11, R12, R21, R22);
        return R;
    
```