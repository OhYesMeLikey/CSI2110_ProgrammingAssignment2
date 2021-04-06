public class Test {
    /*
    Things I need:
    1. 4 individual characters from a string
    2. obtain the equivalent byte (i.e. 8 bits) for each of the characters
    3. convert each equivalent byte to its string representation
    4. combine each of the equivalent string representation in reverse order
    5. convert the combined string into its equivalent numeric value
    */
    public static void main(String[] args) {
        // 1. 4 individual characters from a string
		char c = 'd';
		char c1 = 'a';
		char c2 = 't';
		char c3 = 'a';

        // 2. obtain the equivalent byte (i.e. 8 bits) for each of the characters'
        byte b = (byte) c;
        byte b1= (byte) c1;
        byte b2 = (byte) c2;
        byte b3 = (byte) c3;

        //3. convert each equivalent byte to its string representation
        String s = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
        String s1 = String.format("%8s", Integer.toBinaryString(b1 & 0xFF)).replace(' ', '0');
        String s2 = String.format("%8s", Integer.toBinaryString(b2 & 0xFF)).replace(' ', '0');
        String s3 = String.format("%8s", Integer.toBinaryString(b3 & 0xFF)).replace(' ', '0');

        //4. combine each of the equivalent string representation in reverse order
        String reverseAndCombine = s3 + s2 + s1 + s;

        //5. convert the combined string into its equivalent numeric value
        int eqIntValue = Integer.parseInt(reverseAndCombine, 2);

        ////////////////////////////////////////////////////////////////////////////////////////////
        // 1. 4 individual characters from a string
        char testChar = 'l';
        char testChar1 = 'o';
        char testChar2 = 'r';
        char testChar3 = 'e';
        //2. obtain the equivalent byte (i.e. 8 bits) for each of the characters
        byte bTest = (byte) testChar;
        byte bTest1 = (byte) testChar1;
        byte bTest2 = (byte) testChar2;
        byte bTest3 = (byte) testChar3;
        //3. convert each equivalent byte to its string representation
        String sTest = String.format("%8s", Integer.toBinaryString(bTest & 0xFF)).replace(' ', '0');
        String sTest1 = String.format("%8s", Integer.toBinaryString(bTest1 & 0xFF)).replace(' ', '0');
        String sTest2 = String.format("%8s", Integer.toBinaryString(bTest2 & 0xFF)).replace(' ', '0');
        String sTest3 = String.format("%8s", Integer.toBinaryString(bTest3 & 0xFF)).replace(' ', '0');
        System.out.println(" sTest = l: " + sTest);
        System.out.println("sTest1 = o: " + sTest1);
        System.out.println("sTest2 = r: " + sTest2);
        System.out.println("sTest3 = e: " + sTest3);
        //4. combine each of the equivalent string representation in reverse order
        String combinedTestString = sTest3 + sTest2 + sTest1 + sTest;
        String givenString = "01100101011100100110111101101100";
        System.out.println("combinedTestString: " + combinedTestString);
        System.out.println("Are they equal strings: " + combinedTestString.matches(givenString));
        //5. convert the combined string into its equivalent numeric value
        int eqIntCombinedTestString = Integer.parseInt(combinedTestString, 2);
        System.out.println("eqCombinedTestString: " + eqIntCombinedTestString);
        int givenIntValue = 1701998444;
        System.out.println("Are they equal decimals: " + (givenIntValue == eqIntCombinedTestString));
        ////////////////////////////////////////////////////////////////////////////////////////////

    }
}
