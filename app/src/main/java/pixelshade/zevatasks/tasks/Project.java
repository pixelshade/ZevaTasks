package pixelshade.zevatasks.tasks;

import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by pixelshade on 1.4.2015.
 */
public class Project extends SugarRecord<Project> implements Serializable {
    public String name;
    public int status;
    public int timeSpent;
    public int timeBank;

    public Date createdAt;
    public Date completedAt;
    public int isPreset;

    // constructors
    public Project() {
        createdAt = new Date();
        completedAt = new Date(Long.MAX_VALUE);
    }

    public Project(String name, int isPreset, int timeBank) {
        this.name = name;
        this.status = status;
        this.timeSpent = timeSpent;
        this.createdAt = createdAt;
        this.completedAt = completedAt;
        this.isPreset = isPreset;
        this.timeBank = timeBank;
    }

    public Project saveDuplicateAsPreset(String presetName, int timeBank){
        Project preset = new Project();
        preset.timeBank = timeBank;
        preset.name = presetName;
        preset.status = 0;
        preset.timeSpent =0;
        preset.isPreset = 1;
        preset.save();

        long presetId =  preset.getId();
        List<Task> tasks = Task.find(Task.class,"project = ?",""+presetId);

        for(Task t : tasks){
            Task presetTask = new Task();
            presetTask.project = preset;

            presetTask.info = t.info;
            presetTask.name = t.name;
            presetTask.save();
        }

        return preset;
    }

    public Project projectFromPreset(){
        return projectFromPreset("Default Name", 60);
    }

    public Project projectFromPreset(String name, int timeBank) {
        Project project = new Project();
        project.timeBank = timeBank;
        project.name = name;
        project.createdAt = new Date();
        project.save();

        List<Task> tasks = Task.find(Task.class,"project = ?",""+getId());

        for(Task t : tasks){
            Task projectTask = new Task();
            projectTask.project = this;
            projectTask.info = t.info;
            projectTask.name = t.name;
            projectTask.save();
        }

        return project;
    }

    public String ToString(){
        return name;
    }
}