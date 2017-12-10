package todoApp;

import java.io.Serializable;
import java.util.ArrayList;

public class TodoApp implements Serializable {
    private ArrayList<TodoList> Lists;

    public TodoApp(){
        this.Lists = new ArrayList<>();
    }
    public void addList(TodoList todoList) {
        this.Lists.add(todoList);
    }
    public void printList(){
        for(TodoList l : Lists) {
            String what = l.getName() +" "+ Integer.toString(l.getNumberOfTask());
            System.out.println(what);
        }
    }
    public TodoList getList(String listname){
        for(TodoList todoList : Lists) {
            if (todoList.getName().equals(listname)) return todoList;
        }
        return null;
    }

    public void deleteList(TodoList todolist){
        this.Lists.remove(todolist);
    }

}
