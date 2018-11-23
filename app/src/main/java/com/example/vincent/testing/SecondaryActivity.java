package com.example.vincent.testing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
    }

    public void onClickBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickFinish(View view) {
        finish();
    }

    public void onClickAdd(View view) {
        OfferedService service = new OfferedService(9, 3, 111.00);
        service.add(this);
    }

    public void onClickFind(View view) {
//        Storable service = OfferedService.find(this, OfferedService.class,2);
        Storable service = new OfferedService().findAny(this, OfferedService.COL_HOURLYRATE, 111);
        System.out.println(((OfferedService) service).getID());
    }

    public void onClickDelete(View view) {
        Storable service = new OfferedService().find(this,OfferedService.COL_ID, 8);
        service.delete(this);
    }

    public void onClickUpdate(View view) {
        OfferedService service = new OfferedService().find(this,OfferedService.COL_ID, 2);
        service.setHourlyRate(555);
        service.update(this);
    }
}
