package galdino.examplelistshotsapi.screens.listShots;

import java.util.List;

import galdino.examplelistshotsapi.api.ApiMvpHelper;
import galdino.examplelistshotsapi.model.Shot;
import io.reactivex.Single;

/**
 * Created by Galdino on 22/12/2017.
 */

public class ListShotsDataManager implements ListShotsMvpDataManager
{
    private ApiMvpHelper mApiMvpHelper;

    public ListShotsDataManager(ApiMvpHelper apiMvpHelper) {
        this.mApiMvpHelper = apiMvpHelper;
    }

    @Override
    public Single<List<Shot>> loadShots() {
        return mApiMvpHelper.getShots().singleOrError();
    }
}
