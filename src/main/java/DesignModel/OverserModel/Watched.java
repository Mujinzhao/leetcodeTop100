package DesignModel.OverserModel;

import lombok.Data;

import java.util.Observable;

/**
 * 被观察者
 */
@Data
public class Watched extends Observable {
    String url;

    String sessionID;

    public Watched() {
    }

    public Watched(String url, String sessionID) {
        this.url = url;
        this.sessionID = sessionID;
    }

    public void printINFO(){
        System.out.println(this.toString());
        setChanged();
        notifyObservers(this);
    }

    @Override
    public String toString() {
        return "Watched{" +
                "url='" + url + '\'' +
                ", sessionID='" + sessionID + '\'' +
                '}';
    }
}
