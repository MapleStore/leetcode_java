package darren.gong.leetcode;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue1188 {
  private int capacity;
  private int size;
  private ReentrantLock lock;
  private Condition notEmpty;
  private Condition notFull;
  private int[] content;
  private int putIndex = 0;
  private int takeIndex = 0;
  public BoundedBlockingQueue1188(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    this.lock = new ReentrantLock();
    this.notEmpty = lock.newCondition();
    this.notFull = lock.newCondition();
    this.content = new int[capacity];
  }

  public void enqueue(int element) throws InterruptedException {
    try {
      lock.lock();
      while (size == capacity) {
        notFull.await();
      }
      content[putIndex] = element;
      putIndex = (putIndex+1)%capacity;
      size++;
      notEmpty.signal();
    } finally {
      lock.unlock();
    }
  }

  public int dequeue() throws InterruptedException {
    try {
      lock.lock();
      while (size == 0) {
        notEmpty.await();
      }
      int result = content[takeIndex];
      takeIndex = (takeIndex+1)%capacity;
      size--;
      notFull.signal();
      return result;
    } finally {
      lock.unlock();
    }
  }

  public int size() {
    return size;
  }
}
