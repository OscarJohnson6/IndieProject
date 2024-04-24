package fit.app.utilities;

import fit.app.entities.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Code copied from the course site for an interface to be implemented in the
 * analyzer project.
 *
 * @author OscarJohnson6
 */
public interface RecentRecordLoader {

    /**
     * Loads the most recent records in the database, is used
     * mostly by UpdateAccount to set the most recent records
     * and their ID as attributes, index servlet uses this to
     * just get the records.
     *
     * @param user current user account in the http session
     * @param req  a servlets http request
     */
    default void loadRecentRecords(User user, HttpServletRequest req) {
        List<WeightRecord> weightRecords = user.getWeightRecords();
        List<HeightRecord> heightRecords = user.getHeightRecords();
        List<HipRecord> hipRecords = user.getHipRecords();
        List<WaistRecord> waistRecords = user.getWaistRecords();

        if (!weightRecords.isEmpty()) {
            WeightRecord weight = weightRecords.get(weightRecords.size() - 1);
            req.setAttribute("userWeight", weight.getWeight());
            req.setAttribute("userWeightId", weight.getId());
        }
        if (!heightRecords.isEmpty()) {
            HeightRecord height = heightRecords.get(heightRecords.size() - 1);
            req.setAttribute("userHeight", height.getHeight());
            req.setAttribute("userHeightId", height.getId());
        }
        if (!hipRecords.isEmpty()) {
            HipRecord hip = hipRecords.get(hipRecords.size() - 1);
            req.setAttribute("userHip", hip.getHip());
            req.setAttribute("userHipId", hip.getId());
        }
        if (!waistRecords.isEmpty()) {
            WaistRecord waist = waistRecords.get(waistRecords.size() - 1);
            req.setAttribute("userWaist", waist.getWaist());
            req.setAttribute("userWaistId", waist.getId());
        }
    }

}