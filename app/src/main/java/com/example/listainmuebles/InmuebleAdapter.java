package com.example.listainmuebles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.listainmuebles.databinding.ActivityMainBinding;
import com.example.listainmuebles.databinding.ItemBinding;

import java.util.List;

public class InmuebleAdapter extends ArrayAdapter<Inmueble> {
    private Context context;
    private List<Inmueble> lista;
    private LayoutInflater li;
    public InmuebleAdapter(@NonNull Context context, int resource, @NonNull List<Inmueble> objects, LayoutInflater li) {
        super(context, resource, objects);
        this.context=context;
        lista=objects;
        this.li=li;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if(convertView == null){
            convertView = li.inflate(R.layout.item,parent,false);
        }
        ItemBinding ib= ItemBinding.bind(convertView);
        Inmueble i = lista.get(position);

        ib.ivFoto.setImageResource(i.getFoto());
        ib.tvDireccion.setText(i.getDireccion());
        ib.tvPrecio.setText(i.getPrecio());

        return convertView;
    }

}
