package com.prop.ber.numbergame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tvRandomNumber;
    private RecyclerView recyclerView;
    private Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvRandomNumber = (TextView) findViewById(R.id.tvRandomNumber);
        btnReset = (Button) findViewById(R.id.btnReset);
        recyclerView = (RecyclerView) findViewById(R.id.rc);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGame();
            }
        });
        btnReset.performClick();
    }

    private void startGame() {
        tvRandomNumber.setVisibility(View.INVISIBLE);
        int randomNumber = GameUtil.getRandomNumberInRange(1, 9);
        tvRandomNumber.setText(randomNumber+"");
        tvRandomNumber.postDelayed(new Runnable() {
            public void run() {
                tvRandomNumber.setVisibility(View.VISIBLE);
            }
        }, 3500);
        List<Integer> itemList = Arrays.asList(GameUtil.getArray());
        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.addAll(itemList);
        ItemArrayAdapter itemArrayAdapter = new ItemArrayAdapter(R.layout.list_item, intList,randomNumber);
        recyclerView.setAdapter(itemArrayAdapter);
    }
}
