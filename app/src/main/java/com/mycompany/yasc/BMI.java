package com.mycompany.yasc;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;


public class BMI extends Fragment {
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment BMI.
     */
    // TODO: Rename and change types and number of parameters
    public static BMI newInstance() {
        BMI fragment = new BMI();
        return fragment;
    }

    public BMI() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void updateBMI(View view) {
        EditText editWeight = (EditText) view.findViewById(R.id.weight);
        EditText editHeight = (EditText) view.findViewById(R.id.height);
        TextView outputBMI = (TextView) view.findViewById(R.id.bmiValue);
        String weightValue = editWeight.getText().toString().replace(',', '.');
        String heightValue = editHeight.getText().toString().replace(',', '.');
        if (weightValue.isEmpty() || heightValue.isEmpty()) {
            outputBMI.setText("0.0");
        } else {
            double weight = Double.valueOf(weightValue);
            double height = Double.valueOf(heightValue) / 100.0;
            outputBMI.setText(String.format("%.2f", weight/(height*height)));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_bmi, container, false);
        final EditText editWeight = (EditText) view.findViewById(R.id.weight);
        final EditText editHeight = (EditText) view.findViewById(R.id.height);

        editWeight.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    updateBMI(view);
                }
                return false;
            }
        });

        editHeight.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    updateBMI(view);
                }
                return false;
            }
        });

        return view;
    }


}
