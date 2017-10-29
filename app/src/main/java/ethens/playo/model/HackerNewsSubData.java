package ethens.playo.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ethens on 29/10/17.
 */

public class HackerNewsSubData {

  String title;

  @SerializedName("num_comments") long comments;

  String url;

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public long getComments() {
    return comments;
  }

  public void setComments(long comments) {
    this.comments = comments;
  }
}
