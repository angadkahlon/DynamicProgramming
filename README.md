# Group Members: 
# Angad Kahlon - 300187930
# Jasjeet Singh - 300188659

This is the last assignment/project (Assignment #3) and final for COMP 359 (Design and Analysis of Algorithms).

# Angad's Part:

A dynamic programming code implementation of measuring DNA/RNA Sequence Similarities for the final portion of the course COMP 359.

Main Idea: 

I chose to implement a topic that we learned about in COMP 359 that I found very interesting which is about how Dynamic Programming can be used to find similarities between DNA/RNA Sequences. 

Background Information:

DNA (Deoxyribonucleic acid) and RNA (Ribonucleic Acid) are an integral part of life on Earth. They are strands of genetic data that carry immense amounts of information for organisms. These strands are made up of blocks called nucleotides. There are 4 different kinds of nucleotides A (adenine), T (thymine) which is actually U (uracil) in RNA due to some differences, C (cytosine), and G (guanine). These nucleotides pair up with each other: A and T/U pair up, while C and G pair up. These pairs form DNA and RNA sequences.

Calculating the similarity between two different DNA or RNA strands has important applications in the real world, such as understanding mutations, evolutions, protein development, and numerous others.

My Work and Implementation:

The program created in this project takes two different DNA or RNA sequences, aligns them for maximum similarity of nucleotides, and returns the similarity between the strands including information about additions, deletions, or mutations between the strands.
 
Sources and Credit:

For Code Implementation: 

I would like to give credit and reference the people who explained and implemented this in Python. I took inspiration and used their implementation as a guide and resource to implement my version.

Treadway, A. (2018, November 28). How to measure DNA similarity with Python and Dynamic Programming - Open Source Automation. Open Source Automation. https://theautomatic.net/2018/11/28/how-to-measure-dna-similarity-with-python-and-dynamic-programming/ 

For Data:

The code in the repository linked above under the folder Angad's part includes a Java implementation of this idea. For this project I chose to take data sequences from a United States website which is the National Center for Biotechnology Information part of the National Library of Medicine

Link: https://www.ncbi.nlm.nih.gov/labs/virus/vssi/#/virus?SeqType_s=Nucleotide 

Through this source I was able to obtain the nucleotide sequence for COVID-19 for 2023 and for 2024. In my implementation I compare how much the sequence has changed in a year.

References:

NCBI Virus. (2024). Nih.gov. https://www.ncbi.nlm.nih.gov/labs/virus/vssi/#/virus?SeqType_s=Nucleotide
Treadway, A. (2018, November 28). How to measure DNA similarity with Python and Dynamic Programming - Open Source Automation. Open Source Automation. https://theautomatic.net/2018/11/28/how-to-measure-dna-similarity-with-python-and-dynamic-programming/ 

# Jasjeet's Part:

Implementing Dynamic coding to calculate the minimum edit distance. Also known as LeetCode Problem 72. 

Main Idea:

The main idea behind the minimum edit distance problem is to quantify the similarity between two strings by measuring the minimum number of operations required to transform one string into another. These operations typically include insertion, deletion, and substitution of individual characters.

Background: 

The problem is often framed in the context of computational linguistics and bioinformatics, where it is used for tasks such as spell checking, DNA sequencing, and natural language processing. By calculating the minimum edit distance between two strings, one can determine how similar or dissimilar they are and infer relationships or patterns between them.

Dynamic programming algorithms, such as the Wagner-Fischer algorithm or the Levenshtein distance algorithm, are commonly used to efficiently compute the minimum edit distance between strings by breaking down the problem into smaller subproblems and reusing solutions to overlapping subproblems.

