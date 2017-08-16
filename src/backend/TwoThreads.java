package backend;

import java.util.HashMap;

/**
 * Created by jay on 7/28/17.
 */

/**
 * Basic implementation of two threads sharing one HashMap and trying to update one key
 * Because the second threads updates after a minutes First thread has completed its task
 * it would be able to Update the value of the same key. By property the HashMap would override
 * the values when we do not have a check.
 * The difference is created when we implement the join() method , without it we might be able to
 * see the actual value of the Map. It randomly print the value when either of the Threads process first.
 * */
public class TwoThreads {
    private static HashMap<Integer, String> map = new HashMap<>();

    public static class ThreadOne implements Runnable {

        @Override
        public void run() {
            map.put(1, "one");
            try {
                Thread.sleep(100000);
            }catch(Exception e)
            {}
        }
    }

    public static class ThreadTwo implements Runnable {

        @Override
        public void run() {
            map.put(1, "two");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread one = new Thread(new ThreadOne());
        Thread two = new Thread(new ThreadTwo());

        one.start();

        two.start();
        one.join();
        two.join();
        System.out.println("final: "+map.get(1));


    }

}
