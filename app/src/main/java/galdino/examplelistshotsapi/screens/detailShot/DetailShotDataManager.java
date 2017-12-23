package galdino.examplelistshotsapi.screens.detailShot;

import galdino.examplelistshotsapi.api.ApiMvpHelper;
import galdino.examplelistshotsapi.model.Shot;
import io.reactivex.Single;

/**
 * Created by Galdino on 22/12/2017.
 */

public class DetailShotDataManager implements DetailShotMvpDataManager{
    private ApiMvpHelper mApiMvpHelper;

    public DetailShotDataManager(ApiMvpHelper mApiMvpHelper) {
        this.mApiMvpHelper = mApiMvpHelper;
    }

    @Override
    public Single<Shot> loadShot(Integer mIdShot) {
        return mApiMvpHelper.getShotDetail(mIdShot).singleOrError();
    }
}
