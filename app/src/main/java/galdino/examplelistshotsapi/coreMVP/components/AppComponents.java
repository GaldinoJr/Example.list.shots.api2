package galdino.examplelistshotsapi.coreMVP.components;


import dagger.Component;
import galdino.examplelistshotsapi.coreMVP.modules.DataManagerModule;
import galdino.examplelistshotsapi.coreMVP.modules.HelperModule;
import galdino.examplelistshotsapi.coreMVP.modules.PresenterModule;
import galdino.examplelistshotsapi.coreMVP.modules.SchedulerModule;

/**
 * Created by galdino on 05/11/17.
 */

@Component(modules = {PresenterModule.class, SchedulerModule.class, DataManagerModule.class, HelperModule.class})
public interface AppComponents extends BaseComponent{
}
