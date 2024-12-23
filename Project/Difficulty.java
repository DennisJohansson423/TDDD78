package se.liu.denjo163_anthu456;

public enum Difficulty {
    EASY(2, 4, 2),
    MEDIUM(4, 4, 3),
    HARD(6, 4, 4),
    MULTIPLE_BALLS(8, 6, 2);

    private final int aiPaddleVelocity;
    private final int playerPaddleVelocity;
    private final int ballVelocity;

    Difficulty(int aiPaddleVelocity, int playerPaddleVelocity, int ballVelocity) {
	this.aiPaddleVelocity = aiPaddleVelocity;
	this.playerPaddleVelocity = playerPaddleVelocity;
	this.ballVelocity = ballVelocity;
    }

    public int getAiPaddleVelocity() {
	return aiPaddleVelocity;
    }

    public int getPlayerPaddleVelocity() {
	return playerPaddleVelocity;
    }

    public int getBallVelocity() {
	return ballVelocity;
    }
}
