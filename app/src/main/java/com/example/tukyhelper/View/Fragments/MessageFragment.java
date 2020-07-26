package com.example.tukyhelper.View.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tukyhelper.R;
import com.example.tukyhelper.View.Adapters.MessageRVAdapter;

import java.util.ArrayList;
import java.util.List;

public class MessageFragment extends Fragment {

    //Fields

    public static final String ARG_PAGE = "ARG_PAGE";
    public static final String[] TITLES = {"ADV", "IMPORTANT", "PROP"};
    int cpage;

    RecyclerView rv_messages;
    List<String> messages = new ArrayList<>();  //  will be deleted

    MessageRVAdapter msg_adapter;

    //endregion

    public static MessageFragment getInstance(int page){

        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);

        MessageFragment messageFragment = new MessageFragment();
        messageFragment.setArguments(args);
        return messageFragment;
    }

    //region Override
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            cpage = getArguments().getInt(ARG_PAGE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_essence_msg, container, false);
        TextView page = (TextView) view.findViewById(R.id.tv_page);
        String tmp = page.getText().toString() + String.valueOf(cpage);
        page.setText(tmp);
        return view;
    }

    //endregion

    //region Setup Methods
    void MessageRV(){
        rv_messages = (RecyclerView) getView().findViewById(R.id.rv_msg);
    }
    //endregion
}
