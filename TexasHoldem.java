import java.util.ArrayList;
import java.util.Scanner;

public class TexasHoldem {

    private int minBet = 0;
    private int pot = 3;
    private int bettingRound = 1; //

    public static void main(String[] args) {
        int playerCount;

        System.out.println("Enter the number of players (2-6)");
        Scanner scanner = new Scanner(System.in);
        playerCount = scanner.nextInt();

        if (playerCount < 2 || playerCount > 6) {
            System.out.println("Invalid amount of players. ");
            System.exit(0);
        }

        System.out.println("Welcome to Texas Holdem! \nHere are your cards: \nPlayer 1 is dealing.....");
        System.out.println("Players 2 and 3 must now bet.");
        System.out.println("Player 2 adds $1. \nPlayer 3 adds $2.");
        System.out.println("Starting pot: $3");

        TexasHoldem texasHoldem = new TexasHoldem();
        RandomCardDrawer cardDrawer = new RandomCardDrawer();
        ArrayList<ArrayList<Card>> Players = new ArrayList<>(); //first instance array list


        for (int i = 0; i < playerCount; i++) {  //adds the cards to the 'players' arraylist, then prints
            ArrayList<Card> drawnCards = cardDrawer.drawTwoRandomCards();

            Players.add(drawnCards);

            System.out.println("\nPlayer " + (i + 1) + ": ");
            System.out.println("First Card: " + drawnCards.get(0));
            System.out.println("Second Card: " + drawnCards.get(1));
        }

        System.out.println("---------------");

        while (playerCount != 1) {  //main driving loop
            for (int playernum = 0; playernum < playerCount; playernum++) {
                System.out.println("\nPlayer " + (playernum + 1) + "'s turn:");
                if (playernum == 0 && texasHoldem.bettingRound < 6) {
                    texasHoldem.bettingRound++;
                }
                texasHoldem.menu(Players, playernum);

            }

            if (texasHoldem.bettingRound == 2) {
                ArrayList<Card> drawnCards = cardDrawer.drawTwoRandomCards();
                System.out.print("\nHere comes the flop!");
                System.out.println("\nFirst Card: " + drawnCards.get(0));
                System.out.println("\nSecond Card: " + drawnCards.get(1));
                System.out.println("\nThird Card: " + drawnCards.get(2));
            }
            if (texasHoldem.bettingRound == 3) {
                ArrayList<Card> drawnCards = cardDrawer.drawTwoRandomCards();
                System.out.print("\nHere comes the turn!");
                System.out.println("\nFourth Card: " + drawnCards.get(3));
            }
            if (texasHoldem.bettingRound == 4) {
                ArrayList<Card> drawnCards = cardDrawer.drawTwoRandomCards();
                System.out.print("\nHere comes the river!");
                System.out.println("\nFifth Card: " + drawnCards.get(4));
                System.out.print("\nAll 5 community cards are down!");

            }
        }
    }
    public void menu(ArrayList<ArrayList<Card>> Players, int playernum) {
        Scanner scanner = new Scanner(System.in);
        int playerbet;


        System.out.println("Choose an option:" +
                "\n1.) View Cards" +
                "\n2.) Add Money to Pot" +
                "\n3.) Check" +
                "\n4.) Fold" +
                "\n5.) Pass Play");

        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            if (playernum >= 0 && playernum < Players.size()) {
                ArrayList<Card> currentPlayer = Players.get(playernum);
                System.out.println("Player " + (playernum + 1) + "'s Cards:");
                System.out.println("---------------");
                System.out.println(currentPlayer.get(0));
                System.out.println(currentPlayer.get(1));
                System.out.println("---------------");
                menu(Players, playernum);

            }

        }

        if (choice.equals("2")) {
            if (playernum >= 0 && playernum < Players.size()) {
                System.out.println("Player " + (playernum + 1) + ", add your bet: \nPot: $" + pot + " Minimum Bet: $" + minBet);
                playerbet = scanner.nextInt();
                if (playerbet >= minBet) {
                    minBet = playerbet;
                    pot += playerbet;
                    System.out.println("Pot: $" + pot + "\nMinimum Bet: $" + minBet);
                    menu(Players, playernum);

                } else {
                    System.out.println("You must bet greater than or equal to: " + minBet);
                    menu(Players, playernum);
                }


            }


        }

        if (choice.equals("3")) {
            if (bettingRound <= 1) {
                System.out.println("Can't Check");
            }

        }

        if (choice.equals("4")) {
            if (playernum >= 0 && playernum < Players.size()) {
                Players.remove(playernum);
                //playerCount--;
                menu(Players, playernum);
            }
        }

    }
}