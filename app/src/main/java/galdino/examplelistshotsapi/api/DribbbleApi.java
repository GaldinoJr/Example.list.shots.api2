package galdino.examplelistshotsapi.api;

import java.util.List;

import galdino.examplelistshotsapi.model.Shot;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Galdino on 22/12/2017.
 */

public interface DribbbleApi
{
    // Parameters
    String PAR_SHOT_ID = "shotId";
    // Métodos GET
    String GET_SHOTS = "shots";
    String GET_SHOT_DETAIL = GET_SHOTS + "/{" + PAR_SHOT_ID + "}";
    // parametros
    String PATH_ACCESS_TOKEN = "access_token";

    //
    @GET(GET_SHOTS)
    Observable<List<Shot>> getShots(
            @Query(PATH_ACCESS_TOKEN) String access_token);

    @GET(GET_SHOT_DETAIL)
    Observable<Shot> getShotDetail(
            @Path(PAR_SHOT_ID) String shotId,
            @Query(PATH_ACCESS_TOKEN) String access_token);
}
