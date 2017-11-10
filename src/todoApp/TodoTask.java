package todoApp;

import java.util.Date;
import java.util.Scanner;

public class TodoTask {
    private String name;
    private boolean done;
    private Date date;

    static Scanner in = new Scanner(System.in);
    public TodoTask(int year, int month,int date, int hrs, int min){
        System.out.print("Type Name of TodoTask:");
        String what = in.nextLine();
        this.name = what;
        this.done = false;
        this.date = new Date(year, month, date, hrs, min);
    }

    public String getName(){
        return this.name;
    }

    public void setName(){
        System.out.print("Type Name of TodoTask:");
        String what = in.nextLine();
        this.name = what;
}
    public void checkDone(){
        this.done = !this.done;
    }

    public void setDate(int year, int month,int date, int hrs, int min){
        this.date.setYear(year);
        this.date.setMonth(month);
        this.date.setDate(date);
        this.date.setHours(hrs);
        this.date.setMinutes(min);
    }

    public Date getDate(){
        return this.date;
    }

}
