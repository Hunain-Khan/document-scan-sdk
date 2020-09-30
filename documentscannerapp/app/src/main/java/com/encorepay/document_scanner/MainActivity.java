package com.encorepay.document_scanner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.encorepay.documentscannerlib.ScanDocument;
import com.encorepay.documentscannerlib.ScanSide;

public class MainActivity extends AppCompatActivity {

    public Button btnFront,btnBack;
    ScanDocument scanDocument;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setView();
        scanDocument = new ScanDocument();
        btnFront.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scanDocument.setCardScanSide(ScanSide.FRONT);
                scanDocument.startScanActivity(MainActivity.this,100);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scanDocument.setCardScanSide(ScanSide.BACK);
                scanDocument.startScanActivity(MainActivity.this,200);
            }
        });



    }

    public void setView(){
        btnFront = findViewById(R.id.front);
        btnBack = findViewById(R.id.back);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 100){
            if(resultCode == RESULT_OK){
                byte[] front =  (byte[])data.getExtras().getSerializable(ScanDocument.CARD_FRONT_IMAGE);
            }
        }else if(requestCode == 200){
            if(resultCode == RESULT_OK){
                byte[] front =  (byte[])data.getExtras().getSerializable(ScanDocument.CARD_BACK_IMAGE);
            }
        }
    }
}
