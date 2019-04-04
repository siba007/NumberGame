package com.prop.ber.numbergame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ItemArrayAdapter  extends RecyclerView.Adapter<ItemArrayAdapter.ViewHolder> {

    //All methods in this adapter are required for a bare minimum recyclerview adapter
    private int listItemLayout;
    private ArrayList<Integer> itemList;
    private  int randomNumber ;
    // Constructor of the class
    public ItemArrayAdapter(int layoutId, ArrayList<Integer> itemList, int randomNumber) {
        listItemLayout = layoutId;
        this.itemList = itemList;
        this.randomNumber = randomNumber;
    }

    // get the size of the list
    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }


    // specify the row list_item file and click for each row
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    // load data in each row element
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int listPosition) {
        TextView item = holder.item;
        item.setText(itemList.get(listPosition).toString());
    }

    // Static inner class to initialize the views of rows
     class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView item;
        public ViewHolder(final View itemView) {
            super(itemView);

            item = (TextView) itemView.findViewById(R.id.row_item);
            item.postDelayed(new Runnable() {
                public void run() {
                    item.setVisibility(View.INVISIBLE);
                    itemView.setOnClickListener(ViewHolder.this);
                }
            }, 3000);
        }


        @Override
        public void onClick(View view) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " " + item.getText());
            item.setVisibility(View.VISIBLE);
            itemView.setOnClickListener(null);
            if(randomNumber == Integer.parseInt(item.getText().toString())){
                showAlert("Congratulations you won the game");
            }else {
                showAlert("Try again");
            }



        }

        private void showAlert(String msg) {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(item.getContext());
            builder1.setMessage(msg);
            builder1.setCancelable(true);
            builder1.setPositiveButton(
                    "ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();

        }
    }
}
