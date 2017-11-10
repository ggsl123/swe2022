package todoApp;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
    private String name;
    private TodoTheme theme;
    private Boolean hideDone;
    private ArrayList<TodoTask> tasks;

    static Scanner in = new Scanner(System.in);
    public TodoList(){
        this.theme = blue;
        this.hideDone = false;
        System.out.print("Type Name of TodoList:");
        String what = in.nextLine();
        this.name = what;
    }

    public void setName(){
        System.out.print("Type Name of TodoList:");
        String what = in.nextLine();
        this.name = what;
    }

    public void sortTasks(){
    }

    public void setTheme(){

    }

    public void setHideDone(boolean b){
        this.hideDone = b;
    }

    public void export(TodoTask what, TodoList to){
        /*
        int i = 0;
        for(TodoTask task : tasks){
            String taskName = task.getName();
            taskName =Integer.toString(i) + ". " + taskName;
            System.out.println(taskName);
            i++;
        }
        i = in.nextInt();
        TodoTask what = tasks.get(i);
        */
        if(this.tasks.contains(what)) {
            to.tasks.add(what);
            this.tasks.remove(what);
        }
    }




}
