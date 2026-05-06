package register;

import java.util.Date;

public class EmailGenerator_1 {
	public static void main(String[] args)

	{

		Date date = new Date();
		String stringDate = date.toString();

		System.out.println(stringDate);

		String noSpaceStringDate = stringDate.replaceAll("\\s", "");

		System.out.println(noSpaceStringDate);

		String noColonStringDate = noSpaceStringDate.replaceAll("\\:", "");

		System.out.println(noColonStringDate);

		String emailWithTimeStamp = "kundan"+ noColonStringDate + "@gmail.com";
		System.out.println(emailWithTimeStamp);

	}

}

