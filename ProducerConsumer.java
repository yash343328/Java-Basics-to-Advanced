class Company {
    int item;
    boolean produced = false;

    synchronized void produce(int item) throws InterruptedException {
        while (produced)
            wait();

        this.item = item;
        System.out.println("Produced: " + item);
        produced = true;
        notify();
    }

    synchronized int consume() throws InterruptedException {
        while (!produced)
            wait();

        System.out.println("Consumed: " + item);
        produced = false;
        notify();
        return item;
    }
}

class Producer extends Thread {
    Company c;

    Producer(Company c) {
        this.c = c;
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                c.produce(i);
                Thread.sleep(500);
            }
        } catch (Exception e) {
        }
    }
}

class Consumer extends Thread {
    Company c;

    Consumer(Company c) {
        this.c = c;
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                c.consume();
                Thread.sleep(500);
            }
        } catch (Exception e) {
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        Company c = new Company();
        new Producer(c).start();
        new Consumer(c).start();
    }
}
