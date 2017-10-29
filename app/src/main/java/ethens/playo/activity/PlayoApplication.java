package ethens.playo.activity;

import android.app.Application;
import ethens.playo.di.master.ComponentFactory;

/**
 * Created by ethens on 29/10/17.
 */

public class PlayoApplication extends Application{

  @Override public void onCreate() {
    super.onCreate();
    ComponentFactory.getInstance().initializeComponent(this);

  }
}
