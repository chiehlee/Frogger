import tester.*;
import javalib.funworld.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;
import javalib.colors.*;
import java.awt.Color;

public class Frog {
    // constant: the size of the screen
    int width = 1024;
    int height = 583;

    // the location of this UFO
    CartPt loc;
    // the name of the image file for displaying this apple
    String imgName = "frog.png";
    Floater floater;

    // To change the location of this Frog to the given one

    Frog(CartPt loc) {
        super();
        this.loc = loc;
    };

    // To set the location of this frog
    public CartPt relocate(CartPt newLoc) {
        this.loc = newLoc;
        return this.loc;
    }

    // To get the location of this frog
    public CartPt getLoc() {
        return this.loc;
    }

    // To move this frog along the given displacement
    public CartPt moveBy(int dx, int dy) {
        if ((this.loc.x + dx >= 0) && (this.loc.x + dx <= this.width)
        /* && (this.loc.y + dy >= 0) */&& (this.loc.y + dy <= this.height)) {
            this.loc = this.loc.moveBy(dx, dy);
            this.floater = null;
        }
        return this.loc;
        /*
         * this.loc.x = this.loc.x + displacement.x; this.loc.y = this.loc.y +
         * displacement.y;
         */
    }

    public boolean isPasssed() {
        return this.loc.y <= 0;
    }

    // To create the image of this frog
    public WorldImage makeImage() {
        // return new DiskImage(this.loc, 10, new Red());
        return new FromFileImage(this.loc, this.imgName);
    }

    // To make this frog hop on the given floater
    public Frog hopOn(Floater f) {
        this.floater = f;
        return this;
    }

    // To move this frog on the floater if there is any
    public CartPt moveOn() {
        if (!(this.floater == null))
            this.loc = this.floater.getLoc();
        return this.loc;
    }
}
