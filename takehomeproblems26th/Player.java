package takehomeproblems26th;

public class Player
{
    private String name;
    private int chips;
    private int bet;

    public Player(String n)
    {
        name = n;
        chips = 100;
        bet = 0;
    }

    public void setBet(int b)
    {
        if (chips >= b)
            bet = b;
        else
            bet = chips;

        chips -= bet;
    }

    public int getBet()
    {
        return bet;
    }

    public void winBet(int b)
    {
        chips += b;
    }

    public void loseBet(int b)
    {
        chips -= b;
    }

    public String getName()
    {
        return name;
    }

    public int getChips()
    {
        return chips;
    }
}
