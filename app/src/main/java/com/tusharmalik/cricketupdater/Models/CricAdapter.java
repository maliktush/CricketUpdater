package com.tusharmalik.cricketupdater.Models;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tusharmalik.cricketupdater.Crics;
import com.tusharmalik.cricketupdater.R;

import java.util.ArrayList;

/**
 * Created by tushm on 05-02-2018.
 */

public class CricAdapter extends RecyclerView.Adapter<CricAdapter.Cricss>{
    private ArrayList<Crics> cricket;
    public CricAdapter(ArrayList<Crics> cricket) {
        this.cricket= cricket;
    }
    public void setCric(ArrayList<Crics> cricket) {
        this.cricket= cricket;
        notifyDataSetChanged();
    }

    @Override
    public CricAdapter.Cricss onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        return new Cricss(li.inflate(R.layout.listdisplay, parent, false));
    }

    @Override
    public void onBindViewHolder(CricAdapter.Cricss holder, int position) {
        holder.bindView(cricket.get(position));

    }

    @Override
    public int getItemCount() {
        return cricket.size();
    }
     class Cricss extends RecyclerView.ViewHolder{
        TextView tvID,tvTeam1,tvTeam2,tvDate,tvTime,tvType;
         public Cricss(View itemView) {
             super(itemView);

             tvTeam1=itemView.findViewById(R.id.tvTeam1);
             tvTeam2=itemView.findViewById(R.id.tvTeam2);
             tvDate=itemView.findViewById(R.id.tvDate);
             tvTime=itemView.findViewById(R.id.tvTime);
             tvType=itemView.findViewById(R.id.tvType);
         }
         void bindView(Crics crics){

             tvTeam1.setText(crics.getTeam1());
             tvTeam2.setText(crics.getTeam2());
             tvDate.setText(crics.getDate());
             tvTime.setText(crics.getTime());
             tvType.setText(crics.getType());

         }
     }


}
