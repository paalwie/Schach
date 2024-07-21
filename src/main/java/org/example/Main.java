package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello world!");

        Spielbrett spielbrett = new Spielbrett();
        Player player1 = new Player("Patrick", "white", "unten");
        Player player2 = new Player("Alen", "black", "oben");

        spielbrett.spielbrettFüllen();
        spielbrett.spielBrettAnzeigen();;

        System.out.println();

        player1.erstelleFiguren(player1.startbereich);
        player2.erstelleFiguren(player2.startbereich);
        System.out.println();

        boolean running = true;
        boolean player1Spielt = true;

        while(running){

            while(player1Spielt){
                spielbrett.spielBrettAnzeigen();
                System.out.println("Player 1 ist dran! (Weiß) Übrige Figurenanzahl: " + player1.figurenAnzahl + " Alle Figuren: " + Spielbrett.alleFiguren.size());
                System.out.println("Gebe ein: <------ 0 - 7 ------>");
                System.out.println("Ä");
                System.out.println("|");
                System.out.println("0");
                System.out.println("-");
                System.out.println("7");
                System.out.println("|");
                System.out.println("V");

                System.out.println("Wert für Oben nach Unten eingeben:");
                int indexX = scanner.nextInt();
                System.out.println("Wert für Links nach Rechts eingeben:");
                int indexY = scanner.nextInt();

                if(player1.checkeObFigurVomSpielerAufFeldLiegt(indexX, indexY)){
                    System.out.println("Die Figur ist auf dem Feld!");
                    System.out.println("Wohin möchten Sie die Figur bewegen?");
                    System.out.println("Wert für Oben nach Unten eingeben:");
                    int endIndexX = scanner.nextInt();
                    System.out.println("Wert für Links nach Rechts eingeben:");
                    int endIndexY = scanner.nextInt();

                    player1.getFigur(indexX, indexY).bewegeFigur(indexX, indexY, endIndexX, endIndexY, spielbrett,  player1);

                    if (Spielbrett.löschVorgang){
                        player2.deleteFigur(endIndexX, endIndexY);
                    }

                    Spielbrett.löschVorgang = false;

                } else {
                    System.out.println("FEHLER! Figur ist nicht auf dem Feld!");
                }

                player1Spielt = false;
            }

            while(!player1Spielt){
                spielbrett.spielBrettAnzeigen();
                System.out.println("Player 2 ist dran! (Schwarz) Übrige Figurenanzahl: " + player2.figurenAnzahl);
                System.out.println("Gebe ein: <------ 0 - 7 ------>");
                System.out.println("Ä");
                System.out.println("|");
                System.out.println("0");
                System.out.println("-");
                System.out.println("7");
                System.out.println("|");
                System.out.println("V");

                System.out.println("Wert für Oben nach Unten eingeben:");
                int indexX = scanner.nextInt();
                System.out.println("Wert für Links nach Rechts eingeben:");
                int indexY = scanner.nextInt();

                if(player2.checkeObFigurVomSpielerAufFeldLiegt(indexX, indexY)){
                    System.out.println("Die Figur ist auf dem Feld!");
                    System.out.println("Wohin möchten Sie die Figur bewegen?");
                    System.out.println("Wert für Oben nach Unten eingeben:");
                    int endIndexX = scanner.nextInt();
                    System.out.println("Wert für Links nach Rechts eingeben:");
                    int endIndexY = scanner.nextInt();

                    player2.getFigur(indexX, indexY).bewegeFigur(indexX, indexY, endIndexX, endIndexY, spielbrett, player2);

                    if (spielbrett.löschVorgang){
                        player1.deleteFigur(endIndexX, endIndexY);
                    }

                } else {
                    System.out.println("FEHLER! Figur ist nicht auf dem Feld!");
                }


                player1Spielt = true;
            }


        }

    }
}