package todoApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static java.util.Comparator.comparing;
import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.nullsFirst;

public class TodoList {
    public enum TypeOfSort {NAME_ORDER,NAME_REVERSE_ORDER, DATE_ORDER, DATE_REVERSE_ORDER,
        CREATED_ORDER, CREATED_REVERSE_ORDER, DONE_ORDER, DONE_REVERSE_ORDER}

    private String name;
    private TodoTheme theme;
    private Boolean hideDone;
    private TypeOfSort typeOfSort;
    private ArrayList<TodoTask> tasks;

    Scanner in = new Scanner(System.in);
    /*public TodoList(){
        System.out.print("Type Name of TodoList:");
        this.name = in.nextLine();
        this.theme = new TodoTheme();
        this.hideDone = false;
        this.typeOfSort = TypeOfSort.CREATED_ORDER;
        this.tasks = new ArrayList<>();
    }*/
    public TodoList(String name){
        this.name = name;
        this.theme = new TodoTheme();
        this.hideDone = false;
        this.typeOfSort = TypeOfSort.CREATED_ORDER;
        this.tasks = new ArrayList<>();
    }

    public void setName(){
        System.out.print("Type Name of TodoList:");
        String what = in.nextLine();
        this.name = what;
    }
    public void setTheme(TodoTheme.ThemeColor col){
        this.theme.setColor(col);
        //this.theme.setImageIcon();
    }
    public void setHideDone(){
        this.hideDone = !this.hideDone;
    }
    public void setTypeOfSort(TypeOfSort t) {
        this.typeOfSort = t;
        this.sortTask();
    }

    public void addTask(TodoTask newTask){
        this.tasks.add(newTask);
        this.sortTask();
    }
    public void sortTask(){
        switch (this.typeOfSort) {
            case NAME_ORDER: {
                tasks.sort(comparing(TodoTask::getName));
            }
            case NAME_REVERSE_ORDER:{
                tasks.sort(comparing(TodoTask::getName));
                Collections.reverse(tasks);
            }
            case DATE_ORDER: {
                tasks.sort(comparing(TodoTask::getDate,
                        nullsFirst(naturalOrder())));
            }
            case DATE_REVERSE_ORDER:{
                tasks.sort(comparing(TodoTask::getDate,
                        nullsFirst(naturalOrder())));
                Collections.reverse(tasks);
            }
            case CREATED_ORDER:{
                tasks.sort(comparing(TodoTask::getCreated));
            }
            case CREATED_REVERSE_ORDER: {
                tasks.sort(comparing(TodoTask::getCreated));
                Collections.reverse(tasks);
            }
            case DONE_ORDER: {
                tasks.sort(comparing(TodoTask::getDone));
            }
            case DONE_REVERSE_ORDER: {
                tasks.sort(comparing(TodoTask::getDone));
                Collections.reverse(tasks);
            }
        }
    }
    public void delTask(TodoTask todoTask){
        this.tasks.remove(todoTask);
    }

    public String getName(){
        return this.name;
    }
    public int getNumberOfTask(){
        return this.tasks.size();
    }
    public void printTasks(){
        this.sortTask();
        if (tasks.size()==0) {
            System.out.println("Task is empty");
        }else for (TodoTask task : tasks)
            if (this.hideDone && task.getDone()) continue;
            else {
                String check = "-";
                if(task.getDone()) check ="o";
                String what = "[" +check + "] "+ task.getName() + " ";
                if(task.getDate() != null) {
                    what = what +","+ task.getDate().toString();
                }
                if(task.getAlarm() != null) {
                    what = what + "," + task.getAlarm().toString();
                }
                System.out.println(what);
            }
    }
    public ArrayList<TodoTask> getTasks(){
        return this.tasks;
    }

    /*public void exportTask(){
            int i = 0;
            for(TodoTask task : tasks){
                String taskName = task.getName();
                taskName =Integer.toString(i) + ". " + taskName;
                System.out.println(taskName);
                i++;
            }
            i = in.nextInt();
            TodoTask what = tasks.get(i);

            i = 0;
            for(TodoList list : TodoApp.this.Lists){
                String listName = list.getName();
                listName =Integer.toString(i) + ". " + listName;
                System.out.println(listName);
                i++;
            }
            i = in.nextInt();
            TodoList to = TodoApp.this.Lists.get(i);

            to.tasks.add(what);
            this.tasks.remove(what);

        }*/

}
