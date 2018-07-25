package com.example.bodhi64.tvshowsandmovies.searching;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bodhi64.tvshowsandmovies.BaseApplication;
import com.example.bodhi64.tvshowsandmovies.R;
import com.example.bodhi64.tvshowsandmovies.model.SearchesResult;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchingFragment extends Fragment implements SearchingView {
    @Inject
    SearchingPresenter presenter;

    @BindView(R.id.imb_delete)
    ImageView delete;

    @BindView(R.id.edit_keyword)
    EditText editText;

    @BindView(R.id.list_results)
    ListView listResults;

    private Unbinder unbinder;


    public SearchingFragment() {
        // Required empty public constructor
    }

    public static SearchingFragment getInstance( )
    {
        SearchingFragment fragment = new SearchingFragment();
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        ((BaseApplication) getActivity().getApplication()).createSearchingComponent().inject(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_searching, container, false);
        unbinder= ButterKnife.bind(this,v);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter.setView(this);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                onInputChanged(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });

    }

    @Override
    public void showContent(List<SearchesResult> content) {
        ArrayList<String> titles= new ArrayList<>();

        if (SearchTvContentActivity.search.equals("shows")){
        for(int i = 0; i<content.size();i++){
            if(content.get(i).getOriginal_name().startsWith(editText.getText().toString()))
            titles.add(content.get(i).getOriginal_name());
            }
        }
        else {
            for(int i = 0; i<content.size();i++){
                titles.add(content.get(i).getTitle());
            }
        }

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,titles){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text = (TextView) view.findViewById(android.R.id.text1);
                text.setTextColor(Color.WHITE);
                return view;
            }
        };
        listResults.setAdapter(adapter);
    }


    @Override
    public void onInputChanged(String keyword) {
        if (SearchTvContentActivity.search.equals("shows"))
            presenter.displayShows(keyword);
        else
            presenter.displayContent(keyword);
    }


}
