package com.sheygam.contactapp.presentetion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sheygam.contactapp.R;
import com.sheygam.contactapp.presentetion.login.view.LoginView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,new LoginView())
                    .commit();
        }
    }
}
