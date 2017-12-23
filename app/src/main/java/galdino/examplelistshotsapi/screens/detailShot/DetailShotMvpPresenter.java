package galdino.examplelistshotsapi.screens.detailShot;

import galdino.examplelistshotsapi.coreMVP.MvpPresenter;

/**
 * Created by Galdino on 22/12/2017.
 */

public interface DetailShotMvpPresenter extends MvpPresenter<DetailShotMvpView> {
    void loadShot(Integer mIdShot);
}
