import java.awt.*;
import java.awt.event.MouseEvent;

public class Enemy {

    public double x;
    public double constX;
    public double constY;
    public double y;
    public double width;
    public double height;
    private double enemySpeedX;
    private double enemySpeedY;
    public Character character;
    private int enemyGoX;
    private int enemyGoY;
    public double xH;
    public double yH;
    public int startEnemy;
    public double enemyHealth;
    public boolean canHit;
    public boolean drawHealth;
    public boolean drawEnemy;
    private long previousWorldUpdateTime;

    public Enemy(double x, double y, Character character) {
        this.x = x;
        this.y = y;
        this.width = 40;
        this.height = 40;
        this.xH = x + 5;
        this.yH = y - 10;
        this.enemySpeedX = 0.15;
        this.enemySpeedY = 0.15;
        this.character = character;
        this.enemyGoX = 0;
        this.enemyGoY = 0;
        this.startEnemy = 0;
        this.enemyHealth = 100;
        this.canHit = true;
        this.drawHealth = false;
        this.drawEnemy = true;
        previousWorldUpdateTime = System.currentTimeMillis();

    }

    public void draw(Graphics g) {
        if (character.startGame) {
            if (drawEnemy) {
                g.setColor(Color.MAGENTA);
                g.fillRect((int) x, (int) y, (int) width, (int) height);
                g.setColor(Color.black);
                g.drawRect((int) x, (int) y, (int) width, (int) height);
                if (drawHealth) {
                    g.setColor(Color.blue);
                    g.drawString(String.valueOf(enemyHealth), (int) xH, (int) yH);
                    g.setColor(Color.black);
                }
            }
        }
    }


    public void update(long dt) {
        if (character.startGame) {
            if (drawEnemy) {
                if (enemyHealth <= 0) {
                    x = 999999999;
                    y = 999999999;
                    //xH = x + 10;
                    //yH = y - 10;
                    drawHealth = false;
                    drawEnemy = false;
                    canHit = false;
                    character.characterHealth += 25;
                    //enemyHealth = 100;
                }



                if (x >= character.x - 40 && x + width <= character.x + 90 && y >= character.y - 40 && y + height <= character.y + 90) {
                    enemyGoX = 0;
                    enemyGoY = 0;
                    //    go = false;
                } else {
                    //if (go) {
                    if (character.x + 25 > x + 22) {
                        enemyGoX = 1;
                    } else if (character.x + 25 < x + 18) {
                        enemyGoX = -1;
                    } else if (character.x + 25 <= x + 22 && character.x + 25 >= x + 18) {
                        enemyGoX = 0;
                    }
                    //}


                    //if (go) {
                    if (character.y + 25 > y + 22) {
                        enemyGoY = 1;
                    } else if (character.y + 25 < y + 18) {
                        enemyGoY = -1;
                    } else if (character.y + 25 <= y + 22 && character.y + 25 >= y + 18) {
                        enemyGoY = 0;
                    }
                    //}
                    //    go = true;
                }





                if (character.x > x - 300 && character.x < x + 340 && character.y > y - 300 && character.y < y + 340) {
                    x += enemyGoX * enemySpeedX * dt;
                    y += enemyGoY * enemySpeedY * dt;
                    xH += enemyGoX * enemySpeedX * dt;
                    yH += enemyGoY * enemySpeedY * dt;
                    drawHealth = true;

                }
            }
        }


    }

    public void checkAnotherEnemy(Enemy enemy) {
        if (character.startGame) {
            if (enemy.x >= this.x && enemy.x <= this.x + width && enemy.y + height - 7 >= this.y && enemy.y + 7 <= this.y + height) {
                enemy.x = this.x + width;
                enemy.xH = enemy.x + 5;
            }

            if (enemy.x + width >= this.x && enemy.x + width <= this.x + width && enemy.y + height - 7 >= this.y && enemy.y + 7 <= this.y + height) {
                enemy.x = this.x - width;
                enemy.xH = enemy.x + 5;
            }

            if (enemy.y >= this.y && enemy.y <= this.y + width && enemy.x + height - 7 >= this.x && enemy.x + 7 <= this.x + height) {
                enemy.y = this.y + width;
                enemy.yH = enemy.y + 60;
            } else {
                enemy.yH = enemy.y - 10;
            }

            if (enemy.y + width >= this.y && enemy.y + width <= this.y + width && enemy.x + height - 7 >= this.x && enemy.x + 7 <= this.x + height) {
                enemy.y = this.y - width;
                enemy.yH = enemy.y - 10;
            }
        }

    }

    public void changeLocation(int x) {
        if (character.startGame) {
            if (x == 1) {
                this.y = this.y + 1000;
                this.yH = this.yH + 1000;
            } else if (x == 2) {
                this.x = this.x - 1000;
                this.xH = this.xH - 1000;
            } else if (x == 3) {
                this.y = this.y - 1000;
                this.yH = this.yH - 1000;
            } else if (x == 4) {
                this.x = this.x + 1000;
                this.xH = this.xH + 1000;
            }
        }

    }

    public void changeNLocation(int nX, int nY) {
        x = x + 1000 * nX;
        xH = xH + 1000 * nX;
        y = y + 1000 * nY;
        yH = xH + 1000 * nY;
    }

    public void updateDamage() {
        if (character.startGame) {
            long currentTime = System.currentTimeMillis();
            if ((character.x - 5 <= x + 35 && character.x + 55 >= x) && (character.y - 5 <= y + 35 && character.y + 55 >= y)) {
                if ((currentTime - previousWorldUpdateTime) >= 1600) {
                    if (character.characterHealth > 0) {
                        previousWorldUpdateTime = currentTime;
                        character.characterHealth -= (int) (Math.random() * 6) + 5;
                        System.out.println("HIT");
                    }
                }
            }
        }

    }

    public void characterDamage(MouseEvent e) {
        if (character.startGame) {
            if (e.getX() >= this.x && e.getX() <= this.x + 40 && e.getY() >= this.y && e.getY() <= this.y + 40 && e.getButton() == 1) {
                if ((character.x - 5 <= this.x + 35 && character.x + 55 >= this.x) && (character.y - 5 <= this.y + 35 && character.y + 55 >= this.y)) {
                    if (character.characterHealth > 0) {
                        this.enemyHealth -= (int) ((Math.random() * (character.damageMax + 1)) + (character.damageMax/2));
                        System.out.println("Yes");
                    }
                }
            }
        }
    }
}