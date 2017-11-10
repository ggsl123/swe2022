package todoApp;

import java.util.Scanner;

public class TodoTask {
    private String name;

    static Scanner in = new Scanner(System.in);
    public TodoTask(){
        System.out.print("Type Name of TodoTask:");
        String what = in.nextLine();
        this.name = what;
    }
    public String getName(){
        return this.name;
    }
}
