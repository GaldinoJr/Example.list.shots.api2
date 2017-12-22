package galdino.examplelistshotsapi.screens.listShots;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import galdino.examplelistshotsapi.R;
import galdino.examplelistshotsapi.databinding.AdapterListShotBinding;
import galdino.examplelistshotsapi.model.Shot;

import static galdino.examplelistshotsapi.util.MethodsUtil.getDateFormated;

/**
 * Created by Galdino on 22/12/2017.
 */

public class ListShotsAdapter extends RecyclerView.Adapter<ListShotsAdapter.ViewHolder>
{
    private ListShotsAdapter.Listener mOnClickListener;
    private List<Shot> mList;
    public interface Listener
    {
        void onItemClicked(Shot shot);
    }

    public ListShotsAdapter(Listener mOnClickListener, List<Shot> mList) {
        this.mOnClickListener = mOnClickListener;
        this.mList = mList;
    }

    @Override
    public ListShotsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        AdapterListShotBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.adapter_list_shot,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ListShotsAdapter.ViewHolder holder, int position)
    {
        Shot shot = mList.get(position);
        AdapterListShotBinding binding = holder.mBinding;
        if(shot != null && binding != null)
        {
            binding.tvTitle.setText(shot.getTitle());
            binding.tvCreatAt.setText(getDateFormated(shot.getCreatedAt()));
            binding.tvViewsCount.setText(String.valueOf(shot.getViewsCount()));
            // TODO não esqucer de colocar a imagem na tela
        }
    }

    @Override
    public int getItemCount()
    {
        if(mList != null)
        {
            return mList.size();
        }
        else
        {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private AdapterListShotBinding mBinding;
        public ViewHolder(AdapterListShotBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
            mBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    int position = getAdapterPosition();
                    Shot shot = mList.get(position);
                    if(mOnClickListener!= null && shot != null) {
                        mOnClickListener.onItemClicked(shot);
                    }
                }
            });
        }
    }
}
