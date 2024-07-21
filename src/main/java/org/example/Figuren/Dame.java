package org.example.Figuren;

import org.example.Player;
import org.example.Spielbrett;

import static org.example.Spielbrett.spielbrett;

public class Dame extends Figur{

    int nummer;
    Player player;

    public Dame(int nummer, Player player, int startPositionX, int startPositionY, String symbol) {
        this.nummer = nummer;
        this.player = player;
        this.startPositionX = startPositionX;
        this.startPositionY = startPositionY;
        this.symbol = symbol;

        setzeStartPosition(startPositionX, startPositionY);
    }

    public void setzeStartPosition(int startPositionX, int startPositionY) {
        spielbrett[startPositionX][startPositionY] = symbol;
    }

    //Bewegung: Sowohl Horizontal/Vertikal als auch Diagonal beliebig weit
    public void bewegeFigur(int startPositionX, int startPositionY, int endPositionX, int endPositionY, Spielbrett spielbrett, Player player) {

        if (
                startPositionX == endPositionX ||
                startPositionY == endPositionY ||
                Math.abs(startPositionX - endPositionX) == Math.abs(startPositionY - endPositionY)
        ){
            super.bewegeFigur(startPositionX, startPositionY, endPositionX, endPositionY, spielbrett, player);
        }
        else {
            System.out.println("Fehler: Figur darf sich nur Horizontal/Vertikal und Diagonal bewegen!");
        }
    }
}
