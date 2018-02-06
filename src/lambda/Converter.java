package lambda;

public interface Converter<T, F> {
	T convert(F from);
}
