import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {

    private HashMap<String, String> phoneBook = new HashMap<>();

    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента
        Pattern correctPhone = Pattern.compile("^[0-9]+$");
        Matcher searchPhone = correctPhone.matcher(phone);
        if (searchPhone.find()) {
            phone = searchPhone.group();
            phoneBook.put(phone, name);
        } else {
            Pattern correctName = Pattern.compile("^[a-zA-Z]+$");
            Matcher searchName = correctName.matcher(name);
            if (searchName.find()) {
                name = searchName.group();
                phoneBook.put(phone, name);
            }
        }
    }

    public String getNameByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        StringBuilder nameByPhone = new StringBuilder();
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            if (entry.getKey().equals(phone)) {
                nameByPhone.append(entry.getValue() + " - " + phone);
            }
        }
        return String.valueOf(nameByPhone);
    }

    public Set<String> getPhonesByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        Set<String> phonesByName = new TreeSet<>();
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            if (entry.getValue().equals(name)) {
            phonesByName.add(name + " - " + entry.getKey());
            }
        }
        return phonesByName;
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        Set<String> allContacts = new TreeSet<>();
        for (Map.Entry<String, String> all : phoneBook.entrySet()) {
            if (all.getValue().isEmpty())
                return Collections.emptySet();
            if (all.getValue().matches("\\d+"))
                return Collections.emptySet();
            allContacts.add(all.getValue() + " - " + all.getKey());
        }
        return allContacts;
    }
}