package org.springframework.android.showcase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.code.rome.android.repackaged.com.sun.syndication.feed.atom.Entry;
import com.google.code.rome.android.repackaged.com.sun.syndication.feed.atom.Feed;

public class AtomFeedListAdapter extends BaseAdapter 
{
	private Feed _feed;
	private final LayoutInflater _layoutInflater;

	public AtomFeedListAdapter(Context context, Feed feed) 
	{
		_feed = feed;
		_layoutInflater = LayoutInflater.from(context);
	}

	public int getCount() 
	{
		return _feed.getEntries().size();
	}

	public Object getItem(int position) 
	{
		return _feed.getEntries().get(position);
	}

	public long getItemId(int position) 
	{
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) 
	{
		Entry entry = (Entry) getItem(position);
		
		View view = convertView;
		
		if (view == null)
		{
			view = _layoutInflater.inflate(R.layout.synd_feed_list_item, parent, false);
		}

		TextView t = (TextView) view.findViewById(R.id.synd_feed_title);
		t.setText(entry.getTitle());
		
		t = (TextView) view.findViewById(R.id.synd_feed_date);
		t.setText(entry.getPublished().toString());
		
		t = (TextView) view.findViewById(R.id.synd_feed_description);
		t.setText(entry.getSummary().getValue());

		return view;
	}
}
