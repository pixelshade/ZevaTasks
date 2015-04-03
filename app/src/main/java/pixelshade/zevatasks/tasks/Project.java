package pixelshade.zevatasks.tasks;

import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by pixelshade on 1.4.2015.
 */
public class Project extends SugarRecord<Project> implements Serializable {
    public String name;
    public int status;
    public int timeSpent;
    public Date createdAt;
    public Date completedAt;
    public int isPreset;

    // constructors
    public Project() {
    }

    public Project(String name, int status, int timeSpent, Date createdAt, Date completedAt, int isPreset) {
        this.name = name;
        this.status = status;
        this.timeSpent = timeSpent;
        this.createdAt = createdAt;
        this.completedAt = completedAt;
        this.isPreset = isPreset;
    }

    public void MakePreset(){

    }

}