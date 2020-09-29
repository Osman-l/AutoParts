package com.autoparts.Fragment;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.autoparts.Adapter.ListviewAdapterZapchast;
import com.autoparts.Adapter.Zapchast;
import com.autoparts.DB.DatabaseHelper;
import com.autoparts.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentSearch extends Fragment {
    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;
    private static ArrayList<Zapchast> productList;
    private Zapchast item11;
    @BindView(R.id.searchtext)
    EditText searchtext;
    @BindView(R.id.imageSearch)
    ImageView imageSearch;
    @BindView(R.id.listserch)
    ListView lview;
    @BindView(R.id.imgBtnDelete)
    ImageButton delete;
    @BindView(R.id.spinner)
    Spinner spinner;
    static ListviewAdapterZapchast adapter;
    String sercht;
    String str="kuzov";
    public static Zapchast getZapchast() {
        return zapchast;
    }

    public static Zapchast zapchast;

    public FragmentSearch() {
        // Required empty public constructor
    }
    String[] s ={
            "kuzov",
            "brakesystem",
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
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, null);
        ButterKnife.bind(this, view);
        productList = new ArrayList<>();
        adapter = new ListviewAdapterZapchast(getContext(), productList);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // показываем позиция нажатого элемента
                Toast.makeText(getContext(), "Position = " + position, Toast.LENGTH_SHORT).show();
               str= s[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
            });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchtext.setText("    ");
            }
        });
        imageSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sercht= String.valueOf(searchtext.getText());
                Log.d("values",sercht);
                Log.d("values","aesgkjsygsduhdspui");
                populateList(sercht);
            }
        });
        adapter.notifyDataSetChanged();
        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
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
                        .add(R.id.main_container, new FragmentZapchastSearch()).addToBackStack(null).commit();


            }
        });

        return view;
    }

    private void populateList(String searchtext) {
        productList.clear();
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
//Список параметров конкретного клиента
        HashMap<String, Object> client;
//Отправляем запрос в БД

        Cursor cursor = mDb.rawQuery("SELECT * FROM "+str, null);
        cursor.moveToFirst();
        Resources res = getResources();
//Пробегаем по всем клиентам
        while (!cursor.isAfterLast()) {
            if(cursor.getString(5).equals(searchtext)||cursor.getString(2).equals(searchtext)){
            item11 = new Zapchast(cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8));
            productList.add(item11);}

            // Log.d("photo",cursor.getString(7));
            // client.put("image",  cursor.getString(3));
            cursor.moveToNext();
        }
        cursor.close();
        lview.setAdapter(adapter);
    }

}