package com.chawki.foodordertraking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private TimeLineAdapter mTimeLineAdapter;
    private List<TimeLineModel> mDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(getLinearLayoutManager());
        mRecyclerView.setHasFixedSize(true);

        initView();
    }

    private LinearLayoutManager getLinearLayoutManager() {

        return new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

    }

    private void initView() {
        setDataListItems();
        mTimeLineAdapter = new TimeLineAdapter(mDataList, Orientation.VERTICAL, true);
        mRecyclerView.setAdapter(mTimeLineAdapter);
    }

    private void setDataListItems(){
        mDataList.add(new TimeLineModel("ORDER PALACED", "We have recieved your order", OrderStatus.COMPLETED, R.drawable.orderplaced));
        mDataList.add(new TimeLineModel("ORDER CONFIRMED", "Your order has been confirmed", OrderStatus.COMPLETED, R.drawable.order_confirmed));
        mDataList.add(new TimeLineModel("ORDER PROCESSED", "We are preparing your order", OrderStatus.ACTIVE, R.drawable.orderplaced));
        mDataList.add(new TimeLineModel("READY TO PICK", "Your order is ready for pickup", OrderStatus.INACTIVE,R.drawable.ready));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Menu
        switch (item.getItemId()) {
            //When home is clicked
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
