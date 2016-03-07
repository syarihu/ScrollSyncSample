package net.syarihu.android.scrollsyncsample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import net.syarihu.android.scrollsyncsample.databinding.FragmentTestBinding;

import java.util.ArrayList;

public class TestFragment extends Fragment {
    private static final String KEY_LIST = "key_list";

    public static TestFragment newInstance(ArrayList<String> list) {
        TestFragment fragment = new TestFragment();
        Bundle args = new Bundle();
        args.putStringArrayList(KEY_LIST, list);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentTestBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test, container, false);
        ArrayList<String> list = getArguments().getStringArrayList(KEY_LIST);
        if(list != null) {
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, list);
            binding.listView.setAdapter(arrayAdapter);
        }

//        RecylerAdapter adapter = new RecylerAdapter(getActivity(), list);
//        binding.listView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        binding.listView.setAdapter(adapter);
        return binding.getRoot();
    }
}
