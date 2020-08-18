package com.example.clase16;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clase16.databinding.WordItemLayoutBinding;

import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {
    private List<String> wordList;
    private PassElementSelected mListener;

    public WordAdapter(List<String> wordList, PassElementSelected mElementSelected) {
        this.wordList = wordList;
        this.mListener = mElementSelected;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       WordItemLayoutBinding mBinding = WordItemLayoutBinding.
               inflate(LayoutInflater.from(parent.getContext()),parent, false);

        return new WordViewHolder(mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        String mword = wordList.get(position);
        holder.textView.setText(mword);
    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }


    public class WordViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {

       private TextView textView;

        public WordViewHolder(@NonNull WordItemLayoutBinding mBinding) {
            super(mBinding.getRoot());
            textView = mBinding.wordTv;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();
            String element = wordList.get(position);
            mListener.passElement(element);
        }
    }



    public interface PassElementSelected {
        void passElement(String word);
    }
}
