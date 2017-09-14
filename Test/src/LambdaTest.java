import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaTest {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		
		Collections.sort(names, (a, b) -> -1*a.compareTo(b));
		System.out.println(names);
		System.out.println(Collections.binarySearch(names, "mike",(a, b) -> a.compareTo(b)));
		
//		Converter<String, Integer> converter = (from)->Integer.valueOf(from);
		Converter<String, Integer> converter =  Integer::valueOf;
		Integer ij = converter.convert("1234");
		System.out.println(ij);
	}
	
	@FunctionalInterface
	interface Converter<F, T> {
	    T convert(F from);
	}

	
	
}
