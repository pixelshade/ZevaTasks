package pixelshade.zevatasks.tasks;

import com.orm.SugarRecord;

/**
 * Created by pixelshade on 4.4.2015.
 */
public class Work extends SugarRecord<Work> {

    public String worker;
    public long hours;
    public Task task;



    public Work(){
    }

    public Work(String worker, long hours, Task task) {
        this.worker = worker;
        this.hours = hours;
        this.task = task;
    }
}
