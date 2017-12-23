package galdino.examplelistshotsapi.api;

import android.content.Context;

import java.util.List;

import galdino.examplelistshotsapi.R;
import galdino.examplelistshotsapi.model.Shot;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Galdino on 22/12/2017.
 */

public class ApiHelper implements ApiMvpHelper
{
    private static final String BASE_URL = "http://api.dribbble.com/v1/";
    private Context mContext;
    private DribbbleApi mDbApi;
    private String mToken;

    public ApiHelper(Context context) {
        this.mContext = context;
        Retrofit retrofit = getRetrofit();
        mDbApi = retrofit.create(DribbbleApi.class);
        if(mContext != null)
        {
            mToken = mContext.getString(R.string.token);
        }
    }

    private Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Override
    public Observable<List<Shot>> getShots() {
        return mDbApi.getShots(mToken).flatMap(new Function<List<Shot>, Observable<List<Shot>>>() {
            @Override
            public Observable<List<Shot>> apply(@NonNull List<Shot> shots) throws Exception {
                return Observable.just(shots);
            }
        });
    }

    @Override
    public Observable<Shot> getShotDetail(Integer mIdShot)
    {
        return mDbApi.getShotDetail(String.valueOf(mIdShot),mToken).flatMap(new Function<Shot, Observable<Shot>>() {
            @Override
            public Observable<Shot> apply(@NonNull Shot shot) throws Exception {
                return Observable.just(shot);
            }
        });
    }
}
