package galdino.examplelistshotsapi.coreMVP.modules;

import android.content.Context;

import dagger.Module;
import galdino.examplelistshotsapi.api.DribbbleApi;
import galdino.examplelistshotsapi.api.DribbbleDbApiMocked;

/**
 * Created by galdino on 05/11/17.
 */

@Module
public class HelperModule {
    private Context mContext;
    private DribbbleApi mApiMocked;

    public HelperModule(Context context) {
        this.mContext = context;
        this.mApiMocked = new DribbbleDbApiMocked();
    }
}
