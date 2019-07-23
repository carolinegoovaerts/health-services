package goovaerts.nl;

class BmiCalculationEndpoint {

    private static double determineBmiFor(BmiRequest request) {
        return request.getWeight() / (request.getLength() * request.getLength());
    }

    BmiResponse calculate(BmiRequest request) {
        return new BmiResponse(determineBmiFor(request));
    }
}
