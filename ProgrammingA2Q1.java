import java.lang.Math;
import java.util.Scanner;

public class ProgrammingA2Q1 {

    public int partA (String randWord, int m){
        return partAHelper (randWord, m, randWord.length() - 1);
    }

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
        if (randWord.equals("") || pos <= 0) {
            return 0;
        }

        String shorter = makeItShorter(randWord, pos);
        int leftXOR = partAHelper (shorter, m, pos - 1) * 33;
        char c = randWord.charAt(pos);
        int ascii = (int) c;
        int rightXOR = ascii;
        int entireXOR = leftXOR ^ rightXOR;
        int hashTableSize = (int) Math.pow(2, m);
        return entireXOR % hashTableSize;
    }


    public static void main(String[] args) {
        if (args[0].equals("a") || args[0].equals("A")) {
            ProgrammingA2Q1 a = new ProgrammingA2Q1 ();

            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter hash table size: ");
            String size = myObj.nextLine();  // Read user input
            System.out.println("Enter word to hash: ");
            String word = myObj.nextLine();  // Read user input
            System.out.println( "This is your hashed result: " +
            String.valueOf( a.partA(word, Integer.parseInt(size)) ) );
        }
    }
}
