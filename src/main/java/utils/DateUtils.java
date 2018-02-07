package utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	private static Calendar cal = Calendar.getInstance();

	public static Date getCurrentDate() {

		return cal.getTime();
	}
}
