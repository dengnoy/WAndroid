package example.hp.wandroid.widget.behavior;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.List;

import example.hp.wandroid.R;
import example.hp.wandroid.bean.Hotkey;
import example.hp.wandroid.bean.ResponseData;
import example.hp.wandroid.model.DataManager;
import example.hp.wandroid.ui.search.SearchActivity;
import io.reactivex.functions.Consumer;

public class CustomPopuoWindow {


    public static void showSearchPopWindow(Context context, View achor) {
        PopupWindow popwindow = new PopupWindow();
        View view = LayoutInflater.from(context).inflate(R.layout.popupwindow_search, null);


        popwindow.setContentView(view);
        popwindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        popwindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popwindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffe2d8d8")));
        popwindow.setOutsideTouchable(true);
        popwindow.setFocusable(true);
        initViews(view);
        popwindow.showAsDropDown(achor);


    }

    private static void initViews(View view) {
        TagFlowLayout tfl = view.findViewById(R.id.search_window_tagflow);
        loadHotkey(tfl);
        final EditText input = view.findViewById(R.id.serach_window_input);
        Button startSearch = view.findViewById(R.id.search_windown_start_search);
        startSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key = input.getText().toString();
                if (!checkNoNull(key))
                    return;
                SearchActivity.startSearch(view.getContext(), key);

            }
        });
        tfl.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                TextView tv = (TextView) ((ViewGroup) view).getChildAt(0);
                if (tv != null && tv instanceof TextView)
                    SearchActivity.startSearch(view.getContext(), tv.getText().toString());

                return true;
            }
        });

    }

    private static boolean checkNoNull(String s) {
        if (s != null && s.length() > 0)
            return true;
        return false;
    }

    private static void loadHotkey(final TagFlowLayout layout) {

        DataManager.getInstance().getHotkey()
                .subscribe(new Consumer<ResponseData<List<Hotkey>>>() {
                    @Override
                    public void accept(ResponseData<List<Hotkey>> listResponseData) throws Exception {
                        //create a adapter
                        layout.setAdapter(new MyTagAdapter(listResponseData.getData()));

                    }
                });
    }

    private static class MyTagAdapter extends TagAdapter<Hotkey> {

        public MyTagAdapter(List datas) {
            super(datas);
        }


        @Override
        public View getView(FlowLayout parent, int position, Hotkey hotkey) {
            TextView view = new TextView(parent.getContext());
            view.setText(hotkey.getName());
            view.setTag(hotkey.getLink());
            view.setPadding(8, 3, 8, 3);


            return view;
        }
    }

}
