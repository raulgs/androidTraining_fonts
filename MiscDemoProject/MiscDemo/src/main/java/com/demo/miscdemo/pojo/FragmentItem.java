package com.demo.miscdemo.pojo;

import android.support.v4.app.Fragment;

import java.io.Serializable;

/**
* Created by raulg on 11/28/13.
*/
public class FragmentItem implements Serializable{
    public String id;
    public String title;
    public Fragment fragment;

    public FragmentItem(String id, String title, Fragment fragment) {
        this.id = id;
        this.title = title;
        this.fragment = fragment;
    }

    @Override
    public String toString() {
        return title;
    }
}
