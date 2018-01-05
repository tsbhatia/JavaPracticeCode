import java.util.List;
import java.util.ArrayList;

/*
Semaphore is very powerful synchronization
construct. Conceptually, semaphone maintains
a set of permit. 
A thread calling acquire() on the semaphore 
waits, if necessary, until a permit
is available, and then take it. 
A thread calling release() on a semaphone
adds a permit and notifies threads waiting
on that semaphore, potentially releasing a 
blocking acquirer.
*/
class Semaphore{
  private final int MAX_AVAILABLE;
  private int taken;

  public Semaphore(int maxAvailable){
   this.MAX_AVAILABLE = maxAvailable;
   this.taken = 0;
  }

  public synchronized void acquire() throws InterruptedException{
   while(this.taken == MAX_AVAILABLE){
    wait();
   }
   this.taken++;
  }

  public synchronized void release() throws InterruptedException{
   this.taken--;
   this.notifyAll();
  }
  
  public static void main(String args[]){
    Semaphore spr = new Semaphore(3);

    List<Thread> threadList = new ArrayList<Thread>();
     
    for(int i = 0; i < 10; i++){
      Thread t = new Thread(new Task(i,spr));
      threadList.add(t);
      t.start();
    }
    //threadList.forEach(x-> x.start());
    threadList.forEach(x-> {
           try{
            x.join();
           }catch (InterruptedException e){
             e.printStackTrace();
           }
       });
  }
  
  private static class Task implements Runnable{
     private int id;
     private Semaphore spr;
     public Task(int id, Semaphore spr){
      this.id = id;
      this.spr = spr;
     }

     public void run(){
       try{
         spr.acquire();
         System.out.println("Thread " + id+ " acquired permit.");
         int seconds = (int)(Math.random()*10)*1000;
         System.out.println("-- Thread "+ id + " sleeping for " + seconds+ " ms"); 
         Thread.sleep(seconds);
         spr.release();
	 System.out.println("== Thread " + id+" released permit.");
       }catch (InterruptedException e){
         e.printStackTrace();
       }
     }
  }
}
