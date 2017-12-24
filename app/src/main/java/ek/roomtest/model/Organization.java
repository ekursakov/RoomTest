package ek.roomtest.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Organization {
    @PrimaryKey
    private final int id;
    private final String name;
    @Embedded(prefix = "address_")
    private final Address embeddedAddress;

    public Organization(int id, String name, Address embeddedAddress) {
        this.id = id;
        this.name = name;
        this.embeddedAddress = embeddedAddress;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getEmbeddedAddress() {
        return embeddedAddress;
    }

    @Override
    public String toString() {
        return "Organization{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", embeddedAddress=" + embeddedAddress +
               '}';
    }
}
