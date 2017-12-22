package galdino.examplelistshotsapi.screens.listShots;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import galdino.examplelistshotsapi.MyAplication;
import galdino.examplelistshotsapi.R;
import galdino.examplelistshotsapi.databinding.FragmentListShotsBinding;
import galdino.examplelistshotsapi.screens.BaseFragment;

public class ListShotsFragment extends BaseFragment {
    private FragmentListShotsBinding mBinding;
    private ListShotsMvpPresenter mPresenter;

    public static ListShotsFragment newInstance(String param1, String param2) {
        ListShotsFragment fragment = new ListShotsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_list_shots, container, false);
        loadControls();
        return mBinding.getRoot();
    }

    private void loadControls() {
        MyAplication application = (MyAplication) getContext().getApplicationContext();
        application.getDiComponent().inject(this);
    }

    @Inject
    public void setPresenter(ListShotsMvpPresenter presenter)
    {
        mPresenter = presenter;
    }
}
