package ethens.playo.http;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ethens on 29/10/17.
 */

public class HttpModule {

  public HttpApiService provideAsyncRestAdapter() {
    Retrofit.Builder builder = new Retrofit.Builder();
    builder.client(getHttpClient())
        .baseUrl("http://hn.algolia.com/api/v1/")
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create());
    return builder.build().create(HttpApiService.class);
  }

  private OkHttpClient getHttpClient() {
    OkHttpClient.Builder builder = new OkHttpClient.Builder().retryOnConnectionFailure(false);
    return builder.readTimeout(0, TimeUnit.MILLISECONDS).build();
  }
}
