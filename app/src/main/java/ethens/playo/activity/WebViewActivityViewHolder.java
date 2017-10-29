package ethens.playo.activity;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import ethens.playo.R;

/**
 * Created by ethens on 29/10/17.
 */
public class WebViewActivityViewHolder {
  private WebView webview;
  private ProgressBar progressBar;

  WebViewActivityViewHolder(View view, String urlString) {
    webview = (WebView) view.findViewById(R.id.web_tnc);
    progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);

    webview.getSettings().setJavaScriptEnabled(true);
    setWebViewListener();
    loadUrl(urlString);
  }

  private void loadUrl(String urlString) {
    if (urlString != null) {
      webview.loadUrl(urlString);
    }
  }

  private void setWebViewListener() {
    webview.setWebViewClient(new WebViewClient() {
      @Override
      public void onPageStarted(WebView view, String url, Bitmap favicon) {
        setLayoutOnWebPageStarted(true);
        super.onPageStarted(view, url, favicon);
      }

      @Override
      public void onPageFinished(WebView view, String url) {
        setLayoutOnWebPageStarted(false);
        super.onPageFinished(view, url);
      }
    });
  }


  public void setLayoutOnWebPageStarted(boolean layoutOnWebPageStarted) {
    if (layoutOnWebPageStarted) {
      progressBar.setVisibility(View.VISIBLE);
      webview.setVisibility(View.GONE);
    } else {
      progressBar.setVisibility(View.GONE);
      webview.setVisibility(View.VISIBLE);
    }
  }


}

