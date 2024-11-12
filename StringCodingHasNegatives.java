import java.util.Random;

public class StringCodingHasNegatives
{

        public static void main(String[] args)
        {
                Random rand = new Random();
                byte[] input = new byte[5786];
                int i = 0;
                while(i < 4000000) {
                        rand.nextBytes(input);
                        boolean result1 = oracleOfNegatives(input, 0, 5786);
                        boolean result2 = callHelper(input, 0, 5786);
                        if (result1 != result2) {
                                System.out.println("Random. Found failing case.");
                                break;
                        }
                        i++;
                }
        }

        public static boolean oracleOfNegatives(byte[] ba, int off, int len)
        {
            for (int i = off; i < off + len; i++) {
                if (ba[i] < 0) {
                    return true;
                }
            }
            return false;
        }

        public static boolean callHelper(byte[] input, int off, int len)
        {
		// TODO: uncomment below line and make StringCoding class public to make the test work.
		// return StringCoding.hasNegatives(input, off, len);
        }
}
