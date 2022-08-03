package takehomeproblems26th;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Card
{
    private String suit;
    private int value;

    public Card(String s, int v)
    {
        suit = s;
        value = v;
    }

    public String getSuit()
    {
        return suit;
    }

    public int getValue()
    {
        return value;
    }
}

    private static String[] suit = {"Spades", "Diamonds", "Hearts", "Clubs"};
    private static String[] value = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
}