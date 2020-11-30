package com.example.a33;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.graphics.Color;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt=(TextView)findViewById(R.id.txt);
        //为文本框注册上下文菜单
        registerForContextMenu(txt);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflator=new MenuInflater(this);
        //装填R.menu.my_menu对应的菜单，并添加到menu中
        inflator.inflate(R.menu.my_menu, menu);
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_res_test, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenuInfo menuInfo) {
        MenuInflater inflator=new MenuInflater(this);
        //装填R.menu.context对应的菜单，并添加到menu中
        inflator.inflate(R.menu.context, menu);
        menu.setHeaderIcon(R.drawable.tools);
        menu.setHeaderTitle("选择背景色");
        // TODO Auto-generated method stub
        //super.onCreateContextMenu(menu, v, menuInfo);
    }
    //上下文菜单中，菜单项被单击时触发该方法
    @Override
    public boolean onContextItemSelected(MenuItem mi) {
        //勾选菜单项
        mi.setCheckable(true);  //①
        switch(mi.getItemId())
        {
            case R.id.red:
                mi.setCheckable(true);
                txt.setBackgroundColor(Color.RED);
                break;
            case R.id.green:
                mi.setCheckable(true);
                txt.setBackgroundColor(Color.GREEN);
                break;
            case R.id.blue:
                mi.setCheckable(true);
                txt.setBackgroundColor(Color.BLUE);
                break;
        }
        return true;
        // TODO Auto-generated method stub
        //return super.onContextItemSelected(item);
    }
    //菜单项被单击后的回调方法
    @Override
    public boolean onOptionsItemSelected(MenuItem mi) {
        if(mi.isCheckable())
        {
            //勾选该菜单项
            mi.setCheckable(true);//②
        }
        //判断单击的是哪个菜单项，并有针对性地作出响应
        switch(mi.getItemId())
        {
            case R.id.font_10:
                txt.setTextSize(10*2);
                break;
            case R.id.font_12:
                txt.setTextSize(12*2);
                break;
            case R.id.font_14:
                txt.setTextSize(14*2);
                break;
            case R.id.font_16:
                txt.setTextSize(16*2);
                break;
            case R.id.font_18:
                txt.setTextSize(18*2);
                break;
            case R.id.red_font:
                txt.setTextColor(Color.RED);
                mi.setCheckable(true);
                break;
            case R.id.green_font:
                txt.setTextColor(Color.GREEN);
                mi.setCheckable(true);
                break;
            case R.id.blue_font:
                txt.setTextColor(Color.BLUE);
                mi.setCheckable(true);
                break;
            case R.id.plain_item:
                Toast toast=Toast.makeText(MenuResTest.this, "您单击了普通菜单项",Toast.LENGTH_SHORT);
                toast.show();
                break;

        }
        // TODO Auto-generated method stub
        //return super.onOptionsItemSelected(mi);
        return true;
    }




}
