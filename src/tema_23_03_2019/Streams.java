package tema_23_03_2019;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {
	
	public static void main(String[] args) {
		User homer = new User("Homer", true);
		User bart = new User("Bart", true);
		User maggie = new User("Maggie", false);
		User lisa = new User("Lisa", false);
		List<User> input = asList(homer, bart, maggie, lisa);
		Map<Boolean, List<User>> result = Streams.partionUsersByGender(input);
		System.out.println(Arrays.asList(result));
		
	}

	public static class NotImplementedException extends RuntimeException {
		public NotImplementedException() {
			super("This method hasn't been implemented yet!");
		}
	}

	public static List<Integer> returnSquareRoot(List<Integer> numbers) {
		return numbers.stream()
					  .mapToInt(i -> (int)Math.sqrt(i))
					  .boxed()
					  .collect(Collectors.toList());
	}

	public static List<Integer> getAgeFromUsers(List<User> user) {
		return user.stream()
				   .map(u -> u.getAge())
				   .collect(Collectors.toList());
	}

	public static List<Integer> getDistinctAges(List<User> users) {
		return users.stream()
					.map(i -> i.getAge())
					.distinct()
					.collect(Collectors.toList());
	}

	public static List<User> getLimitedUserList(List<User> users, int limit) {
		return users.stream()
					.limit(limit)
					.collect(Collectors.toList());
	}

	public static Integer countUsersOlderThen25(List<User> users) {
		return (int) users.stream()
					.mapToInt(i -> i.getAge())
					.filter(i -> i > 25)
					.count();
	}

	public static List<String> mapToUpperCase(List<String> strings) {	
		return strings.stream()
					  .map(str -> str.toUpperCase())
					  .collect(Collectors.toList());	
	}

	public static Integer sum(List<Integer> integers) {
		return integers.stream()
					   .collect(Collectors.summingInt(i -> i));
	}

	public static List<Integer> skip(List<Integer> integers, Integer toSkip) {
		return integers.stream()
					   .skip(toSkip)
					   .collect(Collectors.toList());				   
	}

	public static List<String> getFirstNames(List<String> names) {
		return names.stream()
					.map(str -> str.split(" ")[0])
					.collect(Collectors.toList());
	}

	public static List<String> getDistinctLetters(List<String> names) {
		return names.stream()
					.map(str -> str.split(""))
					.map(str -> asList(str))
					.flatMap(List -> List.stream())
					.distinct()
					.collect(Collectors.toList());
	}

	public static String separateNamesByComma(List<User> users) {
		return users.stream()
					.map(n -> n.getName())
					.collect(Collectors.joining(", "));
	}

	public static double getAverageAge(List<User> users) {
		return users.stream()
					.map(age -> age.getAge())
					.collect(Collectors.averagingDouble(age -> age));
	}

	public static Integer getMaxAge(List<User> users) {
		return users.stream()
				.mapToInt(age -> age.getAge())
				.max()
				.getAsInt();
	}

	public static Integer getMinAge(List<User> users) {
		return users.stream()
					.mapToInt(age -> age.getAge())
					.min()
					.getAsInt();
	}

	public static Map<Boolean, List<User>> partionUsersByGender(List<User> users) {
		return users.stream()
					.collect(Collectors.groupingBy(User::isMale));
	}

	public static Map<Integer, List<User>> groupByAge(List<User> users) {
		throw new NotImplementedException();
	}

	public static Map<Boolean, Map<Integer, List<User>>> groupByGenderAndAge(List<User> users) {
		throw new NotImplementedException();
	}

	public static Map<Boolean, Long> countGender(List<User> users) {
		throw new NotImplementedException();
	}

	public static boolean anyMatch(List<User> users, int age) {
		return users.stream()
					.anyMatch(u -> u.getAge().equals(age));
	}

	public static boolean noneMatch(List<User> users, int age) {
		return users.stream()
				.noneMatch(u -> u.getAge().equals(age));
	}

	public static Optional<User> findAny(List<User> users, String name) {
		return users.stream()
					.findAny()
					.filter(str -> str.getName().equals(name));
	}

	public static List<User> sortByAge(List<User> users) {
		return users.stream()
					.sorted(Comparator.comparing(User::getAge))
					.collect(Collectors.toList());
	}

	public static Stream<Integer> getBoxedStream(IntStream stream) {
		return stream.boxed();
	}

	public static List<Integer> generateFirst10PrimeNumbers() {
		throw new NotImplementedException();	
	}

	public static boolean isPrime(int number) {
		return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
	}

	public static List<Integer> generate10RandomNumbers() {
		return new Random().ints(10)
						   .boxed()
						   .collect(Collectors.toList());
	}

	public static User findOldest(List<User> users) {
		return users.stream()
					.max(Comparator.comparing(User::getAge))
					.get();
	}

	public static int sumAge(List<User> users) {
		return (int)users.stream()
				    .map(u -> u.getAge())
				    .collect(Collectors.summingInt(i -> i));	
	}

}
