package ethens.playo.di.dashboard;

import dagger.Subcomponent;
import ethens.playo.di.http.HttpModule;

/**
 * Created by ethens on 29/10/17.
 */

@Subcomponent(modules = { DashboardModule.class, HttpModule.class }) public interface DashboardComponent {
}
