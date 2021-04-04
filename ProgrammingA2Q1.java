import java.lang.Math;
import java.util.Scanner;

public class ProgrammingA2Q1 {

    public int partA (String randWord, int m){
        return partAHelper (randWord, m, randWord.length() - 1);
    }

    /*
    I technically don't need this, but I'll just leave it here for now.
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
        //System.out.println(randWord);
        if (randWord.equals("") || pos < 0) {
            return 0;
        }

        //String shorter = makeItShorter(randWord, pos);
        String shorter = randWord.substring(0, pos);
        //System.out.println("shorter: " + shorter);
        int leftXOR = partAHelper (shorter, m, pos - 1) * 33;
        char c = randWord.charAt(pos);
        int ascii = (int) c;
        int rightXOR = ascii;

        //System.out.println("Left XOR: " + String.valueOf(leftXOR));
        //System.out.println("Right XOR: " + String.valueOf(rightXOR));

        int entireXOR = leftXOR ^ rightXOR;
        int hashTableSize = (int) Math.pow(2, m);
        return entireXOR % hashTableSize;
    }

    private String[] oneLoop (int k, int m, String alphabet){
        int counter = 0;
        String res = "";
        int numOfLetters = alphabet.length();
        for (int loop1 = 0; loop1 < numOfLetters; loop1++) {
            char c = alphabet.charAt(loop1);
            String s = Character.toString(c);
            //String s = String.valueOf(c);

            if ((partA(s, m) == k) && (loop1 == numOfLetters - 1)) {
                counter++;
                res += c;
            }
            else if ( partA(s, m) == k ) {
                counter++;
                res += c + "\n";
            }
        }
        return new String[] {String.valueOf(counter), res};
    }

    private String[] twoLoops (int k, int m, String alphabet){
        int counter = 0;
        String res = "";
        int numOfLetters = alphabet.length();
        for (int loop1 = 0; loop1 < numOfLetters; loop1++) {
            for (int loop2 = 0; loop2 < numOfLetters; loop2++) {
                char c1 = alphabet.charAt(loop1);
                char c2 = alphabet.charAt(loop2);
                String s1 = Character.toString(c1);
                String s2 = Character.toString(c2);

                String s = String.valueOf(s1+s2);

                if ( (partA(s, m) == k) &&
                    (loop1 == numOfLetters - 1) &&
                    (loop2 == numOfLetters - 1) ) {
                        counter++;
                        res += s;
                }
                else if ( partA(s, m) == k ) {
                    counter++;
                    res += s + "\n";
                }
            }
        }
        return new String[] {String.valueOf(counter), res};
    }

    private String[] threeLoops (int k, int m, String alphabet){
        int counter = 0;
        String res = "";
        int numOfLetters = alphabet.length();
        for (int loop1 = 0; loop1 < numOfLetters; loop1++) {
            for (int loop2 = 0; loop2 < numOfLetters; loop2++) {
                for (int loop3 = 0; loop3 < numOfLetters; loop3++) {
                    char c1 = alphabet.charAt(loop1);
                    char c2 = alphabet.charAt(loop2);
                    char c3 = alphabet.charAt(loop3);
                    String s1 = Character.toString(c1);
                    String s2 = Character.toString(c2);
                    String s3 = Character.toString(c3);

                    String s = String.valueOf(s1+s2+s3);
                    //System.out.println(s);

                    if ( (partA(s, m) == k) &&
                        (loop1 == numOfLetters - 1) &&
                        (loop2 == numOfLetters - 1) &&
                        (loop3 == numOfLetters - 1) ) {
                            counter++;
                            res += s;
                            //System.out.println("Eq string is: " + res);
                    }
                    else if ( partA(s, m) == k ) {
                        counter++;
                        res += s + "\n";
                        //System.out.println("Eq string is: " + res);
                    }
                }
            }
        }
        return new String[] {String.valueOf(counter), res};
    }

    private String[] fourLoops (int k, int m, String alphabet){
        int counter = 0;
        String res = "";
        int numOfLetters = alphabet.length();
        for (int loop1 = 0; loop1 < numOfLetters; loop1++) {
            for (int loop2 = 0; loop2 < numOfLetters; loop2++) {
                for (int loop3 = 0; loop3 < numOfLetters; loop3++) {
                    for (int loop4 = 0; loop4 < numOfLetters; loop4++) {
                        char c1 = alphabet.charAt(loop1);
                        char c2 = alphabet.charAt(loop2);
                        char c3 = alphabet.charAt(loop3);
                        char c4 = alphabet.charAt(loop4);
                        String s1 = Character.toString(c1);
                        String s2 = Character.toString(c2);
                        String s3 = Character.toString(c3);
                        String s4 = Character.toString(c4);

                        String s = String.valueOf(s1+s2+s3+s4);

                        if ( (partA(s, m) == k) &&
                            (loop1 == numOfLetters - 1) &&
                            (loop2 == numOfLetters - 1) &&
                            (loop3 == numOfLetters - 1) &&
                            (loop4 == numOfLetters - 1) ) {
                                counter++;
                                res += s;
                        }
                        else if ( partA(s, m) == k ) {
                            counter++;
                            res += s + "\n";
                        }
                    }
                }
            }
        }
        return new String[] {String.valueOf(counter), res};
    }

    private String[] fiveLoops (int k, int m, String alphabet){
        int counter = 0;
        String res = "";
        int numOfLetters = alphabet.length();
        for (int loop1 = 0; loop1 < numOfLetters; loop1++) {
            for (int loop2 = 0; loop2 < numOfLetters; loop2++) {
                for (int loop3 = 0; loop3 < numOfLetters; loop3++) {
                    for (int loop4 = 0; loop4 < numOfLetters; loop4++) {
                        for (int loop5 = 0; loop5 < numOfLetters; loop5++) {
                            char c1 = alphabet.charAt(loop1);
                            char c2 = alphabet.charAt(loop2);
                            char c3 = alphabet.charAt(loop3);
                            char c4 = alphabet.charAt(loop4);
                            char c5 = alphabet.charAt(loop5);
                            String s1 = Character.toString(c1);
                            String s2 = Character.toString(c2);
                            String s3 = Character.toString(c3);
                            String s4 = Character.toString(c4);
                            String s5 = Character.toString(c5);

                            String s = String.valueOf(s1+s2+s3+s4+s5);

                            if ( (partA(s, m) == k) &&
                                (loop1 == numOfLetters - 1) &&
                                (loop2 == numOfLetters - 1) &&
                                (loop3 == numOfLetters - 1) &&
                                (loop4 == numOfLetters - 1) &&
                                (loop5 == numOfLetters - 1) ) {
                                    counter++;
                                    res += s;
                            }
                            else if ( partA(s, m) == k ) {
                                counter++;
                                res += s + "\n";
                            }
                        }
                    }
                }
            }
        }
        return new String[] {String.valueOf(counter), res};
    }

    public String[] partB (int n, int k, int m){
        String[] result = new String[2];
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        if (n == 1) {
            result = oneLoop(k, m, alphabet);
        }
        else if (n == 2) {
            result = twoLoops(k, m, alphabet);
        }
        else if (n == 3) {
            result = threeLoops(k, m, alphabet);
        }
        else if (n == 4) {
            result = fourLoops(k, m, alphabet);
        }
        else if (n == 5) {
            result = fiveLoops(k, m, alphabet);
        }
        return result;
    }

    public static void main(String[] args) {
        /*
        ProgrammingA2Q1 a = new ProgrammingA2Q1 ();

        String[] resultOfPartB = a.partB(3, 10, 12);
        System.out.println(resultOfPartB[0]);
        System.out.println(resultOfPartB[1]);

        String[] resultOfPartB2 = a.partB(3, 11, 12);
        System.out.println(resultOfPartB2[0]);
        System.out.println(resultOfPartB2[1]);

        String[] resultOfPartB3 = a.partB(4, 25, 10);
        System.out.println(resultOfPartB3[0]);
        System.out.println(resultOfPartB3[1]);
        */
        /*
        int test = a.partA("Abm", 10);
        int test2 = a.partA("fun", 10);
        int test3 = a.partA("hsq", 10);
        int test4 = a.partA("pcy", 10);
        int test5 = a.partA("xsa", 10);
        System.out.println("Result: " + String.valueOf(test));
        */

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
        else if (args[0].equals("b") || args[0].equals("B")) {
            ProgrammingA2Q1 a = new ProgrammingA2Q1 ();
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter the size of your word from 1 to 5, inclusively: ");
            String size = myObj.nextLine();  // Read user input
            System.out.println("Enter the hash value: ");
            String hashValue = myObj.nextLine();  // Read user input
            System.out.println("Enter the hash table size from 0 to 25, inclusively: ");
            String hashTableSize = myObj.nextLine();  // Read user input
            System.out.println();

            String[] b = a.partB(Integer.parseInt(size), Integer.parseInt(hashValue), Integer.parseInt(hashTableSize));
            System.out.println();
            System.out.println("There are " + b[0] + " words with the length " + size + ". They are below:");
            System.out.println(b[1]);
        }
    }
}
