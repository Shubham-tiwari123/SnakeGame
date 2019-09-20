
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Variables {
    private ImageIcon titleImage;
    private int score;
    private int snakeLen;
    private int moves;
    private Timer timer=null;
    private int delay;

    public final int[] snakeXLength = new int[750];
    public final int[] snakeYLength = new int[750];
    
    private boolean left =false;
    private boolean right =false;
    private boolean up =false;
    private boolean down =false;
    
    private ImageIcon rightmouth;
    private ImageIcon upmouth;
    private ImageIcon downmouth;
    private ImageIcon leftmouth;
    private ImageIcon snakeImage;
    private ImageIcon enemyImage;
    
    private final int[] enemyXPos={25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,
                            525,550,575,600,625,650,675,700,725,750,775,800,825,850};
    private final int[] enemyYPos={75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,
                            525,550,575,600,625};
    
    private final Random random = new Random();
    private int xpos = random.nextInt(34);
    private int ypos = random.nextInt(23);

    public int[] getEnemyXPos() {
        return enemyXPos;
    }

    public int[] getEnemyYPos() {
        return enemyYPos;
    }

    public Random getRandom() {
        return random;
    }

    
    
    public ImageIcon getEnemyImage() {
        return enemyImage;
    }

    public void setEnemyImage(ImageIcon enemyImage) {
        this.enemyImage = enemyImage;
    }

    public int getXpos() {
        return xpos;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }
    
    
    
    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getMoves() {
        return moves;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }
    
    public int[] getSnakeXLength() {
        return snakeXLength;
    }

    public int[] getSnakeYLength() {
        return snakeYLength;
    }
    
    public ImageIcon getSnakeImage() {
        return snakeImage;
    }

    public void setSnakeImage(ImageIcon snakeImage) {
        this.snakeImage = snakeImage;
    }
    
    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public ImageIcon getRightmouth() {
        return rightmouth;
    }

    public void setRightmouth(ImageIcon rightmouth) {
        this.rightmouth = rightmouth;
    }

    public ImageIcon getUpmouth() {
        return upmouth;
    }

    public void setUpmouth(ImageIcon upmouth) {
        this.upmouth = upmouth;
    }

    public ImageIcon getDownmouth() {
        return downmouth;
    }

    public void setDownmouth(ImageIcon downmouth) {
        this.downmouth = downmouth;
    }

    public ImageIcon getLeftmouth() {
        return leftmouth;
    }

    public void setLeftmouth(ImageIcon leftmouth) {
        this.leftmouth = leftmouth;
    }

    public int getSnakeLen() {
        return snakeLen;
    }

    public void setSnakeLen(int snakeLen) {
        this.snakeLen = snakeLen;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ImageIcon getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(ImageIcon titleImage) {
        this.titleImage = titleImage;
    }
}
