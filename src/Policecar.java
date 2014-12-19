
public class Policecar extends Vehicle{
    Policecar(CartPt loc, int velocityX) {
        super(loc, velocityX, 62);
        if (velocityX < 0)
            this.imgName = "policecar_left.png";
        else
            this.imgName = "policecar_right.png";
    }
}
