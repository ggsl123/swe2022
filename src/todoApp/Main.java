package todoApp;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;

public class Main implements Serializable{
    public void on(InputStream src, TodoApp app)
            throws ArrayIndexOutOfBoundsException, NullPointerException {
        TodoList nowList = null;

        Scanner in = new Scanner(src).useDelimiter("\\n");
        app.printList();
        exit:
        while (true) {
            in.reset();
            String c = in.nextLine();

            if (c.startsWith("addList:")) {
                TodoList todoList = new TodoList(c.split(":")[1]);
                app.addList(todoList);
                app.printList();
            }

            if (c.startsWith("list:")) {
                nowList = app.getList(c.split(":")[1]);
                nowList.printTasks();
            }

            if (c.startsWith("addTodo:")) {
                String what = "";
                try {
                    what = c.split(":")[1];
                } catch (ArrayIndexOutOfBoundsException ex) {
                }

                try {
                    what = what + ":" + c.split(":")[2];
                } catch (ArrayIndexOutOfBoundsException ex) {
                }

                String name;
                try {
                    name = what.split(",")[0];
                } catch (ArrayIndexOutOfBoundsException ex) {
                    name = what;
                }
                TodoTask newTask = new TodoTask(name);

                String date = null;
                try {
                    date = what.split(",")[1];
                } catch (ArrayIndexOutOfBoundsException ex) {
                }
                try {
                    int dueyear = Integer.parseInt(date.split("\\.")[0]);
                    dueyear = 100 + dueyear;
                    int duemonth = Integer.parseInt(date.split("\\.")[1]);
                    duemonth = duemonth - 1;
                    int dueday = Integer.parseInt(date.split("\\.")[2]);
                    newTask.setDate(TodoTask.SetDate.SELECT_DATE, dueyear, duemonth, dueday);
                } catch (ArrayIndexOutOfBoundsException ex) {
                } catch (NullPointerException ex) {
                }

                String alarm = null;
                try {
                    alarm = what.split(",")[2];
                } catch (ArrayIndexOutOfBoundsException ex) {
                }

                String time = null;
                try {
                    time = alarm.split(" ")[1];
                    alarm = alarm.split(" ")[0];
                } catch (NullPointerException ex) {
                }

                try {
                    int year = Integer.parseInt(alarm.split("\\.")[0]);
                    year = 100 + year;
                    int month = Integer.parseInt(alarm.split("\\.")[1]);
                    month = month - 1;
                    int day = Integer.parseInt(alarm.split("\\.")[2]);
                    int hour = Integer.parseInt(time.split(":")[0]);
                    int min = Integer.parseInt(time.split(":")[1]);
                    newTask.setAlarm(TodoTask.SetAlarm.SELECT_DATE_TIME, year, month, day, hour, min);
                } catch (ArrayIndexOutOfBoundsException ex) {
                } catch (NullPointerException ex) {
                }
                try {
                    nowList.addTask(newTask);
                    nowList.printTasks();
                } catch (NullPointerException ex) {
                }

            }

            if (c.startsWith("complete:")) {
                String what = "";
                try {
                    what = c.split(":")[1];
                } catch (ArrayIndexOutOfBoundsException ex) {
                }

                try {
                    for (TodoTask task : nowList.getTasks()) {
                        if (task.getName().equals(what)) task.complete();
                    }
                    nowList.printTasks();
                } catch (NullPointerException ex) {
                }
            }

            if (c.startsWith("incomplete:")) {
                String what = "";
                try {
                    what = c.split(":")[1];
                } catch (ArrayIndexOutOfBoundsException ex) {
                }

                try {
                    for (TodoTask task : nowList.getTasks()) {
                        if (task.getName().equals(what)) task.incomplete();
                    }
                    nowList.printTasks();
                } catch (NullPointerException ex) {
                }
            }


            if (c.startsWith("save:")) {
                try {
                    Path p = Paths.get("c:/test", "obj.txt");
                    if (!Files.exists(p)) Files.createFile(p);
                    ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(p));
                    out.reset();
                    out.writeObject(app);
                    System.out.println("Saved.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (c.startsWith("load:")) {
                try {
                    Path p = Paths.get("c:/test", "obj.txt");
                    ObjectInputStream inn = new ObjectInputStream(Files.newInputStream(p));
                    //inn.defaultReadObject();
                    app = (TodoApp) inn.readObject();
                    app.printList();
                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
            if ("exit".equals(c)) break exit;

            }

        }


    public static void main(String[] arg){
        //기본설정들

        TodoApp app = new TodoApp();

        /*
        TodoList atHome = new TodoList("집에서할일");
        TodoTask hometask1 = new TodoTask("commit");
        atHome.addTask(hometask1);

        TodoList homework = new TodoList("학교숙제");
        TodoTask homework1 = new TodoTask("시계열과제");
        homework.addTask(homework1);

        app.addList(atHome);
        app.addList(homework);
        */

        new Main().on(System.in,app);

    }

}

