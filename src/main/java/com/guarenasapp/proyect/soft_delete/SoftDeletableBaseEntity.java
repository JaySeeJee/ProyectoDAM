package com.guarenasapp.proyect.soft_delete;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.guarenasapp.proyect.model.BaseEntity;

import java.util.Date;

/**
 * Base Entity which implements a soft delete column
 */
@MappedSuperclass
public class SoftDeletableBaseEntity extends BaseEntity{

    @Column(name = "deleted_at")
    private Date deletedAt;

    /**
     * Gets the deletion {@link Date}
     * @return the deletion {@link Date}
     */
    public Date getDeletedAt() {
        return deletedAt;
    }

    /**
     * Sets the deletion {@link Date}
     * @param deletedAt the deletion {@link Date}
     */
    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
}