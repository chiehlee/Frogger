import java.awt.Color;
import java.util.ArrayList;

import javalib.funworld.World;
import javalib.worldimages.CircleImage;
import javalib.worldimages.DiskImage;
import javalib.worldimages.Posn;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.TextImage;
import javalib.worldimages.WorldEnd;
import javalib.worldimages.WorldImage;

public class Playground extends World{
    // the size of the screen
    int width = 1024;
    int height = 583;
    // defining
    Frog frog;
    Integer score; 
    Integer lives;
    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    ArrayList<Floater> floaters = new ArrayList<Floater>();    

    Playground(Frog frog, Integer score, Integer lives) {
        this.frog = frog;
        this.score = score;
        this.lives = lives;
        // adding Vehicles
        initVehicles();
        // adding Floaters
        initFolaters();
    }
    // To initialize Vehicles
    private void initVehicles() {
        int currentX;
        int interval;
        int velocityX;
        int locY;
        boolean isCar = true;
        // first lane;
        currentX = 0;
        interval = 600;
        locY = this.height - 50 - 25 - 5;
        velocityX = 1;
        while (currentX < this.width) {
            // if (isCar) {
            this.vehicles.add(new Motorcycle(new CartPt(currentX, locY), 
                    velocityX));
            currentX = currentX + interval;
            // }
        }
        // second lane
        currentX = 0;
        interval = 600;
        locY = locY - 50 - 5;
        velocityX = 5;
        this.vehicles.add(new Ambulance(new CartPt(currentX, locY), 
                velocityX));
        // third lane;
        currentX = 0;
        interval = 600;
        locY = locY - 50 - 5;
        velocityX = -2;
        while (currentX < this.width) {
            // if (isCar) {
            this.vehicles.add(new Policecar(new CartPt(currentX, locY), 
                    velocityX));
            currentX = currentX + interval;
            // }
        }
        // fourth lane;
        currentX = 0;
        interval = 300;
        locY = locY - 50 - 5;
        velocityX = -1;
        while (currentX < this.width) {
            if (isCar)
                this.vehicles.add(new Car(new CartPt(currentX, locY), 
                        velocityX));
            else
                this.vehicles.add(new Motorcycle(new CartPt(currentX, locY), 
                        velocityX));
            currentX = currentX + interval;
            isCar = !isCar;
        }
    }
    // To initialize Floaters
    private void initFolaters() {
        int currentX;
        int interval;
        int velocityX;
        int locY;
        boolean isLeaf = true;
        // first lane;
        currentX = 0;
        interval = 300;
        locY = 53 + 53 / 2;
        velocityX = 1;
        while (currentX < this.width) {
            // if (isCar) {
            this.floaters.add(new Leaf(new CartPt(currentX, locY), 
                    velocityX));
            currentX = currentX + interval;
            // }
        }
        // second lane;
        currentX = 0;
        interval = 100;
        locY = locY + 53;
        velocityX = 3;
        while (currentX < this.width) {
            if (isLeaf) 
                this.floaters.add(new Leaf(new CartPt(currentX, locY), 
                    velocityX));
            else
                this.floaters.add(new Wood(new CartPt(currentX, locY), 
                        velocityX));      
            isLeaf = !isLeaf;
            currentX = currentX + interval;
            // }
        }
        // third lane;
        currentX = 0;
        interval = 500;
        locY = locY + 53;
        velocityX = -1;
        while (currentX < this.width) {
            // if (isCar) {
            this.floaters.add(new Wood(new CartPt(currentX, locY), 
                    velocityX));
            currentX = currentX + interval;
            // }
        }        
    }
    // To generate the background of this playground
    private WorldImage background() {
        return // background color
        new RectangleImage(new Posn(width / 2, height / 2), width, height,
                Color.getHSBColor(92, 163, 99))
                // score and lives
                .overlayImages(
                        new TextImage(new Posn(width - 125, 20), "Score: "
                                + Integer.toString(this.score) + " | Lifes: "
                                + Integer.toString(this.lives), 20, 1, 
                                Color.black))
                // road
                .overlayImages(
                        new RectangleImage(new Posn(width / 2, 
                                height - 50 * 3 - 5 * 2),
                                width, 50 * 4 + 5 * 3, Color.darkGray))
                .overlayImages(
                        new RectangleImage(new Posn(width / 2, 
                                height - 50 * 3 - 5 * 2
                                - 2), width, 2, Color.orange))
                .overlayImages(
                        new RectangleImage(new Posn(width / 2, 
                                height - 50 * 3 - 5 * 2
                                + 2), width, 2, Color.orange))
                .overlayImages(this.makeDashedLines(height - 50 * 2 - 5 - 3, 
                        20))
                .overlayImages(
                        this.makeDashedLines(height - 50 * 4 - 15 + 3, 20)
                                .overlayImages(
                                        new RectangleImage(new Posn(width / 2,
                                                height - 50 - 3), 
                                                width, 2, Color.white)
                                                .overlayImages(new RectangleImage(
                                                        new Posn(width / 2, 
                                                                height - 50
                                                                * 5 - 5 * 4 + 3
                                                                ), width,
                                                        2, Color.white))))
                // river
                .overlayImages(
                        new RectangleImage(
                                new Posn(width / 2, 53 + (3 * 53) / 2), width,
                                3 * 53, Color.blue));
    }

