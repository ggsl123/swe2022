package todoApp;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class TodoTheme {
    private Color color;
    private ImageIcon imageIcon;

    public TodoTheme(){
        color = Color.BLUE;
        imageIcon = new ImageIcon();
    }
    static Scanner in = new Scanner(System.in);
    public void setColor(){
        System.out.println("Type of Color");
        System.out.println("1. BLUE");
        System.out.println("2. PINK");
        System.out.println("3. PURPLE");
        System.out.println("4. GREEN");
        System.out.println("5. SKY");
        System.out.print("Type number of color type: ");
        int what = in.nextInt();
        switch(what){
            case 1 : this.color = Color.BLUE;
            case 2 : this.color = Color.PINK;
            case 3 : this.color = new Color(98,27,155);
            case 4 : this.color = Color.GREEN;
            case 5 : this.color = Color.CYAN;
        }

    }
    public void setImageIcon(){

    }



}
