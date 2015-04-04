package pixelshade.zevatasks.tasks;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by pixelshade on 1.4.2015.
 */
public class Task extends SugarRecord<Task>{

    public String name;
    public String info;
    public int status;
    public int timeSpent;
    public Date completedAt;

    public Project project;

    // constructors
    public Task() {
        completedAt = new Date(Long.MAX_VALUE);
    }

    public String ToString(){
        return name;
    }

}