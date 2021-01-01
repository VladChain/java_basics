import java.util.ArrayList;

public class TodoList {

    private ArrayList<String> todoList = new ArrayList<>();

    public void add(String todo) {
        todoList.add(todo);
        System.out.println(todo);
    }

    public void add(int index, String todo) {
        if (index < todoList.size()) {
            todoList.add(index, todo);
            System.out.println(todo);
        }
        if (index > todoList.size()) {
            System.out.println("Размер массива: " + todoList.size() + ", дело добавлено в " +
                    "конец списка");
            todoList.add(todo);
            System.out.println(todo);
        }
    }

    public void edit(String todo, int index) {
        if (index < todoList.size()) {
            todoList.add(index, todo);
            System.out.println(todo);
        }
        if (index < todoList.size()) {
            todoList.remove(index + 1);
            System.out.println(todo);
        }
    }

    public void delete(int index) {
        if (index < todoList.size()) {
            todoList.remove(index);
        } else {
            System.out.println("Дело с таким номером не существует");
        }
    }

    public ArrayList<String> getTodos() {
        return todoList;
    }
}