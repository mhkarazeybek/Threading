import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Synchronisation {
    int c = 0; 
    public void deSomething() {
        synchronized(this){
            ++c; //atomic bir operasyon değil
        }
    }
}

//Lock kullanma



class InnerSynch {

    int count = 0; //threadlerle paylaşılıyor

    Lock lock = new ReentrantLock();
    public void doSomething() {
        try {
            lock.lock();
            ++count;
        } finally {
            lock.unlock(); //sure to release the lock without fail
        }
    }
}
//Locking, responsive to interruption
class Locky{
    int count=0;//shared among multiple threads

    Lock lockObj = new ReentrantLock();
    public void doSomething() {
        try{
           try {
                lockObj.lockInterruptibly();
                ++count;
           } catch (InterruptedException e) {
               Thread.currentThread().interrupt();//stopping
           }
        }finally{
            if(!Thread.currentThread().isInterrupted()){
                lockObj.unlock();
            }
        }
    }
}
//Only do something when able to lock
class Locky2{
    int count = 0;
    Lock lockObj = new ReentrantLock();

    public void doSomething() {
        boolean locked = lockObj.tryLock();

        if(locked){
            try{
                ++count; //a non-atomic operation
            }finally{
                lockObj.unlock();
            }
        }
    }
}