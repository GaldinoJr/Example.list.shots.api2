package galdino.examplelistshotsapi.api;

import java.util.List;

import galdino.examplelistshotsapi.model.Shot;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by Galdino on 22/12/2017.
 */

public interface ApiMvpHelper
{
    Observable <List<Shot>> getShots();
    Observable <Shot> getShotDetail(Integer mIdShot);
}
