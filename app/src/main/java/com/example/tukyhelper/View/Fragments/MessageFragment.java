package com.example.tukyhelper.View.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tukyhelper.R;
import com.example.tukyhelper.View.Adapters.MessageRVAdapter;
import com.example.tukyhelper.ViewModel.MessageViewModel;

import java.util.ArrayList;
import java.util.List;

public class MessageFragment extends Fragment {

    //Fields

    public static final String KEY_ARG_PAGE = "ARG_PAGE";
    public static final String KEY_ESSENCE_ID = "ESSENCE_ID";
    public static final String[] TITLES = {"ADV", "IMPORTANT", "PROP"};

    int cpage;
    int id;

    RecyclerView rv_messages;

    MessageViewModel msgVM;

    //endregion

    public static MessageFragment getInstance(int page, int essenceId){
        Bundle args = new Bundle();

        args.putInt(KEY_ARG_PAGE, page);
        args.putInt(KEY_ESSENCE_ID, essenceId);

        MessageFragment messageFragment = new MessageFragment();
        messageFragment.setArguments(args);
        return messageFragment;
    }

    //region Override
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            cpage = getArguments().getInt(KEY_ARG_PAGE);
            id = getArguments().getInt(KEY_ESSENCE_ID);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_essence_msg, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        msgVM = ViewModelProviders.of(this).get(MessageViewModel.class);
        setMessageRV(view);
    }

    //endregion

    //region Setup Methods
    void setMessageRV(@NonNull View view){
        rv_messages = view.findViewById(R.id.rv_msg);
        rv_messages.setLayoutManager(new LinearLayoutManager(getContext()));

        MessageRVAdapter adapter = new MessageRVAdapter();
        rv_messages.setAdapter(adapter);

        int msgType = cpage + 1;
        msgVM.getMsgByTypeForEssence(id, msgType).observe(this, adapter::setData);

    }
    //endregion
}
