package assignment1.question2;

public interface ComparableGeometricFigure<T> extends Comparable<T> {
    int compareTo(GeometricFigure2 figure);
}
