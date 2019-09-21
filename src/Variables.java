
import java.awt.Graphics;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Variables {
    static private ImageIcon titleImage;
    static private int score;
    static private int snakeLen;
    static private int moves;
    static private Timer timer=null;
    static private Graphics graphics=null;

    public static Graphics getGraphics() {
        return graphics;
    }

    public static void setGraphics(Graphics graphics) {
        Variables.graphics = graphics;
    }
    static private int delay;

    static public final int[] snakeXLength = new int[750];
    static public final int[] snakeYLength = new int[750];
    
    static private boolean left =false;
    static private boolean right =false;
    static private boolean up =false;
    static private boolean down =false;
    
    static private ImageIcon rightmouth;
    static private ImageIcon upmouth;
    static private ImageIcon downmouth;
    static private ImageIcon leftmouth;
    static private ImageIcon snakeImage;
    static private ImageIcon enemyImage;
    
    static private final int[] enemyXPos={25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,
                            525,550,575,600,625,650,675,700,725,750,775,800,825,850};
    static private final int[] enemyYPos={75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,
                            525,550,575,600,625};
    
    static private final Random random = new Random();
    static private int xpos = random.nextInt(34);
    static private int ypos = random.nextInt(23);
    
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
        Variables.enemyImage = enemyImage;
    }

    public int getXpos() {
        return xpos;
    }

    public void setXpos(int xpos) {
        Variables.xpos = xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public void setYpos(int ypos) {
        Variables.ypos = ypos;
    }
    
    
    
    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        Variables.timer = timer;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        Variables.delay = delay;
    }

    public int getMoves() {
        return moves;
    }

    public void setMoves(int moves) {
        Variables.moves = moves;
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
        Variables.snakeImage = snakeImage;
    }
    
    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        Variables.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        Variables.right = right;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        Variables.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        Variables.down = down;
    }

    public ImageIcon getRightmouth() {
        return rightmouth;
    }

    public void setRightmouth(ImageIcon rightmouth) {
        Variables.rightmouth = rightmouth;
    }

    public ImageIcon getUpmouth() {
        return upmouth;
    }

    public void setUpmouth(ImageIcon upmouth) {
        Variables.upmouth = upmouth;
    }

    public ImageIcon getDownmouth() {
        return downmouth;
    }

    public void setDownmouth(ImageIcon downmouth) {
        Variables.downmouth = downmouth;
    }

    public ImageIcon getLeftmouth() {
        return leftmouth;
    }

    public void setLeftmouth(ImageIcon leftmouth) {
        Variables.leftmouth = leftmouth;
    }

    public int getSnakeLen() {
        return snakeLen;
    }

    public void setSnakeLen(int snakeLen) {
        Variables.snakeLen = snakeLen;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        Variables.score = score;
    }

    public ImageIcon getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(ImageIcon titleImage) {
        Variables.titleImage = titleImage;
    }
}
