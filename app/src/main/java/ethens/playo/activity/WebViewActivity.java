package ethens.playo.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import ethens.playo.R;
import ethens.playo.common.BaseActivity;
import ethens.playo.di.master.ComponentFactory;

/**
 * Created by ethens on 29/10/17.
 */

public class WebViewActivity extends BaseActivity {

  private String urlString;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setupUI(R.layout.layout_webview, R.id.parent_coordinator_layout);
  }



  @Override public void setupComponent() {
    ComponentFactory.getInstance().getDashboardComponent().inject(this);
  }



  @Override protected void setupViewHolder(View view) {
    if (getSupportActionBar() != null) {
      getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
    }
    Intent intent  = getIntent();
    urlString = intent.getStringExtra("info");
    new WebViewActivityViewHolder(view, urlString);
  }


}
