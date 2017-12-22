package galdino.examplelistshotsapi.coreMVP.modules;

import dagger.Module;
import dagger.Provides;
import galdino.examplelistshotsapi.api.ApiMvpHelper;
import galdino.examplelistshotsapi.screens.detailShot.DetailShotDataManager;
import galdino.examplelistshotsapi.screens.detailShot.DetailShotMvpDataManager;
import galdino.examplelistshotsapi.screens.listShots.ListShotsDataManager;
import galdino.examplelistshotsapi.screens.listShots.ListShotsMvpDataManager;

/**
 * Created by galdino on 05/11/17.
 */

@Module
public class DataManagerModule
{
    @Provides
    DetailShotMvpDataManager providesDetailShotMvpDataManager(ApiMvpHelper apiHelper)
    {
        return new DetailShotDataManager(apiHelper);
    }

    @Provides
    ListShotsMvpDataManager providesListShotsMvpDataManager(ApiMvpHelper apiHelper)
    {
        return new ListShotsDataManager(apiHelper);
    }
}
