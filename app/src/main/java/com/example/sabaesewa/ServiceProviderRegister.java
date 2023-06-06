package com.example.sabaesewa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class ServiceProviderRegister extends AppCompatActivity {
    private Spinner serviceTypeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_register);
        hideSystemUI();
        final EditText fullnameET = findViewById(R.id.fullnameET);
        final EditText emailET = findViewById(R.id.emailET);
        final EditText mobileET = findViewById(R.id.mobileET);
        final EditText addressET= findViewById(R.id.addressET);
        final ImageView passwordIcon = findViewById(R.id.passwordIcon);
        final TextView signInBtn = findViewById(R.id.signInBtn);
        final TextView signUpBtn = findViewById(R.id.signUpBtn);
        serviceTypeSpinner = findViewById(R.id.serviceTypeSpinner);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.service_types,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        serviceTypeSpinner.setAdapter(adapter);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new Intent(ServiceProviderRegister.this, LoginActivity.class)});
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivities(new Intent[]{new Intent(ServiceProviderRegister.this, ServiceProviderDashboard.class)});
            }
        });
    }
    private void hideSystemUI() {
        View decorView = getWindow().getDecorView();
        int flags = View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(flags);
    }
    }
