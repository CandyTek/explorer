package com.calintat.explorer.recycler;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.content.ContextCompat;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.calintat.explorer.R;
import com.calintat.explorer.utils.FileUtils;
import com.calintat.explorer.utils.PreferenceUtils;

import java.io.File;

import static com.calintat.explorer.utils.FileUtils.getColorResource;
import static com.calintat.explorer.utils.FileUtils.getName;

final class ViewHolderImage extends ViewHolder {

	private TextView name;

	private TextView date;

	ViewHolderImage(Context context,OnItemClickListener listener,View view) {
		super(context,listener,view);
	}

	@Override
	protected void loadIcon() {

		image = (ImageView) itemView.findViewById(R.id.list_item_image);
	}

	@Override
	protected void loadName() {

		name = (TextView) itemView.findViewById(R.id.list_item_name);
	}

	@Override
	protected void loadInfo() {

		date = (TextView) itemView.findViewById(R.id.list_item_date);
	}

	@Override
	protected void bindIcon(File file,Boolean selected) {

		final int color = ContextCompat.getColor(context,getColorResource(file));
		// this.view.setImageBitmap(resource);
		
	}

	@Override
	protected void bindName(File file) {

		boolean extension = PreferenceUtils.getBoolean(context,"pref_extension",true);

		name.setText(extension ? getName(file) : file.getName());
	}

	@Override
	protected void bindInfo(File file) {

		if (date == null) return;

		date.setText(FileUtils.getLastModified(file));
	}
}
