package com.example.sabaesewa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.sabaesewa.databinding.ActivityCustomerDashboardBinding;
import com.example.sabaesewa.databinding.ActivityServiceProviderDashboardBinding;
public class CustomerDashboard extends AppCompatActivity {
    ActivityCustomerDashboardBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCustomerDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        hideSystemUI();
        int menuProfileId = R.id.menuProfile;
        int menuHomeId = R.id.menuHome;
        int menuHistoryId = R.id.menuHistory;
        replaceFragment(new CustomerHome());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == menuProfileId) {
                replaceFragment(new CustomerProfile());
            } else if (itemId == menuHomeId) {
                replaceFragment(new CustomerHome());
            } else if (itemId == menuHistoryId) {
                replaceFragment(new CustomerHistory());
            }
            return true;
        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
    private void hideSystemUI() {
        View decorView = getWindow().getDecorView();
        int flags = View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(flags);
    }
}