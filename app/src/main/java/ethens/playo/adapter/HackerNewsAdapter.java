package ethens.playo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import de.greenrobot.event.EventBus;
import ethens.playo.NewsCLick;
import ethens.playo.R;
import ethens.playo.model.HackerNewsData;
import ethens.playo.model.HackerNewsSubData;
import java.util.List;
import org.w3c.dom.Text;

/**
 * Created by ethens on 29/10/17.
 */

public class HackerNewsAdapter extends RecyclerView.Adapter<HackerNewsAdapter.HackerNewsAdapterViewHolder>{
  HackerNewsData mHackerNewsData;

  public HackerNewsAdapter(HackerNewsData hackerNewsData){
    mHackerNewsData= hackerNewsData;
  }

  @Override public HackerNewsAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hackernews_data, parent, false);
    return new HackerNewsAdapterViewHolder(v);
  }

  @Override public void onBindViewHolder(HackerNewsAdapterViewHolder holder, int position) {
    HackerNewsSubData information = mHackerNewsData.getHackerNewsSubData().get(position);
    holder.setData(information);
  }

  @Override public int getItemCount() {
    return mHackerNewsData.getHackerNewsSubData().size();
  }

  public void setData(HackerNewsData hackerNewsData) {
    mHackerNewsData = hackerNewsData;
    notifyDataSetChanged();
  }

  public class HackerNewsAdapterViewHolder extends RecyclerView.ViewHolder {

    TextView title, count;
    LinearLayout layout;
    public HackerNewsAdapterViewHolder(View itemView) {
      super(itemView);
      title = itemView.findViewById(R.id.title);
      count = itemView.findViewById(R.id.comment_count);
      layout = itemView.findViewById(R.id.item_data);

    }

    public void setData(final HackerNewsSubData hackerNewsSubData) {
      title.setText(hackerNewsSubData.getTitle());
      count.setText(String.valueOf(hackerNewsSubData.getComments()));
      layout.setOnClickListener(new View.OnClickListener() {

        @Override public void onClick(View view) {
          EventBus.getDefault().post(new NewsCLick(hackerNewsSubData.getUrl()));
        }
      });
    }
  }
}
