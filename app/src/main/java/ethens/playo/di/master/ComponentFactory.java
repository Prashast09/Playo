package ethens.playo.di.master;

import android.support.v7.app.AppCompatActivity;
import ethens.playo.activity.PlayoApplication;
import ethens.playo.http.HttpModule;

/**
 * Created by ethens on 29/10/17.
 */

public class ComponentFactory {

  public static ComponentFactory componentFactory;
  public PlayoComponent playoComponent;
  public DashboardComponent dashboardComponent;

  public static ComponentFactory getInstance() {
    if (componentFactory == null) {
      componentFactory = new ComponentFactory();
    }

    return componentFactory;
  }

  public ComponentFactory initializeComponent(PlayoApplication playoApplication) {
    playoComponent = DaggerPlayoComponent.builder()
        // This also corresponds to the name of your module: %component_name%Module
        .appModule(new AppModule(playoApplication)).build();
    return componentFactory;
  }

  public PlayoComponent getPlayoComponent() {
    return playoComponent;
  }

  public DashboardComponent getDashboardComponent(AppCompatActivity appCompatActivity) {
    if (dashboardComponent == null) {
      dashboardComponent =
          getPlayoComponent().plus(new DashboardModule(appCompatActivity), new HttpModule());
    }
    return dashboardComponent;
  }

  public DashboardComponent getDashboardComponent() {
    return dashboardComponent;
  }

  public void removeDashboardComponent() {
    dashboardComponent = null;
  }
}
