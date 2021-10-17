package hu.nye.progtech.torpedo;

import java.util.Scanner;

import hu.nye.progtech.torpedo.model.Player;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "ISO-8859-2");
        Player player1 = new Player();
        Player player2 = new Player();
        System.out.print("Name of Player1: ");
        player1.setPlayerName(scanner.nextLine());
        System.out.print("Name of Player2: ");
        player2.setPlayerName(scanner.nextLine());
        System.out.println(player1.getPlayerName() + " vs " + player2.getPlayerName());
    }
}
