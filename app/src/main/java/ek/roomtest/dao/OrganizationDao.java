package ek.roomtest.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import java.util.List;

import ek.roomtest.model.Address;
import ek.roomtest.model.Organization;
import ek.roomtest.model.OrganizationDetails;
import ek.roomtest.model.OrganizationWithDetails;
import ek.roomtest.model.OrganizationWithDetailsWrong;

@Dao
public abstract class OrganizationDao {
    @Query("SELECT organization.*, organizationdetails.workTime FROM organization" +
           " LEFT JOIN organizationdetails ON organization.id = organizationdetails.organizationId")
    public abstract List<OrganizationWithDetails> getOrganizations();

    @Query("SELECT organization.*, details.workTime FROM organization" +
           " LEFT JOIN (SELECT * FROM organizationdetails WHERE 1 = 1) details ON organization.id = details.organizationId")
    public abstract List<OrganizationWithDetailsWrong> getOrganizationsWrong();

    @Transaction
    public void init() {
        deleteAllOrganizations();
        deleteAllOrganizationDetails();
        for (int i = 0; i < 3; i++) {
            insert(new Organization(i, "org" + i, new Address("Default City", "Central st. " + i)));
            insert(new OrganizationDetails(i, "10:00-20:00"));
        }
    }

    @Insert
    public abstract void insert(Organization organization);

    @Query("DELETE FROM organization")
    public abstract void deleteAllOrganizations();
    @Query("DELETE FROM organizationdetails")
    public abstract void deleteAllOrganizationDetails();

    @Insert
    public abstract void insert(OrganizationDetails details);

}
