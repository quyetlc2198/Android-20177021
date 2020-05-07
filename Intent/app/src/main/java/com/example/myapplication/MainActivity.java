package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Notification;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView , textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn;
        btn = findViewById(R.id.btn_intent);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String myPhoneNumberUri = "tel:555-1234";
//                Intent myActivity2 = new Intent(Intent.ACTION_DIAL,
//                        Uri.parse(myPhoneNumberUri));
//                startActivity(myActivity2);
//
//                String myData = "tel:555-1234";
//                Intent myActivity2 = new Intent(
//                        Intent.ACTION_CALL,
//                        Uri.parse(myData));
//                startActivity(myActivity2);
//                Action_web_search
//                Intent intent = new Intent(
//                        Intent.ACTION_WEB_SEARCH);
//                intent.putExtra(SearchManager.QUERY,
//                        "straight hitting golf clubs");
//                startActivity(intent);
//                ACTION_SENDTO
//                Intent intent = new Intent(
//                        Intent.ACTION_SENDTO,
//                        Uri.parse("smsto: 0828234613"));
//                intent.putExtra("sms_body",
//                        "Nguyen Duc Quyet");
//                startActivity(intent);

//                Intent intent = new Intent();
//                intent.setType("image/pictures/*");
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                startActivity(intent);

//                String myData = "content://contacts/people/";
//                Intent myActivity2 = new Intent(Intent.ACTION_VIEW,
//                        Uri.parse(myData));
//                startActivity(myActivity2);

//                String myData = ContactsContract.Contacts.CONTENT_URI + "/" + "2";
//                Intent myActivity2 = new Intent(Intent.ACTION_EDIT, Uri.parse(myData));
//                startActivity(myActivity2);

//                String myUriString = "http://www.youtube.com";
//                Intent myActivity2 = new Intent(Intent.ACTION_VIEW,
//                        Uri.parse(myUriString));
//                startActivity(myActivity2);

//

//                Intent intent = new Intent(
//                        android.content.Intent.ACTION_VIEW,
//                        Uri.parse(
//                                "http://maps.google.com/maps?"
//                                        + "saddr=9.938083,-84.054430&"
//                                        + "daddr=9.926392,-84.055964"));
//                startActivity(intent);
//                saddr start address
//                daddr destination address

//                Intent myActivity2 = new Intent(
//                        "android.intent.action.MUSIC_PLAYER");
//                startActivity(Intent.createChooser(myActivity2,"To complete action choose:"));

//                 send email
//                String emailSubject = "Department Meeting";
//                String emailText = "We’ll discuss the new project "
//                        + "on Tue. at 9:00am @ room BU344";
//                String[] emailReceiverList = {"v.matos@csuohio.edu"};
//                Intent intent = new Intent(Intent.ACTION_SEND);
//                intent.setType("vnd.android.cursor.dir/email");
//                intent.putExtra(Intent.EXTRA_EMAIL, emailReceiverList);
//                intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
//                intent.putExtra(Intent.EXTRA_TEXT, emailText);
//                startActivity(Intent.createChooser(intent,
//                        "To complete action choose:"));
//                startActivity(new Intent(
//                        android.provider.Settings.ACTION_INTERNAL_STORAGE_SETTINGS
//                ));
            }
        });

//        findViewById(R.id.btn_pick).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
//                startActivityForResult(intent, 1234);
//
//            }
//        });

        findViewById(R.id.btn_pick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK , Uri.parse("content://media/external/images/media"));
                startActivityForResult(intent, 1234);
            }
        });

        findViewById(R.id.btn_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(result));
                startActivity(intent);
            }
        });
        textView  = findViewById(R.id.result);
        textView2 = findViewById(R.id.result_add);

        final EditText edit1, edit2;
        edit1 = findViewById(R.id.param1);
        edit2 = findViewById(R.id.param2);
        findViewById(R.id.btn_pick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("param1", edit1.getText().toString());
                intent.putExtra("param2", edit2.getText().toString());
                startActivityForResult(intent, 1111);
            }
        });
    }
    String result;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1234){
            if( resultCode == Activity.RESULT_OK){
                result = data.getDataString();
                textView.setText(result);
            }
        }else{
            if (requestCode== 1111){
                if (resultCode == Activity.RESULT_OK){
                    double result = data.getDoubleExtra("result", 0.0);
                    textView2.setText("RESULT "+ result);
                }
            }
        }
    }
}
