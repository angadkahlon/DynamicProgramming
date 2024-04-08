
//Angad Kahlon, Student #: 300187930, 
//COMP 359 - Design and Analysis of Algorithms - Professor: Dr. Russell Campbell

/* Explanation:
 * This is the code implementation for the final portion of the course COMP 359 
 * (Design and Analysis of Algorithms). 
 * 
 * I chose to implement a topic that we learned about in COMP 359
 * that I found very interesting which is about how Dynamic Programming can be used
 * in find similarities between DNA Sequences. The code below is a Java implemenation
 * of this idea.
 * 
 * I would like to first give credit and reference the people who explained and 
 * implemented this in Python. I took inspiration and used their implemenation as a
 * resource to implement my version.
 * 
 * Treadway, A. (2018, November 28). 
 * How to measure DNA similarity with Python and Dynamic Programming - Open Source Automation. Open Source Automation. 
 * https://theautomatic.net/2018/11/28/how-to-measure-dna-similarity-with-python-and-dynamic-programming/
 */

import javax.swing.plaf.synth.SynthStyle;

public class DNASimilarityImplementation {

    private static String X = new String();
    private static String Y = new String();
    private static int plus = 1;
    private static int minus = -1;

    // public DNASimilarityImplementation(String x, String y){
    //     X = x;
    //     Y = y;
    // }

    public static int assignScore(char n1, char n2) {
        if (n1 == n2) {
            return plus;
        }
        else {
            return minus;
        }
    }

    public static void main(String[] args){
        //initializing the matrix that will keep track of scores:
        int[][] scoreMatrix = new int[X.length()+1][Y.length()+1];
        for (int i=0; i<=X.length(); i++){
            scoreMatrix[i][0] = minus*i;
        }
        for (int j=0; j<=Y.length(); j++){
            scoreMatrix[0][j] = minus*j;
        }
        int match;
        int delete;
        int insert;

        for(int i=1; i<(X.length()+1); i++){
            for(int j=1; j<(Y.length()+1); j++){
                match = scoreMatrix[i-1][j-1] + assignScore(X.charAt(i-1), Y.charAt(j-1));
                delete = scoreMatrix[i - 1][j] + minus;
                insert = scoreMatrix[i][j-1] + minus;
                scoreMatrix[i][j] = Math.max(Math.max(match, delete), insert);
            }
        }

        int lenx = X.length();
        int leny = Y.length();

        String alignedX = new String();
        String alignedY = new String();

        int firstChange = 0;
        int secondChange = 0;

        while(lenx>0 && leny>0){
            int currentScore = scoreMatrix[lenx][leny];
            int leftScore = scoreMatrix[lenx-1][leny];
            
            if ((lenx > 0) && (leny > 0) && X.charAt(lenx-1) == Y.charAt(leny-1)){
                alignedX = X.charAt(lenx-1) + alignedX;
                alignedY = Y.charAt(leny-1) + alignedY;
                lenx--;
                leny--;

            }
            else if (lenx > 0 && (currentScore == leftScore + minus)){
                alignedX = X.charAt(lenx-1) + alignedX;
                alignedY = "-" + alignedY;
                lenx--;
                firstChange = firstChange + 1;

            }
            else {
                alignedX = "-" + alignedX;
                alignedY = Y.charAt(leny-1) + alignedY;
                leny--;
                secondChange = secondChange + 1;
            }
        }

        //System.out.println("Score Matrix:");
        // for (int i = 0; i <= X.length(); i++) {
        //     for (int j = 0; j <= Y.length(); j++) {
        //         System.out.print(scoreMatrix[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        System.out.println("\nAligned Sequences:");
        System.out.println("Aligned X: " + alignedX);
        System.out.println("Aligned Y: " + alignedY);
        System.out.println("2023 DNA Sequence: " + firstChange);
        System.out.println("2024 DNA Sequence: " + secondChange + " additions");

    }
}


