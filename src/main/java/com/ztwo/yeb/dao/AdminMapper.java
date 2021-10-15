package com.ztwo.yeb.dao;

import com.ztwo.yeb.bean.Admin;
import com.ztwo.yeb.general.GeneralDao;

public interface AdminMapper extends GeneralDao<Admin> {

    Admin selectAdmin(String username,boolean enabled);
}