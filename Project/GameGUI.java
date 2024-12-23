package se.liu.denjo163_anthu456;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI {
    private static final int DELAY = 50;
    private JFrame mainFrame;
    private Game game = null;
    private JButton startButton;
    private JComboBox<Difficulty> difficultySelector;
    private static final int GAME_WIDTH = 870, GAME_HEIGHT = 580;

    public GameGUI() {
        mainFrame = new JFrame("Pong Game");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) (screenSize.width * 0.645);
        int screenHeight = (int) (screenSize.height * 0.775);

        mainFrame.setSize(screenWidth, screenHeight);
        mainFrame.setMinimumSize(new Dimension((int) (screenSize.width * 0.6), (int) (screenSize.height * 0.6)));
        mainFrame.setMaximumSize(new Dimension((int) (screenSize.width * 0.9), (int) (screenSize.height * 0.9)));
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        mainFrame.add(topPanel, BorderLayout.NORTH);

        Difficulty[] difficultyLevels = Difficulty.values();
        difficultySelector = new JComboBox<>(difficultyLevels);
        difficultySelector.setSelectedIndex(0);
        topPanel.add(difficultySelector);

        startButton = new JButton("Start");
        topPanel.add(startButton);

        JLabel pongLabel = new JLabel("Welcome to Pong Game!  First to 5 points wins", SwingConstants.CENTER);
        pongLabel.setFont(new Font("Arial", Font.BOLD, 30));
        mainFrame.add(pongLabel, BorderLayout.CENTER);

        Timer[] timer = {new Timer(DELAY, null)};

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Difficulty selectedDifficulty = (Difficulty) difficultySelector.getSelectedItem();

                for (Component component : mainFrame.getContentPane().getComponents()) {
                    if (component instanceof Game) {   //It isn't a chain of instanceof's and cant be removed
                        mainFrame.remove(component);    //it just removes every active instance of the game class
                    }
                }

                game = new Game(
                        selectedDifficulty.getAiPaddleVelocity(),
                        selectedDifficulty.getPlayerPaddleVelocity(),
                        selectedDifficulty.getBallVelocity()
                );

                if (selectedDifficulty == Difficulty.MULTIPLE_BALLS) {
                    BallMaker ball2 = new BallMaker(GAME_WIDTH / 2, 2 * GAME_HEIGHT / 3, -5, -5, 15, Color.CYAN);
                    game.addBall(ball2);
                }

                game.setGameOverCallback(this::gameOver);
                mainFrame.add(game, BorderLayout.CENTER);
                game.requestFocus();
                mainFrame.revalidate();
                mainFrame.repaint();

                game.startGame();

                startButton.setVisible(false);
                difficultySelector.setVisible(false);

                timer[0].stop();

                timer[0] = new Timer(DELAY, actionEvent -> {
                    if (game.getIsRunning()) {
                        game.updateGame();
                        game.repaint();
                    }
                });
                timer[0].start();
            }

            private void gameOver(boolean playerWon) {
                game.stopGame();
                String winnerMessage = playerWon ? "Player won the game!" : "Ai won the game!";
                JOptionPane.showMessageDialog(mainFrame, winnerMessage, "Game Over", JOptionPane.INFORMATION_MESSAGE);
                SwingUtilities.invokeLater(() -> {
                    game.resetGame();
                    mainFrame.remove(game);
                    mainFrame.revalidate();
                    mainFrame.repaint();
                    difficultySelector.setVisible(true);
                    startButton.setVisible(true);
                });
            }
        });

        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameGUI::new);
    }
}
