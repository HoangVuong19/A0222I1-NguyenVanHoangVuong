package _04_class_and_object_java.bai_tap.bai_xay_dung_lop_stop_watch;

import java.util.Date;

public class StopWatch {
    private Date startTime;
    private Date endTime;

    public StopWatch() {
        startTime = new Date();
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void start() {
        startTime = new Date();
    }

    public void stop() {
        endTime = new Date();
    }

    public long getElapsedTime() {
        return endTime.getTime() - startTime.getTime();
    }
}
