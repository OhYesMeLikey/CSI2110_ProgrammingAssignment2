public class ProgrammingA2Q2 {

    /*
    This method returns the decimal value of given string paragraph by calling the helper method bitFoldingHelper to do the recursive calls.
    */
    public int bitFolding (String paragraph){
        return bitFoldingHelper(paragraph, 0);
    }

    /*
    This is a helper method for the method bitFolding. This returns the decimal value of the given string paragraph, where you have to bit fold every 4 letters in the string. If you can't bit fold last 4 letters, then you have to use 10000000 as the second 8 bits in a 32 bit number, and you have to append the leading zeros 00000000 as many times as needed to make a 32 bit value.

    Things I need:
    1. 4 individual characters from a string
    2. obtain the equivalent byte (i.e. 8 bits) for each of the characters
    3. convert each equivalent byte to its string representation
    4. combine each of the equivalent string representation in reverse order
    5. convert the combined string into its equivalent numeric value
    */
    private int bitFoldingHelper (String paragraph, int pos){
        char c;
        char c1;
        char c2;
        char c3;

        byte b;
        byte b1;
        byte b2;
        byte b3;

        String s;
        String s1;
        String s2;
        String s3;

        String reverseAndCombine = "";

        int eqIntValue;

        if (pos + 4 > paragraph.length() - 1) {
            String eightZeros = "00000000";
            String sevenZeros = "10000000";

            if (paragraph.length() == 3) {
                c = paragraph.charAt(pos);
                c1 = paragraph.charAt(pos+1);
                c2 = paragraph.charAt(pos+2);

                b = (byte) c;
                b1 = (byte) c1;
                b2 = (byte) c2;

                s = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
                s1 = String.format("%8s", Integer.toBinaryString(b1 & 0xFF)).replace(' ', '0');
                s2 = String.format("%8s", Integer.toBinaryString(b2 & 0xFF)).replace(' ', '0');

                reverseAndCombine = sevenZeros + s2 + s1 + s;
            }
            else if (paragraph.length() == 2) {
                c = paragraph.charAt(pos);
                c1 = paragraph.charAt(pos+1);

                b = (byte) c;
                b1 = (byte) c1;

                s = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
                s1 = String.format("%8s", Integer.toBinaryString(b1 & 0xFF)).replace(' ', '0');

                reverseAndCombine = eightZeros + sevenZeros + s1 + s;
            }
            else if (paragraph.length() == 1) {
                c = paragraph.charAt(pos);

                b = (byte) c;

                s = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');

                reverseAndCombine = eightZeros + eightZeros + sevenZeros + s;
            }
            eqIntValue = Integer.parseInt(reverseAndCombine, 2);
            //System.out.println("eqIntValue: " + String.valueOf(eqIntValue));
            return eqIntValue;
        }
        else {
            // 1. 4 individual characters from a string
            c = paragraph.charAt(pos);
            c1 = paragraph.charAt(pos+1);
            c2 = paragraph.charAt(pos+2);
            c3 = paragraph.charAt(pos+3);

            // 2. obtain the equivalent byte (i.e. 8 bits) for each of the characters'
            b = (byte) c;
            b1 = (byte) c1;
            b2 = (byte) c2;
            b3 = (byte) c3;

            //3. convert each equivalent byte to its string representation
            /*
            The string.format method is SUPER IMPORTANT because it includes the zeros that are technically in front of the 8 bit binary value. E.g. If c = 'd', then it's equivalent binary value is 01100100, so b should be 01100100. However, when you convert a character to a byte in Java, it doesn't include that first zero. b will actually show up as 1100100 instead. Therefore, you have to include all preceding zeros, so no data is lost.
            */
            s = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
            s1 = String.format("%8s", Integer.toBinaryString(b1 & 0xFF)).replace(' ', '0');
            s2 = String.format("%8s", Integer.toBinaryString(b2 & 0xFF)).replace(' ', '0');
            s3 = String.format("%8s", Integer.toBinaryString(b3 & 0xFF)).replace(' ', '0');

            //4. combine each of the equivalent string representation in reverse order
            reverseAndCombine = s3 + s2 + s1 + s;
            //System.out.println("reverseAndCombine: " + reverseAndCombine);

            //5. convert the combined string into its equivalent numeric value
            eqIntValue = Integer.parseInt(reverseAndCombine, 2);
            //System.out.println("eqIntValue: " + String.valueOf(eqIntValue));

            String smallerParagraph = paragraph.substring(pos+4);

            /*
            // more print statements to test
            System.out.println("current paragraph:" + paragraph);
            String current4 = Character.toString(c) + Character.toString(c1) + Character.toString(c2) + Character.toString(c3);
            System.out.println("current 4 characters:" + current4);
            System.out.println("smallerParagraph:" + smallerParagraph + "\n");
            */

            return eqIntValue ^ bitFoldingHelper(smallerParagraph, pos);
        }

    }

    public static void main(String[] args) {

        /*
        ProgrammingA2Q2 test = new ProgrammingA2Q2();
        //int res = test.bitFolding("lorem ipsum dolor");
        //System.out.println(res);
        int res1 = test.bitFolding("data structure is fun");
        System.out.println("The result is: " + String.valueOf(res1));
        */

        ProgrammingA2Q2 q2 = new ProgrammingA2Q2();
        int result = q2.bitFolding(args[0]);
        System.out.println("The result is: ");
        System.out.println(result);

    }
}
