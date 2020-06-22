package DesignModel.OverserModel;

import javafx.beans.Observable;

import java.util.Observer;

public class Watcher implements Observer {


    public void update(java.util.Observable o, Object arg){
        System.out.println("after changed");
        Watched watched = (Watched) o;
        System.out.println(watched.toString());
        System.out.println("after changed");
    }
}
