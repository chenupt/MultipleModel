package github.chenupt.sample;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by chenupt@gmail.com on 2014/4/3. Description : TODO
 */
public class UnScrollListView extends ListView {

	public UnScrollListView(Context context) {
		super(context);
	}

	public UnScrollListView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public UnScrollListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// set unScroll
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}
}
