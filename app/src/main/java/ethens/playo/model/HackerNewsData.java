package ethens.playo.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by ethens on 29/10/17.
 */

public class HackerNewsData {

  public List<HackerNewsSubData> getHackerNewsSubData() {
    return hackerNewsSubData;
  }

  public void setHackerNewsSubData(List<HackerNewsSubData> hackerNewsSubData) {
    this.hackerNewsSubData = hackerNewsSubData;
  }

  @SerializedName("hits") private List<HackerNewsSubData> hackerNewsSubData;
}
