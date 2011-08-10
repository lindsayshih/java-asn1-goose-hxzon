package org.hxzon.util;

public class DebugUtil {
	public static final String error = "ERROR";
	public static final String debug = "DEBUG";
	public static final String info = "INFO";
	public static final String trace = "TRACE";

	private static void output(String type, String className, String methodName, int lineNumber, String message) {
		String output = (type + ":" + className + "." + methodName + "(" + lineNumber + ")" + ":" + message);
		if (error.equals(type)) {
			System.err.println(output);
		} else {
			System.out.println(output);
		}
	}

	public static void error(String message) {

		StackTraceElement ste = Thread.currentThread().getStackTrace()[2];
		String className = ste.getClassName();
		String methodName = ste.getMethodName();
		int lineNumber = ste.getLineNumber();
		output(error, className, methodName, lineNumber, message);
	}
	
	public static void error(String message,Throwable e){
		
	}

	public static void debug(String message) {
		StackTraceElement ste = Thread.currentThread().getStackTrace()[2];
		String className = ste.getClassName();
		String methodName = ste.getMethodName();
		int lineNumber = ste.getLineNumber();
		output(debug, className, methodName, lineNumber, message);
	}

	public static void trace(String message) {
		StackTraceElement ste = Thread.currentThread().getStackTrace()[2];
		String className = ste.getClassName();
		String methodName = ste.getMethodName();
		int lineNumber = ste.getLineNumber();
		output(trace, className, methodName, lineNumber, message);
	}

	public static void info(String message) {
		StackTraceElement ste = Thread.currentThread().getStackTrace()[2];
		String className = ste.getClassName();
		String methodName = ste.getMethodName();
		int lineNumber = ste.getLineNumber();
		output(info, className, methodName, lineNumber, message);
	}

}
