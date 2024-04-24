package fit.app.formulas;

import fit.app.entities.*;
import org.decimal4j.util.DoubleRounder;

import java.util.List;

public class HealthCalculations {

    private final User user;

    private final String gender;

    // KG will be 0 if user has no records
    private int weight;

    // CM will be 0 if user has no records
    private int height;

    // CM will be 0 if user has no records
    private int hip;

    // CM will be 0 if user has no records
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
        List<WaistRecord> waistRecords = user.getWaistRecords();

        if (!weightRecords.isEmpty()) {
            weight = weightRecords.get(weightRecords.size() - 1).getWeight();
        }

        if (!heightRecords.isEmpty()) {
            height = heightRecords.get(heightRecords.size() - 1).getHeight();
        }

        if (!hipRecords.isEmpty()) {
            hip = hipRecords.get(hipRecords.size() - 1).getHip();
        }

        if (!waistRecords.isEmpty()) {
            waist = waistRecords.get(waistRecords.size() - 1).getWaist();
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
            bFP = genderCheckFormula(
                    (1.20 * bmi) + (0.23 * age),
                    -16.2,
                    -5.4
            );
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
        Integer userAge = user.getAgeNumber();

        if (height != 0 && waist != 0 && userAge != null) {
            bMR = genderCheckFormula(
                    0.0,
                    88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * userAge),
                    447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * userAge)
            );
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

        if (heightInches != 0) {
            iBW = genderCheckFormula(
                    0.0,
                    50 + 2.3 * (heightInches - 60),
                    45.5 + 2.3 * (heightInches - 60)
            );
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

        if (height != 0 && waist != 0) {
            lBM = genderCheckFormula(
                    0.0,
                    (0.407 * weight) + (0.267 * height) - 19.2,
                    (0.252 * weight) + (0.473 * height) - 48.3
            );
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

    /**
     * Gets whtr.
     * WHtR = waist circumference / height
     *
     * @return the whtr
     */
    private Double genderCheckFormula(Double formulaNumber, Double maleNumber, Double femaleNumber) {
        if (gender != null) {
            if (gender.equals("male")) {
                formulaNumber += maleNumber;
            } else if (gender.equals("female")){
                formulaNumber += femaleNumber;
            } else {
                formulaNumber = null;
            }

            if (formulaNumber != null) {
                formulaNumber = DoubleRounder.round(formulaNumber, 2);
            }
        } else {
            formulaNumber = null;
        }

        return formulaNumber;
    }
}