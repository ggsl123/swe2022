package todoApp;

import sun.text.resources.et.CollationData_et;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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
    public TodoList(){
        System.out.print("Type Name of TodoList:");
        this.name = in.nextLine();
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

    public void addTask(){
        TodoTask newTask = new TodoTask();
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

    public String getName(){
        return this.name;
    }
    public void getTasks(){
        this.sortTask();
        if (tasks.size()==0) {
            System.out.println("Task is empty");
        }else for (TodoTask task : tasks)
            if (this.hideDone && task.getDone()) continue;
            else System.out.println(task.getName());
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

    public class TodoTask {
        private String name;
        private boolean done;
        private final Date created;
        private Date date;
        private Date alarm;

        Scanner in = new Scanner(System.in);
        public TodoTask() {
            System.out.print("Type Name of TodoTask:");
            String what = in.nextLine();
            this.name = what;
            this.done = false;
            this.created = new Date();

        }
        public void del(){
            TodoList.this.tasks.remove(this);
        }

        public void setName() {
            System.out.print("Type Name of TodoTask:");
            String what = in.nextLine();
            this.name = what;
        }
        public void setDate() {
            System.out.print("1. Today");
            System.out.print("2. Tomorrow");
            System.out.print("3. Next Week");
            System.out.print("4. Select Date");
            System.out.print("Type number of setting type: ");
            int what = in.nextInt();

            Date now = new Date();
            switch (what) {
                case 1:
                    ;
                case 2: {
                    now.setDate(now.getDate() + 1);
                }
                case 3: {
                    now.setDate(now.getDate() + 7);
                }
                case 4: {
                    now = setSpecificDate(false);
                }
            }
            this.date = now;
        }
        public void setAlarm() {
            System.out.print("1. Today Later");
            System.out.print("2. Tomorrow");
            System.out.print("3. Next Week");
            System.out.print("4. Select Date and Time");
            System.out.print("Type number of setting type: ");
            int what = in.nextInt();

            Date now = new Date();
            switch (what) {
                case 1: {
                    now.setHours(now.getHours() + 3);
                    now.setMinutes(0);
                    now.setSeconds(0);
                }
                case 2: {
                    now.setDate(now.getDate() + 1);
                    now.setHours(9);
                    now.setMinutes(0);
                    now.setSeconds(0);
                }
                case 3: {
                    now.setDate(now.getDate() + 7);
                    now.setHours(9);
                    now.setMinutes(0);
                    now.setSeconds(0);
                }
                case 4: {
                    now = setSpecificDate(true);
                }
            }
            this.date = now;
        }

        public void checkDone() {
            this.done = !this.done;
        }
        public boolean isAlarm(){ //isAlarm method가 매분 실행된다는 가정
            Date now = new Date();
            if (this.alarm == null){return false;}
            if (this.alarm.getYear() != now.getYear()){return false;}
            if (this.alarm.getMonth() != now.getMonth()){return false;}
            if (this.alarm.getDate() != now.getDate()){return false;}
            if (this.alarm.getHours() != now.getHours()){return false;}
            if (this.alarm.getMinutes() != now.getMinutes()){return false;}
            return true;
        }

        public String getName() {
            return this.name;
        }
        public Date getDate() {
            return this.date;
        }
        public Date getCreated(){return this.created;}
        public boolean getDone(){return this.done;}

        public Date setSpecificDate(Boolean time) {
            Date d = new Date();
            System.out.print("Type year: ");
            int year = in.nextInt();
            System.out.print("Type month: ");
            int month = in.nextInt();
            System.out.print("Type date: ");
            int date = in.nextInt();
            d.setYear(year);
            d.setMonth(month);
            d.setDate(date);

            if (time == false) {
                return d;
            } else {
                System.out.print("Type Hours: ");
                int hours = in.nextInt();
                System.out.print("Type Minutes: ");
                int min = in.nextInt();
                d.setHours(hours);
                d.setMinutes(min);
                d.setSeconds(0);
                return d;
            }
        }
    }
}
