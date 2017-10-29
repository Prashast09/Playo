package ethens.playo.http;

import ethens.playo.model.HackerNewsData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ethens on 29/10/17.
 */

public interface HttpApiService {

  @GET("search") Call<HackerNewsData> searchNews(@Query("query") String query);
}
