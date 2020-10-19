public class Main {

  public static void main(String[] args) {
    Container container = new Container();
    container.count += 7843;

    int sum = sumDigits(12345);

    System.out.println(sum);
  }

  /* Реализуйте метод sumDigits который возвращает сумму цифр числа, пример:
  передано 12345, метод должен вернуть 15
  если передано null, то должен вернуть -1

  Запустите тесты TestSumDigits для проверки корректности работы метода

  не меняйте название метода, его возвращаемое значение и модификаторы доступа (public).
  В противном случае тестовый метод не сможет проверить ваш код
   */

  // Домашняя работа 4.1
  public static Integer sumDigits(Integer number) // Задание 2 изменение int в Integer
  {
    if (number == null)
    return -1;

    int sum = 0;
    for (int i = 0; i < number.toString().length(); i++)
//        sum += Integer.parseInt(String.valueOf(number.toString().charAt(i)));
        sum += Character.getNumericValue(number.toString().charAt(i)); // Доп. задание Домашняя работа 4.1
    return sum;
  }
}
