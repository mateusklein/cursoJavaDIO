import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class main {

    /*
    private final static Queue<Integer> numbers = new LinkedBlockingQueue<>();
    
    private synchronized static void inc(int number){
        numbers.add(number);
    }


    private synchronized static void show(){
        System.out.println(numbers);
    }

    */

    private static AtomicInteger number = new AtomicInteger(0);
    
    public static void main(String[] args) {
        /*
        Runnable inc = () -> {
            for(int i = 0; i < 100; i++){
                inc(i);
            }
        };

        Runnable dec = () -> {
            for(int i = 100; i > 0; i++){
                inc(i);
            }
        };


        Runnable show = () -> {
            for(int i = 0; i < 200; i++){
                show();
            }
        };
        */
        Runnable inc = () -> {
            for(int i = 0; i < 50_000; i++){
                number.incrementAndGet();
            }
        };

        Runnable dec = () -> {
            for(int i = 50_000; i > 0; i++){
                number.decrementAndGet();
            }
        };


        Runnable show = () -> {
            for(int i = 0; i < 100_000; i++){
                System.out.println(number);
            }
        };



        var exexInc = new Thread(inc);
        exexInc.start();
        exexInc.setName("exexInc");


        var execDec =  new Thread(dec);
        execDec.start();
        execDec.setName("execDec");

        //ADICIONA UMA PRIORIZAÇÃO POR DETERMINADOS TEMPO
        //execDec.join(Duration.ofSeconds(1));

        var execShow = new Thread(show);
        execShow.start();
        execShow.setName("execShow");

        System.out.println(exexInc.getName());
        System.out.println(execDec.getName());
        System.out.println(execShow.getName());
    }

}
