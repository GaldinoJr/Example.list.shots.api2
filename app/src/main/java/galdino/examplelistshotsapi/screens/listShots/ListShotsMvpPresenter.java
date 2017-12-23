package galdino.examplelistshotsapi.screens.listShots;

import galdino.examplelistshotsapi.coreMVP.MvpPresenter;

/**
 * Created by Galdino on 22/12/2017.
 */

public interface ListShotsMvpPresenter extends MvpPresenter<ListShotsMvpView>{
    void loadShots();
}
