//Application Specifications:
//Assuming access to a collection of people and their birthdates,
//write a method that returns a list of people with birthdays in the current calendar week.
//Include person name, day in the week their birthday falls upon, and the age they’re turning.
//Disclaimer: Where noted, "personal information" is analogous to (name, day of week, and turning age) of each person.
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class People {
	//hash map stores list holding personal information as keys mapped to calendar dates as values
	private static Map<List, Calendar> peopleMap = new HashMap<List, Calendar>();
	//current week of year stored as a private variable for easier readability and reuse
	private static int currentWeekOfYear = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);

	public static void main(String[] args) {
		//calWeekMap hash map stores specific key=>value pairs of personal information=>birthdays
		//occurring during current calendar week
		Map<List, Calendar> calWeekMap = new HashMap<List, Calendar>();
		buildMap();
		calWeekMap = filterBirthdays();
		//print name, day of week and turning age of each individual to console
		System.out.println(calWeekMap.keySet());
	}

	//build hash map of an arbitrary amount of people
	//does not accept any parameters
	//does not return anything
	//does not throw any exceptions
	public static void buildMap(){
		Person megan = new Person("Megan Pena", 1989, 4, 5);
		Person marie = new Person("Marie Daniels", 1962, 8, 2);
		Person stephanie = new Person ("Stephanie Thomas", 1956, 3, 11);
		Person ernesto = new Person ("Ernesto Mitchell", 1987, 3, 30);
		Person vera = new Person ("Vera Hamilton", 1979, 9, 8);
		Person jane = new Person ("Jane Quinn", 1971, 6, 20);
		Person luke = new Person ("Luke Wilkins", 1968, 12, 26);
		Person andrea = new Person ("Andrea Hall", 1985, 9, 19);
		Person vivian = new Person ("Vivian Francis", 1993, 8, 16);
		Person yvette = new Person ("Yvette Cobb", 1991, 3, 6);
		Person tami = new Person("Tami Bishop", 1989, 4, 5);
		Person armando = new Person("Armando Wilkerson", 1972, 10, 25);
		Person isabel = new Person ("Isabel Perkins", 1985, 3, 11);
		Person cedric = new Person ("Cedric Freeman", 1991, 3, 30);
		Person carmen = new Person ("Carmen Hardy", 1979, 9, 8);
		Person ricardo = new Person ("Ricardo Powers", 1988, 6, 20);
		Person tara = new Person ("Tara Washington", 1951, 5, 26);
		Person clayton = new Person ("Clayton Cox", 1994, 2, 19);
		Person hubert = new Person ("Hubert Curry", 2003, 11, 16);
		Person diane = new Person ("Diane Carroll", 1944, 3, 6);
		peopleMap.put(megan.getName(), megan.getCalendar());
		peopleMap.put(marie.getName(), marie.getCalendar());
		peopleMap.put(stephanie.getName(), stephanie.getCalendar());
		peopleMap.put(ernesto.getName(), ernesto.getCalendar());
		peopleMap.put(vera.getName(), vera.getCalendar());
		peopleMap.put(jane.getName(), jane.getCalendar());
		peopleMap.put(luke.getName(), luke.getCalendar());
		peopleMap.put(andrea.getName(), andrea.getCalendar());
		peopleMap.put(vivian.getName(), vivian.getCalendar());
		peopleMap.put(yvette.getName(),  yvette.getCalendar());
		peopleMap.put(tami.getName(), tami.getCalendar());
		peopleMap.put(armando.getName(), armando.getCalendar());
		peopleMap.put(isabel.getName(), isabel.getCalendar());
		peopleMap.put(cedric.getName(), cedric.getCalendar());
		peopleMap.put(carmen.getName(), carmen.getCalendar());
		peopleMap.put(ricardo.getName(), ricardo.getCalendar());
		peopleMap.put(tara.getName(), tara.getCalendar());
		peopleMap.put(clayton.getName(), clayton.getCalendar());
		peopleMap.put(hubert.getName(), hubert.getCalendar());
		peopleMap.put(diane.getName(),  diane.getCalendar());
	}

	//filter peopleMap hash map to certain people with birthdays which occur on current calendar week
	//does not accept any parameters
	//does return hash map of filtered person objects
	//does not throw any exceptions
	public static Map<List, Calendar> filterBirthdays()
	{
		return peopleMap
			.entrySet()
			.stream()
			.filter(p -> p.getValue()
			.get(Calendar.WEEK_OF_YEAR) == currentWeekOfYear)
			.collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
	}
}
