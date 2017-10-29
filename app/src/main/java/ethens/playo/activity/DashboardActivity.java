package ethens.playo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import de.greenrobot.event.EventBus;
import ethens.playo.NewsCLick;
import ethens.playo.R;
import ethens.playo.common.BaseActivity;
import ethens.playo.di.master.ComponentFactory;
import ethens.playo.model.HackerNewsSubData;

public class DashboardActivity extends BaseActivity {

DashboardActivityViewHolder dashboardActivityViewHolder;
  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setupUI(R.layout.activity_dashboard, R.id.dashboard_layout);
    EventBus.getDefault().register(this);
  }

  @Override public void setupComponent() {
    ComponentFactory.getInstance().getDashboardComponent(this).inject(this);
  }

  @Override protected void setupViewHolder(View view) {
    dashboardActivityViewHolder = new DashboardActivityViewHolder(view);
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_category, menu);
    return dashboardActivityViewHolder.setupSearch(this, menu);
  }

  public void onEventMainThread(NewsCLick newsCLick){
    Intent intent = new Intent(this, WebViewActivity.class);
    intent.putExtra("info", newsCLick.getUrl());
    startActivity(intent);
  }
}
