
import java.util.*;

public class Encoding
{
   public static Set<String> morseCodes(int numDots, int numDashes){
		if (numDots == 1 && numDashes == 1){
			Set<String> combinations = new HashSet<>();
			combinations.add(".-");
			combinations.add("-.");
			return combinations;
		}
		else{
			if (numDots == 1 && numDashes > 1)
				return getCombinations('-', morseCodes(numDots, --numDashes));
		
			return getCombinations('.', morseCodes(--numDots, numDashes));
		}
	}
   public static Set<String> getCombinations(char c, Set<String> combinations){
		Set<String> newCombinations = new HashSet<>();

		for (String str: combinations){
			//for each string in the old combinations
			newCombinations.add(c+str);
			for (int pos = 1; pos < str.length(); pos++){
				//traverse the string and make a new string by adding the character to all the possible positions
				StringBuffer buf = new StringBuffer();
				buf.append(str.substring(0, pos));
				buf.append(c);
				buf.append(str.substring(pos));

				newCombinations.add(buf.toString());
			}
		}

		return newCombinations;
	}
}