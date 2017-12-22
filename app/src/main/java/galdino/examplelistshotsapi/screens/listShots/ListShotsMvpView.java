package galdino.examplelistshotsapi.screens.listShots;

import java.util.List;

import galdino.examplelistshotsapi.coreMVP.MvpView;
import galdino.examplelistshotsapi.model.Shot;

/**
 * Created by Galdino on 22/12/2017.
 */

public interface ListShotsMvpView extends MvpView {
    void onGettingShots(boolean isGetting);

    void showShots(List<Shot> shots);

    void onErrorGettingShots();
}
