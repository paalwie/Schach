package org.example.Figuren;

import org.example.Player;
import org.example.Spielbrett;

import static org.example.Spielbrett.spielbrett;

//Springer
public class Pferd extends Figur{

    int nummer;
    Player player;

    public Pferd(int nummer, Player player, int startPositionX, int startPositionY, String symbol) {
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

    //Bewegung: Zwei Feld nach vorne, eins nach links bzw. rechts
    public void bewegeFigur(int startPositionX, int startPositionY, int endPositionX, int endPositionY, Spielbrett spielbrett, Player player) {

        if (

                (startPositionX == endPositionX - 2 && startPositionY == endPositionY - 1) ||
                (startPositionX == endPositionX - 2 && startPositionY == endPositionY + 1) ||
                (startPositionX == endPositionX + 2 && startPositionY == endPositionY - 1) ||
                (startPositionX == endPositionX + 2 && startPositionY == endPositionY + 1) ||
                (startPositionX == endPositionX - 1 && startPositionY == endPositionY - 2) ||
                (startPositionX == endPositionX - 1 && startPositionY == endPositionY + 2) ||
                (startPositionX == endPositionX + 1 && startPositionY == endPositionY - 2) ||
                (startPositionX == endPositionX + 1 && startPositionY == endPositionY + 2)
        ){

            super.bewegeFigur(startPositionX, startPositionY, endPositionX, endPositionY, spielbrett, player);
        } else {
            System.out.println("Fehler: Figur darf nur 2.1 Felder (2 nach vorne, eins zur Seite) bewegt werden!");
        }
    }
}
