
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GamePlay extends JPanel implements KeyListener,ActionListener{

    private int[] snakeXLength = new int[750];
    private int[] snakeYLength = new int[750];
    
    private boolean left =false;
    private boolean right =false;
    private boolean up =false;
    private boolean down =false;
    
    private ImageIcon rightmouth;
    private ImageIcon upmouth;
    private ImageIcon downmouth;
    private ImageIcon leftmouth;
    
    private int snakeLen =3;
    private Timer timer;
    private int delay = 100;
    private  int moves=0;
    
    private ImageIcon snakeImage;
    private ImageIcon titleImage;
    
    public GamePlay() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }
    
    @Override
    public void paint(Graphics g){
        
        if(moves==0){
            snakeXLength[2]=50;
            snakeXLength[1]=75;
            snakeXLength[0] = 100;
            
            snakeYLength[2]=100;
            snakeYLength[1]=100;
            snakeYLength[0] = 100;
        }
        g.setColor(Color.white);
        g.drawRect(24, 10, 851, 55);
        
        //title imaage
        titleImage = new ImageIcon("/home/shubham/NetBeansProjects/SnakeGame/src/image/snaketitle.jpg");
        titleImage.paintIcon(this, g, 25, 11);
        g.setColor(Color.WHITE);
        g.drawRect(24, 74, 851, 577);
        g.setColor(Color.black);
        g.fillRect(25, 75, 850, 575);
        
        rightmouth = new ImageIcon("/home/shubham/NetBeansProjects/SnakeGame/src/image/rightmouth.png");
        rightmouth.paintIcon(this, g, snakeXLength[0], snakeYLength[0]);
        
        for(int i=0;i<snakeLen;i++){
            if(i==0 && right){
                rightmouth = new ImageIcon("/home/shubham/NetBeansProjects/SnakeGame/src/image/rightmouth.png");
                rightmouth.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
            }
            if(i==0 && left){
                leftmouth = new ImageIcon("/home/shubham/NetBeansProjects/SnakeGame/src/image/leftmouth.png");
                leftmouth.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
            }
            if(i==0 && down){
                downmouth = new ImageIcon("/home/shubham/NetBeansProjects/SnakeGame/src/image/downmouth.png");
                downmouth.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
            }
            if(i==0 && up){
                upmouth = new ImageIcon("/home/shubham/NetBeansProjects/SnakeGame/src/image/upmouth.png");
                upmouth.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
            }
            if(i!=0){
                snakeImage = new ImageIcon("/home/shubham/NetBeansProjects/SnakeGame/src/image/snakeimage.png");
                snakeImage.paintIcon(this, g, snakeXLength[i], snakeYLength[i]);
            }
        }
        
        g.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
