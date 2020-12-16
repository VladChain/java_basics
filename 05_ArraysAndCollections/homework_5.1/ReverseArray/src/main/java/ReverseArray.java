
public class ReverseArray {

    public static String[] reverse(String[] strings) {
        StringBuilder line = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            line.append(strings[i]).append(" ");
        }
        String[] text = line.toString().split(("\\s+"));
        System.arraycopy(text, 0, strings, 0, strings.length);

        return strings;
    }
}
