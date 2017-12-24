package ek.roomtest;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import ek.roomtest.dao.OrganizationDao;
import ek.roomtest.model.Organization;
import ek.roomtest.model.OrganizationDetails;

@Database(entities = {Organization.class, OrganizationDetails.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract OrganizationDao organizationDao();
}