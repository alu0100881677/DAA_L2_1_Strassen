import java.util.ArrayList;
import java.io.*;

/**
* This is a pretty simple class that allows you to read two matrixes from textfiles and multiply them using the traditional algorithm, with O(n^3) complexity.
* As said, it is a pretty basic class, so it only works with an specific syntax on the reading textfiles.
*/
public class MatrixTraditionalProduct {

    ArrayList<ArrayList<Integer>> matrixA;
    ArrayList<ArrayList<Integer>> matrixB;

    public MatrixTraditionalProduct() {}

    /**
    * This method reads a file specified by its filename, and stores that information in an ArrayList of ArrayList of integers.
    * If matrixA is not defined, then it saves the matrix at matrixA. If it is already defined, then it stores the new one at matrixB.
    */
    public void readMatrix(String filename) {
        BufferedReader bReader = null;
        ArrayList<ArrayList<Integer>> pointer = null;
        if (matrixA == null) {
            this.matrixA = new ArrayList<ArrayList<Integer>>();
            pointer = matrixA;
        }
        else {
            this.matrixB = new ArrayList<ArrayList<Integer>>();
            pointer = matrixB;
        }
        try {
            bReader = new BufferedReader(new FileReader(filename));
            String line = bReader.readLine();
            line = bReader.readLine();
            int row = 0;
            while ((line = bReader.readLine()) != null)
            {
                ArrayList<Integer> matrixRow = new ArrayList<Integer>();
                line.trim();
                String[] splitted = line.split("\\s+");
                for (int col = 0; col < splitted.length; col++) {
                    int number = Integer.parseInt(splitted[col]);
                    matrixRow.add(number);
                }
                pointer.add(matrixRow);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
    * This method calculates the product of matrixA and matrixB, using the traditional algorithm for multiplying matrixes.
    * The result is not saved, it is just printed on screen.
    * Returns the number of operations made, so that number can be compared with the expected complexity (O(n^3)).
    */
    public int operate() {
        int value = 0;
        int cnt = 0;
        int n = this.matrixA.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    value += matrixA.get(i).get(k) * matrixB.get(k).get(j);
                    cnt++;
                }
                System.out.print(value + " ");
                value = 0;
            }
            System.out.println();
        }
        return cnt;
    }

    /**
    * Simple main program that creates an object of this class, reads two textfiles with two matrixes and calculates their product.
    * It prints on screen the number of operations made, so that number can be compared with the expected complexity (O(n^3)).
    */
    public static void main(String[] args) {
        MatrixTraditionalProduct product = new MatrixTraditionalProduct();
        product.readMatrix("matrixA.txt");
        product.readMatrix("matrixB.txt");
        int times = product.operate();
        System.out.println();
        System.out.println("Ejecución en " + times + " pasos.");
    }
}















//END
