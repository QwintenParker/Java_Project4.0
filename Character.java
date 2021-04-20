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
    public boolean pause;
    public Font font1;
    public Font font2;
    public Font font3;
    public ArrayList<FireBall> balls = new ArrayList<>();
    public long previousWorldUpdateTime;
    public int maxBalls;
    public boolean gameOver;


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
        this.characterHealth = 10000;
        this.canHit = false;
        this.startGame = false;
        this.gameOverImage = ImageIO.read(img1);
        this.isMoving = false;
        this.maxHealth = 1000000;
        this.damageMax = 10;
        this.coins = 0;
        this.value = "BYTE";
        this.font3 = new Font("TimesRomab", Font.PLAIN, 15);
        this.font2 = new Font("TimesRomab", Font.PLAIN, 12);
        this.font1 = new Font("TimesRoman", Font.BOLD, 30);
        this.previousWorldUpdateTime = System.currentTimeMillis();
        this.maxBalls = 10;
        this.pause = false;
        this.gameOver = false;
    }

    public void draw(Graphics g) {
        if (startGame) {
            int imageX = (int) x;
            int imageY = (int) y;
            g.setColor(Color.GREEN);
            g.fillRect(imageX, imageY, (int) width, (int) height);
            g.setColor(Color.black);
            g.drawRect(imageX, imageY, (int) width, (int) height);

            g.setFont(font3);
            if (maxBalls > 0) {
                g.setColor(Color.WHITE);
                g.drawString("AMMO:", 800, 30);
                g.drawString(String.valueOf(maxBalls), 850, 30);
            } else {
                g.setColor(Color.RED);
                g.drawString("AMMO", 800, 30);
                g.drawString(String.valueOf(maxBalls), 850, 30);
            }
            g.setFont(font2);
            g.setColor(new Color(0xFF000D01, true));

            for (int i = 0; i < balls.size(); i++) {
                (balls.get(i)).drawBall(g);
                balls.get(i).num = i;
            }
        }
    }

    public void drawHealth(Graphics g) {
        if (startGame) {
            if (characterHealth > maxHealth) {
                characterHealth = maxHealth;
            }

            g.setFont(font1);
            g.fillRect(1, 1, 240, 48);

            g.setColor(Color.green);
            g.drawRect(1, 1, 240, 48);
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
                gameOver = true;
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
        if (startGame && !pause) {
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
                this.y = 51;
            }
        }
    }

    public void createFireBalls(MouseEvent e) {
        long currentTime = System.currentTimeMillis();
        if (characterHealth > 0 && !pause) {
            if (maxBalls > 0) {
                if (e.getButton() == 3 && e.getID() == MouseEvent.MOUSE_CLICKED) {
                    if ((currentTime - previousWorldUpdateTime) >= 1000) {
                        System.out.println(balls.size());
                        balls.add(new FireBall(this, e.getX(), e.getY(), balls.size()));
                        previousWorldUpdateTime = currentTime;
                        maxBalls = maxBalls - 1;
                    }
                }
            }

        }
    }

    public void removeBall(int n) {
        int num1 = n;
        balls.remove(num1);
        System.out.println("R" + n);
        //for (int i = 0; i < balls.size(); i++) {
        //    if (balls.get(i).num > num1) {
        //        balls.get(i).num = num1;
        //    }
        //    num1 = num1 + 1;
//
        //}
    }
}