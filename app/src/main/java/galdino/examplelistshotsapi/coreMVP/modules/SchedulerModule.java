package galdino.examplelistshotsapi.coreMVP.modules;


import dagger.Module;
import dagger.Provides;
import galdino.examplelistshotsapi.coreMVP.scheduler.AppSchedulerProvider;
import galdino.examplelistshotsapi.coreMVP.scheduler.SchedulerProvider;

/**
 * Created by galdino on 05/11/17.
 */

@Module
public class SchedulerModule
{
    @Provides
    SchedulerProvider provideSchedulerModule()
    {
        return new AppSchedulerProvider();
    }
}
