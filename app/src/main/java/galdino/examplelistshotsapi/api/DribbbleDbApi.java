package galdino.examplelistshotsapi.api;

import java.util.List;

import galdino.examplelistshotsapi.model.Shot;
import io.reactivex.Observable;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Galdino on 22/12/2017.
 */

public class DribbbleDbApi implements DribbbleApi {

    @Override
    public Observable<List<Shot>> getShots(@Path(PATH_ACCESS_TOKEN) String access_token) {
        return null;
    }

    @Override
    public Observable<Shot> getShotDetail(@Path(PAR_SHOT_ID) String shotId, @Query(PATH_ACCESS_TOKEN) String access_token) {
        return null;
    }

}
