package com.autoparts.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.autoparts.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FragmentMarka extends Fragment {
    private static String marka;
    @BindView(R.id.alfa_romeo)
    ImageButton alfa_romeo;
    @BindView(R.id.lexus)
    ImageButton astom_martin;
    @BindView(R.id.audi)
    ImageButton audi;
    @BindView(R.id.bentley)
    ImageButton bentley;
    @BindView(R.id.bmv)
    ImageButton bmv;
    @BindView(R.id.cadilac)
    ImageButton cadilac;
    @BindView(R.id.Chevrolet)
    ImageButton chevrolet;
    @BindView(R.id.ferarri)
    ImageButton ferarri ;
    @BindView(R.id.infiniti)
    ImageButton infiniti;
    @BindView(R.id.jeep)
    ImageButton jeep;
    @BindView(R.id.jaguar)
    ImageButton jaguar;
    @BindView(R.id.mersedes)
    ImageButton mersedes;
    @BindView(R.id.vw)
    ImageButton vw;
    @BindView(R.id.opel)
    ImageButton opel;
    @BindView(R.id.skoda)
    ImageButton skoda;
    @BindView(R.id.landrover)
    ImageButton landrover;
    @BindView(R.id.lamborghini)
    ImageButton lamborghini;
    @BindView(R.id.toyota)
    ImageButton toyota;

    public static String getMarka() {
        return marka;
    }

    public FragmentMarka() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_marka, null);
        ButterKnife.bind(this, view);
        alfa_romeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marka="alfa_romeo";
                getFragmentManager().beginTransaction()
                        .add(R.id.main_container, new FragmentModel()).addToBackStack(null)
                        .commit();


            }
        });
        astom_martin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marka="lexus";
                getFragmentManager().beginTransaction()
                        .add(R.id.main_container, new FragmentModel()).addToBackStack(null)
                        .commit();


            }
        });
        audi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marka="audi";
                getFragmentManager().beginTransaction()
                        .add(R.id.main_container, new FragmentModel()).addToBackStack(null)
                        .commit();


            }
        });
        bentley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marka="bentley";
                getFragmentManager().beginTransaction()
                        .add(R.id.main_container, new FragmentModel()).addToBackStack(null)
                        .commit();


            }
        });
        bmv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marka="bmv";
                getFragmentManager().beginTransaction()
                        .add(R.id.main_container, new FragmentModel()).addToBackStack(null)
                        .commit();


            }
        });
        cadilac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marka="cadilac";
                getFragmentManager().beginTransaction()
                        .add(R.id.main_container, new FragmentModel()).addToBackStack(null)
                        .commit();


            }
        });
        chevrolet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marka="chevrolet";
                getFragmentManager().beginTransaction()
                        .add(R.id.main_container, new FragmentModel()).addToBackStack(null)
                        .commit();


            }
        });
        ferarri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marka="ferarri";
                getFragmentManager().beginTransaction()
                        .add(R.id.main_container, new FragmentModel()).addToBackStack(null)
                        .commit();


            }
        });
        infiniti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marka="infiniti";
                getFragmentManager().beginTransaction()
                        .add(R.id.main_container, new FragmentModel()).addToBackStack(null)
                        .commit();


            }
        });
        jeep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marka="jeep";
                getFragmentManager().beginTransaction()
                        .add(R.id.main_container, new FragmentModel()).addToBackStack(null)
                        .commit();


            }
        });
        jaguar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marka="jaguar";
                getFragmentManager().beginTransaction()
                        .add(R.id.main_container, new FragmentModel()).addToBackStack(null)
                        .commit();


            }
        });
        mersedes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marka="mersedes";
                getFragmentManager().beginTransaction()
                        .add(R.id.main_container, new FragmentModel()).addToBackStack(null)
                        .commit();


            }
        });

        vw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marka="vw";

                getFragmentManager().beginTransaction()
                        .add(R.id.main_container, new FragmentModel()).addToBackStack(null)
                        .commit();

            }
        });
        opel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marka="opel";

                getFragmentManager().beginTransaction()
                        .add(R.id.main_container, new FragmentModel()).addToBackStack(null)
                        .commit();

            }
        });
        skoda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marka="skoda";

                getFragmentManager().beginTransaction()
                        .add(R.id.main_container, new FragmentModel()).addToBackStack(null)
                        .commit();

            }
        });
        landrover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marka="landrover";

                getFragmentManager().beginTransaction()
                        .add(R.id.main_container, new FragmentModel()).addToBackStack(null)
                        .commit();

            }
        });
        lamborghini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marka="lamborghini";

                getFragmentManager().beginTransaction()
                        .add(R.id.main_container, new FragmentModel()).addToBackStack(null)
                        .commit();

            }
        });
        toyota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marka="toyota";

                getFragmentManager().beginTransaction()
                        .add(R.id.main_container, new FragmentModel()).addToBackStack(null)
                        .commit();

            }
        });
        return view;
    }

}
