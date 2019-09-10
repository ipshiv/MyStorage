package com.example.mystorage;


import android.util.Log;

public class TestClass implements TestInterface {

    public static class mvvmClass{
        /*Model*/
        public static int GetSum (int a, int b)
        {
            return a+b;
        }
    }


    private static final String TAG = "TestClass";
    
    @Override
    public String GetClassName() {
        return null;
    }

    @Override
    public String getId() {
        Log.d(TAG, "getId: OK");
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String getImg() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void setTitle(String title) {

    }

    @Override
    public void setImg(String img) {

    }

    @Override
    public void setDescription(String description) {

    }

    public TestClass() {
    }
}
