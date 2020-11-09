import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int box = Integer.parseInt(scanner.nextLine());

//        System.out.println("Введите количество ящиков: ");
//        int box = new Scanner(System.in).nextInt(); // 2-й вариант

        int truck = 0;
        int container = 0;

        if (box > 0)
        {
            truck++;
            container++;

            System.out.println("Грузовик: " + truck + "\r\n\tКонтейнер: " + container);

            for (int i = 1; i <= box; i++)
            {
                System.out.println("\t\tЯщик: " + i);
                if (i % 27 == 0)
                {
                    if (container % 12 == 0)
                    {
                        truck++;
                        System.out.println("Грузовик: " + truck);
                    }

                    if (i + 1 <= box)
                    {
                        container++;
                        System.out.println("\tКонтейнер: " + container);
                    }
                }
            }
        }
        System.out.println("Необходимо:\r\nгрузовиков - " + truck + " шт." +
                "\r\nконтейнеров - " + container + " шт.");
        // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */
    }
}

