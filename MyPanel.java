import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class MyPanel extends JPanel implements MouseListener {

    public Character character;
    public double x0;
    public double y0;
    public double xN;
    public double yN;
    private long previousWorldUpdateTime;
    private double frameWidth;
    private double frameHeight;
    public World world;
    public Menu menu;

    public MyPanel(double x, double y) throws IOException {
        this.frameWidth = x;
        this.frameHeight = y;
        this.x0 = 0;
        this.y0 = 50;
        this.xN = x;
        this.yN = y;
        this.character = new Character(frameWidth/2 - 50, frameHeight/2 - 50);
        this.menu = new Menu(character);
        this.world = new World(character);
        this.previousWorldUpdateTime = System.currentTimeMillis();
        this.addMouseListener(this);
        //world.createTestWorld();
        world.createFirstWorld();
        world.createEnemies();
        world.createChests();
        System.out.println(x0 + ", " + y0 + " : " + xN + ", " + yN);
    }

    //public void startGame() throws IOException {
    //    if (menu.startGame) {
    //        this.character = new Character(frameWidth/2 - 50, frameHeight/2 - 50);
    //        this.world = new World(character);
    //        world.createFirstWorld();
    //        world.createEnemies();
    //        world.createChests();
    //    }
    //}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        menu.drawMenu(g);
        if (character.startGame) {
            g.setColor(new Color(0xFF000D01));
            //g.setColor(new Color(0x86DBD071, true));
            g.fillRect(0, 0, (int) frameWidth, (int) frameHeight);
            g.setColor(Color.black);
        }


        world.drawWalls(g);
        world.drawChest(g);

        character.draw(g);
        world.drawEnemies(g);
        character.drawHealth(g);
        character.drawGameOver(g);


    }

    public void updateWorldPhysics() {
        long currentTime = System.currentTimeMillis();
        long dt = currentTime - previousWorldUpdateTime;

        world.checkEnemyWalls();
        world.checkAnotherEnemy();

        character.update(dt);
        world.updateEnemies(dt);
        character.changeLocation(x0, y0, xN, yN, world);
        //walls0.update(dt);

        previousWorldUpdateTime = currentTime;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        menu.clikStart(e);

        world.updateCharacterDamage(e);
        world.openChest(e);
        character.createFireBalls(e);
        //character.open(e, walls0);
        //character.damage(enemy1, e);
        //character.damage(enemy2, e);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
