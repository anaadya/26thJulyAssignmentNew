package takehomeproblems26th;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Game
{
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        System.out.println("Welcome to Mankatha!");

        ArrayList<Player> players = new ArrayList<Player>();

        System.out.print("Enter number of players: ");
        int numPlayers = kb.nextInt();
        kb.nextLine();

        for (int a = 1; a <= numPlayers; a++)
        {
            System.out.print("Enter name of Player " + a + ": ");
            players.add(new Player(kb.nextLine()));
        }

        Deck deck = new Deck();
        Random rand = new Random();
        int currentPlayer = rand.nextInt(numPlayers);
        System.out.println("\n" + players.get(currentPlayer).getName() + " will be the host.");
        int currentBet = 0;

        ArrayList<Integer> bets = new ArrayList<Integer>();
        for (int a = 0; a < numPlayers; a++)
        {
            if (a == currentPlayer)
                continue;

            System.out.println("\n" + players.get(a).getName() + "'s turn to bet");
            System.out.print("Place your bet: ");
            bets.add(kb.nextInt());
            kb.nextLine();
        }

        currentBet = Collections.max(bets);
        System.out.println("\nThe bet is " + currentBet + "\n");

        for (int a = 0; a < numPlayers; a++)
        {
            if (bets.get(a) != currentBet)
            {
                System.out.println(players.get(a).getName() + " has quit the game.");
                players.remove(a);
                bets.remove(a);
                a--;
            }
        }

        numPlayers = players.size();

        for (int a = 0; a < numPlayers; a++)
        {
            if (a == currentPlayer)
                continue;

            players.get(a).setBet(currentBet);
            System.out.println(players.get(a).getName() + " has placed their bet.");
        }

        for (int a = 0; a < numPlayers; a++)
        {
            if (a == currentPlayer)
                continue;

            System.out.println("\n" + players.get(a).getName() + "'s turn to select a card");
            System.out.print("Enter the value of the card you wish to select (1-13): ");
            int cardValue = kb.nextInt();
            kb.nextLine();
            System.out.print("Enter the suit of the card you wish to select (1-4): ");
            int cardSuit = kb.nextInt();
            kb.nextLine();

            System.out.print("Enter the orientation you wish to bet on (1 for in, 2 for out): ");
            int orient = kb.nextInt();
            kb.nextLine();

            if (orient == 1)
                System.out.println(players.get(a).getName() + " has selected the " + value[cardValue - 1] + " of " + suit[cardSuit - 1] + " and has bet on in.");
            else
                System.out.println(players.get(a).getName() + " has selected the " + value[cardValue - 1] + " of " + suit[cardSuit - 1] + " and has bet on out.");
        }

        System.out.println();

        int inCount = 0;
        int outCount = 0;
        int topCard = 0;
        String topSuit = "";
        int winner = -1;

        for (int a = 0; a < 52; a++)
        {
            if (deck.isEmpty())
                break;

            topCard = deck.deal().getValue();
            topSuit = deck.deal().getSuit();

            if (a % 2 == 0)
            {
                inCount++;
                System.out.println("The " + value[topCard - 1] + " of " + topSuit + " has been placed in.");
            }
            else
            {
                outCount++;
                System.out.println("The " + value[topCard - 1] + " of " + topSuit + " has been placed out.");
            }

            for (int b = 0; b < numPlayers; b++)
            {
                if (b == currentPlayer)
                    continue;

                if (players.get(b).getBet() != 0 && players.get(b).getBet() == currentBet)
                {
                    if (orient == 1 && inCount == cardValue)
                    {
                        winner = b;
                        break;
                    }
                    else if (orient == 2 && outCount == cardValue)
                    {
                        winner = b;
                        break;
                    }
                }
            }

            if (winner != -1)
                break;
        }

        if (winner == -1)
        {
            currentPlayer = 0;
            System.out.println(players.get(currentPlayer).getName() + " wins the round and is the new host.");
            players.get(currentPlayer).winBet(currentBet * (numPlayers - 1));

            for (int a = 1; a < numPlayers; a++)
                players.get(a).loseBet(currentBet);
        }
        else
        {
            currentPlayer = winner;
            System.out.println(players.get(currentPlayer).getName() + " wins the round and is the new host.");
            players.get(currentPlayer).winBet(currentBet * (numPlayers - 1));

            for (int a = 0; a < numPlayers; a++)
            {
                if (a == currentPlayer)
                    continue;

                players.get(a).loseBet(currentBet);
            }
        }

        while (true)
        {
            System.out.println("\nThe current host is " + players.get(currentPlayer).getName() + ".");

            for (int a = 0; a < numPlayers; a++)
                System.out.println(players.get(a).getName() + " has " + players.get(a).getChips() + " chips.");

            System.out.println();
            System.out.print("Enter 1 to continue playing, 2 to quit: ");
            int choice = kb.nextInt();
            kb.nextLine();

            if (choice == 2)
                break;

            for (int a = 0; a < numPlayers; a++)
                players.get(a).setBet(0);

            currentBet = 0;
            winner = -1;

            bets.clear();

            for (int a = 0; a < numPlayers; a++)
            {
                if (a == currentPlayer)
                    continue;

                System.out.println("\n" + players.get(a).getName() + "'s turn to bet");
                System.out.print("Place your bet: ");
                bets.add(kb.nextInt());
                kb.nextLine();
            }

            currentBet = Collections.max(bets);
            System.out.println("\nThe bet is " + currentBet + "\n");

            for (int a = 0; a < numPlayers; a++)
            {
                if (bets.get(a) != currentBet)
                {
                    System.out.println(players.get(a).getName() + " has quit the game.");
                    players.remove(a);
                    bets.remove(a);
                    a--;
                }
            }

            numPlayers = players.size();

            for (int a = 0; a < numPlayers; a++)
            {
                if (a == currentPlayer)
                    continue;

                players.get(a).setBet(currentBet);
                System.out.println(players.get(a).getName() + " has placed their bet.");
            }

            for (int a = 0; a < numPlayers; a++)
            {
                if (a == currentPlayer)
                    continue;

                System.out.println("\n" + players.get(a).getName() + "'s turn to select a card");
                System.out.print("Enter the value of the card you wish to select (1-13): ");
                int cardValue = kb.nextInt();
                kb.nextLine();
                System.out.print("Enter the suit of the card you wish to select (1-4): ");
                int cardSuit = kb.nextInt();
                kb.nextLine();

                System.out.print("Enter the orientation you wish to bet on (1 for in, 2 for out): ");
                int orient = kb.nextInt();
                kb.nextLine();

                if (orient == 1)
                    System.out.println(players.get(a).getName() + " has selected the " + value[cardValue - 1] + " of " + suit[cardSuit - 1] + " and has bet on in.");
                else
                    System.out.println(players.get(a).getName() + " has selected the " + value[cardValue - 1] + " of " + suit[cardSuit - 1] + " and has bet on out.");
            }

            System.out.println();

            inCount = 0;
            outCount = 0;
            topCard = 0;
            topSuit = "";

            for (int a = 0; a < 52; a++)
            {
                if (deck.isEmpty())
                    break;

                topCard = deck.deal().getValue();
                topSuit = deck.deal().getSuit();

                if (a % 2 == 0)
                {
                    inCount++;
                    System.out.println("The " + value[topCard - 1] + " of " + topSuit + " has been placed in.");
                }
                else
                {
                    outCount++;
                    System.out.println("The " + value[topCard - 1] + " of " + topSuit + " has been placed out.");
                }

                for (int b = 0; b < numPlayers; b++)
                {
                    if (b == currentPlayer)
                        continue;

                    if (players.get(b).getBet() != 0 && players.get(b).getBet() == currentBet)
                    {
                        if (orient == 1 && inCount == cardValue)
                        {
                            winner = b;
                            break;
                        }
                        else if (orient == 2 && outCount == cardValue)
                        {
                            winner = b;
                            break;
                        }
                    }
                }

                if (winner != -1)
                    break;
            }

            if (winner == -1)
            {
                currentPlayer = 0;
                System.out.println(players.get(currentPlayer).getName() + " wins the round and is the new host.");
                players.get(currentPlayer).winBet(currentBet * (numPlayers - 1));

                for (int a = 1; a < numPlayers; a++)
                    players.get(a).loseBet(currentBet);
            }
            else
            {
                currentPlayer = winner;
                System.out.println(players.get(currentPlayer).getName() + " wins the round and is the new host.");
                players.get(currentPlayer).winBet(currentBet * (numPlayers - 1));

                for (int a = 0; a < numPlayers; a++)
                {
                    if (a == currentPlayer)
                        continue;

                    players.get(a).loseBet(currentBet);
                }
            }
        }

        System.out.println("\nThanks for playing!");
    }