package galdino.examplelistshotsapi.screens.detailShot;

import galdino.examplelistshotsapi.coreMVP.MvpView;
import galdino.examplelistshotsapi.model.Shot;

/**
 * Created by Galdino on 22/12/2017.
 */

public interface DetailShotMvpView extends MvpView
{
    void onGettindShot(boolean isGetting);

    void showShot(Shot shot);

    void onErrorGetShot();
}
