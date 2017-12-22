package galdino.examplelistshotsapi.coreMVP.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import galdino.examplelistshotsapi.api.ApiHelper;
import galdino.examplelistshotsapi.api.ApiMvpHelper;
import galdino.examplelistshotsapi.api.DribbbleApi;
import galdino.examplelistshotsapi.api.DribbbleDbApi;
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

    @Provides
    ApiMvpHelper providesApiHelper()
    {
        return new ApiHelper(mContext);
    }
}
