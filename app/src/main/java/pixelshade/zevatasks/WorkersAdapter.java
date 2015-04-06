package pixelshade.zevatasks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import pixelshade.zevatasks.tasks.Work;

/**
 * Created by pixelshade on 6.4.2015.
 */



public class WorkersAdapter extends ArrayAdapter<Work> {
    private Context context;
    private LayoutInflater inflater;
    private List<Work> workItems;

    static class ViewHolder {
        TextView nameTextView;
        TextView hoursTextView;
    }


    public WorkersAdapter(Context context, List<Work> values) {
        super(context, R.layout.workers_row_layout, values);
        this.context = context;
        this.workItems = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if(rowView == null) {
            //set viewholder
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.workers_row_layout, null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.nameTextView =(TextView) rowView.findViewById(R.id.workerNameTextView);
            viewHolder.hoursTextView = (TextView) rowView.findViewById(R.id.workerHoursTextView);
            rowView.setTag(viewHolder);
        }


        ViewHolder holder = (ViewHolder) rowView.getTag();
        holder.nameTextView.setText(workItems.get(position).worker);
        holder.hoursTextView.setText(workItems.get(position).hours+"h");

        return rowView;

    }
}