package net.syarihu.android.scrollsyncsample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import net.syarihu.android.scrollsyncsample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    MyPagerAdapter adapter;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        adapter = new MyPagerAdapter(getSupportFragmentManager(), binding.pager, R.id.list_view);
        binding.pager.setAdapter(adapter);
    }
}
