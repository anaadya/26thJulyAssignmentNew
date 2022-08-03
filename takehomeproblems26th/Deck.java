package takehomeproblems26th;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;




public class Deck
{
    private ArrayList<Card> cards;

    public Deck()
    {
        cards = new ArrayList<Card>();

        for (int a = 0; a < 4; a++)
        {
            for (int b = 0; b < 13; b++)
            {
                cards.add(new Card(suit[a], value[b]));
            }
        }

        Collections.shuffle(cards, new Random());
    }

    public int size()
    {
        return cards.size();
    }

    public boolean isEmpty()
    {
        return cards.size() == 0;
    }

    public Card deal()
    {
        if (isEmpty())
            return null;
        return cards.remove(0);
    }

    public void reset()
    {
        cards.clear();

        for (int a = 0; a < 4; a++)
        {
            for (int b = 0; b < 13; b++)
            {
                cards.add(new Card(suit[a], value[b]));
            }
        }

        Collections.shuffle(cards, new Random());
    }
}
