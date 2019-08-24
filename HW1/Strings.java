public class Strings
{
   public static String uniqueLetters(String str)
   {
      StringBuffer answer = new StringBuffer();
		short[] counts = new short[256];

		for (int c = 0; c < str.length(); c++)
			counts[str.charAt(c)]++;

		for (int c = 0; c < str.length(); c++)
			if (counts[str.charAt(c)] == 1)
				answer.append(str.charAt(c));

		return answer.toString();
   }
}