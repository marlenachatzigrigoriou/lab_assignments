package math;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * An class used as a holder of the @RunWith and @Suite 
 * annotations, necessary when someone needs to group
 * classes that include tests, for demonstrating Unit Testing.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({MyMathTest.class, MyParameterizedMathTest.class})
public class MyTestSuite {
	/*
	 * This class remains empty. Is used only as a holder 
	 * of the above annotations.
	 */
}