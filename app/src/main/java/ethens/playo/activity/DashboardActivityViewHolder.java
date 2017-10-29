package ethens.playo.activity;

import android.app.SearchManager;
import android.content.Context;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import dagger.Component;
import ethens.playo.R;
import ethens.playo.adapter.HackerNewsAdapter;
import ethens.playo.common.BaseActivity;
import ethens.playo.di.http.HttpModule;
import ethens.playo.di.master.ComponentFactory;
import ethens.playo.http.HttpApiService;
import ethens.playo.model.HackerNewsData;
import javax.inject.Inject;
import javax.inject.Named;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ethens on 29/10/17.
 */

public class DashboardActivityViewHolder {

  @Inject Context context;
  HackerNewsData mHackerNewsData = new HackerNewsData();
  LinearLayout noDataLayout;
  RecyclerView recyclerView;

  @Inject @Named("background") HttpApiService httpApiService;

  HackerNewsAdapter hackerNewsAdapter;
  public DashboardActivityViewHolder(View view) {
ComponentFactory.getInstance().getDashboardComponent().inject(this);
    noDataLayout = view.findViewById(R.id.no_data_layout);
    recyclerView = view.findViewById(R.id.recycler_view);
    showNoDataLayout();
  }

  public void showNoDataLayout(){
    recyclerView.setVisibility(View.GONE);
    noDataLayout.setVisibility(View.VISIBLE);
  }

  public void hideNoDataLayout(){
    noDataLayout.setVisibility(View.GONE);
    recyclerView.setVisibility(View.VISIBLE);
  }
  private void setupAdapter(String query) {
    updateDataFromServer(query);
  }

  private void updateDataFromServer(String query) {
    httpApiService.searchNews(query).enqueue(new Callback<HackerNewsData>() {
      @Override
      public void onResponse(Call<HackerNewsData> call, Response<HackerNewsData> response) {
        mHackerNewsData = response.body();
        setDataToAdapter();
      }

      @Override public void onFailure(Call<HackerNewsData> call, Throwable t) {

      }
    });
  }

  private void setDataToAdapter() {
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
    recyclerView.setLayoutManager(linearLayoutManager);
    if(mHackerNewsData.getHackerNewsSubData().get(0) == null) {
      showNoDataLayout();
    }
    else {
      hideNoDataLayout();
      if (hackerNewsAdapter == null) hackerNewsAdapter = new HackerNewsAdapter(mHackerNewsData);
      else hackerNewsAdapter.setData(mHackerNewsData);
      recyclerView.setAdapter(hackerNewsAdapter);
    }

  }

  public boolean setupSearch(Context context, Menu menu) {
    ComponentFactory.getInstance().getDashboardComponent().inject(this);
      final MenuItem searchItem = menu.findItem(R.id.search_category);
      final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
      SearchManager searchManager = (SearchManager) context.getSystemService(Context.SEARCH_SERVICE);
      searchView.setSearchableInfo(
          searchManager.getSearchableInfo(((BaseActivity) context).getComponentName()));
      searchView.setQueryHint("Search with keywords");
      ImageView closeButton = searchView.findViewById(R.id.search_close_btn);
      closeButton.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
          searchView.clearFocus();
          searchView.setQuery("", false);
          searchView.setIconified(true);
          searchItem.collapseActionView();
        }
      });
      searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        @Override public boolean onQueryTextSubmit(String query) {
          searchView.clearFocus();
          return false;
        }

        @Override public boolean onQueryTextChange(String query) {
          if (!query.isEmpty()) {
            setupAdapter(query);
          }
          return false;
        }
      });
      return true;
    }

}
