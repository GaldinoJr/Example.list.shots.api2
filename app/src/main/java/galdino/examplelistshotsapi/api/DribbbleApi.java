package galdino.examplelistshotsapi.api;

import galdino.examplelistshotsapi.model.Shot;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Galdino on 22/12/2017.
 */

public interface DribbbleApi
{
    String URL_API = "api.dribbble.com/v1/";
    // Métodos GET
    String GET_SHOTS = "shots";
    String GET_DETAIL_SHOTS = "cd_aluno";
    // parametros
    static final String PAR_ACCESS_TOKEN = "access_token";

    //
    @GET(GET_SHOTS)
    Observable<Shot> getShots(@Path(PAR_ACCESS_TOKEN) String access_token);
}
