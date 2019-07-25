package nl.goovaerts.api;

import nl.goovaerts.data.BmiRequest;
import nl.goovaerts.data.BmiResponse;
import nl.goovaerts.domain.BmiCalculation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bmi")
class BmiCalculationEndpoint {

    private final BmiCalculation bmiCalculation;

    BmiCalculationEndpoint(BmiCalculation bmiCalculation) {
        this.bmiCalculation = bmiCalculation;
    }

    @PostMapping("/calculate")
    BmiResponse calculate(@RequestBody BmiRequest request) {
        return bmiCalculation.process(request);
    }
}
