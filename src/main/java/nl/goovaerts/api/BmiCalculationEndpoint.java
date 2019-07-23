package nl.goovaerts.api;

import nl.goovaerts.data.BmiRequest;
import nl.goovaerts.data.BmiResponse;
import nl.goovaerts.domain.BmiCalculation;

class BmiCalculationEndpoint {

    private final BmiCalculation bmiCalculation;

    BmiCalculationEndpoint(BmiCalculation bmiCalculation) {
        this.bmiCalculation = bmiCalculation;
    }

    BmiResponse calculate(BmiRequest request) {
        return bmiCalculation.process(request);
    }
}
