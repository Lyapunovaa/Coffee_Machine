class Circle {

    double radius;

    double getLength() {
        return radius * 2 * Math.PI;
    }

    double getArea() {
        return Math.PI * (radius * radius);
    }
}