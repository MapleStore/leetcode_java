package darren.gong.leetcode;

public class TrafficLight1279 {
  private volatile int roadId = 1;
  public TrafficLight1279() {

  }

  public void carArrived(
      int carId,           // ID of the car
      int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
      int direction,       // Direction of the car
      Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
      Runnable crossCar    // Use crossCar.run() to make car cross the intersection
  ) {
    synchronized (this) {
      if (this.roadId != roadId) {
        turnGreen.run();
        this.roadId = roadId;
      }
      crossCar.run();
    }
  }
}
