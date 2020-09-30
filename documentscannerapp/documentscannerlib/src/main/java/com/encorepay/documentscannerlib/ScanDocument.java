package com.encorepay.documentscannerlib;

import android.app.Activity;
import android.content.Intent;
import io.card.payment.CardConfig;
import io.card.payment.CardScannerActivity;


public class ScanDocument {
    private CardConfig.Builder cardConfig;
    public static final int REQ_CARD_SCAN = 200;
    public static final String CARD_FRONT_IMAGE = "cardFrontSideImage";
    public static final String CARD_BACK_IMAGE = "cardBackSideImage";


    public ScanDocument(){
        cardConfig = new CardConfig.Builder();
    }

    public void startScanActivity(Activity activity,int REQ_CODE) {
        CardConfig cardConfiguration = cardConfig.build();
        Intent intent = new Intent(activity, CardScannerActivity.class);
        intent.putExtra(CardScannerActivity.FACEOFF_CARD_CONFIG, cardConfiguration);
        activity.startActivityForResult(intent,REQ_CODE);
    }

    public void setCardScanSide(ScanSide scanSide){
       if(ScanSide.FRONT.equals(scanSide))
           cardConfig.setCardScanSide(CardConfig.CardScanSide.FRONT);
       else if(ScanSide.BACK.equals(scanSide))
           cardConfig.setCardScanSide(CardConfig.CardScanSide.BACK);
       else if(ScanSide.BOTH.equals(scanSide))
           cardConfig.setCardScanSide(CardConfig.CardScanSide.BOTH);
    }

    public void flashLightEnabled(boolean enable){
        cardConfig.setIsFlashOn(enable);
    }


}
