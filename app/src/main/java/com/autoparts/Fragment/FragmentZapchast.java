package com.autoparts.Fragment;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.autoparts.Adapter.ListviewAdapterZapchast;
import com.autoparts.Adapter.Zapchast;
import com.autoparts.DB.DatabaseHelper;
import com.autoparts.R;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.ButterKnife;


public class FragmentZapchast extends Fragment {
    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;
    private static ArrayList<Zapchast> productList;
    private Zapchast item11;
    public static Zapchast zapchast;
    public static Zapchast getZapchast() {
        return zapchast;
    }
    public FragmentZapchast() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_zapchast,null);
        ButterKnife.bind(this, view);
//Какие параметры клиента мы будем отображать в соответствующих
//элементах из разметки adapter_item.xml
        productList = new ArrayList<>();
        ListView lview = (ListView) view.findViewById(R.id.list_zapchast);
        final ListviewAdapterZapchast adapter = new ListviewAdapterZapchast( getContext(), productList);
        lview.setAdapter(adapter);
        populateList();
        adapter.notifyDataSetChanged();
        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                zapchast = new Zapchast(
                        productList.get(position).getPodkhodit(),
                        productList.get(position).getTip(),
                        productList.get(position).getOpisaniye(),
                        productList.get(position).getTsena(),
                        productList.get(position).getKod(),
                        productList.get(position).getBrend(),
                        productList.get(position).getIdImages(),
                        productList.get(position).getValue());
                //Log.d("type",Slecteditem);
                       getFragmentManager().beginTransaction()
                               .add(R.id.main_container, new FragmenInfoDetail()).addToBackStack(null).commit();


            }
        });

        return view;
    }
    private void populateList() {
        mDBHelper = new DatabaseHelper(getContext());

        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }
        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }
//Отправляем запрос в БД
        String nametayble=null;
        nametayble=FragmentComlect.getNametayble();
        Log.d("dfhdfhfdh",nametayble);
        Cursor cursor = mDb.rawQuery("SELECT * FROM "+nametayble, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if(cursor.getString(1).equals(FragmentEquipment.getKod())) {
                item11 = new Zapchast(cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8));
                productList.add(item11);
            }
            // Log.d("photo",cursor.getString(7));
            // client.put("image",  cursor.getString(3));
            cursor.moveToNext();
        }
        cursor.close();

    }

    public static ArrayList<Zapchast> getProductList() {
        return productList;
    }
}
