import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailList {

    private TreeSet<String> emailList = new TreeSet<>();

    public void add(String email) {
        // TODO: валидный формат email добавляется
        Pattern pattern = Pattern.compile("^[a-z]+@.+\\..+$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.find()) {
            email = matcher.group();
            emailList.add(email);
            System.out.println(emailList);
        }
    }

    public List<String> getSortedEmails() {
        // TODO: возвращается список электронных адресов в алфавитном порядке
        List<String> sortedEmail = new ArrayList<>(emailList);
            return sortedEmail;
    }
}