package takehomeproblems26th;

import java.util.ArrayList;
import java.util.List;

public class Mankatha {

public static void main(String[] args) {
    
    // create deck
    Deck deck = new Deck();
    
    // create players
    List<Player> players = new ArrayList<Player>();
    players.add(new Player(5, "8 of Spades", "in"));
    players.add(new Player(5, "8 of Spades", "out"));
    
    // create and play game
    Game game = new Game(players, deck);
    game.play();
}
}