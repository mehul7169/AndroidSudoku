package com.example.sudoku;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

public class SudokuAdapter extends BaseAdapter {

    private Context context;
    private int[][] values;

    public SudokuAdapter(Context context, int[][] values) {
        this.context = context;
        this.values = values;
    }

    @Override
    public int getCount() {
        return 81;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        EditText editText = new EditText(context);
        int row = position / 9;
        int col = position % 9;
        if (values[row][col] != 0) {
            editText.setText(String.valueOf(values[row][col]));
            editText.setEnabled(false);
        } else {
            editText.setText("");
        }
        return editText;
    }
}
