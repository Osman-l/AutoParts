package com.autoparts.Adapter;
import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.autoparts.R;



public class ListviewAdapterZapchast extends BaseAdapter {
    private final Context context;
    public ArrayList<Zapchast> productList;

    public ListviewAdapterZapchast (Context context, ArrayList<Zapchast> productList) {
        super();
        this.context = context;
        this.productList = productList;
    }


    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        TextView tip;

        TextView brend;
        ImageView imageView;
        public TextView getTip() {
            return tip;
        }
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder holder;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        //View rowView=inflater.inflate(R.layout.row_listview_tayble, null,true);

        if (view == null) {
            view = inflater.inflate(R.layout.row_listview_zapchast, null);
            holder = new ViewHolder();
            holder.tip = (TextView) view.findViewById(R.id.tip);
            holder.brend = (TextView) view.findViewById(R.id.brend);
            holder.imageView = (ImageView) view.findViewById(R.id.image);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Zapchast item = productList.get(position);
        holder.tip.setText(item.getTip());
        holder.brend.setText(item.getBrend());
        Resources resources = context.getResources();
        String packageName = context.getPackageName();
        int resID = resources.getIdentifier(item.getIdImages(), "drawable", packageName);
        Drawable drawable = resources.getDrawable(resID);
        holder.imageView.setImageDrawable(drawable);
        return view;
    }

}