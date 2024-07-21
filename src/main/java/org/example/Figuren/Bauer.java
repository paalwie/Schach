package org.example.Figuren;

import org.example.Player;
import org.example.Spielbrett;

import static org.example.Spielbrett.spielbrett;

public class Bauer extends Figur {

    int nummer;
    Player player;

    public Bauer(int nummer, Player player, int startPositionX, int startPositionY, String bauerSymbol) {
        this.nummer = nummer;
        this.player = player;
        this.startPositionX = startPositionX;
        this.startPositionY = startPositionY;
        this.symbol = bauerSymbol;

        setzeStartPosition(startPositionX, startPositionY);
    }

    public void setzeStartPosition(int startPositionX, int startPositionY) {
        spielbrett[startPositionX][startPositionY] = symbol;
    }

    //Bewegung: Ein Schritt vor, ein Schritt zurück, beim Schlagen ein Feld Diagonal
    public void bewegeFigur(int startPositionX, int startPositionY, int endPositionX, int endPositionY, Spielbrett spielbrett, Player player) {

        //schlagen
        if (
                ((startPositionX - endPositionX) == 1 && (startPositionY - endPositionY) == 1 ||
                        (startPositionX - endPositionX) == -1 && (startPositionY - endPositionY) == 1 ||
                        (startPositionX - endPositionX) == 1 && (startPositionY - endPositionY) == -1 ||
                        (startPositionX - endPositionX) == -1 && (startPositionY - endPositionY) == -1) &&
                        (!spielbrett.checkeObFigurVomSpielerAufFeldLiegt(endPositionX, endPositionY))
        ) {
            spielbrett.wurfVorgang();
            System.out.println("Figur wurde vom Bauer geschlagen");
            super.bewegeFigur(startPositionX, startPositionY, endPositionX, endPositionY, spielbrett, player);

        } else {

            if (((startPositionX - endPositionX) == 1 || (startPositionX - endPositionX) == -1) && (startPositionY - endPositionY) == 0) {

                if (!spielbrett.checkeObFigurVomSpielerAufFeldLiegt(endPositionX, endPositionY)) {
                    System.out.println("Feld belegt!");
                } else {
                    super.bewegeFigur(startPositionX, startPositionY, endPositionX, endPositionY, spielbrett, player);
                }
            } else {
                System.out.println("Die Figur kann nicht bewegt werden! Nur ein Feld nach oben oder unten ist möglich!");
            }
        }
    }


}


