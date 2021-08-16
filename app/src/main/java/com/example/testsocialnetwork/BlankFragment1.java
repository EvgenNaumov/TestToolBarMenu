package com.example.testsocialnetwork;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment1 newInstance(String param1, String param2) {
        BlankFragment1 fragment = new BlankFragment1();
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        InitView(view);
        iniPopupMenu(view);
    }

    private void iniPopupMenu(View view) {
        TextView textView1 = view.findViewById(R.id.text1_fragment);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = requireActivity();
                PopupMenu popupMenu = new PopupMenu(activity,v);

                activity.getMenuInflater().inflate(R.menu.popup,popupMenu.getMenu());

                //*****добавим еще один пункт меню динамически*****
                Menu menu = popupMenu.getMenu();
                menu.findItem(R.id.item1_popup).setVisible(false);
                menu.add(0, 123456, 12, R.string.new_menu_item_added);
                //****добавим еще один пункт меню динамически*****

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int itemId = item.getItemId();
                        switch (itemId){
                            case R.id.item1_popup:
                                Toast.makeText(getContext(), "popup 1", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.item2_popup:
                                Toast.makeText(getContext(), "popup 2", Toast.LENGTH_SHORT).show();
                                return true;
                            case 123456:
                                Toast.makeText(getContext(),"new menu",Toast.LENGTH_SHORT).show();
                                return true;
                        }
                        return false;
                    }
                });
                popupMenu.show();

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank1, container, false);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.main_fragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.action_add){
            Toast.makeText(getContext(), "Chosen add", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void InitView(View view) {

        InitButton1(view);
        InitButton2(view);

    }

    private void InitButton2(View view) {
        Button button = (Button) view.findViewById(R.id.button2);
        ConstraintLayout constraintLayout = (ConstraintLayout)view;
//        final Fragment fragmenttop =  new FragmentTop();
//        final Fragment conteiner = getChildFragmentManager().findFragmentById(R.id.fragment_of_item1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                FragmentManager fragmentManager = getChildFragmentManager();
//                fragmentManager.beginTransaction().add(R.id.fragment_of_item1,fragmenttop).commit();
                Toast.makeText(getContext(), "кнопка 2", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void InitButton1(View view) {

        Button button = (Button) view.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "кнопка 1", Toast.LENGTH_LONG).show();
            }
        });
    }
}