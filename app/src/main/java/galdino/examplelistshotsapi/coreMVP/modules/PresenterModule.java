package galdino.examplelistshotsapi.coreMVP.modules;

import dagger.Module;
import dagger.Provides;
import galdino.examplelistshotsapi.coreMVP.scheduler.SchedulerProvider;
import galdino.examplelistshotsapi.screens.detailShot.DetailShotMvpDataManager;
import galdino.examplelistshotsapi.screens.detailShot.DetailShotMvpPresenter;
import galdino.examplelistshotsapi.screens.detailShot.DetailShotPresenter;
import galdino.examplelistshotsapi.screens.listShots.ListShotsMvpDataManager;
import galdino.examplelistshotsapi.screens.listShots.ListShotsMvpPresenter;
import galdino.examplelistshotsapi.screens.listShots.ListShotsPresenter;

/**
 * Created by galdino on 05/11/17.
 */

@Module
public class PresenterModule {

    @Provides
    ListShotsMvpPresenter provideListShotsMvpPresenter(SchedulerProvider schedulerProvider, ListShotsMvpDataManager listShotsMvpDataManager){
        return new ListShotsPresenter(schedulerProvider, listShotsMvpDataManager);
    }

    @Provides
    DetailShotMvpPresenter provideDetailShotMvpPresenter(SchedulerProvider schedulerProvider, DetailShotMvpDataManager detailShotMvpDataManager)
    {
        return new DetailShotPresenter(schedulerProvider, detailShotMvpDataManager);
    }
}
