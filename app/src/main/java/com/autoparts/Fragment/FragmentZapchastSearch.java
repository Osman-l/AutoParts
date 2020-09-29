package com.autoparts.Fragment;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.autoparts.Adapter.Zapchast;
import com.autoparts.DB.DatabaseHelper;
import com.autoparts.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentZapchastSearch extends Fragment {
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.type)
    TextView type;
    @BindView(R.id.kod)
    TextView kod;
    @BindView(R.id.tsena)
    TextView tsena;
    @BindView(R.id.opisanie)
    TextView opisanie;
    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;
    boolean aBoolean=false;
    private Zapchast item11;


    public FragmentZapchastSearch() {
        // Required empty public constructor

    }
    Zapchast zapchast= FragmentSearch.getZapchast();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_zapchastsearch,null);
        ButterKnife.bind(this, view);
        CheckBox CheckBox = (CheckBox) view.findViewById(R.id.checkbox);
        if(null!=(name.getText())){
            name.setText("");
        }
//Список параметров конкретного клиента
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
        HashMap<String, Object> client;
//Отправляем запрос в БД
        // Определите содержимое обновленной строки.
        final ContentValues updatedValues = new ContentValues();

// Назначьте значения для каждой строки.
        updatedValues.put("status", 9);
        updatedValues.put("status", 2);
        updatedValues.put("status", 3);
        mDb.update("kuzov", updatedValues, String.valueOf(4), null);
// Обновите строку с указанным индексом, используя новые значения.

        name.setText(zapchast.getTip());
        type.setText("Производитель: "+zapchast.getBrend());
        kod.setText("Номер запчасти: "+zapchast.getKod());
        tsena.setText("Цена: "+zapchast.getTsena());
        opisanie.setText("Описание: "+zapchast.getOpisaniye());
        if(zapchast.getValue().equals("1")){
            Log.d("bolean",zapchast.getValue());
            CheckBox.setChecked(true);
        }

        CheckBox.setOnClickListener(new View.OnClickListener() {
            int id =1;
            @Override
            public void onClick(View v) {
                if (((CheckBox)v).isChecked()) {
                    int updCount=  mDb.update("kuzov", updatedValues, "_idkuzov=" + String.valueOf(id), null);
                    Log.d("GHJFGJGJFG", "updated rows count = " + updCount);
                }
                else      aBoolean=false;
            }
        });
        Resources resources = getContext().getResources();
        String packageName = getContext().getPackageName();
        int resID = resources.getIdentifier(zapchast.getIdImages() , "drawable", packageName);
        Drawable drawable = resources.getDrawable(resID );
        image.setImageDrawable(drawable);

        return view;
    }
    private void populateList() {


    }

}
