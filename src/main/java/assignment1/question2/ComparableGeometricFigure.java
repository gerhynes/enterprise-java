package assignment1.question2;

public interface ComparableGeometricFigure<T> extends Comparable<T> {
    public int compareTo(GeometricFigure2 figure);
}
