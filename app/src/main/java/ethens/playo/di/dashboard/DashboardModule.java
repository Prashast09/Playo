package ethens.playo.di.dashboard;

import android.support.v7.app.AppCompatActivity;
import dagger.Module;

/**
 * Created by ethens on 29/10/17.
 */

@Module public class DashboardModule {
  public AppCompatActivity activity;

  public DashboardModule(AppCompatActivity activity) {
    this.activity = activity;
  }

}
