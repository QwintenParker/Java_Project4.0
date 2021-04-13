import java.awt.*;
import java.awt.event.MouseEvent;

public class Chest {

    public double x;
    public double y;
    public int closing;
    public int opening;
    public double speedX;
    public double speedY;
    public boolean canOpen;
    public double width;
    public double height;
    public Character character;
    public int stuff;
    public int st;

    public Chest(double x, double y, Character character) {
        this.x = x;
        this.y = y;
        this.width = 20;
        this.height = 20;
        this.speedX = 0.21;
        this.speedY = 0.21;
        this.closing = 0;
        this.opening = 0;
        this.canOpen = false;
        this.character = character;
        this.stuff = (int) (Math.random() * 3);
        this.st = 0;
        System.out.println(stuff);
    }

    public void open(MouseEvent e) {
        if (character.startGame) {
            if (e.getX() >= this.x && e.getX() <= this.x + 20 && e.getY() >= this.y && e.getY() <= this.y + 20 && e.getButton() == 1) {
                if (canOpen && closing !=1) {
                    opening = 1;
                    closing = closing + 1;
                } else {
                    opening = 0;
                    closing = 0;
                }
            }
        }

    }

    public void draw(Graphics g) {
        if (character.startGame) {
            if (opening == 0) {
                g.setColor(Color.CYAN);
            } else {
                g.setColor(Color.red);
            }
            g.drawRect((int) x, (int) y, (int) width, 20);
            g.fillRect((int) x, (int) y, 20, 20);
        }

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

    public void update() {
        if (character.startGame) {
            if (character.x + 50 > x - 10 && character.x < x + width + 10 && character.y + 50 > y - 10 && character.y < y + height + 10) {
                canOpen = true;
            } else {
                canOpen = false;
                closing = 0;
                opening = 0;
            }

            if (opening == 1 && st == 0) {
                if (stuff == 0) {
                    character.characterHealth = character.characterHealth + 25;
                    st = 1;
                } else if (stuff == 1) {
                    character.maxHealth = character.maxHealth + 10;
                    character.characterHealth = character.maxHealth;
                    st = 1;
                } else if (stuff == 2) {
                    character.coinsSum = character.coinsSum + (int) ((Math.random() * 100) + 10);
                    st = 1;
                }
                System.out.println(st);
            }
        }


    }
}

