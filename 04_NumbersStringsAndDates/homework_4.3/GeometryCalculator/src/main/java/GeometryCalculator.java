public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius)
    {
        return Math.PI * Math.pow(radius, 2);
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius)
    {
        return 4.0 / 3.0 * Math.PI * Math.abs(Math.pow(radius, 3));
    }

    public static boolean isTrianglePossible(double a, double b, double c)
    {
        return a < b + c && b < a + c && c < a + b;
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTriangleRightAngled, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c)
    {
        if (isTrianglePossible(a,  b,  c))
        {
            double p = (a + b + c) / 2;
            double triangleSquare = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            return triangleSquare;
        }
        return -1;
    }
}
