
import java.util.*;
import java.util.concurrent.*;

class ProducerConsumer{
  public static void main(String args[]) throws InterruptedException{
    BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(1);
    Producer pr = new Producer(queue);
    Consumer cr = new Consumer(queue);

    Thread tpr = new Thread(pr);
    Thread tcr = new Thread(cr);

    tpr.start();
    tcr.start();

    tpr.join();
    tcr.join();
  }

  private static class Producer implements Runnable{
    BlockingQueue<Integer> queue; 

    public Producer(BlockingQueue<Integer> queue){
      this.queue = queue;
    }

    public void run(){
      int count = 0;
      while(count <= 10){
        System.out.println("adding count: "+ count);
        try{
         queue.put(count++);
         Thread.sleep(1000);
        }catch(InterruptedException e){}
      }
    }
  }

  private static class Consumer implements Runnable{
    BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue){
      this.queue = queue;
    }

    public void run(){
      int count = 0;
      while(count < 10){
        try{
        count = queue.take();
        System.out.println("removed count: " + count);
        }catch(InterruptedException e){}
      } 
    }
  }

}
