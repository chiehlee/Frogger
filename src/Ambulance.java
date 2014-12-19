public class Ambulance extends Vehicle {
    Ambulance(CartPt loc, int velocityX) {
        super(loc, velocityX, 66);
        if (velocityX < 0)
            this.imgName = "ambulance_left.png";
        else
            this.imgName = "ambulance_right.png";
    }
}
