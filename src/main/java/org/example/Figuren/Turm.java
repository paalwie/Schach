package org.example.Figuren;

import org.example.Player;
import org.example.Spielbrett;

import static org.example.Spielbrett.spielbrett;

public class Turm extends Figur {

    int nummer;
    Player player;

    public Turm(int nummer, Player player, int startPositionX, int startPositionY, String symbol) {
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

    //Bewegung: Ein Feld Horizontal oder Vertikal, in alle Richtungen
    public void bewegeFigur(int startPositionX, int startPositionY, int endPositionX, int endPositionY, Spielbrett spielbrett, Player player) {

        if (
                startPositionX == endPositionX ||
                        startPositionY == endPositionY
        ) {
            if(isBewegungErlaubtMitKollisionsprüfung(startPositionX, startPositionY, endPositionX, endPositionY, spielbrett, player)){
                super.bewegeFigur(startPositionX, startPositionY, endPositionX, endPositionY, spielbrett, player);
            }
            else {
                System.out.println("Die Figur kann nicht bewegt werden weil eine Figur im Weg ist!");
            }

        } else {
            System.out.println("Die Figur kann nicht bewegt werden! Nur Horizontal oder Vertikal ist möglich!");
        }
    }

    private boolean isBewegungErlaubtMitKollisionsprüfung(int startPositionX, int startPositionY, int endPositionX, int endPositionY, Spielbrett spielbrett, Player player) {

        // Hier ein Beispiel für die Implementierung der Kollisionsprüfung
        for (int i = startPositionX; i <= endPositionX; i++) {
            for (int j = startPositionY; j <= endPositionY; j++) {
                if (spielbrett.getFigur(i, j) != null && i != endPositionX && j != endPositionY) {
                    return false; // Kollision mit einer anderen Figur gefunden
                }
            }
        }

        return true; // Keine Kollision gefunden
    }

    public boolean schlagen(int startPositionX, int startPositionY, int endPositionX, int endPositionY, Spielbrett spielbrett) {
        return false;
    }

}
