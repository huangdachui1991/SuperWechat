/**
 * Copyright (C) 2016 Hyphenate Inc. All rights reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.ucai.superwechat.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.ucai.superwechat.R;
import cn.ucai.superwechat.adapter.NewFriendsMsgAdapter;
import cn.ucai.superwechat.db.InviteMessgeDao;
import cn.ucai.superwechat.domain.InviteMessage;
import cn.ucai.superwechat.utils.MFGT;

/**
 * Application and notification
 *
 */
public class NewFriendsMsgActivity extends BaseActivity {

    @BindView(R.id.img_back)
    ImageView mimgBack;
    @BindView(R.id.txt_title)
    TextView mtxtTitle;
    @BindView(R.id.list)
    ListView mlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.em_activity_new_friends_msg);
        ButterKnife.bind(this);

        mimgBack.setVisibility(View.VISIBLE);
        mtxtTitle.setVisibility(View.VISIBLE);
        mtxtTitle.setText(getString(R.string.recommended_friends));
        InviteMessgeDao dao = new InviteMessgeDao(this);
        List<InviteMessage> msgs = dao.getMessagesList();

        NewFriendsMsgAdapter adapter = new NewFriendsMsgAdapter(this, 1, msgs);
        mlist.setAdapter(adapter);
        dao.saveUnreadMessageCount(0);

    }

    public void back(View view) {
        finish();
    }

    @OnClick(R.id.img_back)
    public void onClick() {
        //在通讯录—新的朋友里的点击事件
        MFGT.finish(this);
    }
}
