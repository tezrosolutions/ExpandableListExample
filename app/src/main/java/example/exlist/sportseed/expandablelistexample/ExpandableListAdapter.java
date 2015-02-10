package example.exlist.sportseed.expandablelistexample;

import java.util.HashMap;
import java.util.List;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> expandableListTitle;
    private HashMap<String, List<ListItemModel>> expandableListDetail;

    public ExpandableListAdapter(Context context, List<String> expandableListTitle,
                                 HashMap<String, List<ListItemModel>> expandableListDetail) {
        this.context = context;
        this.expandableListTitle = expandableListTitle;
        this.expandableListDetail = expandableListDetail;
    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        return this.expandableListDetail.get(this.expandableListTitle.get(listPosition))
                .get(expandedListPosition);
    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    static class ChildViewHolder {
        TextView txt;
    }

    @Override
    public View getChildView(int listPosition, final int expandedListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final ListItemModel expandedListItem = (ListItemModel) getChild(listPosition, expandedListPosition);
        LayoutInflater mInflater = (LayoutInflater) this.context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(expandedListItem.isHeader){
            convertView = mInflater.inflate(R.layout.list_header, null);
            TextView expandedListTextView = (TextView) convertView
                    .findViewById(R.id.expandedListItem);
            expandedListTextView.setText(expandedListItem.title);

            return convertView;
        }

        // A ViewHolder keeps references to children views to avoid unneccessary calls
        // to findViewById() on each row.
        ChildViewHolder holder = null;


        //Get ViewHolder first
        if(convertView!=null){
            holder = (ChildViewHolder) convertView.getTag();
        }

        //If no ViewHolder, then create a new child row as convertView is probably a header
        if(holder == null){
            convertView = mInflater.inflate(R.layout.list_item, null);
            holder = new ChildViewHolder();
            convertView.setTag(holder);
        }

        holder.txt = (TextView) convertView.findViewById(R.id.expandedListItem);

        holder.txt.setText(expandedListItem.title);

        return convertView;
    }

    @Override
    public int getChildrenCount(int listPosition) {
        return this.expandableListDetail.get(this.expandableListTitle.get(listPosition))
                .size();
    }

    @Override
    public Object getGroup(int listPosition) {
        return this.expandableListTitle.get(listPosition);
    }

    @Override
    public int getGroupCount() {
        return this.expandableListTitle.size();
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    static class GroupHolder {
        ImageView img;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String listTitle = (String) getGroup(listPosition);
        GroupHolder groupHolder;
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_group, null);

            groupHolder = new GroupHolder();
            groupHolder.img = (ImageView) convertView.findViewById(R.id.img);

            convertView.setTag(groupHolder);
        } else {
            groupHolder = (GroupHolder) convertView.getTag();
        }

        TextView listTitleTextView = (TextView) convertView
                .findViewById(R.id.listTitle);
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);


        if (isExpanded) {
            groupHolder.img.setImageResource(R.drawable.collapse);
        } else {
            groupHolder.img.setImageResource(R.drawable.expand);
        }

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }
}