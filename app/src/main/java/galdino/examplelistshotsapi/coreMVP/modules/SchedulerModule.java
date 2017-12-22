package galdino.examplelistshotsapi.coreMVP.modules;


import dagger.Module;
import dagger.Provides;
import galdino.examplelistshotsapi.coreMVP.AppSchedulerProvider;
import galdino.examplelistshotsapi.coreMVP.SchedulerProvider;

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