    // To draw dashed line for the road
    private WorldImage makeDashedLines(int y, int dashLength) {
        int interval = 50;
        WorldImage currentImage = new DiskImage(new Posn(0, 0), 0, 
                Color.darkGray);
        int currentX = 0;
        while (currentX < this.width) {
            currentImage = currentImage.overlayImages(new RectangleImage(
                    new Posn(
                    currentX, y), dashLength, 2, Color.white));
            currentX = currentX + interval;
        }
        return currentImage;
    }

    // To draw this playground
    public WorldImage makeImage() {
        WorldImage currentImage = this.background();
        for (Floater f : this.floaters) {
            currentImage = currentImage.overlayImages(f.makeImage());
        }
        
        currentImage = currentImage.overlayImages(this.frog.makeImage());
        
        for (Vehicle v : this.vehicles) {
            currentImage = currentImage.overlayImages(v.makeImage());
        }
        return currentImage;
    }

    // To deal with the KeyEvent
    public World onKeyEvent(String ke) {
        if (ke.equals("up"))
            this.frog.moveBy(0, -53);
        else if (ke.equals("down"))
            this.frog.moveBy(0, 53);
        else if (ke.equals("left"))
            this.frog.moveBy(-50, 0);
        else if (ke.equals("right"))
            this.frog.moveBy(50, 0);

        return this;
    }

    // To move the world on tick
    public World onTick() {
        if (this.lives <= 0)
            return this;
        for (Vehicle v : this.vehicles) {
            v.moveOn();
        }
        for (Floater f : this.floaters) {
            f.moveOn();
        }
        this.frog.moveOn();
        if (this.frogHit() || this.frogDrowned()) {
            this.frog.relocate(new CartPt(this.width / 2, height - 25));
            this.lives--;
        }
        return this;
    }

    // After each tick, check if UFO hit the ground -
    // if yes, end the game
    public WorldEnd worldEnds() {
        if (this.lives <= 0) {
            return new WorldEnd(true, this.makeImage().overlayImages(
                    new TextImage(new Posn(width / 2, height / 2), 
                            "GAME OVER", 
                            30, 1,
                            Color.red)));
        } else {
            if (this.frog.isPasssed()) {
                this.score++;
                this.frog.relocate(new CartPt(this.width / 2, height - 25));
            }
            return new WorldEnd(false, this.makeImage());
        }

    }

    // To check if any vehicle hit the frog
    public boolean frogHit() {
        for (Vehicle v : this.vehicles) {
            if (v.crush(this.frog.getLoc()))
                return true;
        }

        return false;
    }
    // To check if any floater get the frog
    public boolean frogDrowned() {
        if ((this.frog.loc.y <= 53 + 50 /2) ||
                (this.frog.loc.y >= 4 * 53 + 50 /2 ))
            return false;
        for (Floater f : this.floaters) {
            if (f.catches(this.frog.getLoc())) {
                this.frog.hopOn(f);
                return false;
            }
        }
        return true;
    }    

}
