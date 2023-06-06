package com.example.sabaesewa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sabaesewa.ApiServices.ApiClient;
import com.example.sabaesewa.ApiServices.CustomerRegisterServices;
import com.example.sabaesewa.Model.CustomerModel;
import com.example.sabaesewa.ResponseModel.CRegisterResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {
    private EditText fullnameET, emailET, phonenumberET, addressET, passwordET, conpasswordET;
    private TextView signInBtn, signUpBtn;

    private CustomerRegisterServices customerRegisterServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        hideSystemUI();
        fullnameET = findViewById(R.id.fullnameET);
        emailET = findViewById(R.id.emailET);
        phonenumberET = findViewById(R.id.mobileET);
        addressET = findViewById(R.id.addressET);
        final ImageView passwordIcon = findViewById(R.id.passwordIcon);
        passwordET = findViewById(R.id.passwordET);
        conpasswordET = findViewById(R.id.conpasswordET);
        signInBtn = findViewById(R.id.signInBtn);
        signUpBtn = findViewById(R.id.signUpBtn);

        // Create UserService instance
        customerRegisterServices = ApiClient.getRetrofitInstance().create(CustomerRegisterServices.class);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle sign-in button click
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

    private void registerUser() {
        String fullName = fullnameET.getText().toString();
        String email = emailET.getText().toString();
        String phonenumber = phonenumberET.getText().toString();
        String address = addressET.getText().toString();
        String password = passwordET.getText().toString();
        String password_confirmation = conpasswordET.getText().toString();
        // Create User object
        CustomerModel customerModel = new CustomerModel(fullName, email, phonenumber, address, password, password_confirmation);

        // Make API call
        Call<CRegisterResponseModel> call = customerRegisterServices.registerUser(customerModel);
        call.enqueue(new Callback<CRegisterResponseModel>() {
            @Override
            public void onResponse(Call<CRegisterResponseModel> call, Response<CRegisterResponseModel> response) {
                if (response.isSuccessful()) {
                    // Registration successful, handle the response here
                    CRegisterResponseModel userResponse = response.body();
                    if (userResponse != null && userResponse.getStatus().equals("success")) {
                        // Registration successful
                        Toast.makeText(Register.this, "Registration successful", Toast.LENGTH_SHORT).show();
                        // ...
                    } else {
                        // Registration failed, handle the error response here
                        Toast.makeText(Register.this, "Registration failed", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Registration failed
                    Toast.makeText(Register.this, "Registration failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CRegisterResponseModel> call, Throwable t) {
                Toast.makeText(Register.this, "Registration request failed", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }
}