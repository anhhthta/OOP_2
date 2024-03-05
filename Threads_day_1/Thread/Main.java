package Threads_day_1.Thread;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        int numThreads = 6;
        int incrementsPerThread = 5;
        IncrementThread[] threads = new IncrementThread[numThreads];

        // Create and start the threads
        for(int i = 0; i < numThreads; i++){
            threads[i] = new IncrementThread(counter, incrementsPerThread);
            threads[i].start();
        }

//        Wait for all threads to finish
        try{
            for(IncrementThread thread: threads){
                thread.join();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
