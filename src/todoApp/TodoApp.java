package todoApp;

import java.util.ArrayList;

public class TodoApp {
    private ArrayList<TodoList> Lists;

    public TodoApp(){
        this.Lists = new ArrayList<>();
    }
    public void getList(){
        for(TodoList l : Lists) System.out.println(l.getName());
    }
    public void deleteList(TodoList todolist){
        this.Lists.remove(todolist);
    }

}
