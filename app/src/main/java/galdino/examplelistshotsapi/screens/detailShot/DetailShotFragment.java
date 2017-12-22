package galdino.examplelistshotsapi.screens.detailShot;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import galdino.examplelistshotsapi.MyAplication;
import galdino.examplelistshotsapi.R;
import galdino.examplelistshotsapi.databinding.FragmentDetailShotBinding;
import galdino.examplelistshotsapi.screens.BaseFragment;
import galdino.examplelistshotsapi.screens.listShots.ListShotsMvpPresenter;

public class DetailShotFragment extends BaseFragment
{
    private DetailShotMvpPresenter mPresenter;
    private FragmentDetailShotBinding mBinding;
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
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail_shot, container, false);
        loadControls();
        return mBinding.getRoot();
    }

    private void loadControls() {
        MyAplication application = (MyAplication) getContext().getApplicationContext();
        application.getDiComponent().inject(this);
    }

    @Inject
    public void setPresenter(DetailShotMvpPresenter presenter)
    {
        mPresenter = presenter;
    }
}
