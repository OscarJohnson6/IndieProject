package fit.app.entities;

import java.util.Date;

/**
 * The interface Identity.
 */
public interface Identity {
    /**
     * Gets id.
     *
     * @return the id
     */
    int getId();

    /**
     * Sets id.
     *
     * @param idNumber the id number
     */
    void setId(int idNumber);

    /**
     * Gets entry date.
     *
     * @return the entry date
     */
    Date getEntryDate();

    /**
     * Sets entry date.
     *
     * @param entryDate the entry date
     */
    void setEntryDate(Date entryDate);
}
