package com.aura.training.dashboard.service;

import com.aura.training.dashboard.entity.UserOrder;
import com.aura.training.dashboard.entity.UserPic;

import java.util.List;

public interface UserPicServiceInfo {
    public List<UserPic> getUserPic(int uid);
}
