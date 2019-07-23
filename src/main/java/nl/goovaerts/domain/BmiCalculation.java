package nl.goovaerts.domain;

import nl.goovaerts.data.BmiRequest;
import nl.goovaerts.data.BmiResponse;

public interface BmiCalculation {
    BmiResponse process(BmiRequest request);
}
