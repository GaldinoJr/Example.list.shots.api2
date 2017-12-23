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
import galdino.examplelistshotsapi.model.Shot;
import galdino.examplelistshotsapi.screens.BaseFragment;
import galdino.examplelistshotsapi.screens.listShots.ListShotsMvpPresenter;

import static galdino.examplelistshotsapi.util.MethodsUtil.getDateFormated;

public class DetailShotFragment extends BaseFragment implements DetailShotMvpView
{
    private static final String ARG_ID_SHOT = "ARG_ID_SHOT";

    private DetailShotMvpPresenter mPresenter;
    private FragmentDetailShotBinding mBinding;
    private Integer mIdShot;

    public static DetailShotFragment newInstance(Integer idShot)
    {
        DetailShotFragment fragment = new DetailShotFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_ID_SHOT, idShot);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIdShot = getArguments().getInt(ARG_ID_SHOT);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        if(mIdShot == null || mIdShot == -1)
        {
            showMessage(R.string.error_have_not_id_shot);
            getActivity().finish();
        }
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail_shot, container, false);
        loadControls();
        return mBinding.getRoot();
    }

    private void loadControls() {
        MyAplication application = (MyAplication) getContext().getApplicationContext();
        application.getDiComponent().inject(this);
        mPresenter.loadShot(mIdShot);
    }

    @Inject
    public void setPresenter(DetailShotMvpPresenter presenter)
    {
        mPresenter = presenter;
        mPresenter.attach(this);
    }

    @Override
    public void onGettindShot(boolean isGetting)
    {
        int visibility = View.GONE;
        if(isGetting)
        {
            visibility = View.VISIBLE;
        }
        mBinding.pgLoading.setVisibility(visibility);
    }

    @Override
    public void showShot(Shot shot)
    {
        mBinding.tvTitle.setText(shot.getTitle());
        mBinding.tvDescription.setText(shot.getDescription());
        if(shot.getViewsCount() != null) {
            mBinding.tvViewsCount.setText(String.valueOf(shot.getViewsCount()));
        }
        if(shot.getCommentsCount() != null) {
            mBinding.tvComentsCount.setText(String.valueOf(shot.getCommentsCount()));
        }
        mBinding.tvCreatAt.setText(getDateFormated(shot.getCreatedAt()));
        // TODO COLOCAR A IMAGEM COM CENTER CROP
    }

    @Override
    public void onErrorGetShot()
    {
        showMessage(R.string.error_on_getting_shot_detail);
        getActivity().finish();
    }
}
