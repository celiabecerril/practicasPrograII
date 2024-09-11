class Game {
    private Player[] players = new Player[2];
    private int[] scores = new int[2];
    private int numberOfRounds = 7;

    public Game(String name1, String name2) {
        this.players[0] = new Player(name1);
        this.players[1] = new Player(name2);
    }

    public void play() {
        for (int round = 0; round < numberOfRounds; round++) {
            players[0].choose();
            players[1].choose();
            System.out.println("[" + players[0].name() + "] saca [" + players[0].choice() + "] / [" + players[1].name() + "] saca [" + players[1].choice() + "]");

            if (players[0].choice().equals(players[1].choice())) {
                System.out.println("> Empate");
            } else if (players[0].beats(players[1])) {
                System.out.println("> Gana " + players[0].name());
                scores[0]++;
            } else {
                System.out.println("> Gana " + players[1].name());
                scores[1]++;
            }
        }

        System.out.println("Jugador " + players[0].name() + "\n" + scores[0] + " puntos...");
        System.out.println("Jugador " + players[1].name() + "\n" + scores[1] + " puntos...");
    }
}
