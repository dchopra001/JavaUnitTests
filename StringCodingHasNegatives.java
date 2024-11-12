import java.util.Random;

public class Test
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
                                for (int j = 0; j < input.length; j++)
                                        System.out.print(" " + input[j] + ",");
                                System.out.println();
                                break;
                        }
                        i++;
                }

                for (i = 1; i < 200000; i++)
                {
                        input = new byte[i];
                        for (int j = 0; j < input.length; j++)
                        {
                                input[j] = (byte)j;
                        }
                        boolean result1 = oracleOfNegatives(input, 0, input.length);
                        boolean result2 = callHelper(input, 0, input.length);
                        if (result1 != result2) {
                                System.out.println("sequential loop. Found Failing case.");
                                for (int j = 0; j < input.length; j++)
                                        System.out.print(" " + input[j] + ",");
                                System.out.println();
                                break;
                        }
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
		// TODO: Make string coding public and uncomment below line to get the test to compile and work
                //return StringCoding.hasNegatives(input, off, len);
        }
}

