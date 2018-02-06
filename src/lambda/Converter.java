package lambda;

@FunctionalInterface
public interface Converter<T, F> {
	T convert(F from);
}
