package galdino.examplelistshotsapi.screens.listShots;

import galdino.examplelistshotsapi.coreMVP.BasePresenter;
import galdino.examplelistshotsapi.coreMVP.SchedulerProvider;

/**
 * Created by Galdino on 22/12/2017.
 */

public class ListShotsPresenter extends BasePresenter<ListShotsMvpView> implements ListShotsMvpPresenter
{
    private ListShotsMvpView mView;
    public ListShotsPresenter(SchedulerProvider schedulerProvider) {
        super(schedulerProvider);
    }

    @Override
    public void attach(ListShotsMvpView view)
    {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = new ListShotsMvpView() {
        };
    }
}
