import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

public class Person {
	//list contains name, day of week birthday falls upon and turning age of each person
	private List<String> personalInfo = new ArrayList<String>();
	//calendar holds year, month and day of person
	private Calendar calendar;

	//constructor accepts name, year, month, and day of birth as arguments
	//throws an exception if any integer parameter is negative or 0
	public Person(String name, int year, int month, int day){
		if (year <= 0 || month <=0 || day <=0)
			throw new IllegalArgumentException("n must be positive");
		//adjust month due to GregorianCalendar 0 based month system
		int adjustedMonth = --month;
		calendar = new GregorianCalendar(year, adjustedMonth, day);
		//add name to list
		personalInfo.add(name);
		//add day of week to list
		personalInfo.add(calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.getDefault()));
		//add age to list
		personalInfo.add(Integer.toString(Calendar.getInstance()
					.get(Calendar.YEAR)-calendar.get(Calendar.YEAR)));
	}

	//name field getter method
	//does not accept any parameters
	//does return a list of personally identifiable information
	//does not throw any exceptions
	public List<String> getName(){
		return personalInfo;
	}

	//calendar field getter method
	//does not accept any parameters
	//does return a calendar of birth date of person
	//does not throw any exceptions
	public Calendar getCalendar(){
		return calendar;
	}
}
