package galdino.examplelistshotsapi.screens.detailShot;

import galdino.examplelistshotsapi.coreMVP.BasePresenter;
import galdino.examplelistshotsapi.coreMVP.scheduler.SchedulerProvider;
import galdino.examplelistshotsapi.model.Shot;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by Galdino on 22/12/2017.
 */

public class DetailShotPresenter extends BasePresenter<DetailShotMvpView> implements DetailShotMvpPresenter
{
    private DetailShotMvpView mView;
    private DetailShotMvpDataManager mDataManager;
    public DetailShotPresenter(SchedulerProvider schedulerProvider, DetailShotMvpDataManager dataManager) {
        super(schedulerProvider);
        mDataManager = dataManager;
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

            @Override
            public void onGettindShot(boolean isGetting) {

            }

            @Override
            public void showShot(Shot shot) {

            }

            @Override
            public void onErrorGetShot() {

            }
        };
    }

    @Override
    public void loadShot(Integer mIdShot)
    {
        SchedulerProvider schedulerProvider = getSchedulerProvider();
        mDataManager.loadShot(mIdShot)
                .observeOn(schedulerProvider.ui())
                .subscribeOn(schedulerProvider.io())
                .subscribe(new SingleObserver<Shot>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mView.onGettindShot(true);
                    }

                    @Override
                    public void onSuccess(@NonNull Shot shot) {
                        mView.onGettindShot(false);
                        mView.showShot(shot);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        mView.onGettindShot(false);
                        mView.onErrorGetShot();
                    }
                });
    }
}
