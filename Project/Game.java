package se.liu.denjo163_anthu456;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Game extends JPanel implements MouseMotionListener, Runnable {
    private static final int GAME_WIDTH = 870, GAME_HEIGHT = 580;
    private static final int BALL_DIAMETER = 15;
    private static final int WIN_CONDITION = 5;
    private static final int GAME_X = 30, GAME_Y = 20;
    private static final int SCORE_Y_POSITION = 16;
    private static final int PADDLE_RIGHT_X_POSITION = GAME_WIDTH - 15;
    private static final int TOP_EDGE = 25;
    private static final int UPPER_BOUND = 20, LOWER_BOUND = GAME_HEIGHT + UPPER_BOUND;
    private static final int DELAY = 30;
    private PaddleMaker paddleRight = null, paddleLeft = null;
    private int mouseY;
    private int playerScore, aiScore;
    private Consumer<Boolean> gameOverCallback = null;
    private boolean isRunning;
    private List<BallMaker> balls = new ArrayList<>();




    public void paintComponent(Graphics g) {
	g.setColor(Color.BLACK);
	g.fillRect(GAME_X, GAME_Y, GAME_WIDTH, GAME_HEIGHT);
	for (BallMaker ball : balls) {
	    ball.draw(g);
	}
	paddleRight.draw(g);
	paddleLeft.draw(g);
	g.setColor(Color.BLUE);
	String scoreText = "Player score: " + playerScore + "   AI score: " + aiScore;
	FontMetrics fontMetrics = g.getFontMetrics();
	int textWidth = fontMetrics.stringWidth(scoreText);
	int x = (GAME_WIDTH - textWidth / 2) / 2;
	g.drawString(scoreText, x, SCORE_Y_POSITION);
    }

    public void initGame(int aiPaddleVelocity, int playerPaddleVelocity, int ballVelocity) {
	balls.clear();
	balls.add(new BallMaker(GAME_WIDTH / 2, GAME_HEIGHT / 2, 5, 5, BALL_DIAMETER, Color.MAGENTA));
	paddleRight = new PaddleMaker(90, PADDLE_RIGHT_X_POSITION, GAME_HEIGHT / 2, aiPaddleVelocity, Color.RED);
	paddleLeft = new PaddleMaker(90, 50, GAME_HEIGHT / 2, playerPaddleVelocity, Color.YELLOW);
	mouseY = 0;
	playerScore = 0;
	aiScore = 0;
    }


    public Game(int aiPaddleVelocity, int playerPaddleVelocity, int ballVelocity) {
	isRunning = true;
	initGame(aiPaddleVelocity, playerPaddleVelocity, ballVelocity);
	addMouseMotionListener(this);
    }

    public void addBall(BallMaker ball) {
	balls.add(ball);
    }

    public void updateGame() {
	for (BallMaker ball : balls) {
	    ball.move();
	    ball.bounce(TOP_EDGE, LOWER_BOUND);
	}

	paddleLeft.movePaddle(mouseY, UPPER_BOUND, LOWER_BOUND);

	BallMaker closestBall = null;
	int closestDistance = Integer.MAX_VALUE;

	for (BallMaker ball : balls) {
	    int distance = Math.abs(ball.position.y - paddleRight.position.y);
	    if (distance < closestDistance) {
		closestBall = ball;
		closestDistance = distance;
	    }
	}

	if (closestBall != null) {
	    paddleRight.movePaddle(closestBall.position.y, UPPER_BOUND, LOWER_BOUND);
	}

	for (BallMaker ball : balls) {
	    Rectangle ballBounds = new Rectangle(ball.position.x, ball.position.y, BALL_DIAMETER, BALL_DIAMETER);
	    Rectangle rightPaddleBounds = new Rectangle(paddleRight.position.x, paddleRight.position.y, 10, 90);
	    Rectangle leftPaddleBounds = new Rectangle(paddleLeft.position.x, paddleLeft.position.y, 10, 90);

	    if (ballBounds.intersects(rightPaddleBounds) || ballBounds.intersects(leftPaddleBounds)) {
		ball.bounce('x');
	    }

	    if (ball.position.x < getLeftGoalLine()) {
		aiScore++;
		checkAndHandleGameOver(aiScore, false);
		restart();
	    } else if (ball.position.x > getRightGoalLine()) {
		playerScore++;
		checkAndHandleGameOver(playerScore, true);
		restart();
	    }
	}
    }

    private void checkAndHandleGameOver(int score, boolean playerWon) {
	if (score >= WIN_CONDITION) {
	    resetGame();
	    gameOverCallback.accept(playerWon);
	}
    }



    public void restart() {
	for (BallMaker ball : balls) {
	    ball.position.x = 300;
	    ball.position.y = 200;
	}
    }

    public void resetGame() {
	initGame(paddleRight.velocity, paddleLeft.velocity, balls.get(0).velocity.x);
    }

    public void startGame() {
	isRunning = true;
    }

    public void stopGame() {
	isRunning = false;
    }

    public boolean getIsRunning() {
	return isRunning;
    }

    public int getLeftGoalLine() {
	return BALL_DIAMETER + BALL_DIAMETER;
    }

    public int getRightGoalLine() {
	return GAME_WIDTH + BALL_DIAMETER;
    }

    public void setGameOverCallback(Consumer<Boolean> gameOverCallback) {
	this.gameOverCallback = gameOverCallback;
    }

    @Override
    public void run() {
	Timer timer = new Timer(DELAY, e -> {
	    updateGame();
	    repaint();
	});
	timer.start();
    }

    @Override
    public void mouseDragged(final MouseEvent e) {
    }

    @Override
    public void mouseMoved(final MouseEvent e) {
	mouseY = e.getY();
    }
}
