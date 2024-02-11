package dao;

import java.util.Date;

/**
 * The type Entry date.
 *
 * @author OscarJohnson6
 */
public class EntryDate {
    private Date entryDate;

    /**
     * Instantiates a new Entry date.
     */
    public EntryDate() {
        this.entryDate = new Date();
    }

    /**
     * Instantiates a new Entry date.
     *
     * @param entryDate the entry date
     */
    public EntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    /**
     * Gets entry date.
     *
     * @return the entry date
     */
    public Date getEntryDate() {
        return entryDate;
    }

    /**
     * Sets entry date.
     *
     * @param entryDate the entry date
     */
    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }
}