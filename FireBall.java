import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class FireBall {

    //public ArrayList<Integer> balls = new ArrayList<>();
    Character character;
    public double x;
    public double y;
    public double xR;
    public double yR;
    public int radius;
    public double speed;
    public int num;

    public FireBall(Character character, double x, double y, int i) {
        this.character = character;
        this.radius = 10;
        this.x = character.x + 20;
        this.y = character.y + 20;
        xR = x - this.x;
        yR = y - this.y;
        this.speed = 1;
        this.num = i;
    }

    public void drawBall(Graphics g) {
        g.setColor(Color.red);
        g.drawOval((int) x, (int) y, radius, radius);
        g.setColor(new Color(0xFF000D01, true));
    }

    public void update(long dt) {
        this.x += speed * (xR/Math.sqrt(xR*xR + yR*yR)) * dt;
        this.y += speed * (yR/Math.sqrt(xR*xR + yR*yR)) * dt;

       //if (x > 1000 || x < 0 || y > 1000 || y < 0) {
       //    character.removeBall(num);
       //}
        //System.out.println(x);
    }

    public void changeLocation(int x) {
        if (character.startGame) {
            if (x == 1) {
                this.y = this.y + 1000;
            } else if (x == 2) {
                this.x = this.x - 1000;
            } else if (x == 3) {
                this.y = this.y - 1000;
            } else if (x == 4) {
                this.x = this.x + 1000;
            }
        }

    }
}
