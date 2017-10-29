package ethens.playo.di.master;

import android.content.Context;
import dagger.Provides;
import ethens.playo.activity.PlayoApplication;
import javax.inject.Singleton;

/**
 * Created by ethens on 29/10/17.
 */

public class AppModule {
  public PlayoApplication playoApplication;

  public AppModule(PlayoApplication playoApplication) {
    this.playoApplication = playoApplication;
  }

  @Provides @Singleton PlayoApplication providesPlayoApplication() {
    return playoApplication;
  }

  @Provides @Singleton Context providesContext() {
    return playoApplication.getApplicationContext();
  }
}
