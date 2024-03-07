package fit.app.api;

import fit.app.dao.*;

import java.util.List;

/**
 * The type Health calculations.
 */
public class HealthCalculations {

    private User user;

    // KG
    private int weight;

    // CM
    private int height;

    private int hip;

    private int waist;

    /**
     * Instantiates a new Health calculations.
     */
    public HealthCalculations() {
    }

    /**
     * Instantiates a new Health calculations.
     *
     * @param user the user
     */
    public HealthCalculations(User user) {
        this.user = user;
        List<WeightRecord> weightRecords = user.getWeightRecords();
        List<HeightRecord> heightRecords = user.getHeightRecord();
        List<HipRecord> hipRecords = user.getHipRecord();
        List<WaistRecord> waistRecord = user.getWaistRecord();

        if (!weightRecords.isEmpty()) {
            weight = weightRecords.get(0).getWeight();
        }

        if (!heightRecords.isEmpty()) {
            height = heightRecords.get(0).getHeight();
        }

        if (!hipRecords.isEmpty()) {
            hip = hipRecords.get(0).getHip();
        }

        if (!waistRecord.isEmpty()) {
            waist = waistRecord.get(0).getWaist();
        }
    }

    /**
     * Gets bmi.
     * BMI = weight (kg) / (height (m))^2
     *
     * @return the bmi
     */
    public double getBMI() {
        // Converting height from m to cm
        int heightM = height / 100;
        return (double) weight / (heightM * heightM);
    }

    /**
     * Gets whr.
     * WHR = waist circumference / hip circumference
     *
     * @return the whr
     */
    public int getWHR() {
        return 0;
    }

    /**
     * Gets bfp.
     * For men: BMR = 88.362 + (13.397 × weight in kg) + (4.799 × height in cm) - (5.677 × age in years)
     * For women: BMR = 447.593 + (9.247 × weight in kg) + (3.098 × height in cm) - (4.330 × age in years)
     *
     * @return the bfp
     */
    public int getBFP() {

        return 0;
    }

    /**
     * Gets bmr.
     *
     * @return the bmr
     */
    public int getBMR() {
        // Locate
        return 0;
    }

    /**
     * Gets tdee.
     * BMR * activity_level (ex: BMR * 1.55)
     *
     * @return the tdee
     */
    public double getTDEE() {
        double effort = 0;

        switch (user.getActivityLevel()) {
            case "low":
                effort = .5;
                break;
            case "medium":
                effort = 1;
                break;
            case "high":
                effort = 1.5;
                break;
        }

        return getBMR() * effort;
    }

    /**
     * Gets ibw.
     * For men: IBW = 50 + 2.3 × (height in inches - 60)
     * For women: IBW = 45.5 + 2.3 × (height in inches - 60)
     *
     * @return the ibw
     */
    public double getIBW() {
        double IBW = 0;
        double heightInches = height;

        switch (user.getGender()) {
            case "male":
                IBW = 50 + 2.3 * (heightInches - 60);
                break;
            case "female":
                IBW = 45.5 + 2.3 * (heightInches - 60);
                break;
        }

        return IBW;
    }

    /**
     * Gets lbm.
     * For men: LBM = (0.407 × weight in kg) + (0.267 × height in cm) - 19.2
     * For women: LBM = (0.252 × weight in kg) + (0.473 × height in cm) - 48.3
     *
     * @return the lbm
     */
    public double getLBM() {
        double LBM = 0;
        double heightInches = height;

        switch (user.getGender()) {
            case "male":
                LBM = (0.407 * weight) + (0.267 * height) - 19.2;
                break;
            case "female":
                LBM = (0.252 * weight) + (0.473 * height) - 48.3;
                break;
        }

        return LBM;
    }

    /**
     * Gets whtr.
     * WHtR = waist circumference / height
     *
     * @return the whtr
     */
    public double getWHTR() {
        return (double) waist / height;
    }
}
