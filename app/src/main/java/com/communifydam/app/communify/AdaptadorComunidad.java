package com.communifydam.app.communify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 2912 on 17/01/2018.
 */

public class AdaptadorComunidad extends ArrayAdapter<Comunidad> {
    Context context;

    public AdaptadorComunidad(Context context, int resourceId, List<Comunidad> items){
        super(context, resourceId, items);
        this.context = context;
    }

    public class ViewHolder{
        Switch marcado;
        TextView title;
        TextView description;
    }


    public View getView(int position, View convertView, ViewGroup parent){
        AdaptadorComunidad.ViewHolder holder;
        Comunidad rowItem = getItem(position);

        LayoutInflater mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null){
            convertView = mInflater.inflate(R.layout.mini_comunidad, null);
            holder = new AdaptadorComunidad.ViewHolder();
            holder.marcado = (Switch)convertView.findViewById(R.id.swActivado);
            holder.title = (TextView)convertView.findViewById(R.id.tv_nombre);
            convertView.setTag(holder);
        } else
            holder = (AdaptadorComunidad.ViewHolder)convertView.getTag();

        holder.marcado.setChecked(rowItem.getMarcado());
        holder.title.setText(rowItem.getTitle());

        return convertView;
    }

}
