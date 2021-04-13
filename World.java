import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class World {

    public ArrayList<Wall> walls = new ArrayList<Wall>();
    public ArrayList<Enemy> enemies = new ArrayList<>();
    //public ArrayList<Door> doors = new ArrayList<>();
    //public ArrayList<Integer> balls = new ArrayList<>();
    public ArrayList<Chest> chests = new ArrayList<>();
    public Character character;
    public int runningX;
    public int runningY;
    public World(Character character) {
        this.character = character;
        this.runningX = 0;
        this.runningY = 0;
    }

    //public void createWallsSquare() {
//
    //    for (double i = 150; i <= 800;) {
    //        walls.add(new Wall(100, i, character, 10, 50));
    //        i = i + 50;
    //    }
//
    //    for (double i = 150; i <= 800;) {
    //        walls.add(new Wall(790, i, character, 10, 50));
    //        i = i + 50;
    //    }
//
    //    for (double i = 100; i <= 750;) {
    //        walls.add(new Wall(i, 100, character, 50 ,10));
    //        i = i + 50;
    //    }
//
    //    for (double i = 100; i <= 750;) {
    //        walls.add(new Wall(i, 790, character, 50, 10));
    //        i = i + 50;
    //    }
    //}

    public void createFirstWorld() {
        //0.0
        for (double i = 400; i <= 700;) {
            walls.add(new Wall(0, i, character, 25, 25));
            i = i + 25;
        }

        for (double i = 0; i <= 975;) {
            walls.add(new Wall(i, 400, character, 25, 25));
            i = i + 25;
        }

        for (double i = 0; i <= 975;) {
            walls.add(new Wall(i, 700, character, 25, 25));
            i = i + 25;
        }

        //1.0
        for (double i = 1000; i <= 1975;) {
            walls.add(new Wall(i, 50, character, 25, 25));
            i = i + 25;
        }

        for (double i = 1000; i <= 1975;) {
            walls.add(new Wall(i, 1025, character, 25, 25));
            i = i + 25;
        }

        for (double i = 50; i <= 400;) {
            walls.add(new Wall(1000, i, character, 25, 25));
            i = i + 25;
        }

        for (double i = 700; i <= 1025;) {
            walls.add(new Wall(1000, i, character, 25, 25));
            i = i + 25;
        }

        for (double i = 50; i <= 1025;) {
            walls.add(new Wall(1975, i, character, 25, 25));
            i = i + 25;
        }

    }

    public void createEnemies() {
        //enemies.add(new Enemy(200, 700, character));
        //enemies.add(new Enemy(-1500, 400, character));
        //enemies.add(new Enemy(400, 100, character));
        enemies.add(new Enemy(1150, 200, character));
        enemies.add(new Enemy(1150, 900, character));
        enemies.add(new Enemy(1850, 200, character));
        enemies.add(new Enemy(1850, 900, character));
    }

    //public void createDoors() {
    //    doors.add(new Door(400, 700, 75, 25, 1300, 200, 1, 0, character));
    //}

    public void createChests() {
        // chests.add(new Chest(200, 300, character));
        // chests.add(new Chest(400, 600, character));
        chests.add(new Chest(475, 450, character));
    }


    public void drawWalls(Graphics g) {
        if (character.startGame) {
            for (int i = 0; i < walls.size(); i++) {
                (walls.get(i)).draw(g);
            }
        }

    }

    public void drawChest(Graphics g) {
        if (character.startGame) {
            for (int i = 0; i < chests.size(); i++) {
                (chests.get(i)).draw(g);
            }

            for (int i = 0; i < chests.size(); i++) {
                (chests.get(i)).update();
            }
        }

    }

    public void drawEnemies(Graphics g) {
        if (character.startGame) {
            for (int i = 0; i < enemies.size(); i++) {
                (enemies.get(i)).draw(g);
            }
        }

    }

    public void updateEnemies(long dt) {
        if (character.startGame) {
            for (int i = 0; i < enemies.size(); i++) {
                (enemies.get(i)).update(dt);
                (enemies.get(i)).updateDamage();
            }
        }

    }

    public void checkAnotherEnemy() {
        if (character.startGame) {
            for (int i = 0; i < enemies.size(); i++) {
                for (int j = 0; j < enemies.size(); j ++) {
                    if (i != j) {
                        (enemies.get(i)).checkAnotherEnemy(enemies.get(j));
                    }
                }
            }
        }

    }

    public void updateCharacterDamage(MouseEvent e) {
        if (character.startGame) {
            for (int i = 0; i < enemies.size(); i++) {
                (enemies.get(i)).characterDamage(e);
            }
        }

    }

    public void changeLocation(int x) {
        if (character.startGame) {
            for (int i = 0; i < walls.size(); i++) {
                (walls.get(i)).changeLocation(x);
            }

            for (int i = 0; i < enemies.size(); i++) {
                (enemies.get(i)).changeLocation(x);
            }

            for (int i = 0; i < chests.size(); i++) {
                (chests.get(i)).changeLocation(x);
            }
        }

    }

    public void checkEnemyWalls() {
        if (character.startGame) {
            for (int i = 0; i < walls.size(); i++) {
                for (int j = 0; j < enemies.size() ; j++) {
                    (walls.get(i)).checkObjects(enemies.get(j));
                }
            }
        }

    }

    public void openChest(MouseEvent e) {
        if (character.startGame) {
            for (int i = 0; i < chests.size(); i++) {
                (chests.get(i)).open(e);
            }
        }

    }


    public void createTestWorld() {
        for (double i = 300; i <= 650;) {
            walls.add(new Wall(i, 200, character, 25, 25));
            i = i + 25;
        }

        for (double i = 200; i <= 650;) {
            walls.add(new Wall(300, i, character, 25, 25));
            i = i + 25;
        }

        for (double i = 200; i <= 650;) {
            walls.add(new Wall(650, i, character, 25, 25));
            i = i + 25;
        }

        for (double i = 1500; i <= 1875;) {
            walls.add(new Wall(i, 500, character, 25, 25));
            i = i + 25;
        }

        for (double i = -500; i >= -875;) {
            walls.add(new Wall(i, -500, character, 25, 25));
            i = i - 25;
        }
    }


}
