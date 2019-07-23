package goovaerts.nl;

class BmiCalculationEndpoint {

    BmiResponse calculate(BmiRequest request) {
        double value = request.getWeight() / (request.getLength() * request.getLength());
        return new BmiResponse(value);
    }
}
