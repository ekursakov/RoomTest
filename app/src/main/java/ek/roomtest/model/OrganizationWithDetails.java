package ek.roomtest.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;

public class OrganizationWithDetails {

    @Embedded
    public Organization organization;

    @ColumnInfo(name = "workTime")
    public String workTime;

    @Override
    public String toString() {
        return "OrganizationWithDetails{" +
               "organization=" + organization +
               ", workTime='" + workTime + '\'' +
               '}';
    }
}
