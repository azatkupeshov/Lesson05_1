package com.sample.andremion.musicplayer.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sample.andremion.musicplayer.R;
import com.sample.andremion.musicplayer.databases.DatabaseHelper;
import com.sample.andremion.musicplayer.music.MusicContent;
import com.sample.andremion.musicplayer.view.RecyclerViewAdapter;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FavoriteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FavoriteFragment extends Fragment {

    public FavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);


        //Инициализация RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.tracks);
        assert recyclerView != null;

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext() ,LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration decoration = new DividerItemDecoration(Objects.requireNonNull(getContext()), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(decoration);

        //Данные для заполнения RecyclerView
        MusicContent content = new DatabaseHelper(getContext());
        //Инициализация адаптера и заполнение данных
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(content.getAllFavoriteSongs());
        recyclerView.setAdapter(adapter);
        // Inflate the layout for this fragment
        return view;
    }
}
