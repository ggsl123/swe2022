package todoApp;

import java.util.Date;
import java.util.Scanner;

public class TodoTask {
    private String name;
    private boolean done;
    private final Date created;
    private Date date;
    private Date alarm;

    Scanner in = new Scanner(System.in);
    /*public TodoTask() {
        System.out.print("Type Name of TodoTask:");
        String what = in.nextLine();
        this.name = what;
        this.done = false;
        this.created = new Date();
    }*/
    public TodoTask(String name) {
        this.name = name;
        this.done = false;
        this.created = new Date();
    }

    public void setName() {
        System.out.print("Type Name of TodoTask:");
        String what = in.nextLine();
        this.name = what;
    }
    public enum SetDate {TODAY,TOMORROW,NEXT_WEEK,SELECT_DATE}
    public void setDate(SetDate what,int year, int month, int day) {
        Date now = new Date();
        switch (what) {
            case TODAY:
                now.setHours(0);
                now.setMinutes(0);
                now.setSeconds(0);
            case TOMORROW: {
                now.setDate(now.getDate() + 1);
                now.setHours(0);
                now.setMinutes(0);
                now.setSeconds(0);
            }
            case NEXT_WEEK: {
                now.setDate(now.getDate() + 7);
                now.setHours(0);
                now.setMinutes(0);
                now.setSeconds(0);
            }
            case SELECT_DATE: {
                now.setYear(year);
                now.setMonth(month);
                now.setDate(day);
                now.setHours(0);
                now.setMinutes(0);
                now.setSeconds(0);
            }
        }
        this.date = now;
    }
    public enum SetAlarm {TODAY_LATER, TOMORROW, NEXT_WEEK, SELECT_DATE_TIME}
    public void setAlarm(SetAlarm what,int year,int month, int day, int hour, int min) {
        Date now = new Date();
        switch (what) {
            case TODAY_LATER: {
                now.setHours(now.getHours() + 3);
                now.setMinutes(0);
                now.setSeconds(0);
            }
            case TOMORROW: {
                now.setDate(now.getDate() + 1);
                now.setHours(9);
                now.setMinutes(0);
                now.setSeconds(0);
            }
            case NEXT_WEEK: {
                now.setDate(now.getDate() + 7);
                now.setHours(9);
                now.setMinutes(0);
                now.setSeconds(0);
            }
            case SELECT_DATE_TIME: {
                now.setYear(year);
                now.setMonth(month);
                now.setDate(day);
                now.setHours(hour);
                now.setMinutes(min);
                now.setSeconds(0);
            }
        }
        this.alarm = now;
    }

    public void checkDone() {
        this.done = !this.done;
    }
    public void complete(){
        this.done = true;
    }
    public void incomplete(){
        this.done = false;
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
    public Date getAlarm(){return  this.alarm;}
    public boolean getDone(){return this.done;}


}
