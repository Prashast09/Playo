package ethens.playo.di.master;

import dagger.Component;
import ethens.playo.di.dashboard.DashboardComponent;
import ethens.playo.di.dashboard.DashboardModule;
import ethens.playo.di.http.HttpModule;
import javax.inject.Singleton;

/**
 * Created by ethens on 29/10/17.
 */

@Singleton @Component(modules = AppModule.class) public interface PlayoComponent {
  DashboardComponent plus(DashboardModule dashboardModule, HttpModule httpModule);
}
