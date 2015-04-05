package pixelshade.zevatasks;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import pixelshade.zevatasks.tasks.Task;
import pixelshade.zevatasks.tasks.Work;


public class TaskOverview extends ActionBarActivity {
    public static String ARG_TASK_ID = "task_index";

    private Task mTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        long taskId =  intent.getLongExtra(ARG_TASK_ID, -1);

        mTask = Task.findById(Task.class, taskId);
        if (mTask == null) {
            finish();
            return;
        }

        setContentView(R.layout.activity_task_overview);

        TextView nameTV = (TextView) findViewById(R.id.taskNameTextView);
        TextView infoTV = (TextView) findViewById(R.id.taskInfoTextView);
        ListView workersLV = (ListView) findViewById(R.id.taskWorkersListView);

        nameTV.setAllCaps(true);
        nameTV.setText(mTask.name);
        infoTV.setText(mTask.info);

        List<Work> works = Work.find(Work.class, "task = ?", mTask.getId().toString());

        WorkersAdapter workersAdapter = new WorkersAdapter(this, works);
        workersLV.setAdapter(workersAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_task_overview, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == R.id.action_add_work_btn){
            CreateWork createWorkFragment = new CreateWork();
            Bundle bundle = new Bundle();
            bundle.putSerializable(createWorkFragment.ARG_TASK,mTask);
            createWorkFragment.setArguments(bundle);
            createWorkFragment.show(getSupportFragmentManager(),"CREATE_WORK");
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public class WorkersAdapter extends ArrayAdapter<Work> {
        private Context context;
        private LayoutInflater inflater;
        private List<Work> workItems;


        public WorkersAdapter(Context context, List<Work> values) {
            super(context, R.layout.workers_row_layout, values);
            this.context = context;
            this.workItems = values;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.workers_row_layout, parent, false);
            TextView nameTextView = (TextView) rowView.findViewById(R.id.workerNameTextView);
            TextView hoursTextView = (TextView) rowView.findViewById(R.id.workerHoursTextView);

            nameTextView.setText(workItems.get(position).worker);
            hoursTextView.setText("" + workItems.get(position).hours);


            return rowView;

        }
    }
}
