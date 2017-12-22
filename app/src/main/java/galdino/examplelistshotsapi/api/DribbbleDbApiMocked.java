package galdino.examplelistshotsapi.api;

import galdino.examplelistshotsapi.model.Shot;
import io.reactivex.Observable;
import retrofit2.http.Path;

/**
 * Created by Galdino on 22/12/2017.
 */

public class DribbbleDbApiMocked implements DribbbleApi {
    @Override
    public Observable<Shot> getShots(@Path(PAR_ACCESS_TOKEN) String access_token) {
        return null;
    }
}
