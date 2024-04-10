//Angad Kahlon, Student #: 300187930, 
//COMP 359 - Design and Analysis of Algorithms - Professor: Dr. Russell Campbell

/*  Explanation:
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
 * 
 * For Data:
 * 
 * The code in the repository linked above under the folder Angad's part includes a Java implementation of this idea. 
 * For this project I chose to take data sequences from a United States website which is 
 * the National Center for Biotechnology Information part of the National Library of Medicine
 * 
 * NCBI Virus. (2024). Nih.gov. 
 * Link: https://www.ncbi.nlm.nih.gov/labs/virus/vssi/#/virus?SeqType_s=Nucleotide 
 * 
 * Through this source I was able to obtain the nucleotide sequence for COVID-19 for 2023 and for 2024. 
 * In my implementation I compare how much the sequence has changed in a year.
 * 
 * For Java Swing I used some sources from Oracle and Geeks for Geeks along with some other free sources:
 * 
 */

 //Importing relevant stuff 
 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;
 
 public class DNASimilarityGUI extends JFrame implements ActionListener {
    
    //Creating private attributes for GUI and Code
    private JTextField sequence1, sequence2;
    private JButton button1;
    private JTextArea resultArea;
    private String X = new String();
    private String Y = new String();
    private static int plus = 1;
    private static int minus = -1;
 
    //Method for GUI
    public DNASimilarityGUI() {
        //Setting properties (metadata) like title and size
        setTitle("DNA Similarity Alignment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
 
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));
        
        //Creating labels and input fields. Input fields already contain the DNA sequences 
        JLabel XLabel = new JLabel("   Enter the first DNA Sequence from 2023:");
        sequence1 = new JTextField("acttgggaaagagccacccccacattttcacctacagtgaacaatgctagggagagctgcctatatggaagagccctaatgtgtaaaattaattttagtag");
        JLabel YLabel = new JLabel("   Enter the second DNA Sequence from 2024:");
        sequence2 = new JTextField("acttggagccaccacattttttcacctacagtgaacaatgctagggagagctgcctatatggaagagccctaatgtgtaaaattaatttagta");
 
        inputPanel.add(XLabel);
        inputPanel.add(sequence1);
        inputPanel.add(YLabel);
        inputPanel.add(sequence2);
        
        //Creating a button to run code
        button1 = new JButton("Run");
        button1.addActionListener(this);
        
        //Creating area to present results
        resultArea = new JTextArea();
        resultArea.setEditable(false);
 
        //Adding in scrolling to view entire DNA Sequences
        JScrollPane scrollPane = new JScrollPane(resultArea);
 
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button1);
 
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(inputPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }
    //Method to assign score either +1, or -1 depending if nucleotide n1 aligns with nucleotide n2
    public static int assignScore(char n1, char n2) {
        if (n1 == n2) {
            return plus; 
        } else {
            return minus;
        }
    }
 
    //Method for aligning sequences and finding scores after button1 is pressed
    public void actionPerformed(ActionEvent buttonPressed) {
        //Checking if button has been pressed, and if it has setting the input values to new strings
        if (buttonPressed.getSource() == button1) {
            X = sequence1.getText();
            Y = sequence2.getText();
                     
            //initializing the matrix that will keep track of scores:
            int[][] scoreMatrix = new int[X.length() + 1][Y.length() + 1];
            for (int i=0; i<=X.length(); i++) {
                scoreMatrix[i][0] = minus*i;
            }
            for (int j = 0; j <= Y.length(); j++) {
                scoreMatrix[0][j] = minus*j;
            }
            int match;
            int delete;
            int insert;
 
            //Assigning scores, based on an addition, deletion, or match in the sequences
            for (int i=1; i<=X.length(); i++) {
                for (int j=1; j<=Y.length(); j++) {
                    match = scoreMatrix[i-1][j-1] + assignScore(X.charAt(i-1), Y.charAt(j-1));
                    delete = scoreMatrix[i-1][j] + minus;
                    insert = scoreMatrix[i][j-1] + minus;
                    scoreMatrix[i][j] = Math.max(Math.max(match, delete), insert);
                }
            }
            //Saving length of sequences in variables
            int lenx = X.length();
            int leny = Y.length();
 
            //Creating new strings for aligned sequences
            String alignedX = new String();
            String alignedY = new String();
            
            int firstChange = 0;
            int secondChange = 0;
            int matches = 0;
 
            //Going through both X and Y sequences and assigning scores
            while(lenx>0 && leny>0){
                int currentScore = scoreMatrix[lenx][leny];
                int leftScore = scoreMatrix[lenx-1][leny];
 
                //If both match
                if ((lenx > 0) && (leny > 0) && X.charAt(lenx-1) == Y.charAt(leny-1)){
                    alignedX = X.charAt(lenx-1) + alignedX;
                    alignedY = Y.charAt(leny-1) + alignedY;
                    lenx--;
                    leny--;
                    matches++;
     
                }
                //If sequence X has an addition or different nucleotide
                else if (lenx > 0 && (currentScore == leftScore + minus)){
                    alignedX = X.charAt(lenx-1) + alignedX;
                    alignedY = "-" + alignedY;
                    lenx--;
                    firstChange = firstChange + 1;
     
                }
                //If sequence Y has an addition or different nucleotide
                else {
                    alignedX = "-" + alignedX;
                    alignedY = Y.charAt(leny-1) + alignedY;
                    leny--;
                    secondChange = secondChange + 1;
                }
            }
             
             //Similarity Calculatiom

             double percent = Math.round(((double) matches / alignedX.length()) * 100.0);

            resultArea.setText("Aligned Sequences:\n\nThe '-' represent where there has been an addition or deletion in the sequence \n\n");
            resultArea.append("Aligned First DNA Sequence: " + alignedX.toString() + "\n\n");
            resultArea.append("Aligned Second DNA Sequence: " + alignedY.toString() + "\n\n");
            resultArea.append("The similarity of the sequences is approximately: " + percent + "% similar");
        }
    }
 
    //Main Method to run everything
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DNASimilarityGUI gui = new DNASimilarityGUI();
            gui.setVisible(true);
        });
    }
}
 
