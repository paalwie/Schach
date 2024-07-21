package org.example.Figuren;

import org.example.Player;
import org.example.Spielbrett;

import static org.example.Spielbrett.spielbrett;

public class Figur {

    String symbol;
    public  int startPositionX;
    public  int startPositionY;

    public void bewegeFigur(int startPositionX, int startPositionY, int endPositionX, int endPositionY, Spielbrett spielbrett, Player player) {

        String indexWert = String.format("%d,%d", startPositionX, startPositionY);
        Spielbrett.spielbrett[startPositionX][startPositionY] = indexWert;

        String neuerIndexWert = String.format("%d,%d", endPositionX, endPositionY);
        Spielbrett.spielbrett[endPositionX][endPositionY] = neuerIndexWert;

        setStartPositionX(endPositionX);
        setStartPositionY(endPositionY);
        System.out.println("Die Figur bewegt sich auf " + neuerIndexWert);

        Spielbrett.spielbrett[endPositionX][endPositionY] = symbol;
    }

    public int getStartPositionX() {
        return startPositionX;
    }

    public int getStartPositionY() {
        return startPositionY;
    }

    public void setStartPositionX(int startPositionX) {
        this.startPositionX = startPositionX;
    }

    public void setStartPositionY(int startPositionY){
        this.startPositionY = startPositionY;
    }
}
