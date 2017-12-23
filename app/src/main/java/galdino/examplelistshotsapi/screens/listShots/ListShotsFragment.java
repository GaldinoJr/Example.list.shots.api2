package galdino.examplelistshotsapi.screens.listShots;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import galdino.examplelistshotsapi.MyAplication;
import galdino.examplelistshotsapi.R;
import galdino.examplelistshotsapi.databinding.AdapterListShotBinding;
import galdino.examplelistshotsapi.databinding.FragmentListShotsBinding;
import galdino.examplelistshotsapi.model.Shot;
import galdino.examplelistshotsapi.screens.BaseFragment;
import galdino.examplelistshotsapi.screens.detailShot.DetailShotActivity;

public class ListShotsFragment extends BaseFragment implements ListShotsMvpView, ListShotsAdapter.Listener {
    private FragmentListShotsBinding mBinding;
    private ListShotsMvpPresenter mPresenter;

    public static ListShotsFragment newInstance() {
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

    private void loadControls()
    {
        MyAplication application = (MyAplication) getContext().getApplicationContext();
        application.getDiComponent().inject(this);
        //
        mPresenter.loadShots();
        mBinding.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(mPresenter != null)
                {
                    mPresenter.loadShots();
                }
            }
        });
    }

    @Inject
    public void setPresenter(ListShotsMvpPresenter presenter)
    {
        mPresenter = presenter;
        mPresenter.attach(this);
    }

    @Override
    public void onGettingShots(boolean isGetting)
    {
        int visibility = View.GONE;
        if(isGetting)
        {
            visibility = View.VISIBLE;
        }
        else
        {
            mBinding.swipeRefreshLayout.setRefreshing(false);
        }
        mBinding.pgLoading.setVisibility(visibility);
    }

    @Override
    public void showShots(List<Shot> shots)
    {
        ListShotsAdapter adapter = new ListShotsAdapter(this,shots);
        mBinding.rvShots.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.rvShots.setAdapter(adapter);
    }

    @Override
    public void onErrorGettingShots()
    {
        showMessage(R.string.error_on_getting_shots);
    }

    @Override
    public void onItemClicked(Shot shot)
    {
        Intent intent = new Intent(getContext(),DetailShotActivity.class);
        intent.putExtra(DetailShotActivity.EXTRA_ID_SHOT, shot.getId());
        startActivity(intent);
    }
}
