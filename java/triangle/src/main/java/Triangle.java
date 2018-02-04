class Triangle {
    double a, b, c;
    
    Triangle(double side1, double side2, double side3) throws TriangleException {
        if (side1 == 0 || side2 == 0 || side3 == 0) {
            throw new TriangleException();
        }
        
        if (side1 + side2 < side3 || 
                side1 + side3 < side2 || 
                side2 + side3 < side1) {
            throw new TriangleException();
        }
        a = side1;
        b = side2;
        c = side3;
    }

    boolean isEquilateral() {
        return (a == b && b == c);
    }

    boolean isIsosceles() {
        // equilateral triangles are considered as isosceles
        // for this exercise.
        return (a == b || b == c || a == c); 
    }

    boolean isScalene() {
        return (a != b && b != c && a != c);
    }

}
