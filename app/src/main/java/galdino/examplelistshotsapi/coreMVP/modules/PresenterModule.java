package galdino.examplelistshotsapi.coreMVP.modules;

import dagger.Module;
import dagger.Provides;
import galdino.examplelistshotsapi.coreMVP.SchedulerProvider;
import galdino.examplelistshotsapi.screens.detailShot.DetailShotMvpPresenter;
import galdino.examplelistshotsapi.screens.detailShot.DetailShotPresenter;
import galdino.examplelistshotsapi.screens.listShots.ListShotsMvpPresenter;
import galdino.examplelistshotsapi.screens.listShots.ListShotsPresenter;

/**
 * Created by galdino on 05/11/17.
 */

@Module
public class PresenterModule {

    @Provides
    ListShotsMvpPresenter provideListShotsMvpPresenter(SchedulerProvider schedulerProvider){
        return new ListShotsPresenter(schedulerProvider);
    }

    @Provides
    DetailShotMvpPresenter provideDetailShotMvpPresenter(SchedulerProvider schedulerProvider)
    {
        return new DetailShotPresenter(schedulerProvider);
    }
}
