import tester.*;
import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;
import javalib.colors.*;
import java.awt.Color;
public class Examples {
    Frog frog1 = new Frog(new CartPt(1024/ 2, 583 - 25));
    Frog frog2 = new Frog(new CartPt(1024/ 2, 0));
    Frog frog3 = new Frog(new CartPt(1024/ 2, 583 - 53 * 2));
    Floater leaf1 = new Leaf(new CartPt(1024/ 2, 583 - 53 * 2), 1);
    Floater wood1 = new Wood(new CartPt(1024/ 2, 583 - 53 * 2), 1);
    Vehicle policecar1 = new Policecar(new CartPt(1024/ 2, 583 - 53 * 2), 1);
    Vehicle policecar1a = new Policecar(new CartPt(1024/ 2, 583 - 53 * 2), -1);
    Vehicle car1 = new Car(new CartPt(1024/ 2, 583 - 53 * 2), 1);
    Vehicle car1a = new Car(new CartPt(1024/ 2, 583 - 53 * 2), -1);
    Vehicle ambulance1 = new Ambulance(new CartPt(1024/ 2, 583 - 53 * 2), 1);
    Vehicle ambulance1a = new Ambulance(new CartPt(1024/ 2, 583 - 53 * 2), -1);
    Vehicle motorcycle1 = new Motorcycle(new CartPt(1024/ 2, 583 - 25), 1);
    Vehicle motorcycle1a = new Motorcycle(new CartPt(1024/ 2, 583 - 25), -1);
    
    Playground World1 = new Playground(frog1, 0, 3);     
    void testFrog(Tester t) {
        
        t.checkExpect(frog1.getLoc(), frog1.loc);
        t.checkExpect(frog1.getLoc(), frog1.loc);
        t.checkExpect(frog2.isPasssed(), true);
        t.checkExpect(frog2.getLoc(), frog2.loc);
    }
    void testFoaters(Tester t) {        
        Frog frog3a = new Frog(new CartPt(1024/ 2, 583 - 53 * 2));
        Floater leaf1a = new Leaf(new CartPt(1024/ 2, 583 - 53 * 2), 1);
        Playground World1a = new Playground(frog3a, 0, 3);
        World1a.floaters.add(leaf1a);
        
        t.checkExpect(leaf1a.catches(frog3a.getLoc()), true);
        t.checkExpect(frog3a.floater, null);
        t.checkExpect(World1a.frogDrowned(), false);
        //t.checkExpect(frog3a.floater, leaf1a);
    }
    void testMakeImages(Tester t) {
        t.checkExpect(frog1.makeImage(), new FromFileImage(frog1.getLoc(), "frog.png"));
        t.checkExpect(leaf1.makeImage(), new FromFileImage(leaf1.getLoc(), "leaf.png"));
        t.checkExpect(wood1.makeImage(), new FromFileImage(wood1.getLoc(), "wood.png"));
        t.checkExpect(policecar1.makeImage(), new FromFileImage(policecar1.loc, "policecar_right.png"));
        t.checkExpect(policecar1a.makeImage(), new FromFileImage(policecar1a.loc, "policecar_left.png"));
        t.checkExpect(car1.makeImage(), new FromFileImage(car1.loc, "car_right.png"));
        t.checkExpect(car1a.makeImage(), new FromFileImage(car1a.loc, "car_left.png"));
        t.checkExpect(ambulance1.makeImage(), new FromFileImage(ambulance1.loc, "ambulance_right.png"));
        t.checkExpect(ambulance1a.makeImage(), new FromFileImage(ambulance1a.loc, "ambulance_left.png"));
        t.checkExpect(motorcycle1.makeImage(), new FromFileImage(motorcycle1.loc, "motorcycle_right.png"));
        t.checkExpect(motorcycle1a.makeImage(), new FromFileImage(motorcycle1a.loc, "motorcycle_left.png"));
        
    }
}
