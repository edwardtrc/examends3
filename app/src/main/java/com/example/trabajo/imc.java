package com.example.trabajo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link imc.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link imc#newInstance} factory method to
 * create an instance of this fragment.
 */
public class imc extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public imc() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment imc.
     */
    // TODO: Rename and change types and number of parameters
    public static imc newInstance(String param1, String param2) {
        imc fragment = new imc();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    private EditText altura,peso;
    private TextView resultado;
    float valor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_imc, container, false);



        altura = view.findViewById(R.id.editText);
        peso = view.findViewById(R.id.editText2);


        altura.setText("0");
        peso.setText("0");
        resultado = view.findViewById(R.id.resultado);
        altura.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (peso.getText().toString().equals("")){

                }
                else if (altura.getText().toString().equals("")){

                }
                else{
                    valor = Float.parseFloat(peso.getText().toString())/(Float.parseFloat(altura.getText().toString())*Float.parseFloat(altura.getText().toString()));
                    resultado.setText(String.valueOf(Math.round(valor*100.0)/100.0));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        peso.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (peso.getText().toString().equals("")){

                }
                else if (altura.getText().toString().equals("")){

                }
                else{
                    valor = Float.parseFloat(peso.getText().toString())/(Float.parseFloat(altura.getText().toString())*Float.parseFloat(altura.getText().toString()));
                    resultado.setText(String.valueOf(Math.round(valor*100.0)/100.0));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
