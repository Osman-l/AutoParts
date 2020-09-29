package com.autoparts.Adapter;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.autoparts.R;

/**
 * 
 * @author anfer
 * 
 */
public class listviewAdapter extends BaseAdapter {
	private final Context context;
	public ArrayList<Model> productList;

	public listviewAdapter(Context context, ArrayList<Model> productList) {
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

	private class ViewHolder {
		TextView model;
		TextView god;
		TextView motor;
		TextView moshnost;
		TextView odem;
		TextView celinder;
		TextView toplevo;
		TextView kuzov;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {

		ViewHolder holder;

		LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
		//View rowView=inflater.inflate(R.layout.row_listview_tayble, null,true);

		if (view == null) {
			view = inflater.inflate(R.layout.row_listview_tayble, null);
			holder = new ViewHolder();
			holder.model = (TextView) view.findViewById(R.id.model);
			holder.god = (TextView) view.findViewById(R.id.god);
			holder.motor = (TextView) view.findViewById(R.id.motor);
			holder.moshnost = (TextView) view.findViewById(R.id.moshnost);
			holder.odem = (TextView) view.findViewById(R.id.obem);
			holder.celinder = (TextView) view.findViewById(R.id.celinder);
			holder.toplevo = (TextView) view.findViewById(R.id.toplevo);
			holder.kuzov = (TextView) view.findViewById(R.id.kuzov);
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}

		Model item = productList.get(position);
		holder.model.setText(item.getModel());
		holder.god.setText(item.getGod());
		holder.motor.setText(item.getMotor());
		holder.moshnost.setText(item.getMoshnost());
		holder.odem.setText(item.getOdem());
		holder.celinder.setText(item.getCelinder());
		holder.toplevo.setText(item.getToplevo());
		holder.kuzov.setText(item.getKuzov());

		return view;
	}

}