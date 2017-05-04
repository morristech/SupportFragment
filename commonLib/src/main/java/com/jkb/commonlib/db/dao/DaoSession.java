package com.jkb.commonlib.db.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.jkb.commonlib.db.entity.Status;
import com.jkb.commonlib.db.entity.User;

import com.jkb.commonlib.db.dao.StatusDao;
import com.jkb.commonlib.db.dao.UserDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig statusDaoConfig;
    private final DaoConfig userDaoConfig;

    private final StatusDao statusDao;
    private final UserDao userDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        statusDaoConfig = daoConfigMap.get(StatusDao.class).clone();
        statusDaoConfig.initIdentityScope(type);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        statusDao = new StatusDao(statusDaoConfig, this);
        userDao = new UserDao(userDaoConfig, this);

        registerDao(Status.class, statusDao);
        registerDao(User.class, userDao);
    }
    
    public void clear() {
        statusDaoConfig.clearIdentityScope();
        userDaoConfig.clearIdentityScope();
    }

    public StatusDao getStatusDao() {
        return statusDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

}