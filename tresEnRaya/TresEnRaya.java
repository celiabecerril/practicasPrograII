package tresEnRaya;

import java.util.Scanner;

class TicTacToe {

    public static void main(String[] args) {
        Board board = new Board();
        board.displayBoard();
        Player player1 = new Player("X");
        Player player2 = new Player("O");
        Game game = new Game(player1, player2, board);
        game.startGame();
    }
}

class Board {

    private String[][] board = new String[3][3];

    public Board() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = " ";
            }
        }
    }

    public void displayBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.print(" ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(" " + board[i][j] + " ");
                if (j < board[i].length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < board.length - 1) {
                System.out.println("-----------");
            }
        }
        System.out.println();
    }

    public String boardElement(int i, int j) {
        return board[i][j];
    }

    public void setBoardElement(int i, int j, String symbol) {
        board[i][j] = symbol;
    }

    public void updateBoard(int i, int j, Object object) {
        board[i][j] = (String) object;
    }

    public boolean isValidMove(int i, int j) {
        return board[i][j].equals(" ");
    }

}

class Player {
    private String symbol;
    private Scanner scanner;

    public Player(String symbol) {
        this.symbol = symbol;
        this.scanner = new Scanner(System.in);
    }

    public String symbol() {
        return symbol;
    }

    public int[] makeMove() {
        System.out.println("Player " + symbol + "'s turn");
        System.out.print("Enter the row (0-2): ");
        int row = scanner.nextInt();
        System.out.print("Enter the column (0-2): ");
        int column = scanner.nextInt();
        return new int[] { row, column };
    }

    public Object symbolObject() {
        return symbol;
    }

    public int[] makeOldMove() {
        System.out.println("Player " + symbol() + "'s turn");
        System.out.print("Enter the row of the piece you want to move (0-2): ");
        int row = scanner.nextInt();
        System.out.print("Enter the column of the piece you want to move (0-2): ");
        int column = scanner.nextInt();
        return new int[] { row, column };
    }
}

class Game {
    private Player player1;
    private Player player2;
    private Board board;
    private Player currentPlayer;

    public Game(Player player1, Player player2, Board board) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.currentPlayer = player1;
    }

    public void startGame() {
        int counter = 0;
        boolean gameEnded = false;
        while (!gameEnded) {
            int[] move = currentPlayer.makeMove();
            if (board.isValidMove(move[0], move[1])) {
                board.updateBoard(move[0], move[1], currentPlayer.symbolObject());
                board.displayBoard();
                if (isWinner()) {
                    System.out.println("Player " + currentPlayer.symbol() + " wins!");
                    gameEnded = true;
                }
                counter++;
                if (counter == 9) {
                    System.out.println("It's a draw!");
                    gameEnded = true;
                }
                switchTurn();
            } else {
                System.out.println("Invalid move, try again.");
            }
        }
    }

    private void switchTurn() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    private boolean isWinner() {

        for (int i = 0; i < 3; i++) {
            if (board.boardElement(i, 0).equals(currentPlayer.symbol())
                    && board.boardElement(i, 1).equals(currentPlayer.symbol())
                    && board.boardElement(i, 2).equals(currentPlayer.symbol())) {
                return true;
            }
            if (board.boardElement(0, i).equals(currentPlayer.symbol())
                    && board.boardElement(1, i).equals(currentPlayer.symbol())
                    && board.boardElement(2, i).equals(currentPlayer.symbol())) {
                return true;
            }
        }
        if (board.boardElement(0, 0).equals(currentPlayer.symbol())
                && board.boardElement(1, 1).equals(currentPlayer.symbol())
                && board.boardElement(2, 2).equals(currentPlayer.symbol())) {
            return true;
        }
        if (board.boardElement(0, 2).equals(currentPlayer.symbol())
                && board.boardElement(1, 1).equals(currentPlayer.symbol())
                && board.boardElement(2, 0).equals(currentPlayer.symbol())) {
            return true;
        }
        return false;
    }

}