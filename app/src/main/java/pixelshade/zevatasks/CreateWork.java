package pixelshade.zevatasks;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

import pixelshade.zevatasks.tasks.Project;
import pixelshade.zevatasks.tasks.Task;
import pixelshade.zevatasks.tasks.Work;


public class CreateWork extends DialogFragment implements AdapterView.OnItemSelectedListener {
    public String ARG_TASK = "task";

//    private OnFragmentInteractionListener mListener;
    private int mSelectedPresetIndex = -1;
    private View mView;
    private Task mTask;


    public CreateWork() {
        // Required empty public constructor
    }



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mTask = (Task) getArguments().getSerializable(ARG_TASK);

        LayoutInflater inflater = getActivity().getLayoutInflater();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        mView = inflater.inflate(R.layout.fragment_create_work, null);

        builder.setTitle(getString(R.string.add_work))
                .setView(mView)
                .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        EditText workerEditText= (EditText) mView.findViewById(R.id.workerEditText);
                        EditText workHoursEditText= (EditText) mView.findViewById(R.id.workHoursEditText);

                        String worker = workerEditText.getText().toString();
                        long hours = Long.valueOf(workHoursEditText.getText().toString());

                        Work work = new Work();
                        work.worker = worker;
                        work.hours = hours;
                        work.task = mTask;
                        work.save();

                        mTask.timeSpent+=hours;
                        mTask.save();
                        }
                })
                .setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });


        return builder.create();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
//        try {
//            mListener = (OnFragmentInteractionListener) activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
//        mListener = null;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        public void onFragmentInteraction(Uri uri);
//    }

}
