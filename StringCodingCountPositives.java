public class Test2
{

	public static void main(String[] args)
	{
		//failureReproducer();
		//failureReproducer();

		int size = 4096;
		// Note: you can specify one parameter when running this program on the command line. It specifies the length
		// of the test array. It's good to test many variations of lengths.
		if (args.length > 0)
			size = Integer.parseInt(args[0]);
		for (int i = 1; i <= size; i++)
		{
			byte[] input = new byte[i];
			for (int j = 0; j < input.length; j++)
			{
				input[j] = (byte)(j % 128);
			}
			if (callHelper2(input, 0, input.length) != oracleOfCountPositives(input, 0, input.length))
			{
				System.out.println("FAIL: input.length = " + input.length);
				break;

			}
		}
		System.out.println("Positives Tests passed");
		for (int i = 0; i <= size; i++)
		{
			byte[] input = new byte[i+1];
			for (int j = 0; j < input.length; j++)
			{
				input[j] = (byte)(j % 128);
			}
			input[i/2] = -1;
			if (callHelper2(input, 0, input.length) != oracleOfCountPositives(input, 0, input.length))
			{
				System.out.println("FAIL: input.length = " + input.length);
				break;

			}
		}
	}

	public static void failureReproducer()
	{
		byte[] input = new byte[145];
		for (int j = 0; j < input.length; j++)
		{
			input[j] = (byte)j;
		}
		int result = callHelper2(input, 0, input.length);
		int expected = oracleOfCountPositives(input, 0, input.length);
		if (result != expected)
		{
			System.out.println("FAIL: result,expected= " + result + ", " + expected);
			for (int i = 0; i < input.length; i++)
				System.out.print(input[i] + ",");
			System.out.println();
		}

	}

	public static int oracleOfCountPositives(byte[] ba, int off, int len)
	{
        	int limit = off + len;
        	for (int i = off; i < limit; i++) {
            		if (ba[i] < 0) {
                		return i - off;
            		}
        	}
        	return len;
    	}

	public static boolean callHelper(byte[] input, int off, int len)
	{
		return StringCoding.hasNegatives(input, off, len);
	}

	public static int callHelper2(byte[] input, int off, int len)
	{
		return StringCoding.countPositives(input, off, len);
	}
}

