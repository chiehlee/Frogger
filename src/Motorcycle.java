
public class Motorcycle extends Vehicle{
    Motorcycle(CartPt loc, int velocityX) {
        super(loc, velocityX, 52);
        if (velocityX < 0)
            this.imgName = "motorcycle_left.png";
        else
            this.imgName = "motorcycle_right.png";
    }
}
