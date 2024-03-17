package fit.app.health.formulas;

import fit.app.entities.*;
import org.decimal4j.util.DoubleRounder;

import java.util.List;

public class HealthCalculations {

    private User user;

    private String gender;

    // KG
    private int weight;

    // CM
    private int height;

    // CM
    private int hip;

    // CM
    private int waist;

    /**
     * Instantiates a new Health calculations.
     *
     * @param user the user
     */
    public HealthCalculations(User user) {
        this.user = user;
        gender = user.getGender();
        List<WeightRecord> weightRecords = user.getWeightRecords();
        List<HeightRecord> heightRecords = user.getHeightRecords();
        List<HipRecord> hipRecords = user.getHipRecords();
        List<WaistRecord> waistRecord = user.getWaistRecords();

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
    public Double getBMI() {
        Double bmi = null;

        if (height != 0 && weight != 0) {
            // Converting height from cm to m
            double heightM = (double) height / 100;
            bmi = DoubleRounder.round((double) weight / (heightM * heightM), 2);
        }

        return bmi;
    }

    /**
     * Gets whr.
     * WHR = waist circumference / hip circumference
     *
     * @return the whr
     */
    public Double getWHR() {
        Double whr = null;

        if (hip != 0 && waist != 0) {
            whr = DoubleRounder.round((double) waist / hip, 2);
        }

        return whr;
    }

    /**
     * Gets bfp.
     * men, the formula is (1.20 x BMI) + (0.23 x Age) – 16.2
     * women, it is (1.20 x BMI) + (0.23 x Age) – 5.4
     *
     * @return the bfp
     */
    public Double getBFP() {
        Double bFP = null;
        Double bmi = getBMI();
        Integer age = user.getAgeNumber();

        if (bmi != null && age != null) {
            bFP = (1.20 * bmi) + (0.23 * age);

            if (gender != null) {
                switch (gender) {
                    case "male":
                        bFP -= 16.2;
                        break;
                    case "female":
                        bFP -= 5.4;
                        break;
                }
                bFP = DoubleRounder.round(bFP, 2);
            }
        }

        return bFP;
    }

    /**
     * Gets bmr.
     * For men: BMR = 88.362 + (13.397 × weight in kg) + (4.799 × height in cm) - (5.677 × age in years)
     * For women: BMR = 447.593 + (9.247 × weight in kg) + (3.098 × height in cm) - (4.330 × age in years)
     *
     * @return the bmr
     */
    public Double getBMR() {
        Double bMR = null;

        if (gender != null) {
            switch (gender) {
                case "male":
                    bMR = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * user.getAgeNumber());
                    break;
                case "female":
                    bMR = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * user.getAgeNumber());
                    break;
            }
            bMR = DoubleRounder.round(bMR, 2);
        }

        return bMR;
    }

    /**
     * Gets tdee.
     * BMR * activity_level (ex: BMR * 1.55)
     *
     * @return the tdee
     */
    public Double getTDEE() {
        Double effort = null;
        String activityLevel = user.getActivityLevel();

        if (activityLevel != null) {
            switch (activityLevel) {
                case "low":
                    effort = .5;
                    break;
                case "medium":
                    effort = 1.0;
                    break;
                case "high":
                    effort = 1.5;
                    break;
            }
            effort = DoubleRounder.round(getBMR() * effort, 2);
        }

        return effort;
    }

    /**
     * Gets ibw.
     * For men: IBW = 50 + 2.3 × (height in inches - 60)
     * For women: IBW = 45.5 + 2.3 × (height in inches - 60)
     *
     * @return the ibw
     */
    public Double getIBW() {
        Double iBW = null;
        double heightInches = height * 0.393701;

        if (gender != null) {
            switch (gender) {
                case "male":
                    iBW = 50 + 2.3 * (heightInches - 60);
                    break;
                case "female":
                    iBW = 45.5 + 2.3 * (heightInches - 60);
                    break;
            }
            iBW = DoubleRounder.round(iBW, 2);
        }

        return iBW;
    }

    /**
     * Gets lbm.
     * For men: LBM = (0.407 × weight in kg) + (0.267 × height in cm) - 19.2
     * For women: LBM = (0.252 × weight in kg) + (0.473 × height in cm) - 48.3
     *
     * @return the lbm
     */
    public Double getLBM() {
        Double lBM = null;

        if (gender != null) {
            switch (gender) {
                case "male":
                    lBM = (0.407 * weight) + (0.267 * height) - 19.2;
                    break;
                case "female":
                    lBM = (0.252 * weight) + (0.473 * height) - 48.3;
                    break;
            }
            lBM = DoubleRounder.round(lBM, 2);
        }

        return lBM;
    }

    /**
     * Gets whtr.
     * WHtR = waist circumference / height
     *
     * @return the whtr
     */
    public Double getWHTR() {
        Double whtr = null;

        if (height != 0 && waist != 0) {
            whtr = DoubleRounder.round((double) waist / height, 2);
        }

        return whtr;
    }
}