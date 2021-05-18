package com.example.trabajo;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Sonido1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Sonido1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Sonido1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Sonido1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Sonido1.
     */
    // TODO: Rename and change types and number of parameters
    public static Sonido1 newInstance(String param1, String param2) {
        Sonido1 fragment = new Sonido1();
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



    private Button play_pause, btn_repetir,Stop,Siguiente,Anterior;
    MediaPlayer mp;
    ImageView iv;
    int repetir = 2, posicion = 0;
    MediaPlayer vectormp [] = new MediaPlayer [5];
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sonido1, container, false);
        play_pause = view.findViewById(R.id.btn_play);
        btn_repetir = view.findViewById(R.id.btn_repetir);
        Stop = view.findViewById(R.id.btn_stop);
        Siguiente = view.findViewById(R.id.btn_siguiente);
        Anterior = view.findViewById(R.id.btn_anterior);

        iv = view.findViewById(R.id.imageView);

        vectormp[0] = MediaPlayer.create(getActivity(),R.raw.musica1);
        vectormp[1] = MediaPlayer.create(getActivity(),R.raw.musica2);
        vectormp[2] = MediaPlayer.create(getActivity(),R.raw.musica3);


        play_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vectormp[posicion].isPlaying()){
                    vectormp[posicion].pause();
                    play_pause.setBackgroundResource(R.drawable.reproducir);
                    Toast.makeText(getActivity(),"Pausa", Toast.LENGTH_SHORT).show();
                } else {
                    vectormp[posicion].start();
                    play_pause.setBackgroundResource(R.drawable.pausa);
                    Toast.makeText(getActivity(), "Play", Toast.LENGTH_SHORT).show();
                }

            }
        });


        Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_repetir.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(vectormp[posicion] != null){
                            vectormp[posicion].stop();

                            vectormp[0] = MediaPlayer.create(getActivity(),R.raw.musica1);
                            vectormp[1] = MediaPlayer.create(getActivity(), R.raw.musica2);
                            vectormp[2] = MediaPlayer.create(getActivity(), R.raw.musica3);

                            posicion = 0;
                            play_pause.setBackgroundResource(R.drawable.reproducir);
                            iv.setImageResource(R.drawable.goteos);
                            Toast.makeText(getActivity(), "Stop", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });

        btn_repetir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(repetir == 1){
                    btn_repetir.setBackgroundResource(R.drawable.no_repetir);
                    Toast.makeText(getActivity(), "No repetir", Toast.LENGTH_SHORT).show();
                    vectormp[posicion].setLooping(false);
                    repetir = 2;
                } else {
                    btn_repetir.setBackgroundResource(R.drawable.repetir);
                    Toast.makeText(getActivity(), "Repetir", Toast.LENGTH_SHORT).show();
                    vectormp[posicion].setLooping(true);
                    repetir = 1;
                }

            }
        });
        Siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(posicion < vectormp.length -1){

                    if(vectormp[posicion].isPlaying()){
                        vectormp[posicion].stop();
                        posicion++;
                        vectormp[posicion].start();

                        if(posicion == 0){
                            iv.setImageResource(R.drawable.goteos);
                        } else if(posicion == 1){
                            iv.setImageResource(R.drawable.goteos2);
                        }else if(posicion == 2){
                            iv.setImageResource(R.drawable.goteos3);
                        }

                    } else {
                        posicion++;

                        if(posicion == 0){
                            iv.setImageResource(R.drawable.goteos);
                        } else if(posicion == 1){
                            iv.setImageResource(R.drawable.goteos2);
                        }else if(posicion == 2){
                            iv.setImageResource(R.drawable.goteos3);

                        }
                    }

                } else {
                    Toast.makeText(getActivity(), "No hay más canciones", Toast.LENGTH_SHORT).show();
                }

            }
        });


        Anterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(posicion >= 1){

                    if(vectormp[posicion].isPlaying()){
                        vectormp[posicion].stop();
                        vectormp[0] = MediaPlayer.create(getActivity(), R.raw.musica1);
                        vectormp[1] = MediaPlayer.create(getActivity(), R.raw.musica2);
                        vectormp[2] = MediaPlayer.create(getActivity(), R.raw.musica3);
                        posicion--;

                        if(posicion == 0){
                            iv.setImageResource(R.drawable.goteos);
                        } else if(posicion == 1){
                            iv.setImageResource(R.drawable.goteos2);
                        }else if(posicion == 2){
                            iv.setImageResource(R.drawable.goteos3);
                        }

                        vectormp[posicion].start();

                    } else {
                        posicion--;

                        if(posicion == 0){
                            iv.setImageResource(R.drawable.goteos);
                        } else if(posicion == 1){
                            iv.setImageResource(R.drawable.goteos2);
                        }else if(posicion == 2){
                            iv.setImageResource(R.drawable.goteos3);

                        }
                    }

                } else {
                    Toast.makeText(getActivity(), "No hay más canciones", Toast.LENGTH_SHORT).show();
                }

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
