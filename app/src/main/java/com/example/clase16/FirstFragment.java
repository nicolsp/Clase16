package com.example.clase16;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clase16.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private RecyclerView mrecyclerView;
    private WordAdapter mWordAdapter;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater,container, false);


        mrecyclerView = binding.myRecicler;
        mWordAdapter = new WordAdapter(getWorData());
        mrecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mrecyclerView.setAdapter(mWordAdapter);



        Log.d("TAG", String.valueOf(getWorData()));
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    private List<String> getWorData() {
        List<String> palabras = new ArrayList<>();

        for( int i = 0;i <= 49; i++ ) {
            palabras.add("Word" + i);
        }
        return palabras;
    }

}