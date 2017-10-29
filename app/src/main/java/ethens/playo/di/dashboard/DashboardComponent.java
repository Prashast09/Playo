package ethens.playo.di.dashboard;

import dagger.Subcomponent;
import ethens.playo.activity.DashboardActivity;
import ethens.playo.activity.DashboardActivityViewHolder;
import ethens.playo.activity.WebViewActivity;
import ethens.playo.di.http.HttpModule;

/**
 * Created by ethens on 29/10/17.
 */

@Subcomponent(modules = { DashboardModule.class, HttpModule.class }) public interface DashboardComponent {
  void inject(DashboardActivity dashboardActivity);

  void inject(DashboardActivityViewHolder dashboardActivityViewHolder);

  void inject(WebViewActivity webViewActivity);
}
