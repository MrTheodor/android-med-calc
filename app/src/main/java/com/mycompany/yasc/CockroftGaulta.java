package com.mycompany.yasc;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class CockroftGaulta extends Fragment {


    public static CockroftGaulta newInstance() {
        CockroftGaulta fragment = new CockroftGaulta();
        return fragment;
    }

    public CockroftGaulta() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cockroft_gaulta, container, false);
    }


}
