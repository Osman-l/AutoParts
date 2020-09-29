package com.autoparts.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.autoparts.Adapter.ListviewAdapterZapchast;
import com.autoparts.Adapter.Zapchast;
import com.autoparts.R;

import java.util.ArrayList;

public class FragmentStar extends Fragment {
    private static ArrayList<Zapchast> productList;
    private Zapchast item11;
    public static Zapchast zapchast;
    private ArrayList<Zapchast>  saveList;

    public FragmentStar() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_star, null);
        ListView lview = (ListView) view.findViewById(R.id.list_star);

       // saveList = gson.fromJson(D, Zapchast.class);


     saveList=FragmenInfoDetail.getSaveList();
        final ListviewAdapterZapchast adapter = new ListviewAdapterZapchast( getContext(), saveList);
        lview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                item11 = new Zapchast(
                        saveList.get(position).getPodkhodit(),
                        saveList.get(position).getTip(),
                        saveList.get(position).getOpisaniye(),
                        saveList.get(position).getTsena(),
                        saveList.get(position).getKod(),
                        saveList.get(position).getBrend(),
                        saveList.get(position).getIdImages(),
                        saveList.get(position).getValue());
                //Log.d("type",Slecteditem);
                getFragmentManager().beginTransaction()
                        .add(R.id.main_container, new FragmenInfoDetail()).addToBackStack(null).commit();


            }
        });

        return  view;
    }

    public void open(View view){

    }
    }
