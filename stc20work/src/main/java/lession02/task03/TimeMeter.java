package lession02.task03;

/**
 * Class helper for time mert
 */
public class TimeMeter {

    private long start;
    private long stop;

    public TimeMeter(){
        start = now();
    }

    public void stop(){
        stop = now();
    }

    @Override
    public String toString() {
        return getDuration() + " msec";
    }

    private long getDuration(){
        return (stop == 0 ? now() : stop) - start;
    }

    private long now(){
        return System.currentTimeMillis();
    }

}
