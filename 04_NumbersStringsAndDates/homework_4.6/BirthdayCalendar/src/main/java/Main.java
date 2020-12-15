import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int day = 16;
        int month = 05;
        int year = 1984;

        System.out.println(collectBirthdays(year, month, day));
    }

    public static String collectBirthdays(int year, int month, int day) {
        // Вариант 1:
        Calendar calendarBirth = new GregorianCalendar(year, month - 1, day);
        SimpleDateFormat df = new SimpleDateFormat(" - dd.MM.yyyy - E", Locale.ENGLISH);
        Calendar calendarNow = Calendar.getInstance();
        int number = 0;
        while (calendarNow.after(calendarBirth)) {
            System.out.println(number + df.format(calendarBirth.getTime()));
            calendarBirth.add(Calendar.YEAR, +1);
            number++;
        }
        return "";

        // Вариант 2:
//        int number  = 0;
//        StringBuilder builder = new StringBuilder();
//        DateFormat dateFormat = new SimpleDateFormat( " - dd.MM.yyyy - E", Locale.ENGLISH);
//        Calendar calendar = new GregorianCalendar(year, month - 1, day);
//        while (calendar.getTime().before(new Date())){
//            builder.append(number).append(dateFormat.format(calendar.getTime())).append("\n");
//            calendar.add(Calendar.YEAR, 1);
//            number++;
//        }
//        return builder.toString();
    }
}