package csc.coderunner;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A test to run for a java method.
 */
public class MethodTest extends CodeTest
{
	private String paramValues;

	/**
	 * Constructor.
	 * @param testName The name of the test.
	 * @param paramValues The parameter values to pass to the method.
	 */
	public MethodTest(
		@JsonProperty("testName") String testName,
		@JsonProperty("paramValues") String paramValues)
	{
		super(testName);
		this.paramValues = paramValues;
	}
	
	/**
	 * @param javaClass The class containing the code that will be tested.
	 * @return The return type of the test.
	 */
	@Override
	protected String getTestMethodReturnType(Class<?> javaClass)
	{
		return javaClass.getDeclaredMethods()[0].getReturnType().getSimpleName();
	}
	
	/**
	 * @return The getTestMethodBody method body.
	 */
	@Override
	protected String getTestMethodBody(Class<?> javaClass)
	{
		return String.format("return %s.%s(%s);",
			javaClass.getSimpleName(),
			javaClass.getDeclaredMethods()[0].getName(),
			paramValues);
	}
	
	/**
	 * @return Whether or not to include the class name in stack traces.
	 */
	@Override
	protected boolean includeClassNameInStackTraces()
	{
		return false;
	}
}