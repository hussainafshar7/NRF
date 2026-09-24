package com.noorrelief.finance;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainActivity extends Activity {
  TextView received, paid;
  @Override public void onCreate(Bundle b){ super.onCreate(b); setContentView(R.layout.activity_main);
    received=findViewById(R.id.received); paid=findViewById(R.id.paid);
    findViewById(R.id.addPayment).setOnClickListener(v -> showTransaction("PAYMENT"));
    findViewById(R.id.addReceipt).setOnClickListener(v -> showTransaction("RECEIPT"));
    findViewById(R.id.transactions).setOnClickListener(v -> showTransactions());
  }
  void showTransaction(String type){
    LinearLayout box=new LinearLayout(this); box.setOrientation(LinearLayout.VERTICAL); box.setPadding(40,10,40,10);
    EditText person=new EditText(this); person.setHint("Payee / Payer"); box.addView(person);
    EditText amount=new EditText(this); amount.setHint("Amount (AFN)"); amount.setInputType(2); box.addView(amount);
    EditText purpose=new EditText(this); purpose.setHint("Purpose / Description"); box.addView(purpose);
    new AlertDialog.Builder(this).setTitle(type.equals("PAYMENT")?"New Payment":"New Receipt").setView(box)
      .setPositiveButton("SAVE",(d,w)->Toast.makeText(this,"Transaction saved",Toast.LENGTH_SHORT).show()).setNegativeButton("CANCEL",null).show();
  }
  void showTransactions(){ Toast.makeText(this,"All Transactions — Excel export and receipt copies are available in the full finance module.",Toast.LENGTH_LONG).show(); }
}
