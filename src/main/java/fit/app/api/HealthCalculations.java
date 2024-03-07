package fit.app.api;

import fit.app.dao.User;

/**
 * The type Health calculations.
 */
public class HealthCalculations {

    private User user;

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
    }

    /**
     * Gets bmi.
     *
     * @return the bmi
     */
    public int getBMI() {
        // BMI = weight (kg) / (height (m))^2
        return 0;
    }

    /**
     * Gets whr.
     *
     * @return the whr
     */
    public int getWHR() {
        // WHR = waist circumference / hip circumference
        return 0;
    }

    /**
     * Gets bfp.
     *
     * @return the bfp
     */
    public int getBFP() {
        /**
         * For men: BMR = 88.362 + (13.397 × weight in kg) + (4.799 × height in cm) - (5.677 × age in years)
         * For women: BMR = 447.593 + (9.247 × weight in kg) + (3.098 × height in cm) - (4.330 × age in years)
         */

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
     *
     * @return the tdee
     */
    public int getTDEE() {
        // BMR * activity_level (ex: BMR * 1.55)
        return 0;
    }

    /**
     * Gets ibw.
     *
     * @return the ibw
     */
    public int getIBW() {
        /**
         * For men: IBW = 50 + 2.3 × (height in inches - 60)
         * For women: IBW = 45.5 + 2.3 × (height in inches - 60)
         */

        return 0;
    }

    /**
     * Gets lbm.
     *
     * @return the lbm
     */
    public int getLBM() {
        /**
         * For men: LBM = (0.407 × weight in kg) + (0.267 × height in cm) - 19.2
         * For women: LBM = (0.252 × weight in kg) + (0.473 × height in cm) - 48.3
         */

        return 0;
    }

    /**
     * Gets whtr.
     *
     * @return the whtr
     */
    public int getWHTR() {
        // WHtR = waist circumference / height
        return 0;
    }
}
