package pixelshade.zevatasks;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentManager;
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
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import pixelshade.zevatasks.tasks.Project;

public class CreateProjectFragment extends DialogFragment implements AdapterView.OnItemSelectedListener {

    private OnFragmentInteractionListener mListener;
    private int mSelectedPresetIndex = -1;


    public CreateProjectFragment() {
        // Required empty public constructor
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final List<Project> projectPresetsList = Project.find(Project.class,"is_preset = ?","1");
        List<String> presetsNamesList = new ArrayList<String>();
        for(Project p : projectPresetsList){
           presetsNamesList.add(p.name);
        }

        Spinner presetsSpinner = (Spinner) getView().findViewById(R.id.presetsSpinner);
        presetsSpinner.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,presetsNamesList));
        presetsSpinner.setOnItemSelectedListener(this);

        LayoutInflater inflater = getActivity().getLayoutInflater();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Create project")
                .setView(inflater.inflate(R.layout.fragment_create_project, null))
                .setPositiveButton(getString(R.string.create_project), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        if(mSelectedPresetIndex==-1) {
                            Toast.makeText(getActivity(),"You must select preset to create project",Toast.LENGTH_LONG).show();
                            return;
                        }
                        Spinner presetsSpinner = (Spinner) getView().findViewById(R.id.presetsSpinner);
                        Project preset = projectPresetsList.get(mSelectedPresetIndex);
                        // TODO: CREATE PROJECT FROM PRESET
                        preset.createProject();
                        Project project = new Project();

                    }
                })
                .setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
//                .setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,presetsNamesList), new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        // The 'which' argument contains the index position
//                        // of the selected item
//                    }
//                });


        return builder.create();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
