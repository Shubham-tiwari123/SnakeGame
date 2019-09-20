
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GamePlay extends JPanel implements KeyListener,ActionListener{
    Variables variables;
    public GamePlay(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        
        variables = new Variables();
        
        variables.setDelay(100);
        variables.setTimer(new Timer(variables.getDelay(), this));
        variables.getTimer().start();
        
        variables.setSnakeLen(3);
        variables.setMoves(0);
        variables.setDown(false);
        variables.setRight(false);
        variables.setLeft(false);
        variables.setUp(false);
    }
    
    @Override
    public void paint(Graphics g){
        createBackground(g);
        setScore(g);
        displaySnakeLen(g);
        createSnake(g);
        createEnemy(g);
        checkGameExit(g);
        g.dispose();
    }
    
    public void createBackground(Graphics g){
        g.setColor(Color.white);
        g.drawRect(24, 10, 851, 55);
        //title imaage
        variables.setTitleImage(new ImageIcon("/home/shubham/NetBeansProjects/SnakeGame/src/image/snaketitle.jpg"));
        variables.getTitleImage().paintIcon(this, g, 25, 11);
        g.setColor(Color.WHITE);
        g.drawRect(24, 74, 851, 577);
        g.setColor(Color.black);
        g.fillRect(25, 75, 850, 575);
    }
    
    public void setScore(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("arial",Font.PLAIN, 14));
        g.drawString("Score: "+variables.getScore(), 780, 30);
    }
    
    public void displaySnakeLen(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("arial",Font.PLAIN, 14));
        g.drawString("Length: "+variables.getSnakeLen(), 780, 50);
    }
    
    public void createSnake(Graphics g){
        if(variables.getMoves()==0){
            variables.snakeXLength[2]=50;
            variables.snakeXLength[1]=75;
            variables.snakeXLength[0] = 100;
            
            variables.snakeYLength[2]=100;
            variables.snakeYLength[1]=100;
            variables.snakeYLength[0] = 100;
        }
        variables.setRightmouth(new ImageIcon("/home/shubham/NetBeansProjects/SnakeGame/src/image/rightmouth.png"));
        variables.getRightmouth().paintIcon(this, g, variables.getSnakeXLength()[0], variables.getSnakeYLength()[0]);
        
        for(int i=0;i<variables.getSnakeLen();i++){
            if(i==0 && variables.isRight()){
                variables.setRightmouth(new ImageIcon("/home/shubham/NetBeansProjects/SnakeGame/src/image/rightmouth.png"));
                variables.getRightmouth().paintIcon(this, g, variables.getSnakeXLength()[i], variables.getSnakeYLength()[i]);
            }
            if(i==0 && variables.isLeft()){
                variables.setLeftmouth(new ImageIcon("/home/shubham/NetBeansProjects/SnakeGame/src/image/leftmouth.png"));
                variables.getLeftmouth().paintIcon(this, g, variables.getSnakeXLength()[i], variables.getSnakeYLength()[i]);
            }
            if(i==0 && variables.isDown()){
                variables.setDownmouth(new ImageIcon("/home/shubham/NetBeansProjects/SnakeGame/src/image/downmouth.png"));
                variables.getDownmouth().paintIcon(this, g, variables.getSnakeXLength()[i], variables.getSnakeYLength()[i]);
            }
            if(i==0 && variables.isUp()){
                variables.setUpmouth(new ImageIcon("/home/shubham/NetBeansProjects/SnakeGame/src/image/upmouth.png"));
                variables.getUpmouth().paintIcon(this, g, variables.getSnakeXLength()[i], variables.getSnakeYLength()[i]);
            }
            if(i!=0){
                variables.setSnakeImage(new ImageIcon("/home/shubham/NetBeansProjects/SnakeGame/src/image/snakeimage.png"));
                variables.getSnakeImage().paintIcon(this, g, variables.getSnakeXLength()[i], variables.getSnakeYLength()[i]);
            }
        }
    }
    
    public void createEnemy(Graphics g){
        variables.setEnemyImage(new ImageIcon("/home/shubham/NetBeansProjects/SnakeGame/src/image/enemy.png"));
        if(variables.getEnemyXPos()[variables.getXpos()]==variables.getSnakeXLength()[0] &&
                variables.getEnemyYPos()[variables.getYpos()]==variables.getSnakeYLength()[0]){
            int snakeLen = variables.getSnakeLen();
            snakeLen = snakeLen+1;
            variables.setSnakeLen(snakeLen);
            
            int score = variables.getScore();
            score = score+1;
            variables.setScore(score);
            
            variables.setXpos(variables.getRandom().nextInt(34));
            variables.setYpos(variables.getRandom().nextInt(23));
        }
        variables.getEnemyImage().paintIcon(this, g, variables.getEnemyXPos()[variables.getXpos()], 
                variables.getEnemyYPos()[variables.getYpos()]);
    }
    
    public void checkGameExit(Graphics g){
        for(int i=1;i<variables.getSnakeLen();i++){
            if(variables.getSnakeXLength()[i]==variables.getSnakeXLength()[0] && 
                    variables.getSnakeYLength()[i]==variables.getSnakeYLength()[0]){
                variables.setRight(false);
                variables.setLeft(false);
                variables.setUp(false);
                variables.setDown(false);
                g.setColor(Color.white);
                g.setFont(new Font("arial",Font.BOLD, 50));
                g.drawString("Game over:", 300, 300);
                
                g.setColor(Color.white);
                g.setFont(new Font("arial",Font.BOLD, 20));
                g.drawString("Press space bar RESTRAT:", 350, 340);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            variables.setMoves(0);
            variables.setScore(0);
            variables.setSnakeLen(3);
            repaint();
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            int move= variables.getMoves();
            move = move+1;
            variables.setMoves(move);
            variables.setRight(true);
            if(!variables.isLeft())
                variables.setRight(true);
            else{
                variables.setRight(false);
                variables.setLeft(true);
            }
            variables.setUp(false);
            variables.setDown(false);
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            int move= variables.getMoves();
            variables.setMoves(move++);
            variables.setLeft(true);
            if(!variables.isRight())
                variables.setLeft(true);
            else{
                variables.setLeft(false);
                variables.setRight(true);
            }
            variables.setUp(false);
            variables.setDown(false);
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
            int move= variables.getMoves();
            variables.setMoves(move++);
            variables.setUp(true);
            if(!variables.isDown())
                variables.setUp(true);
            else{
                variables.setUp(false);
                variables.setDown(true);
            }
            variables.setRight(false);
            variables.setLeft(false);
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            int move= variables.getMoves();
            variables.setMoves(move++);
            variables.setDown(true);
            if(!variables.isUp())
                variables.setDown(true);
            else{
                variables.setUp(true);
                variables.setDown(false);
            }
            variables.setRight(false);
            variables.setLeft(false);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        variables.getTimer().start();
        if(variables.isRight()){
            for(int i=variables.getSnakeLen()-1;i>=0;i--){
                variables.snakeYLength[i+1] = variables.snakeYLength[i];
            }
            for(int i=variables.getSnakeLen();i>=0;i--){
                if(i==0){
                    variables.snakeXLength[i] = variables.snakeXLength[i]+25;
                }
                else
                    variables.snakeXLength[i]= variables.snakeXLength[i-1];
                if(variables.getSnakeXLength()[i]>850)
                    variables.snakeXLength[i]=25;
            }
            repaint();
        }
        if(variables.isLeft()){
            for(int i=variables.getSnakeLen()-1;i>=0;i--){
                variables.snakeYLength[i+1] = variables.snakeYLength[i];
            }
            for(int i=variables.getSnakeLen();i>=0;i--){
                if(i==0){
                    variables.snakeXLength[i] = variables.snakeXLength[i]-25;
                }
                else
                    variables.snakeXLength[i]= variables.snakeXLength[i-1];
                if(variables.getSnakeXLength()[i]<25)
                    variables.snakeXLength[i]=850;
            }
            repaint();
        }
        if(variables.isUp()){
            for(int i=variables.getSnakeLen()-1;i>=0;i--){
                variables.snakeXLength[i+1] = variables.snakeXLength[i];
            }
            for(int i=variables.getSnakeLen();i>=0;i--){
                if(i==0){
                    variables.snakeYLength[i] = variables.snakeYLength[i]-25;
                }
                else
                    variables.snakeYLength[i]= variables.snakeYLength[i-1];
                if(variables.getSnakeYLength()[i]<75)
                    variables.snakeYLength[i]=625;
            }
            repaint();
        }
        if(variables.isDown()){
            for(int i=variables.getSnakeLen()-1;i>=0;i--){
                variables.snakeXLength[i+1] = variables.snakeXLength[i];
            }
            for(int i=variables.getSnakeLen();i>=0;i--){
                if(i==0){
                    variables.snakeYLength[i] = variables.snakeYLength[i]+25;
                }
                else
                    variables.snakeYLength[i]= variables.snakeYLength[i-1];
                if(variables.getSnakeYLength()[i]>625)
                    variables.snakeYLength[i]=75;
            }
            repaint();
        }
    }

    
}
