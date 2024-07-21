package org.example.Figuren;

import org.example.Player;
import org.example.Spielbrett;

import static org.example.Spielbrett.spielbrett;

public class König extends Figur{

    int nummer;
    Player player;

    public König(int nummer, Player player, int startPositionX, int startPositionY, String symbol) {
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

    //Bewegung: Jedes angrenzendes Feld
    public void bewegeFigur(int indexX, int indexY, int endIndexX, int endIndexY, Spielbrett spielbrett, Player player) {

        if (
                (indexX - 1 == endIndexX || indexX + 1 == endIndexX || indexX == endIndexX) &&
                (indexY - 1 == endIndexY || indexY + 1 == endIndexY || indexY == endIndexY)
        ){
            super.bewegeFigur(indexX, indexY, endIndexX, endIndexY, spielbrett, player);
        } else {
            System.out.println("Fehler, Bewegung ist ungültig! Nur angrenzende Felder!");
        }
    }
}
