package org.example;

import org.example.Figuren.Figur;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Spielbrett {

    public static String[][] spielbrett = new String[8][8];
    public static boolean löschVorgang = false;
    public static ArrayList<Figur> alleFiguren = new ArrayList<>();

    public void spielbrettFüllen(){
        for(int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                String indexWert = String.format("%d,%d", i, j); // Formatiere den Indexwert mit Kommas
                spielbrett[i][j] = indexWert;
            }
        }
    }

    public void spielBrettAnzeigen() {

        System.out.println("+----+----+----+----+----+----+----+---+");

        for (int i = 0; i < 8; i++) {
            System.out.print("|"); // Füge ein "|" am Anfang jeder Zeile hinzu

            for (int j = 0; j < 8; j++) {
                String feldElement = spielbrett[i][j];
                String formattedElement = String.format("%3s", feldElement); // Formatiere jedes Element mit 3 Leerzeichen
                System.out.print(formattedElement + " |"); // Füge ein "|" nach jedem Element hinzu
            }

            System.out.println(); // Füge ein "|" am Ende jeder Zeile hinzu
            System.out.println("+----+----+----+----+----+----+----+---+");
        }
    }


    public boolean checkeObFigurVomSpielerAufFeldLiegt(int indexX, int indexY){

        String indexWert = String.format("%d,%d", indexX, indexY);

        return Objects.equals(spielbrett[indexX][indexY], indexWert);
    }

    public boolean wurfVorgang(){
        System.out.println("Möchten Sie werfen? [y] oder [n]");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("y")) {
            löschVorgang = true;
            return true;
        } else {
            return false;
        }
    }

    public Figur getFigur(int indexX, int indexY){

        for (Figur figur : alleFiguren) {
            if (figur.startPositionX == indexX && figur.startPositionY == indexY) {
                return figur;
            }
        }
        return null;
    }
}
