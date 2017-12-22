package galdino.examplelistshotsapi.screens.detailShot;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import galdino.examplelistshotsapi.R;

public class DetailShotFragment extends Fragment {

    public static DetailShotFragment newInstance(String param1, String param2) {
        DetailShotFragment fragment = new DetailShotFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_shot, container, false);
    }
}
