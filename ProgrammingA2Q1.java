import java.lang.Math;
import java.util.Scanner;

public class ProgrammingA2Q1 {

    /*
    Create a recursive hash function where input is words and output is numerical values. The hash table size is 2M. The function is defined recursively as follows:
        (i) fn(“”) = 0 where “” = empty word
        (ii) fn(previousWord + letter) =((fn(previousWord) x 33) XOR ASCII(letter)) mod 2M where XOR is for the bitwise operator. 0110 XOR 1010 = 1100 and ASCII(letter) is for ASCII code. e.g. ASCII(“A”) = 65, ASCII(“b”) = 98, ASCII(“m”) = 109

    As an example for M = 10, we can find the value of “Abm” recursively as follows:
        ○ fn(“”) = 0
        ○ fn(“A”) = fn(“”) x 33 XOR ASCII(“A”) mod 2M = 0 XOR 65 mod 210 = 0000000 XOR 01000001 mod 210 = 65
        ○ fn(“Ab”) = fn(“A”) x 33 XOR ASCII(“b”) mod 2M = 65 x 33 XOR 98 mod 210 = 2145 XOR 98 mod 210 = 3
        ○ fn(“Abm”) = fn(“Ab”) x 33 XOR ASCII(“m”) mod 2M = 3 x 33 XOR 109 mod 210 = 99 XOR 109 mod 210 = 14 mod 1024 = 14
    */
    public int partA (String randWord, int m){
        return partAHelper (randWord, m, randWord.length() - 1);
    }

    /*
    This method takes in a string and a pos and returns a shorter version of the given string by cutting off the last character of the given string. 
    */
    private String makeItShorter (String s, int pos){
        String newString = "";
        for (int i = 0; i < pos; i++) {
            newString += s.charAt(i);
        }
        return newString;
    }

    /*
    Things I want if I want recurse back:
    1. 2^m
    2. remainder operator
    3. xor expression
        3.1. left side XOR expression
            3.1.1. shortened string expression that consists of original string from beginning all the way to right most selected character of the original string (e.g. "Ab" is the shortened string expression and "m" is the right most selected character. The original string expression is "Abm")
            3.1.2. a method to obtain the shortened string expression
        3.2 right side XOR expression
            3.2.1. right most selected character of the original string (e.g. "m" is the right most selected character. The original string expression is "Abm")
    */
    private int partAHelper (String randWord, int m, int pos){
        System.out.println(randWord);
        if (randWord.equals("") || pos < 0) {
            return 0;
        }

        String shorter = makeItShorter(randWord, pos);
        int leftXOR = partAHelper (shorter, m, pos - 1) * 33;
        char c = randWord.charAt(pos);
        int ascii = (int) c;
        int rightXOR = ascii;

        System.out.println("Left XOR: " + String.valueOf(leftXOR));
        System.out.println("Right XOR: " + String.valueOf(rightXOR));

        int entireXOR = leftXOR ^ rightXOR;
        int hashTableSize = (int) Math.pow(2, m);
        return entireXOR % hashTableSize;
    }


    public static void main(String[] args) {
        ProgrammingA2Q1 a = new ProgrammingA2Q1 ();
        int test = a.partA("Abm", 10);
        int test2 = a.partA("fun", 10);
        System.out.println("Result: " + String.valueOf(test2));

        /*
        if (args[0].equals("a") || args[0].equals("A")) {
            ProgrammingA2Q1 a = new ProgrammingA2Q1 ();

            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter hash table size: ");
            String size = myObj.nextLine();  // Read user input
            System.out.println("Enter word to hash: ");
            String word = myObj.nextLine();  // Read user input
            System.out.println();
            int res = a.partA(word, Integer.parseInt(size));
            System.out.println();
            System.out.println( "\nThis is your hashed result: " + String.valueOf(res) );

        }
        */
    }
}
