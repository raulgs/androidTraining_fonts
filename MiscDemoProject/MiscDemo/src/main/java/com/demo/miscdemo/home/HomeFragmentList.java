package com.demo.miscdemo.home;

import com.demo.miscdemo.ItemDetailFragment;
import com.demo.miscdemo.hint.ArabicHintFragment;
import com.demo.miscdemo.pojo.FragmentItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeFragmentList {

    /**
     * An array of sample  items.
     */
    public static List<FragmentItem> ITEMS = new ArrayList<FragmentItem>();

    /**
     * A map of sample items, by ID.
     */
    public static Map<String, FragmentItem> ITEM_MAP = new HashMap<String, FragmentItem>();

    static {
        // Add 3 sample items.
        addItem(new FragmentItem("1", "Arabic Hint Issue", new ArabicHintFragment()));
        addItem(new FragmentItem("2", "Item 2", new ItemDetailFragment()));
        addItem(new FragmentItem("3", "Item 3", new ItemDetailFragment()));
    }

    private static void addItem(FragmentItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

}
