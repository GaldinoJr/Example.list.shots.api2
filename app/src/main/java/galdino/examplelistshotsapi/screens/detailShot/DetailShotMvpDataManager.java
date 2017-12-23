package galdino.examplelistshotsapi.screens.detailShot;

import galdino.examplelistshotsapi.model.Shot;
import io.reactivex.Single;

/**
 * Created by Galdino on 22/12/2017.
 */

public interface DetailShotMvpDataManager  {
    Single<Shot> loadShot(Integer mIdShot);
}
