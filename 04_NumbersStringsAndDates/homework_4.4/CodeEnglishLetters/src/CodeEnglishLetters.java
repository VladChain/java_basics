public class CodeEnglishLetters
{
    public static void main(String[] args)
    {
        String abcUp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < abcUp.length(); i++)
        {
            char a = abcUp.charAt(i);
            System.out.println(a + " = " + (int) a + ";");
        }
        System.out.println("******");

        String abcLow = "abcdefghijklmnopqrstuvwxyz";

        for (int j = 0; j < abcLow.length(); j++)
        {
            char b = abcLow.charAt(j);
            System.out.println(b + " = " + (int) b + ";");
        }
    }
}
