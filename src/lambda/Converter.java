package lambda;
//@FunctionalInterface
public interface Converter<T, F> {
	F convert(T from);
	default void eat() {
		System.out.println("chi");
	}
}
