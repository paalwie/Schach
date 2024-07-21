package org.example;

import org.example.Figuren.*;

import java.util.ArrayList;
import java.util.Iterator;

public class Player {

    public int figurenAnzahl;
    String name;
    String color;
    String startbereich;
    ArrayList<Figur> figuren = new ArrayList<>();


    public Player(String name, String color, String startbereich) {
        this.name = name;
        this.color = color;
        this.startbereich = startbereich;
    }

    public void erstelleFiguren(String startbereich){

        if (startbereich.equals("oben")){
            Bauer bauer1 = new Bauer(1, this, 1, 0, "♙");
            Bauer bauer2 = new Bauer(2, this, 1, 1, "♙");
            Bauer bauer3 = new Bauer(3, this, 1, 2, "♙");
            Bauer bauer4 = new Bauer(4, this, 1, 3, "♙");
            Bauer bauer5 = new Bauer(5, this, 1, 4, "♙");
            Bauer bauer6 = new Bauer(6, this, 1, 5, "♙");
            Bauer bauer7 = new Bauer(7, this, 1, 6, "♙");
            Bauer bauer8 = new Bauer(8, this, 1, 7, "♙");

            Turm turm1 = new Turm(1, this, 0, 0, "♖");
            Turm turm2 = new Turm(2, this, 0, 7, "♖");

            Pferd pferd1 = new Pferd(1, this, 0, 1, "♘");
            Pferd pferd2 = new Pferd(2, this, 0, 6, "♘");

            Läufer läufer1 = new Läufer(1, this, 0, 2, "♗");
            Läufer läufer2 = new Läufer(2, this, 0, 5, "♗");

            Dame dame1 = new Dame(1, this, 0, 3, "♕");
            König könig1 = new König(1, this, 0, 4, "♔");

            figuren.add(bauer1);
            figuren.add(bauer2);
            figuren.add(bauer3);
            figuren.add(bauer4);
            figuren.add(bauer5);
            figuren.add(bauer6);
            figuren.add(bauer7);
            figuren.add(bauer8);

            figuren.add(turm1);
            figuren.add(turm2);

            figuren.add(pferd1);
            figuren.add(pferd2);

            figuren.add(läufer1);
            figuren.add(läufer2);

            figuren.add(dame1);
            figuren.add(könig1);

            figurenAnzahl = figuren.size();
            Spielbrett.alleFiguren.addAll(figuren);

            System.out.println("Figuren werden erstellt");
        }

        if (startbereich.equals("unten")){
            Bauer bauer9 = new Bauer(9, this, 6, 0, "♟");
            Bauer bauer10 = new Bauer(10, this, 6, 1, "♟");
            Bauer bauer11 = new Bauer(11, this, 6, 2, "♟");
            Bauer bauer12 = new Bauer(12, this, 6, 3, "♟");
            Bauer bauer13 = new Bauer(13, this, 6, 4, "♟");
            Bauer bauer14 = new Bauer(14, this, 6, 5, "♟");
            Bauer bauer15 = new Bauer(15, this, 6, 6, "♟");
            Bauer bauer16 = new Bauer(16, this, 6, 7, "♟");

            Turm turm3 = new Turm(3, this, 7, 0, "♜");
            Turm turm4 = new Turm(4, this, 7, 7, "♜");

            Pferd pferd3 = new Pferd(3, this, 7, 1, "♞");
            Pferd pferd4 = new Pferd(4, this, 7, 6, "♞");

            Läufer läufer3 = new Läufer(3, this, 7, 2, "♝");
            Läufer läufer4 = new Läufer(4, this, 7, 5, "♝");

            Dame dame2 = new Dame(2, this, 7, 3, "♛");
            König könig2 = new König(2, this, 7, 4, "♚");

            figuren.add(bauer9);
            figuren.add(bauer10);
            figuren.add(bauer11);
            figuren.add(bauer12);
            figuren.add(bauer13);
            figuren.add(bauer14);
            figuren.add(bauer15);
            figuren.add(bauer16);

            figuren.add(turm3);
            figuren.add(turm4);

            figuren.add(pferd3);
            figuren.add(pferd4);

            figuren.add(läufer3);
            figuren.add(läufer4);

            figuren.add(dame2);
            figuren.add(könig2);

            figurenAnzahl = figuren.size();
            Spielbrett.alleFiguren.addAll(figuren);

            System.out.println("Figuren werden erstellt");
        }
    }

    public boolean checkeObFigurVomSpielerAufFeldLiegt(int indexX, int indexY) {

        for (Figur figur : figuren) {
            if (figur.getStartPositionX() == indexX && figur.getStartPositionY() == indexY) {
                return true;
            }
        }
        return false;
    }

    public Figur getFigur(int indexX, int indexY){
        for (Figur figur : figuren) {
            if (figur.startPositionX == indexX && figur.startPositionY == indexY) {
                return figur;
            }
        }
        return null;
    }

    public void deleteFigur(int indexX, int indexY) {
        Iterator<Figur> iterator = figuren.iterator();
        while (iterator.hasNext()) {
            Figur figur = iterator.next();
            if (figur.startPositionX == indexX && figur.startPositionY == indexY) {
                iterator.remove();
                figurenAnzahl--;
            }
        }
    }
}
