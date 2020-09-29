package com.autoparts.Fragment;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.autoparts.Adapter.Zapchast;
import com.autoparts.DB.DatabaseHelper;
import com.autoparts.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmenInfoDetail extends Fragment {
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
    boolean aBoolean=false;
    @BindView(R.id.scroll)
    ScrollView scroll;
    public static ArrayList<Zapchast> saveList;

    public static ArrayList<Zapchast> getSaveList() {
        return saveList;
    }

    public FragmenInfoDetail() {

    }
    public final   Zapchast zapchast= FragmentZapchast.getZapchast();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragmen_info_detail,null);
        ButterKnife.bind(this, view);
        final CheckBox CheckBox = (CheckBox) view.findViewById(R.id.checkbox);
        if(null!=(name.getText())){
            name.setText("");
        }

        int size=FragmentZapchast.getProductList().size();

        Log.d("size", String.valueOf(size));
        name.setText(zapchast.getTip());
        type.setText("Производитель: "+zapchast.getBrend());
        kod.setText("Номер запчасти: "+zapchast.getKod());
        tsena.setText("Цена: "+zapchast.getTsena());
        opisanie.setText("Описание: "+zapchast.getOpisaniye());

       Resources resources = getContext().getResources();
       String packageName = getContext().getPackageName();
       int resID = resources.getIdentifier(zapchast.getIdImages() , "drawable", packageName);
       Drawable drawable = resources.getDrawable(resID );
       image.setImageDrawable(drawable);
        CheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(zapchast!=null){
                if(CheckBox.isChecked()){
                    saveList.add(zapchast);

                }}
            }
        });
        return view;
    }


}
