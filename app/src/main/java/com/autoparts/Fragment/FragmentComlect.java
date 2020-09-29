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

import com.autoparts.Adapter.CustomListAdapter;
import com.autoparts.R;



public class FragmentComlect extends Fragment {
    FragmentTransaction fTrans;
    ListView list;
   static String nametayble;

    public static String getNametayble() {
        return nametayble;
    }

    String[] s ={
            "Кузов",
            "Тормозная система",
            "Привод колес",
            "Коробка передач",
            "Детали подвески",
            "Сцепление",
            "Фильтры",
            "Система зажигания",
            "Двигатель",
            "Рулевое управление",
            "Ременной привод",
            "Система подачи топлева",
            "Система выпуска"};

    Integer[] i ={
            R.drawable.carcase,
            R.drawable.brakesystem,
            R.drawable.drivewheels,
            R.drawable.transmission,
            R.drawable.suspension,
            R.drawable.clutch,
            R.drawable.filters,
            R.drawable.ignitionsystem,
            R.drawable.engine,
            R.drawable.steering,
            R.drawable.beltdrive,
            R.drawable.fuelsupplysystem,
            R.drawable.exhaustsystem
    };
    public FragmentComlect() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_comlect, null);
        CustomListAdapter adapter=null;
                adapter=new CustomListAdapter(getContext(), s, i);
        list=(ListView)view.findViewById(R.id.list_item);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem= s[+position];
                Log.d("type",Slecteditem);
                if(Slecteditem.equals("Кузов")){
                        nametayble="";
                        nametayble="kuzov";
                        getFragmentManager().beginTransaction()
                            .add(R.id.main_container, new FragmentZapchast()).addToBackStack(null)
                            .commit();}
                if(Slecteditem.equals("Тормозная система")){
                       nametayble="";
                        nametayble="brakesystem";
                       getFragmentManager().beginTransaction()
                                .add(R.id.main_container, new FragmentZapchast()).addToBackStack(null)
                               .commit();}

            }
        });


        fTrans = getFragmentManager().beginTransaction();
        fTrans.addToBackStack(null);
        fTrans.commit();
        return view;
    }


}
