import java.awt.*;
import java.awt.event.MouseEvent;

public class Menu {

    public World world;
    public Character character;
    public double x;
    public double y;
    public double xS;
    public double yS;
    public double width;
    public double height;
    public boolean startGame;
    public Font font1;
    public Font font2;
    public Font font3;

    public Menu(Character character) {
        this.x = 0;
        this.y = 0;
        this.xS = 405;
        this.yS = 592;
        this.width = 1015;
        this.height = 1090;
        this.startGame = false;
        this.character = character;
        this.font2 = new Font("TimesRomab", Font.PLAIN, 12);
        this.font1 = new Font("TimesRoman", Font.BOLD, 50);
        this.font3 = new Font("TimesRomab", Font.ITALIC, 90);
    }

    public void drawMenu(Graphics g) {
        if (!startGame) {
            g.setColor(new Color(0xFF000D01, true));
            g.fillRect((int) x, (int) y, (int) width, (int) height);
            g.setColor(Color.GREEN);
            g.drawRect((int) xS, (int) yS, 188, 80);
            g.setFont(font3);
            g.drawString("EXTRANET", 275, 400);
            g.setFont(font1);
            g.drawString("START", 415, 650);
            g.setFont(font2);
            //g.setColor(Color.black);
        }
    }

    public void drawPause(Graphics g) {
        if (startGame) {
            g.setColor(Color.CYAN);
            g.drawRect(960, 10, 30, 30);
            g.drawLine(971, 18, 971, 32);
            g.drawLine(979, 18, 979, 32);
            g.setColor(new Color(0xFF000D01, true));

            if (character.pause) {
                g.setColor(Color.black);
                g.fillRect(183, 200, 650, 700);
                g.setColor(Color.CYAN);
                g.drawRect(183, 200, 650, 700);
                g.drawRect(400, 770, 230, 75);
                g.setFont(font1);
                g.drawString("RETURN", 413, 826);
                g.drawString("PAUSE", 427, 270);
            }
        }
    }

    public void clickStart(MouseEvent e) {
        if (!startGame) {
            if (e.getX() > xS && e.getX() < xS + 188 && e.getY() > yS && e.getY() < yS + 80 && e.getButton() == 1) {
                startGame = true;
                character.startGame = true;
            }
        }
    }

    public void clickPause(MouseEvent e) {
        if (startGame && !character.gameOver) {
            if (e.getX() > 960 && e.getX() < 990 && e.getY() > 10 && e.getY() < 40 && e.getButton() == 1) {
                character.pause = true;
                System.out.println("YES");
            }

            if (e.getX() > 400 && e.getX() < 630 && e.getY() > 770 && e.getY() < 845 && e.getButton() == 1 && character.pause) {
                character.pause = false;
            }
        }
    }
}
