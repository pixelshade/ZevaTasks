package pixelshade.zevatasks;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import pixelshade.zevatasks.tasks.Task;
import pixelshade.zevatasks.tasks.Work;


public class TaskOverview extends ActionBarActivity implements View.OnClickListener {
    public static String ARG_TASK_ID = "task_index";
    private PieChart mPieChart;
    private ListView mWorkersLV;
    private Task mTask;
    private Button mToggleButton;
    private List<Work> mWorks;

    private boolean mShowChart = true;


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
        mWorkersLV = (ListView) findViewById(R.id.taskWorkersListView);
        mToggleButton = (Button) findViewById(R.id.toggleWorksListChartButton);

        mToggleButton.setOnClickListener(this);

        nameTV.setAllCaps(true);
        nameTV.setText(mTask.name);
        infoTV.setText(mTask.info);

        mWorks = Work.find(Work.class, "task = ?", mTask.getId().toString());

        mPieChart = (PieChart) findViewById(R.id.workPieChart);

        setUpPieChart(mWorks, mPieChart);
        WorkersAdapter workersAdapter = new WorkersAdapter(this, mWorks);
        mWorkersLV.setAdapter(workersAdapter);


        ToggleChartListVisibility();
    }

    private static void setUpPieChart(List<Work> mWorks, PieChart mPieChart) {
        ArrayList<Entry> yVals = new ArrayList<Entry>();
        ArrayList<String> xVals = new ArrayList<String>();

        int i = 0;
        for(Work w: mWorks) {
            yVals.add(new Entry(w.hours,i));
            xVals.add(w.worker);
            i++;
        }


        ArrayList<Integer> colors = new ArrayList<Integer>();
        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        PieDataSet pieDataSet = new PieDataSet(yVals, "hours");
        pieDataSet.setColors(colors);
        PieData pieData = new PieData(xVals,pieDataSet);
        mPieChart.setData(pieData);
        mPieChart.setDescription("");

        mPieChart.animateXY(1500, 1500);
        Legend l = mPieChart.getLegend();
        l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART_INSIDE);
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

    @Override
    public void onClick(View v) {
        ToggleChartListVisibility();
    }

    private void ToggleChartListVisibility(){
        if(mShowChart){
            mWorkersLV.setVisibility(View.GONE);
            mPieChart.setVisibility(View.VISIBLE);
            mToggleButton.setText("Show list");
        } else {
            mWorkersLV.setVisibility(View.VISIBLE);
            mPieChart.setVisibility(View.GONE);
            mToggleButton.setText("Show chart");
        }
        mShowChart = !mShowChart;
    }
}
