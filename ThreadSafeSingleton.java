class Singleton {

    // volatile ensures visibility across threads
    private static volatile Singleton instance;

    // private constructor
    private Singleton() {
        System.out.println("Singleton Instance Created");
    }

    // public method to get instance
    public static Singleton getInstance() {
        if (instance == null) {                 // First check
            synchronized (Singleton.class) {
                if (instance == null) {         // Second check
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

public class ThreadSafeSingleton {
    public static void main(String[] args) {

        // Creating multiple threads
        Runnable task = () -> {
            Singleton s = Singleton.getInstance();
            System.out.println(s.hashCode());
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();
    }
}
