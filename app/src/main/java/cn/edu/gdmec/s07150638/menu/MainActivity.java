package cn.edu.gdmec.s07150638.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import cn.edu.gdmec.s07150638.menu.R;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView1);
        bt1 = (Button) findViewById(R.id.bt1);
        registerForContextMenu(bt1);
    }

    // 创建菜单所需要重载的方法 onCreateOptionsMenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        /**
         * menu.add()方法的四个参数
         * 第一个参数
         * int groupId——代表的是组的概念，可以把几个菜单归为一组，以便更好的管理自己的菜单
         * 第二个参数
         * int itemId——代表的是项目编号，这个参数非常重要，一个id对应一个Menu中的选项，在后面使用菜单的时候，就靠这个itemId来判断使用的是哪个选项
         * 第三个参数
         * int orderId——代表的是菜单项的显示顺序，默认是0，表示菜单的显示顺序就是安装add的显示顺序来显示
         * 第四个参数
         * 这个参数是你给菜单项的标题和名字
         */
        menu.add(1,1,0,R.string.a1);
        menu.add(1,2,0,R.string.a2);
        SubMenu file = menu.addSubMenu("文件");
        file.add(1,3,0,"二级菜单1");
        file.add(1,4,0,"二级菜单2");
        return super.onCreateOptionsMenu(menu);
    }

    // onOptionsItemSelected 用于处理用户选中的某个菜单项后执行的动作
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu1:
                textView.setText("菜单1" + item.getItemId());
                break;
            case R.id.menu2:
                textView.setText("菜单2" + item.getItemId());
                break;
            case 1:
                textView.setText("菜单3");
                break;
            case 2:
                textView.setText("菜单4");
                break;
            case 3:
                textView.setText("子级菜单1");
                break;
            case 4:
                textView.setText("子级菜单2");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    // 创建上下文菜单
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()){
            case R.id.bt1:
                menu.add(0,1,0,"上下文菜单1");
                menu.add(0,2,0,"上下文菜单2");
                menu.add(0,3,0,"上下文菜单3");
                break;
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    // 用户选择上下文菜单的某项后执行的动作

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                bt1.setText("1");
                break;
            case 2:
                bt1.setText("2");
                break;
            case 3:
                bt1.setText("3");
                break;
        }
        return super.onContextItemSelected(item);
    }
}
