package com.example.sabaesewa.ApiServices;
import com.example.sabaesewa.Model.CustomerModel;
import com.example.sabaesewa.Register;
import com.example.sabaesewa.ResponseModel.CRegisterResponseModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface CustomerRegisterServices {
        @POST("api/register") // Replace "register" with the actual API endpoint for registration
        Call<CRegisterResponseModel> registerUser(@Body CustomerModel customerModel);

}