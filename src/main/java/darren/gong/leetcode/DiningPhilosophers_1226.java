package darren.gong.leetcode;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers_1226 {
  private Lock[] forks = new ReentrantLock[5];
  private Lock publicLock = new ReentrantLock();
  public DiningPhilosophers_1226() {
    for (int i = 0; i < 5; i++) {
      forks[i] = new ReentrantLock();
    }
  }

  // call the run() method of any runnable to execute its code
  public void wantsToEat(int philosopher,
                         Runnable pickLeftFork,
                         Runnable pickRightFork,
                         Runnable eat,
                         Runnable putLeftFork,
                         Runnable putRightFork) throws InterruptedException {
    Lock left;
    Lock right;
    if (philosopher == 4) {
      left = forks[4];
      right = forks[0];
    } else {
      left = forks[philosopher];
      right = forks[philosopher+1];
    }

    publicLock.lock();
    left.lock();
    right.lock();
    pickLeftFork.run();
    pickRightFork.run();
    publicLock.unlock();

    eat.run();
    putLeftFork.run();
    putRightFork.run();
    right.unlock();
    left.unlock();
  }
}
