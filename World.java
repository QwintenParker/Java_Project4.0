import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class World {

    public ArrayList<Wall> walls = new ArrayList<Wall>();
    public ArrayList<Enemy> enemies = new ArrayList<>();
    public ArrayList<EnemySnyp> enemySnyps = new ArrayList<>();
    public ArrayList<Chest> chests = new ArrayList<>();
    public Character character;
    public int runningX;
    public int runningY;
    public World(Character character) {
        this.character = character;
        this.runningX = 0;
        this.runningY = 0;
    }

    //public void createFirstWorld() {
    //    //0.0
    //    for (double i = 400; i <= 700;) {
    //        walls.add(new Wall(0, i, character, 25, 25, 4));
    //        i = i + 25;
    //    }
//
    //    for (double i = 0; i <= 975;) {
    //        walls.add(new Wall(i, 400, character, 25, 25, 1));
    //        i = i + 25;
    //    }
//
    //    for (double i = 0; i <= 975;) {
    //        walls.add(new Wall(i, 700, character, 25, 25, 3));
    //        i = i + 25;
    //    }
//
    //    //1.0
    //    for (double i = 1000; i <= 1975;) {
    //        walls.add(new Wall(i, 50, character, 25, 25, 1));
    //        i = i + 25;
    //    }
//
    //    for (double i = 1000; i <= 1500;) {
    //        walls.add(new Wall(i, 1025, character, 25, 25, 3));
    //        i = i + 25;
    //    }
//
    //    for (double i = 50; i <= 400;) {
    //        walls.add(new Wall(1000, i, character, 25, 25, 4));
    //        i = i + 25;
    //    }
//
    //    for (double i = 700; i <= 1025;) {
    //        walls.add(new Wall(1000, i, character, 25, 25, 4));
    //        i = i + 25;
    //    }
//
    //    for (double i = 50; i <= 1025;) {
    //        walls.add(new Wall(1975, i, character, 25, 25, 2));
    //        i = i + 25;
    //    }
//
    //}

    public void createFinaleWorld() {
        /*//0.0
        for (double i = 250; i <= 700;) {
            walls.add(new Wall(i, 250, character, 50, 50, 0));
            i = i + 50;
        }

        for (double i = 250; i <= 350;) {
            walls.add(new Wall(i, 700, character, 50, 50, 0));
            i = i + 50;
        }

        for (double i = 600; i <= 700;) {
            walls.add(new Wall(i, 700, character, 50, 50, 0));
            i = i + 50;
        }

        for (double i = 250; i <= 700;) {
            walls.add(new Wall(250, i, character, 50, 50, 0));
            walls.add(new Wall(700, i, character, 50, 50, 0));
            i = i + 50;
        }

        for (double i = 700; i <= 1000;) {
            walls.add(new Wall(350, i, character, 50, 50, 0));
            walls.add(new Wall(600, i, character, 50, 50, 0));
            i = i + 50;
        }

        //0.1
        for (double i = 1050; i <= 1350;) {
            walls.add(new Wall(350, i, character, 50, 50, 0));
            walls.add(new Wall(600, i, character, 50, 50, 0));
            i = i + 50;
        }

        for (double i = 0; i <= 350;) {
            walls.add(new Wall(i, 1350, character, 50, 50, 0));
            i = i + 50;
        }

        for (double i = 600; i <= 950;) {
            walls.add(new Wall(i, 1350, character, 50, 50, 0));
            i = i + 50;
        }

        for (double i = 0; i <= 950;) {
            walls.add(new Wall(i, 1700, character, 50, 50, 0));
            i = i + 50;
        }

        //1.1
        for (double i = 1000; i <= 1950;) {
            walls.add(new Wall(i, 1350, character, 50, 50, 0));
            walls.add(new Wall(i, 1700, character, 50, 50, 0));
            i = i + 50;
        }
        //2.1
        for (double i = 2000; i <= 2950;) {
            walls.add(new Wall(i, 1050, character, 50, 50, 0));
            i = i + 50;
        }

        for (double i = 1050; i <= 1350;) {
            walls.add(new Wall(2000, i, character, 50, 50, 0));
            walls.add(new Wall(2950, i, character, 50, 50, 0));
            i = i + 50;
        }

        for (double i = 1700; i <= 2000;) {
            walls.add(new Wall(2000, i, character, 50, 50, 0));
            walls.add(new Wall(2950, i, character, 50, 50, 0));
            i = i + 50;
        }*/

        //0.0
        walls.add(new Wall(250, 250, character, 500, 50, 0));
        walls.add(new Wall(250, 250, character, 50, 500, 0));
        walls.add(new Wall(700, 250, character, 50, 500, 0));
        walls.add(new Wall(250, 700, character, 150, 50, 0));
        walls.add(new Wall(600, 700, character, 150, 50, 0));
        walls.add(new Wall(350, 700, character, 50, 350, 0));
        walls.add(new Wall(600, 700, character, 50, 350, 0));

        //0.1 , -1.1 , 1.1
        walls.add(new Wall(350, 1050, character, 50, 350, 0));
        walls.add(new Wall(600, 1050, character, 50, 350, 0));
        walls.add(new Wall(-1000, 1350, character, 1400, 50, 0));
        walls.add(new Wall(600, 1350, character, 1400, 50, 0));
        walls.add(new Wall(-1000, 1350, character, 1400, 50, 0));
        walls.add(new Wall(-1000, 1700, character, 3000, 50, 0));
        // temporary
        walls.add(new Wall(-1000, 1350, character, 50, 400, 0));
        //

        //2.1
        walls.add(new Wall(2000, 1050, character, 1000, 50, 0));
        walls.add(new Wall(2000, 1050, character, 50, 350, 0));
        walls.add(new Wall(2950, 1050, character, 50, 350, 0));
        walls.add(new Wall(2000, 1700, character, 50, 350, 0));
        walls.add(new Wall(2950, 1700, character, 50, 350, 0));
        walls.add(new Wall(2000, 2000, character, 350, 50, 0));
        walls.add(new Wall(2650, 2000, character, 350, 50, 0));

        //3.1 , 3.0
        walls.add(new Wall(3000, 1350, character, 350, 50, 0));
        walls.add(new Wall(3000, 1700, character, 700, 50, 0));
        walls.add(new Wall(3300, 700, character, 50, 700, 0));
        walls.add(new Wall(3650, 700, character, 50, 1050, 0));

        //3.0 , 2.0
        walls.add(new Wall(2650, 700, character, 700, 50, 0));
        walls.add(new Wall(2650, 350, character, 700, 50, 0));
        walls.add(new Wall(2650, 50, character, 50, 350, 0));
        walls.add(new Wall(2650, 700, character, 50, 350, 0));
        walls.add(new Wall(2350, 50, character, 350, 50,0));
        walls.add(new Wall(2350, 1000, character, 350, 50,0));
        walls.add(new Wall(2350, 50, character, 50, 1000, 0));

        //3.0 , 3.-1
        walls.add(new Wall(3300, -950, character, 50, 1350,0));
        walls.add(new Wall(3650, -950, character, 50, 1350,0));

        //3.-2
        walls.add(new Wall(3000, -1950, character, 1000, 50,0));
        walls.add(new Wall(3000, -1950, character, 50, 1000,0));
        walls.add(new Wall(3950, -1950, character, 50, 1000,0));
        walls.add(new Wall(3000, -1000, character, 350, 50,0));
        walls.add(new Wall(3650, -1000, character, 350, 50,0));

        //4.0 , 3.0
        walls.add(new Wall(3650, 350, character, 700, 50,0));
        walls.add(new Wall(3650, 700, character, 1050, 50,0));

        //4.-1 . 4.0
        walls.add(new Wall(4300, -650, character, 50, 1050,0));
        walls.add(new Wall(4650, -300, character, 50, 1050,0));
        walls.add(new Wall(4300, -650, character, 700, 50,0));
        walls.add(new Wall(4650, -300, character, 350, 50,0));

        //5.-1
        walls.add(new Wall(5000, -950, character, 1000, 50,0));
        walls.add(new Wall(5000, 0, character, 1000, 50,0));
        walls.add(new Wall(5000, -950, character, 50, 350,0));
        walls.add(new Wall(5950, -950, character, 50, 350,0));
        walls.add(new Wall(5000, -300, character, 50, 350,0));
        walls.add(new Wall(5950, -300, character, 50, 350,0));

        //6.-1 , 6.0 , 6.1
        walls.add(new Wall(6000, -650, character, 700, 50,0));
        walls.add(new Wall(6000, -300, character, 350, 50,0));
        walls.add(new Wall(6300, -300, character, 50, 700,0));
        walls.add(new Wall(6650, -650, character, 50, 2050,0));

        //5.0 , 6.0
        walls.add(new Wall(5000, 350, character, 1350, 50,0));
        walls.add(new Wall(5000, 700, character, 1350, 50,0));
        walls.add(new Wall(5000, 350, character, 50, 350,0));

        //6.0 , 6.1 , 6.2
        walls.add(new Wall(6300, 700, character, 50, 1700,0));
        walls.add(new Wall(6650, 1700, character, 50, 1050,0));
        walls.add(new Wall(6650, 1350, character, 350, 50,0));
        walls.add(new Wall(6650, 1700, character, 350, 50,0));

        //5.2 , 6.2
        walls.add(new Wall(5300, 2350, character, 1050, 50,0));
        walls.add(new Wall(5650, 2700, character, 1050, 50,0));

        //5.2 , 5.3
        walls.add(new Wall(5300, 2350, character, 50, 1050,0));
        walls.add(new Wall(5650, 2700, character, 50, 1050,0));
        walls.add(new Wall(5000, 3350, character, 350, 50,0));
        walls.add(new Wall(5000, 3700, character, 700, 50,0));

        //4.3
        walls.add(new Wall(4000, 4000, character, 1000, 50,0));
        walls.add(new Wall(4000, 3050, character, 350, 50,0));
        walls.add(new Wall(4650, 3050, character, 350, 50,0));
        walls.add(new Wall(4000, 3050, character, 50, 350,0));
        walls.add(new Wall(4950, 3050, character, 50, 350,0));
        walls.add(new Wall(4000, 3700, character, 50, 350,0));
        walls.add(new Wall(4950, 3700, character, 50, 350,0));

        //4.1 , 4.2
        walls.add(new Wall(4000, 1050, character, 1000, 50,0));
        walls.add(new Wall(4000, 1050, character, 50, 350,0));
        walls.add(new Wall(4950, 1050, character, 50, 350,0));
        walls.add(new Wall(4000, 1350, character, 350, 50,0));
        walls.add(new Wall(4650, 1350, character, 350, 50,0));
        walls.add(new Wall(4300, 1350, character, 50, 1700,0));
        walls.add(new Wall(4650, 1350, character, 50, 1700,0));

        //2.3 , 3.3 , 2.2
        walls.add(new Wall(2650, 3350, character, 1350, 50,0));
        walls.add(new Wall(2300, 3700, character, 1700, 50,0));
        walls.add(new Wall(2300, 2050, character, 50, 1700,0));
        walls.add(new Wall(2650, 2050, character, 50, 1350,0));

        //7.1
        walls.add(new Wall(7000, 1050, character, 1000, 50,0));
        walls.add(new Wall(7000, 2000, character, 1000, 50,0));
        walls.add(new Wall(7000, 1050, character, 50, 350,0));
        walls.add(new Wall(7950, 1050, character, 50, 350,0));
        walls.add(new Wall(7000, 1700, character, 50, 350,0));
        walls.add(new Wall(7950, 1700, character, 50, 350,0));

        //8.1
        walls.add(new Wall(8000, 1350, character, 1000, 50,0));
        walls.add(new Wall(8000, 1700, character, 1000, 50,0));

        //9.1 , 9.2 , 10.1 , 10.2
        walls.add(new Wall(9000, 1050, character, 2000, 50,0));
        walls.add(new Wall(9000, 3000, character, 2000, 50,0));
        walls.add(new Wall(9000, 1050, character, 50, 350,0));
        walls.add(new Wall(9000, 1700, character, 50, 1350,0));
        walls.add(new Wall(10950, 1050, character, 50, 2000,0));

    }

    public void createEnemies() {
        //enemies.add(new Enemy(200, 700, character));
        //enemies.add(new Enemy(-1500, 400, character));
        //enemies.add(new Enemy(400, 100, character));
        //enemies.add(new Enemy(1150, 200, character));
        //enemies.add(new Enemy(1150, 900, character));
        //enemies.add(new Enemy(1850, 200, character));
        //enemies.add(new Enemy(1850, 900, character));
    }

    public void createEnemySnyps() {
        enemySnyps.add(new EnemySnyp(2700, 1500, character));
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
                //System.out.println(enemies.get(0).x);
            }
        }
    }

    public void drawEnemySnyps(Graphics g) {
        if (character.startGame) {
            for (int i = 0; i < enemySnyps.size(); i++) {
                (enemySnyps.get(i)).draw(g);
            }
        }
    }

    public void updateEnemies(long dt) {
        if (character.startGame) {
            for (int i = 0; i < enemies.size(); i++) {
                (enemies.get(i)).update(dt);
                (enemies.get(i)).updateDamage();
            }

            for (int i = 0; i < enemySnyps.size(); i++) {
                (enemySnyps.get(i)).update(dt);
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

    public void damageByBall() {
        if (character.startGame) {
            for (int i = 0; i < enemies.size(); i++) {
                for (int j = 0; j < character.balls.size(); j++) {
                    (enemies.get(i)).damageByBall(character.balls.get(j));
                }
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

            for (int i = 0; i < enemySnyps.size(); i++) {
                (enemySnyps.get(i)).changeLocation(x);
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

    public void checkEnemySnypeWalls() {
        if (character.startGame) {
            for (int i = 0; i < walls.size(); i++) {
                for (int j = 0; j < enemySnyps.size() ; j++) {
                    (walls.get(i)).checkObjects(enemySnyps.get(j));
                }
            }
        }
    }

    public void checkFireBalls() {
        if (character.startGame) {
            for (int i = 0; i < walls.size(); i++) {
                for (int j = 0; j < character.balls.size(); j++) {
                    (walls.get(i)).checkObjects(character.balls.get(j));
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
            walls.add(new Wall(i, 200, character, 25, 25, 0));
            i = i + 25;
        }

        for (double i = 200; i <= 650;) {
            walls.add(new Wall(300, i, character, 25, 25, 0));
            i = i + 25;
        }

        for (double i = 200; i <= 650;) {
            walls.add(new Wall(650, i, character, 25, 25, 0));
            i = i + 25;
        }

        for (double i = 1500; i <= 1875;) {
            walls.add(new Wall(i, 500, character, 25, 25, 0));
            i = i + 25;
        }

        for (double i = -500; i >= -875;) {
            walls.add(new Wall(i, -500, character, 25, 25, 0));
            i = i - 25;
        }
    }


}
