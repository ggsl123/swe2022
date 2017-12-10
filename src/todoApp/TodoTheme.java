package todoApp;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class TodoTheme implements Serializable {
    public enum ThemeColor implements Serializable {BLUE, PINK, PURPLE, GREEN, SKY};
    public enum ThemeImage implements Serializable {MOUNTAIN, TOWER, BUS, PLANE, HOUSE, SOLID}

    private transient Color color;
    private transient ImageIcon imageIcon;

    public TodoTheme(){
        this.setColor(ThemeColor.BLUE);
        //this.setImageIcon(ThemeImage.SOLID);
        imageIcon = new ImageIcon();
    }
    public void setColor(ThemeColor col){
        switch(col){
            case BLUE : this.color = Color.BLUE;
            case PINK : this.color = Color.PINK;
            case PURPLE : this.color = new Color(98,27,155);
            case GREEN : this.color = Color.GREEN;
            case SKY : this.color = Color.CYAN;
        }

    }
    /*public void setImageIcon(ThemeImage img){
        switch(img){
            case MOUNTAIN : this.imageIcon =
            case TOWER : this.imageIcon =
            case BUS : this.imageIcon =
            case PLANE : this.imageIcon =
            case HOUSE : this.imageIcon =
            case SOLID : this.imageIcon
        }
        */
    }




