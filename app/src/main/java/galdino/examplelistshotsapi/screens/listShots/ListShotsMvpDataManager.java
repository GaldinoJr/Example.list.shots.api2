package galdino.examplelistshotsapi.screens.listShots;

import java.util.List;

import galdino.examplelistshotsapi.model.Shot;
import io.reactivex.Single;

/**
 * Created by Galdino on 22/12/2017.
 */

public interface ListShotsMvpDataManager {
    Single<List<Shot>> loadShots();
}
