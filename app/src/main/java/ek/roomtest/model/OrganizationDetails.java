package ek.roomtest.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class OrganizationDetails {
    @PrimaryKey
    public int organizationId;
    public String workTime;

    public OrganizationDetails() {
    }

    public OrganizationDetails(int organizationId, String workTime) {
        this.organizationId = organizationId;
        this.workTime = workTime;
    }
}
