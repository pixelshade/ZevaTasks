package pixelshade.zevatasks;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import pixelshade.zevatasks.tasks.Project;
import pixelshade.zevatasks.tasks.Task;


public class CreateTask extends DialogFragment implements AdapterView.OnItemSelectedListener {
    public String ARG_PROJECT = "project";

//    private OnFragmentInteractionListener mListener;
    private int mSelectedPresetIndex = -1;
    private View mView;
    private Project mProject;


    public CreateTask() {
        // Required empty public constructor
    }



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mProject = (Project) getArguments().getSerializable(ARG_PROJECT);

        LayoutInflater inflater = getActivity().getLayoutInflater();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        mView = inflater.inflate(R.layout.fragment_create_task, null);

        builder.setTitle(getString(R.string.create_task))
                .setView(mView)
                .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        EditText taskNameEditText= (EditText) mView.findViewById(R.id.taskNameEditText);
                        EditText taskInfoEditText= (EditText) mView.findViewById(R.id.taskInfoEditText);

                        String taskName = taskNameEditText.getText().toString();
                        String taskInfo = taskInfoEditText.getText().toString();


                        Task task = new Task();
                        task.name = taskName;
                        task.info = taskInfo;
                        task.project = mProject;
                        task.save();

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
