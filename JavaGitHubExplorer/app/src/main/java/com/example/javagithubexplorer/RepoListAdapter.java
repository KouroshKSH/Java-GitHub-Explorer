package com.example.javagithubexplorer;


import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.TextView;
        import java.util.List;


public class RepoListAdapter extends ArrayAdapter<Repository> {

    private final Context context;
    private final List<Repository> repositories;

    public RepoListAdapter(Context context, List<Repository> repositories) {
        super(context, R.layout.list_item_repo, repositories);
        this.context = context;
        this.repositories = repositories;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item_repo, parent, false);

        TextView repoTitleTextView = rowView.findViewById(R.id.repoTitleTextView);
        TextView starsTextView = rowView.findViewById(R.id.starsTextView);
        TextView descriptionTextView = rowView.findViewById(R.id.descriptionTextView);

        Repository repository = repositories.get(position);
        repoTitleTextView.setText(repository.getTitle());
        starsTextView.setText(repository.getStars());
        descriptionTextView.setText(repository.getDescription());

        return rowView;
    }
}
