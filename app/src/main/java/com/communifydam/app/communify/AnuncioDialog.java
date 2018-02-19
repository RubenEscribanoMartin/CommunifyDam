package com.communifydam.app.communify;

import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * Created by 2912 on 07/02/2018.
 */


public class AnuncioDialog extends DialogFragment {
    private int paso = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.anuncio_add, container);
        final ViewPager vp = v.findViewById(R.id.dgPager);
        vp.setAdapter(new AdaptadorPagerAddAnuncio(getChildFragmentManager()));
        paso = 0;

        final Button next = v.findViewById(R.id.bNext);
        final Button prev = v.findViewById(R.id.bPrev);


        if (paso==0) {
            prev.setEnabled(false);
            next.setEnabled(true);
        } else if(paso==3) {
            prev.setEnabled(false);
            next.setEnabled(true);
        } else {
            prev.setEnabled(true);
            next.setEnabled(true);
        }


        vp.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
                                       @Override
                                       public void onPageSelected(int pos) {
                                           paso = pos;
                                           if (paso==0) {
                                               prev.setEnabled(false);
                                               next.setEnabled(true);
                                           } else if(paso==3) {
                                               prev.setEnabled(false);
                                               next.setEnabled(true);
                                           } else {
                                               prev.setEnabled(true);
                                               next.setEnabled(true);
                                           }

                                       }
        });



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paso++;
                vp.setCurrentItem(paso);

            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paso--;
                vp.setCurrentItem(paso);

            }
        });

        return v;


    }

    /*
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title = getArguments().getString("title");
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle(title);

        return alertDialogBuilder.create();
    } */
}