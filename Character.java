import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Character {
    public File img1 = new File("C:\\Users\\zarez\\IdeaProjects\\JAVA_2.0-main\\JAVA_2.0-main\\failed.png");
    public double x;
    public double y;
    public double constX;
    public double constY;
    public double width;
    public double height;
    public double xRunningSpeed;
    public double yRunningSpeed;
    public int runningX;
    public int runningY;
    public double characterHealth;
    public double maxHealth;
    public double damageMax;
    public double coins;
    public String value;
    public double coinsSum;
    public boolean canHit;
    public boolean isMoving;
    public BufferedImage gameOverImage;
    public boolean startGame;
    public double dtX;
    public double dtY;
    public double nX;
    public double nY;
    public Font font1;
    public Font font2;
    public ArrayList<FireBall> balls = new ArrayList<>();
    public int countBalls;


    public Character(double x, double y) throws IOException {

        this.x = x;
        this.y = y;
        this.constX = x;
        this.constY = y;
        this.width = 50;
        this.height = 50;
        this.xRunningSpeed = 0.2;
        this.yRunningSpeed = 0.2;
        this.runningX = 0;
        this.runningY = 0;
        this.characterHealth = 100;
        this.canHit = false;
        this.startGame = false;
        this.gameOverImage = ImageIO.read(img1);
        this.isMoving = false;
        this.maxHealth = 100;
        this.damageMax = 10;
        this.coins = 0;
        this.value = "BYTE";
        this.font2 = new Font("TimesRomab", Font.PLAIN, 12);
        this.font1 = new Font("TimesRoman", Font.BOLD, 30);
    }

    public void draw(Graphics g) {
        if (startGame) {
            int imageX = (int) x;
            int imageY = (int) y;
            g.setColor(Color.GREEN);
            g.fillRect(imageX, imageY, (int) width, (int) height);
            g.setColor(Color.black);
            g.drawRect(imageX, imageY, (int) width, (int) height);
            for (int i = 0; i < balls.size(); i++) {
                (balls.get(i)).drawBall(g);
            }
        }
    }

    public void drawHealth(Graphics g) {
        if (startGame) {
            if (characterHealth > maxHealth) {
                characterHealth = 100;
            }

            g.setFont(font1);
            g.fillRect(0, 0, 240, 48);

            g.setColor(Color.green);
            g.drawRect(0, 0, 240, 48);
            g.drawString("HEALTH:", 10, 35);
            g.drawString(String.valueOf((int)characterHealth), 150, 35);

            g.setColor(Color.black);
            g.setFont(font2);
        }
    }




    public void drawCoins(Graphics g) {
        if (startGame) {
            g.setFont(font1);
            g.fillRect(241, 0, 200, 50);
            g.setColor(Color.yellow);
            g.drawRect(241, 0, 200, 50);
            g.drawString(String.valueOf((int) coins), 360, 35);
            g.setColor(Color.black);
            g.setFont(font2);
        }
    }

    public void drawGameOver(Graphics g) {
        if (startGame) {
            if (characterHealth <= 0) {
                g.drawImage(this.gameOverImage, 0, 50, null);
                g.setColor(new Color(0x990000));
                g.fillRect((int) x, (int) y, (int) width, (int) height);
                g.setColor(new Color(0));
                xRunningSpeed = 0;
                yRunningSpeed = 0;
                characterHealth = 0;
            }
        }
    }

    public void startRunningLeft() {
        runningX = -1;
    }

    public void startRunningRight() {
        runningX = 1;
    }

    public void startRunningDown() {
        runningY = 1;
    }

    public void startRunningUp() {
        runningY = -1;
    }

    public void stopRunningLeft() {
        if (runningX == -1) {
            runningX = 0;
        }
    }

    public void stopRunningRight() {
        if (runningX == 1) {
            runningX = 0;
        }
    }

    public void stopRunningDown() {
        if (runningY == 1) {
            runningY = 0;
        }
    }

    public void stopRunningUp() {
        if (runningY == -1) {
            runningY = 0;
        }
    }

    public void update(long dt) {
        if (startGame) {
            dtX = runningX * xRunningSpeed * dt;
            dtY = runningY * yRunningSpeed * dt;

            x += dtX;
            y += dtY;

            for (int i = 0; i < balls.size(); i++) {
                (balls.get(i)).update(dt);
            }
        }
    }

    public void changeLocation(double x0, double y0, double xN, double yN, World world) {
        if (startGame) {
            if (x < x0) {
                world.changeLocation(4);
                this.x = 999;
            }

            if (x > xN) {
                world.changeLocation(2);
                this.x = 1;
            }

            if (y < y0) {
                world.changeLocation(1);
                this.y = 999;
            }

            if (y > yN) {
                world.changeLocation(3);
                this.y = 1;
            }
        }
    }

    public void createFireBalls(MouseEvent e) {
        if (e.getButton() == 3) {
            balls.add(new FireBall(this, e.getX(), e.getY(), balls.size()));
        }
    }
}