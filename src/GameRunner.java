import javalib.worldimages.*;
import javalib.worldcanvas.*;
import javalib.funworld.*;
import tester.Tester;

public class GameRunner {
    // the size of the screen
    int width = 1024;
    int height = 583;
    // defining
    Frog frog = new Frog(new CartPt(width/ 2, height - 25));
    Integer score = 0; 
    Integer lives = 3;
    boolean run() {
        Playground firstWorld = new Playground(frog, score, lives);
        return firstWorld.bigBang(width, height, 0.01);
    }
    public static void main(String[] argv) {
        GameRunner aor = new GameRunner();
        aor.run();
    }
}
