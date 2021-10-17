package incubyte;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringCalculator {

private String delimiter;
private String numbers;

private StringCalculator(String delimiter, String numbers)
{
		this.delimiter = delimiter;
		this.numbers = numbers;
}
public static int add(String numbers) 
{
		return parseInput(numbers).add();
}

private int add()
{
	noNegativeNumbers();
	return getNumbers().sum();
}

private void noNegativeNumbers() 
{
	String negative = getNumbers().filter(n -> n < 0)
			.mapToObj(Integer::toString)
			.collect(Collectors.joining(","));
	
		if (!negative.isEmpty())
		{
				throw new IllegalArgumentException("negatives not allowed " + negative);
			
		}
		}

private IntStream getNumbers()
{
		if (numbers.isEmpty())
		{
			return IntStream.empty();
		}
		else
		{
				return Stream.of(numbers.split(delimiter))
						.mapToInt(Integer::parseInt)
						.map(n -> n % 1000);
		}
		}

private static StringCalculator parseInput(String numbers)
{
			if (numbers.startsWith("//")) 
			{
				String[] str = numbers.split("\n", 2);

			String delimiter = parseDelimiter(str[0]);
			return new StringCalculator(delimiter, str[1]);
			}
			else 
			{
			return new StringCalculator(",|\n", numbers);
			}
}

private static String parseDelimiter(String s) {
		String delimiter = s.substring(2);
			if (delimiter.startsWith("["))
			{
				delimiter = delimiter.substring(1, delimiter.length() - 1);
			}
				return Stream.of(delimiter.split("]\\["))
						.map(Pattern::quote)
						.collect(Collectors.joining("|"));
		}

}

