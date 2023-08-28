package com.example.listainmuebles;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.listainmuebles.databinding.ItemBinding;

import java.util.ArrayList;

public class MainActivityViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<ArrayList<Inmueble>> lista = new MutableLiveData<ArrayList<Inmueble>>();
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();

    }

    public LiveData<ArrayList<Inmueble>> getLista(){
        return lista;
    }
    public void cargarLista(){
        lista.setValue(new ArrayList<Inmueble>());

        lista.getValue().add(new Inmueble(R.drawable.img1,"Naschel","$5000"));
        lista.getValue().add(new Inmueble(R.drawable.img2,"Tilisarao","$7600"));
        lista.getValue().add(new Inmueble(R.drawable.img3,"San Luis","$23000"));
        lista.getValue().add(new Inmueble(R.drawable.img4,"Villa Mercedes","$20"));
    }

    public ArrayAdapter<Inmueble> getAdapter(LayoutInflater li){

        ArrayAdapter<Inmueble> adapter2 = new ArrayAdapter<Inmueble>(context, R.layout.item, lista.getValue()){
            @Override
            @NonNull
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
                if(convertView == null){
                    convertView = li.inflate(R.layout.item,parent,false);
                }
                ItemBinding ib = ItemBinding.bind(convertView);
                Inmueble i = lista.getValue().get(position);
                ib.ivFoto.setImageResource(i.getFoto());
                ib.tvDireccion.setText(i.getDireccion());
                ib.tvPrecio.setText(i.getPrecio());

                return convertView;
            }
        };
        return adapter2;
    }

}
