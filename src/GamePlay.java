
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GamePlay extends JPanel implements KeyListener,ActionListener{

    private final int[] snakeXLength = new int[750];
    private final int[] snakeYLength = new int[750];
    
    private boolean left =false;
    private boolean right =false;
    private boolean up =false;
    private boolean down =false;
    
    private ImageIcon rightmouth;
    private ImageIcon upmouth;
    private ImageIcon downmouth;
    private ImageIcon leftmouth;
    
    private int snakeLen =3;
    private final Timer timer;
    private final int delay = 100;
    private  int moves=0;
    private int score=0;
    
    private ImageIcon snakeImage;
    private ImageIcon titleImage;
    private ImageIcon enemyImage;
    
    
    
    private final int[] enemyXPos={25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,
                            525,550,575,600,625,650,675,700,725,750,775,800,825,850};
    private final int[] enemyYPos={75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,
                            525,550,575,600,625};
    
    private final Random random = new Random();
    private int xpos = random.nextInt(34);
    private int ypos = random.nextInt(23);
    
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
        
        //score
        g.setColor(Color.white);
        g.setFont(new Font("arial",Font.PLAIN, 14));
        g.drawString("Score: "+score, 780, 30);
        
        //len of snake
        g.setColor(Color.white);
        g.setFont(new Font("arial",Font.PLAIN, 14));
        g.drawString("Length: "+snakeLen, 780, 50);
        
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
        
        enemyImage = new ImageIcon("/home/shubham/NetBeansProjects/SnakeGame/src/image/enemy.png");
        if(enemyXPos[xpos]==snakeXLength[0] && enemyYPos[ypos]==snakeYLength[0]){
            snakeLen++;
            score++;
            xpos = random.nextInt(34);
            ypos = random.nextInt(23);
        }
        enemyImage.paintIcon(this, g, enemyXPos[xpos], enemyYPos[ypos]);
        
        for(int i=1;i<snakeLen;i++){
            if(snakeXLength[i]==snakeXLength[0] && snakeYLength[i]==snakeYLength[0]){
                right=false;
                left=false;
                up=false;
                down=false;
                g.setColor(Color.white);
                g.setFont(new Font("arial",Font.BOLD, 50));
                g.drawString("Game over:", 300, 300);
                
                g.setColor(Color.white);
                g.setFont(new Font("arial",Font.BOLD, 20));
                g.drawString("Press space bar RESTRAT:", 350, 340);
            }
        }
        g.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            moves =0;
            score=0;
            snakeLen=3;
            repaint();
        }
        
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            moves++;
            right = true;
            if(!left)
                right=true;
            else{
                right=false;
                left=true;
            }
            up=false;
            down=false;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            moves++;
            left = true;
            if(!right)
                left=true;
            else{
                left=false;
                right=true;
            }
            up=false;
            down=false;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            moves++;
            up = true;
            if(!down)
                up=true;
            else{
                up=false;
                down=true;
            }
            right=false;
            left=false;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            moves++;
            down = true;
            if(!up)
                down=true;
            else{
                down=false;
                up=true;
            }
            right=false;
            left=false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if(right){
            for(int i=snakeLen-1;i>=0;i--){
                snakeYLength[i+1] = snakeYLength[i];
            }
            for(int i=snakeLen;i>=0;i--){
                if(i==0){
                    snakeXLength[i] = snakeXLength[i]+25;
                }
                else
                    snakeXLength[i]= snakeXLength[i-1];
                if(snakeXLength[i]>850)
                    snakeXLength[i]=25;
            }
            repaint();
        }
        if(left){
            for(int i=snakeLen-1;i>=0;i--){
                snakeYLength[i+1] = snakeYLength[i];
            }
            for(int i=snakeLen;i>=0;i--){
                if(i==0){
                    snakeXLength[i] = snakeXLength[i]-25;
                }
                else
                    snakeXLength[i]= snakeXLength[i-1];
                if(snakeXLength[i]<25)
                    snakeXLength[i]=850;
            }
            repaint();
        }
        if(up){
            for(int i=snakeLen-1;i>=0;i--){
                snakeXLength[i+1] = snakeXLength[i];
            }
            for(int i=snakeLen;i>=0;i--){
                if(i==0){
                    snakeYLength[i] = snakeYLength[i]-25;
                }
                else
                    snakeYLength[i]= snakeYLength[i-1];
                if(snakeYLength[i]<75)
                    snakeYLength[i]=625;
            }
            repaint();
        }
        if(down){
            for(int i=snakeLen-1;i>=0;i--){
                snakeXLength[i+1] = snakeXLength[i];
            }
            for(int i=snakeLen;i>=0;i--){
                if(i==0){
                    snakeYLength[i] = snakeYLength[i]+25;
                }
                else
                    snakeYLength[i]= snakeYLength[i-1];
                if(snakeYLength[i]>625)
                    snakeYLength[i]=75;
            }
            repaint();
        }
    }
}
