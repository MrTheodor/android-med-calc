package com.mycompany.yasc;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class BasicCalculation extends Fragment {

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment BasicCalculation.
     */
    public static BasicCalculation newInstance() {
        BasicCalculation fragment = new BasicCalculation();
        return fragment;
    }

    public BasicCalculation() {
        // Required empty public constructor
    }

    private void setValues(EditText input, EditText output, double factor) {
        String sValue = input.getText().toString().replace(',', '.');
        if (sValue.isEmpty()) {
            output.setText("");
        } else {
            double value = Double.valueOf(sValue) * factor;
            output.setText(String.format("%.2f", value));
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_basic_calculation, container, false);

        final EditText editTextGlucoseMmol = (EditText) view.findViewById(R.id.glucose_mmol);
        final EditText editTextGlucoseDl = (EditText) view.findViewById(R.id.glucose_mg);
        final EditText editTextCholesterolMmol = (EditText) view.findViewById(R.id.cholesterol_mmol);
        final EditText editTextCholesterolDl = (EditText) view.findViewById(R.id.cholesterol_mg);
        final EditText editTextTriglyceridesMmol = (EditText) view.findViewById(R.id.triglycerides_mmol);
        final EditText editTextTriglyceridesDl = (EditText) view.findViewById(R.id.triglycerides_mg);
        final EditText editTextHemoglobinMmol = (EditText) view.findViewById(R.id.hemoglobin_mmol);
        final EditText editTextHemoglobinDl = (EditText) view.findViewById(R.id.hemoglobin_mg);
        final EditText editTextCreatinineMmol = (EditText) view.findViewById(R.id.creatinine_mmol);
        final EditText editTextCreatinineDl = (EditText) view.findViewById(R.id.creatinine_mg);
        editTextGlucoseMmol.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    setValues(editTextGlucoseMmol, editTextGlucoseDl, 18.0);
                }
                return false;
            }
        });

        editTextGlucoseDl.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    setValues(editTextGlucoseDl, editTextGlucoseMmol, 1.0 / 18.0);
                }
                return false;
            }
        });

        editTextCholesterolMmol.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    setValues(editTextCholesterolMmol, editTextCholesterolDl, 38.5);
                }
                return false;
            }
        });

        editTextCholesterolDl.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    setValues(editTextCholesterolDl, editTextCholesterolMmol, 1.0 / 38.5);
                }
                return false;
            }
        });

        editTextTriglyceridesMmol.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    setValues(editTextTriglyceridesMmol, editTextTriglyceridesDl, 88.5);
                }
                return false;
            }
        });

        editTextTriglyceridesDl.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    setValues(editTextTriglyceridesDl, editTextTriglyceridesMmol, 1.0 / 88.5);
                }
                return false;
            }
        });

        editTextHemoglobinMmol.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    setValues(editTextHemoglobinMmol, editTextHemoglobinDl, 1.6129);
                }
                return false;
            }
        });

        editTextHemoglobinDl.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    setValues(editTextHemoglobinDl, editTextHemoglobinMmol, 0.62);
                }
                return false;
            }
        });

        editTextCreatinineMmol.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    setValues(editTextCreatinineMmol, editTextCreatinineDl, 88.0);
                }
                return false;
            }
        });

        editTextCreatinineDl.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    setValues(editTextCreatinineDl, editTextCreatinineMmol, 1.0/88.0);
                }
                return false;
            }
        });

        // Clear button.
        Button btnClick = (Button) view.findViewById(R.id.btnClear);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextGlucoseMmol.setText("");
                editTextGlucoseDl.setText("");
                editTextCholesterolDl.setText("");
                editTextCholesterolMmol.setText("");
                editTextHemoglobinDl.setText("");
                editTextHemoglobinMmol.setText("");
                editTextTriglyceridesDl.setText("");
                editTextTriglyceridesMmol.setText("");
                editTextCreatinineMmol.setText("");
                editTextCreatinineDl.setText("");
            }
        });

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
