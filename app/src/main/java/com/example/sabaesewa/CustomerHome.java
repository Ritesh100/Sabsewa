package com.example.sabaesewa;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sabaesewa.adapter.CardAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CustomerHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CustomerHome extends Fragment {
    ViewPager2 viewPager2;
   private Handler sliderhandler = new Handler();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public CustomerHome() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CustomerHome.
     */
    // TODO: Rename and change types and number of parameters
    public static CustomerHome newInstance(String param1, String param2) {
        CustomerHome fragment = new CustomerHome();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_customer_home, container, false);
        viewPager2 = rootView.findViewById(R.id.viewPager);

        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.slider1));
        sliderItems.add(new SliderItem(R.drawable.slider2));
        sliderItems.add(new SliderItem(R.drawable.slider3));

        viewPager2.setAdapter(new SliderAdapter(sliderItems, viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(5);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(30));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + 0.15f);
            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderhandler.removeCallbacks(sliderRunnable);
                sliderhandler.postDelayed(sliderRunnable, 2000);
            }
        });

        // Create a list of card items for the RecyclerView
        List<CardItem> cardItemList = new ArrayList<>();
        cardItemList.add(new CardItem(R.drawable.acmechanic, "AC Mechanic"));
        cardItemList.add(new CardItem(R.drawable.plumber, "Plumber"));
        cardItemList.add(new CardItem(R.drawable.carpenter, "Carpenter"));
        cardItemList.add(new CardItem(R.drawable.cleaner, "Cleaner"));
        cardItemList.add(new CardItem(R.drawable.electrician, "Electrican"));
        cardItemList.add(new CardItem(R.drawable.teacher, "Teacher"));
        cardItemList.add(new CardItem(R.drawable.others, "Others"));
        // Add more card items as needed

        // Set up the RecyclerView with the CardAdapter
        RecyclerView cardRecyclerView = rootView.findViewById(R.id.cardRecyclerView);
        cardRecyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 3)); // Adjust the span count as needed
        CardAdapter cardAdapter = new CardAdapter(requireContext(), cardItemList);
        cardRecyclerView.setAdapter(cardAdapter);
        return rootView;
    }
  private Runnable sliderRunnable = new Runnable() {
      @Override
      public void run() {
          viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);
      }
  };

    @Override
    public void onPause() {
        super.onPause();
        sliderhandler.removeCallbacks(sliderRunnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        sliderhandler.postDelayed(sliderRunnable, 3000);
    }
}