import javalib.worldimages.Posn;

// extension of the Posn class with move methods
public class CartPt extends Posn {
    CartPt(int x, int y) {
        super(x, y);
    }

    // produce a point moved by the given distance from this point
    CartPt moveBy(int dx, int dy) {
        return new CartPt(this.x + dx, this.y + dy);
    }
}