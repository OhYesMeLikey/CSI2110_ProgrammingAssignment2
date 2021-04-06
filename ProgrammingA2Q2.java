public class ProgrammingA2Q2 {

    public int bitFolding (String paragraph){
        return bitFoldingHelper(paragraph, 0);
    }

    private int bitFoldingHelper (String paragraph, int pos){
        if (pos + 4 > paragraph.length() - 1) {
            //System.out.println("128");
            //System.out.println("The rest of the paragraph is:" + paragraph);
            return 128;
        }
        // 1. 4 individual characters from a string
        char c = paragraph.charAt(pos);
        char c1 = paragraph.charAt(pos+1);
        char c2 = paragraph.charAt(pos+2);
        char c3 = paragraph.charAt(pos+3);

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
        //System.out.println("reverseAndCombine: " + reverseAndCombine);

        //5. convert the combined string into its equivalent numeric value
        int eqIntValue = Integer.parseInt(reverseAndCombine, 2);
        //System.out.println("eqIntValue: " + String.valueOf(eqIntValue));

        String smallerParagraph = paragraph.substring(pos+4);

        // more print statements to test
        //System.out.println("current paragraph:" + paragraph);
        String current4 = Character.toString(c) + Character.toString(c1) + Character.toString(c2) + Character.toString(c3);
        //System.out.println("current 4 characters:" + current4);
        //System.out.println("smallerParagraph:" + smallerParagraph + "\n");

        return eqIntValue ^ bitFoldingHelper(smallerParagraph, pos);
    }

    public static void main(String[] args) {
        /*
        ProgrammingA2Q2 test = new ProgrammingA2Q2();
        int res = test.bitFolding("lorem ipsum dolor");
        System.out.println(res);
        int res1 = test.bitFolding("data structure is fun");
        System.out.println(res1);
        */
        ProgrammingA2Q2 q2 = new ProgrammingA2Q2();
        int result = q2.bitFolding(args[0]);
        System.out.println("The result is: ");
        System.out.println(result);
    }
}
