package com.example.sabaesewa;

import static androidx.core.content.ContentProviderCompat.requireContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentProvider;
import android.content.Context;
import android.os.Bundle;

import com.example.sabaesewa.adapter.ServiceProviderAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.sabaesewa.adapter.ServiceProviderAdapter;

import java.util.ArrayList;
import java.util.List;

public class ServiceProviderList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_list);

        // Create a list of service providers
        List<ServiceProvider> providers = new ArrayList<>();
        ServiceProvider provider1 = new ServiceProvider("Hari Lama", "9869885543", "Basundhara,Kathmandu", R.drawable.person4);
        ServiceProvider provider2 = new ServiceProvider("Edwark Khan", "9807766423", "Chabahil,Kathmandu", R.drawable.person3);
        ServiceProvider provider3 = new ServiceProvider("kamala Magar", "9877048322", "Kamalbinayak, Bhaktapur", R.drawable.person1);
        ServiceProvider provider4 = new ServiceProvider("Ram Khanal", "9503219347", "Gwarko, Lalitpur", R.drawable.person2);
        providers.add(provider1);
        providers.add(provider2);
        providers.add(provider3);
        providers.add(provider4);

        // Set up RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ServiceProviderAdapter adapter = new ServiceProviderAdapter(this, providers);
        recyclerView.setAdapter(adapter);
    }

}