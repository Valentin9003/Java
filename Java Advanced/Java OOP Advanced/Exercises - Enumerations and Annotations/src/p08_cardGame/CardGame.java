package p08_cardGame;

public class CardGame {

    private Player firstPlayer;
    private Player secondPlayer;

    public CardGame(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public Player getWinner() {
        return this.firstPlayer.getHighestPoweredCard()
                .compareTo(this.secondPlayer.getHighestPoweredCard()) > 0 ?
                this.firstPlayer : this.secondPlayer;
    }

}
