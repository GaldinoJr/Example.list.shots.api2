package galdino.examplelistshotsapi.screens.listShots;

import java.util.List;

import galdino.examplelistshotsapi.coreMVP.BasePresenter;
import galdino.examplelistshotsapi.coreMVP.SchedulerProvider;
import galdino.examplelistshotsapi.model.Shot;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by Galdino on 22/12/2017.
 */

public class ListShotsPresenter extends BasePresenter<ListShotsMvpView> implements ListShotsMvpPresenter
{
    private ListShotsMvpView mView;
    private ListShotsMvpDataManager mDataManager;
    public ListShotsPresenter(SchedulerProvider schedulerProvider, ListShotsMvpDataManager dataManager) {
        super(schedulerProvider);
        mDataManager = dataManager;
    }

    @Override
    public void attach(ListShotsMvpView view)
    {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = new ListShotsMvpView() {
            @Override
            public void onGettingShots(boolean isGetting) {

            }

            @Override
            public void showShots(List<Shot> shots) {

            }

            @Override
            public void onErrorGettingShots() {

            }
        };
    }

    @Override
    public void loadShots()
    {
        SchedulerProvider schedulerProvider = getSchedulerProvider();
        mDataManager.loadShots()
            .observeOn(schedulerProvider.ui())
            .subscribeOn(schedulerProvider.io())
            .subscribe(new SingleObserver<List<Shot>>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {
                    mView.onGettingShots(true);
                }

                @Override
                public void onSuccess(@NonNull List<Shot> shots) {
                    mView.onGettingShots(false);
                    mView.showShots(shots);
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    mView.onGettingShots(false);
                    mView.onErrorGettingShots();
                }
            });
    }
}
