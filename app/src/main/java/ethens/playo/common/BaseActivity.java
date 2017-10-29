package ethens.playo.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by ethens on 29/10/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setupComponent();
  }

  abstract public void setupComponent();

  protected void setupUI(int layoutId, int viewHolderId) {
    setContentView(layoutId);
    setupViewHolder(findViewById(viewHolderId));
  }

  abstract protected void setupViewHolder(View view);
}
