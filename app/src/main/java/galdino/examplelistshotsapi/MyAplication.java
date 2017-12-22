package galdino.examplelistshotsapi;

import android.app.Application;

import galdino.examplelistshotsapi.coreMVP.components.BaseComponent;
import galdino.examplelistshotsapi.coreMVP.components.DaggerAppComponents;
import galdino.examplelistshotsapi.coreMVP.modules.HelperModule;

/**
 * Created by Galdino on 22/12/2017.
 */

public class MyAplication extends Application
{
    private BaseComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        BaseComponent baseComponent = DaggerAppComponents.builder()
                .helperModule(new HelperModule(this))
                .build();
        setDiComponent(baseComponent);
    }

    public BaseComponent getDiComponent() {
        return appComponent;
    }

    public void setDiComponent(BaseComponent appComponent) {
        this.appComponent = appComponent;
    }
}
