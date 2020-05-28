public class BasicMultiThreading implements Runnable{ 
    private final String name;
    
    public BasicMultiThreading(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.name+ ": "+i);
        }
    }
    public static void main(String[] args) {
        //4 tane paralel thread
        for (int i = 0; i < 4; i++) {
            //start run methodunu çağır
            new Thread(new BasicMultiThreading("Thread "+i)).start();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("Main: "+i);
        }
    }
}

/*
runnable =
synchronisation

*/