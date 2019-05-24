package com.example.firstfragmentapp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyFragment extends Fragment {

    EditText e1,e2;

    Button b,updateBtn;

    MyFragmentListener myFragmentListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.my_fragment_layout, container, false);
        String s= (String) getArguments().get("key");
        e2 = v.findViewById(R.id.etxt2);
        updateBtn=v.findViewById(R.id.updatebtn);
        e2.setText(s);
        //  b=getActivity().findViewById(R.id.btn1);

        e1 = getActivity().findViewById(R.id.etxt1);



     /* b.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              String s=e.getText().toString();
              t.setText(s);
          }
      });*/


        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myFragmentListener.onUpdateField(e2.getText().toString());
            }
        });

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof MyFragmentListener)
        myFragmentListener = (MyFragmentListener) context;
  }

    interface MyFragmentListener{
        void onUpdateField(String updatedText);
    }
}
