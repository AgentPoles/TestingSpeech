package com.mycompany.myapp.testingspeech;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Paul on 5/10/2018.
 */
public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.PxViewHolder> {
    List<Detailse> detailsList;
    int y;
    static   int je;
    static String tooti;
    Detailse details;
    OnRecycleViewItemClicker Listener;
    private String genname, unita, unitb, titlea, titleb, inputa , inputb;
    private int imagea, imageb;
    private int which;
    public class PxViewHolder extends RecyclerView.ViewHolder{
        TextView genname, titlea, titleb, unita, unitb;
        EditText inputa, inputb;
        ImageView imagea, imageb;
        RadioButton firstchoice, secondchoice, thirdchoice, fourthchoice;
        CardView card_view;

        CheckBox rated;
        View vb;
        RelativeLayout wholelasubbusiness;
        public PxViewHolder(View view){
            super(view);
            vb = view;
            genname = (TextView)vb.findViewById(R.id.genname);
            titlea = (TextView)vb.findViewById(R.id.titlea);
            titleb= (TextView)vb.findViewById(R.id.titleb);
            unita = (TextView) vb.findViewById(R.id.unita);
            unitb = (TextView) vb.findViewById(R.id.unitb);
            inputa=(EditText)vb.findViewById(R.id.inputa);
            inputb=(EditText)vb.findViewById(R.id.inputb);
//            card_view =(CardView)vb.findViewById(R.id.card_view);
//            wholelasubbusiness = (RelativeLayout)vb.findViewById(R.id.wholelasubbusiness);
//            view.setClickable(true);
        }
    }
    public DetailsAdapter (List<Detailse> details){
        this.detailsList = details;
        y = this.getItemCount();
    }

    @Override
    public PxViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View celtem = LayoutInflater.from(parent.getContext()).inflate(R.layout.design,parent,false);
        return new PxViewHolder(celtem);
    }
    View.OnClickListener  onClickView = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };
    @Override
    public void onBindViewHolder(PxViewHolder holder, final int position) {
        details = detailsList.get(position);
        je = position;
        holder.setIsRecyclable(false);
//        holder.subusi.setText(busi.getBsub());
//        holder.bustitle.setText(busi.getBtitle());
//        holder.wholelasubbusiness.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Listener.OnRecycleViewItemclicked(position);
//            }
//        });
//        holder.card_view.setCardBackgroundColor(Color.parseColor(busi.getBackgroundcolore()));
//        holder.wholelasubbusiness.setBackgroundColor(Color.parseColor(busi.getBackgroundcolore()));
//        holder.subusi.setTextColor(Color.parseColor(busi.getMottocolor()));
//        holder.bustitle.setTextColor(Color.parseColor(busi.getTitlecolor()));
//        holder.torder.setTextColor(Color.parseColor(busi.getTouchcolor()));
//        tooti = busi.getBsub();

    }
//  View.OnClickListener wholeSubListener = new View.OnClickListener() {
//      @Override
//      public void onClick(View view) {
//          Listener.OnRecycleViewItemclicked(je);
//      }
//  };


    @Override
    public int getItemCount() {
        try{
            return detailsList.size();
        }
        catch(Exception e) {
            return 0;
        }
    }
    public interface OnRecycleViewItemClicker{
        public void OnRecycleViewItemclicked(int position);
    }
    public void setOnItemclickedListener(OnRecycleViewItemClicker listener){
        this.Listener =  listener;
    }
}

