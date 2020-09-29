package com.autoparts.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.autoparts.Adapter.CustomListAdapter;
import com.autoparts.R;

public class FragmentModel extends Fragment {

    FragmentTransaction fTrans;
    ListView list;
    static String model;
    public static String getModel() {
        return model;
    }
    static String[] name_model;
    String[] ar_s ={
            "4c",
            "8c",
            "Brera",
            "Giulietta",
            "Gt",
            "Spider"};
    Integer[] ar_i={
            R.drawable.ar_4c,
            R.drawable.ar_8c,
            R.drawable.ar_brera,
            R.drawable.ar_giulietta,
            R.drawable.ar_gt,
            R.drawable.ar_spider
    };
    String[] lexus_s ={
            "CT",
            "ES",
            "GS",
            "GX",
            "Ifa",
            "Lx",
            "Nx",
            "Rc",
            "Rx"};

    Integer[] lexus_i ={
            R.drawable.lexus_ct,
            R.drawable.lexus_es,
            R.drawable.lexus_gs,
            R.drawable.lexus_gx,
            R.drawable.lexus_lfa,
            R.drawable.lexus_ls,
            R.drawable.lexus_lx,
            R.drawable.lexus_nx,
            R.drawable.lexus_rc,
            R.drawable.lexus_rx
    };
    String[] vw_s ={
            "Amarok",
            "Bora",
            "Caddy",
            "Cc",
            "Golf",
            "Jetta",
            "Multivan",
            "Passat",
            "Polo",
            "Tiguan",
            "Touareg"};

    Integer[] vw_i ={
            R.drawable.vw_amarok,
            R.drawable.vw_bora,
            R.drawable.vw_caddy,
            R.drawable.vw_cc,
            R.drawable.vw_golf,
            R.drawable.vw_jetta,
            R.drawable.vw_multivan,
            R.drawable.vw_passat,
            R.drawable.vw_polo,
            R.drawable.vw_tiguan,
            R.drawable.vw_touareg
    };
    String[] b_s ={
            "Azure",
            "Continental",
            "Flying",
            "Mulsanne"};

    Integer[] b_i ={
            R.drawable.bt_azure,
            R.drawable.bt_continental,
            R.drawable.bt_flying,
            R.drawable.bt_mulsanne
    };
    public FragmentModel() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_model_list, container, false);
        CustomListAdapter adapter=null;
        switch (FragmentMarka.getMarka()){
            case "alfa_romeo":
                adapter=new CustomListAdapter(getContext(), ar_s, ar_i);
                 name_model=ar_s;
                break;
            case "lexus":
                adapter=new CustomListAdapter(getContext(), lexus_s,lexus_i);
                name_model=lexus_s;
                break;
            case "audi":
                adapter=new CustomListAdapter(getContext(), ar_s, ar_i);
                break;
            case "bentley":
                adapter=new CustomListAdapter(getContext(), b_s, b_i);
                break;
            case "bmv":
                adapter=new CustomListAdapter(getContext(), ar_s, ar_i);
                break;
            case "cadilac":
                adapter=new CustomListAdapter(getContext(), ar_s, ar_i);
                break;
            case "chevrolet":
                adapter=new CustomListAdapter(getContext(), ar_s, ar_i);
                break;
            case "ferarri":
                adapter=new CustomListAdapter(getContext(), ar_s, ar_i);
                break;
            case "infiniti":
                adapter=new CustomListAdapter(getContext(), ar_s, ar_i);
                break;
            case "jeep":
                adapter=new CustomListAdapter(getContext(), ar_s, ar_i);
                break;
            case "jaguar":
                adapter=new CustomListAdapter(getContext(), ar_s, ar_i);
                break;
            case "mersedes":
                adapter=new CustomListAdapter(getContext(), ar_s, ar_i);
                break;

            case "vw":
                adapter=new CustomListAdapter(getContext(), vw_s, vw_i);
                break;
            case "opel":
                adapter=new CustomListAdapter(getContext(), ar_s, ar_i);
                break;
            case "skoda":
                adapter=new CustomListAdapter(getContext(), ar_s, ar_i);
                break;
            case "landrover":
                adapter=new CustomListAdapter(getContext(), ar_s, ar_i);
                break;
            case "lamborghini":
                adapter=new CustomListAdapter(getContext(), ar_s, ar_i);
                break;
            case "toyota":
                adapter=new CustomListAdapter(getContext(), ar_s, ar_i);
                break;

        }

        list=(ListView)v.findViewById(R.id.list_item);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                model= name_model[+position];
                Log.d("FGHFGFHFGHFG" ,model);
                getFragmentManager().beginTransaction()
                        .add(R.id.main_container, new FragmentEquipment()).addToBackStack(null)
                        .commit();
            }
        });


        fTrans = getFragmentManager().beginTransaction();
        fTrans.addToBackStack(null);
        fTrans.commit();
        return v;
    }

}
