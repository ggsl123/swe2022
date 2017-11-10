package todoApp;

import java.util.ArrayList;
import java.util.Comparator;
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
        System.out.println("Type of sort");
        System.out.println("1. Name order");
        System.out.println("2. Name reverse order");
        System.out.println("3. Date order");
        System.out.println("4. Date reverse order");
        System.out.print("Type number of sorting type: ");
        int what = in.nextInt();

        if(what == 1){tasks.sort(Comparator.comparing(TodoTask::getName))};
        if(what == 2){tasks.sort((TodoTask x,TodoTask y) -> y.getName().compareTo(x.getName()))};
        if(what == 3){tasks.sort(Comparator.comparing(TodoTask::getDate))};
        if(what == 4){tasks.sort((TodoTask x,TodoTask y) -> y.getDate().compareTo(x.getDate()))};


    }

    public void setTheme(TodoTheme t){
        this.theme = t;
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
