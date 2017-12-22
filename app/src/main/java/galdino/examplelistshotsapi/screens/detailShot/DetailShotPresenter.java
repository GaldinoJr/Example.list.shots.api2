package galdino.examplelistshotsapi.screens.detailShot;

import galdino.examplelistshotsapi.coreMVP.BasePresenter;
import galdino.examplelistshotsapi.coreMVP.SchedulerProvider;

/**
 * Created by Galdino on 22/12/2017.
 */

public class DetailShotPresenter extends BasePresenter<DetailShotMvpView> implements DetailShotMvpPresenter
{
    private DetailShotMvpView mView;
    public DetailShotPresenter(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    @Override
    public void attach(DetailShotMvpView view)
    {
        mView = view;
    }

    @Override
    public void detachView()
    {
        mView = new DetailShotMvpView() {

        };
    }
}
