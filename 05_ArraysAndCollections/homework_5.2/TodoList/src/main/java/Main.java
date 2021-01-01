import java.util.*;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList
        System.out.println("Выберите команду из списка, что вы хотите сделать: " +
                "\n LIST - вывести список дел " +
                "\n ADD - добавить дело в список " +
                "\n EDIT - отредактировать список дел " +
                "\n DELETE - удалить дело из списка");

        while (true) {
            Scanner sc = new Scanner(System.in);
            switch (sc.nextLine()) {
                case "LIST":
                    System.out.println(todoList.getTodos());
                    continue;
                case "ADD":
                    if (sc.hasNextInt()) {
                        int addNumTodo = sc.nextInt();
                        String newTodo = sc.nextLine();
                        todoList.add(addNumTodo, newTodo);
                    } else {
                        String newTodo = sc.nextLine();
                        todoList.add(newTodo);
                    }
                    continue;
                case "EDIT":
                    int numTodo = sc.nextInt();
                    String newTodo = sc.nextLine();
                    todoList.edit(newTodo, numTodo);
                    continue;
                case "DELETE" :
                    int delTodo = sc.nextInt();
                    todoList.delete(delTodo);
                    continue;
                default:
                    System.out.println("Введите правильно команду!");
                    break;
            }
            sc.close();
        }
    }
}
