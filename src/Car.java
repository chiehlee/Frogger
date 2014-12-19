
public class Car extends Vehicle{

    Car(CartPt loc, int velocityX) {
        super(loc, velocityX, 147);
        if (velocityX < 0)
            this.imgName = "car_left.png";
        else
            this.imgName = "car_right.png";
    }

}
