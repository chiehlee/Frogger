import javalib.worldimages.FromFileImage;
import javalib.worldimages.WorldImage;


public abstract class Floater {
    // constant: width of the playground
    int width = 1024;
    // the location of this UFO
    CartPt loc;
    // the name of the image file for displaying this apple
    String imgName;
    // the velocity of this car in x
    int velocityX;
    // the length of this vehicle
    int length;
    Floater(CartPt loc, String imgName, int velocityX, int length) {
        super();
        this.loc = loc;
        this.imgName = imgName;
        this.velocityX = velocityX;
        this.length = length;
    }
    // To move this Floater on
    public CartPt moveOn() {
        this.loc.x = (this.width + this.loc.x + this.velocityX) % width;
        return this.loc;
        // this.loc = this.loc.moveBy(velocityX, 0);
    }

    // To create the image of this Floater
    public WorldImage makeImage() {
        // return new DiskImage(this.loc, 10, new Red());
        return new FromFileImage(this.loc, this.imgName);
    }
    // To determine if this floater catch the given position
    public boolean catches(CartPt that) {
        return (Math.abs(this.loc.y - that.y) <= 10 
                && Math.abs(this.loc.x - that.x) < (this.length / 2 + 25));
    }
    // To get the location of this frog
    public CartPt getLoc() {
        return this.loc;
    }
}
