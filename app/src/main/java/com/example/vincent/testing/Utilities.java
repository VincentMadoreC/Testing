package com.example.vincent.testing;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;

public class Utilities {

//    public static ArrayList<EditText> getAllDescendants(ViewGroup layout) {
//        int childCount = layout.getChildCount();
//        int i = 0;
//        ArrayList<EditText> subEditTextList = new ArrayList<EditText>();
//        while (i < childCount) {
//            if ((layout.getChildAt(i) instanceof ViewGroup)) {
//                getAllDescendants((ViewGroup) layout.getChildAt(i));
//            } else if (layout.getChildAt(i) instanceof EditText) {
//                subEditTextList.add((EditText) layout.getChildAt(i));
//            }
//            i++;
//        }
//
//        ArrayList<EditText> fullEditTextList = new ArrayList<EditText>();
//        for (EditText editText : subEditTextList) {
//
//        }
//    }


//    public static ArrayList<EditText> getAllChildren(ViewGroup layout) {
//
//        if (!(layout instanceof ViewGroup)) {
//            ArrayList<EditText> viewArrayList = new ArrayList<EditText>();
//            viewArrayList.add(layout);
//            return viewArrayList;
//        }
//
//        ArrayList<EditText> result = new ArrayList<EditText>();
//
//        ViewGroup viewGroup = (ViewGroup) layout;
//        for (int i = 0; i < viewGroup.getChildCount(); i++) {
//
//            View child = viewGroup.getChildAt(i);
//
//            ArrayList<EditText> viewArrayList = new ArrayList<EditText>();
//            viewArrayList.add((ViewGroup) layout);
//            viewArrayList.addAll(getAllChildren(child));
//
//            result.addAll(viewArrayList);
//        }
//        return result;
//    }

    public static ArrayList<EditText> getAllDescendants(ViewGroup layout) {

        ArrayList<EditText> subEditTextList = new ArrayList<EditText>();

        int childCount = layout.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View child = layout.getChildAt(i);
                if (child instanceof EditText) {
                    subEditTextList.add((EditText) child);
                } else if (child instanceof ViewGroup) {
                    subEditTextList.addAll(getAllDescendants((ViewGroup) child));
                }
            }
        }

        ArrayList<EditText> fullEditTextList = new ArrayList<EditText>();
        fullEditTextList.addAll(subEditTextList);

        return fullEditTextList;
    }
}
