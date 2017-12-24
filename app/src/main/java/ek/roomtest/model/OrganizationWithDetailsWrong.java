package ek.roomtest.model;

import android.arch.persistence.room.ColumnInfo;

public class OrganizationWithDetailsWrong extends Organization {

    @ColumnInfo(name = "workTime")
    private final String workTime;

    public OrganizationWithDetailsWrong(int id, String name, Address embeddedAddress, String workTime) {
        super(id, name, embeddedAddress);
        this.workTime = workTime;
    }

    public String getWorkTime() {
        return workTime;
    }

    @Override
    public String toString() {
        return "OrganizationWithDetailsWrong{" +
               "workTime='" + workTime + '\'' +
               "} " + super.toString();
    }
}
