package com.autoparts.Fragment;

import android.content.res.Resources;
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

import com.autoparts.Adapter.Model;
import com.autoparts.Adapter.listviewAdapter;
import com.autoparts.DB.DatabaseHelper;
import com.autoparts.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import butterknife.ButterKnife;
/**
 * Created by Osman on 06.05.2018.
 */
public class FragmentEquipment extends Fragment {
    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;
    private ArrayList<Model> productList;

    public static String getKod() {
        return kod;
    }

    static String kod;
    public FragmentEquipment() {
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_equipment, null);
        ButterKnife.bind(this, view);
//Какие параметры клиента мы будем отображать в соответствующих
//элементах из разметки adapter_item.xml
        productList = new ArrayList<>();
        ListView lview = (ListView) view.findViewById(R.id.listview);
        listviewAdapter adapter = new listviewAdapter( getContext(), productList);
        lview.setAdapter(adapter);
        populateList();
        adapter.notifyDataSetChanged();
        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
              //  String sno = ((TextView)view.findViewById(R.id.model)).getText().toString();
                getFragmentManager().beginTransaction()
                        .add(R.id.main_container, new FragmentComlect()).addToBackStack(null)
                        .commit();
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
//Список параметров конкретного клиента
        HashMap<String, Object> client;
//Отправляем запрос в БД
        Cursor cursor = mDb.rawQuery("SELECT * FROM comlek", null);
        cursor.moveToFirst();
        Resources res = getResources();

//Пробегаем по всем клиентам
        while (!cursor.isAfterLast()) {
            Log.d("fdhfdhfhgfhdfshgfsg",FragmentModel.getModel());
            if(cursor.getString(10).equals(FragmentModel.getModel())){
            //Заполняем клиента
                kod=cursor.getString(9);
                Log.d("fdhfdhfhgfhdfshgfsg",kod);
         Model  item11 = new Model(

                 cursor.getString(1),
                 cursor.getString(2),
                 cursor.getString(3),
                 cursor.getString(4),
                 cursor.getString(5),
                 cursor.getString(6),
                 cursor.getString(7),
                 cursor.getString(8));
            productList.add(item11);}
          // client.put("image",  cursor.getString(3));
            //Закидываем клиента в список клиентов
         //   clients.add(client);
            //Переходим к следующему клиенту
            cursor.moveToNext();
        }
        cursor.close();
       /* for (int i=0; i<10;i++){
            Model item1;
            item1 = new Model("1", "Apple (Northern Spy)", "Fruits", "₹. 200");
            productList.add(item1);
        }*/
    }
}