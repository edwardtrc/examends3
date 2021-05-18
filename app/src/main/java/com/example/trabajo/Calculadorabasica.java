package com.example.trabajo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Calculadorabasica.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Calculadorabasica#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Calculadorabasica extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Calculadorabasica() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Calculadorabasica.
     */
    // TODO: Rename and change types and number of parameters
    public static Calculadorabasica newInstance(String param1, String param2) {
        Calculadorabasica fragment = new Calculadorabasica();
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
    //creamos las variables
    private TextView tvdisplay;
    private Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bpunto,bsuma,bigual,bresta,
            bmultiplicar,bdivicion,braiz,btangente,bcoseno,bseno,bcubo,bcuadrado,bpotencialn,bfactorial,bborrartodo,bborrarultimo,brnd,boff;
    private double n1,n2,res;
    private String operador;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       final View view= inflater.inflate(R.layout.fragment_calculadorabasica, container, false);
       tvdisplay= view.findViewById(R.id.tvvis);
        b0= view.findViewById(R.id.b0);
        b1= view.findViewById(R.id.b1);
        b2= view.findViewById(R.id.b2);
        b3= view.findViewById(R.id.b3);
        b4= view.findViewById(R.id.b4);
        b5= view.findViewById(R.id.b5);
        b6= view.findViewById(R.id.b6);
        b7= view.findViewById(R.id.b7);
        b8= view.findViewById(R.id.b8);
        b9= view.findViewById(R.id.b9);
        bsuma= view.findViewById(R.id.bsuma);
        bresta= view.findViewById(R.id.bresta);
        bpunto= view.findViewById(R.id.bpunto);
        bmultiplicar= view.findViewById(R.id.bmultiplicar);
        bdivicion= view.findViewById(R.id.bdivicion);
        braiz= view.findViewById(R.id.braiz);
        bigual= view.findViewById(R.id.bigual);
        btangente= view.findViewById(R.id.btangente);
        bcoseno= view.findViewById(R.id.bcoseno);
        bseno= view.findViewById(R.id.bseno);
        bcubo= view.findViewById(R.id.bcubo);
        bcuadrado= view.findViewById(R.id.bcuadrado);
        bpotencialn= view.findViewById(R.id.bpotencialn);
        bfactorial= view.findViewById(R.id.bfactorial);
        bborrartodo= view.findViewById(R.id.bborrartodo);
        bborrarultimo= view.findViewById(R.id.bborrarultimo);
        brnd= view.findViewById(R.id.brnd);
        boff= view.findViewById(R.id.boff);
       b0.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               tvdisplay.setText(tvdisplay.getText()+"0");

           }
       });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tvdisplay.setText(tvdisplay.getText()+"1");

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tvdisplay.setText(tvdisplay.getText()+"2");

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tvdisplay.setText(tvdisplay.getText()+"3");

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tvdisplay.setText(tvdisplay.getText()+"4");

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tvdisplay.setText(tvdisplay.getText()+"5");

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tvdisplay.setText(tvdisplay.getText()+"6");

            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tvdisplay.setText(tvdisplay.getText()+"7");

            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tvdisplay.setText(tvdisplay.getText()+"8");

            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tvdisplay.setText(tvdisplay.getText()+"9");

            }
        });

        bpunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tvdisplay.setText(tvdisplay.getText()+".");

            }
        });
        bsuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operador="+";
                OnClickOperacioncapturanumero1(view);

            }
        });
        bresta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operador="-";
                OnClickOperacioncapturanumero1(view);

            }
        });
        bmultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operador="*";
                OnClickOperacioncapturanumero1(view);
            }
        });
        bdivicion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operador="/";
                OnClickOperacioncapturanumero1(view);
            }
        });
        braiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    n1=Double.parseDouble(tvdisplay.getText().toString());
                    res=Math.sqrt(n1);
                    tvdisplay.setText(String.valueOf(res));
                }catch (NumberFormatException nfe){

                }
            }
        });
        btangente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    n1=Double.parseDouble(tvdisplay.getText().toString());
                    double rd=Math.toRadians(n1);
                    res=Math.tan(rd);
                    tvdisplay.setText(String.valueOf(res));
                }catch (NumberFormatException nfe){

                }
            }
        });

        bcoseno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    n1=Double.parseDouble(tvdisplay.getText().toString());
                    double rd=Math.toRadians(n1);
                    res=Math.cos(rd);
                    tvdisplay.setText(String.valueOf(res));
                }catch (NumberFormatException nfe){

                }
            }
        });
        bseno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    n1=Double.parseDouble(tvdisplay.getText().toString());
                    double rd=Math.toRadians(n1);
                    res=Math.sin(rd);
                    tvdisplay.setText(String.valueOf(res));
                }catch (NumberFormatException nfe){

                }
            }
        });
        bcubo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    n1=Double.parseDouble(tvdisplay.getText().toString());
                    res=Math.pow(n1,3);
                    tvdisplay.setText(String.valueOf(res));
                }catch (NumberFormatException nfe){

                }
            }
        });

        bcuadrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    n1=Double.parseDouble(tvdisplay.getText().toString());
                    res=Math.pow(n1,2);
                    tvdisplay.setText(String.valueOf(res));
                }catch (NumberFormatException nfe){

                }

            }
        });
        bpotencialn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operador="exp";

                try {
                    n1=Double.parseDouble(tvdisplay.getText().toString());
                    tvdisplay.setText(" ");
                }catch (NumberFormatException nfe){

                }

            }
        });
        bfactorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int fact=1;
                int x;
                try {
                    for(x=1;x<=1;x++){
                        fact = fact * x;
                    }
                    tvdisplay.setText(String.valueOf(res));

                }catch (NumberFormatException nfe){}

            }
        });
        bborrartodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1=0.0;
                n2=0.0;
                tvdisplay.setText(" ");


            }
        });

        bborrarultimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tvdisplay.getText().toString().equals(" "))
                {
                    tvdisplay.setText(tvdisplay.getText().subSequence(0,tvdisplay.getText().length()-1));
                }

            }
        });

        boff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        brnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int x=0;x<=100;x++){
                    int na=(int)Math.floor(Math.random() *(100-(1+1))+(1));
                    tvdisplay.setText(String.valueOf(na));
                }

            }
        });

        bigual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                n2=Double.parseDouble(tvdisplay.getText().toString());
                if (operador.equals("+")){
                    res=n1+n2;
                }else if (operador.equals("-")){
                    res=n1-n2;
                }else if (operador.equals("*")){
                    res=n1*n2;
                }else if (operador.equals("/")){
                    res=n1/n2;
                } else if (operador.equals("exp")){

                    n2=Double.parseDouble(tvdisplay.getText().toString());
                    tvdisplay.setText(" ");
                    res=Math.pow(n1,n2);
                }
                tvdisplay.setText(" "+res);
            }


        });



        return view;
    }


     public void OnClickOperacioncapturanumero1(View view) {
        tvdisplay=(TextView)view.findViewById(R.id.tvvis);
        n1=Double.parseDouble(tvdisplay.getText().toString());
        tvdisplay.setText(" ");
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
