package com.gizmo.unusedassets.util;

import java.lang.reflect.Method;

public class ReflectionHelper {

	public static final Method getDeclaredMethod(Class<?> declaringClass, String[] methodNames, Class<?>... methodTypes)
	{
		Exception failed = null;
		for (String methodName : methodNames)
		{
			try
			{
				Method method = declaringClass.getDeclaredMethod(methodName, methodTypes);
				method.setAccessible(true);
				return method;
			}
			catch (Exception ex)
			{
				failed = ex;
			}
		}
		throw new NullPointerException("idk, but this is from that reflection helper class you made. Have fun :D");
	}


	@SuppressWarnings("unchecked")
	public static final <T, E> T invokeMethod(final Method methodToAccess, E instance, Object... args)
	{
		try
		{
			if (methodToAccess.getReturnType().equals(Void.TYPE))
			{
				methodToAccess.invoke(instance, args);
				return null;
			}
			else
			{
				return (T)methodToAccess.invoke(instance, args);
			}
		}
		catch (Exception ex)
		{
			throw new MethodInvokationException(ex);
		}
	}

	public static <T> T invokeMethod(Method methodToAccess, Object instance)
	{
		return invokeMethod(methodToAccess, instance, (Object[])null);
	}


	public static class MethodInvokationException extends RuntimeException
	{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MethodInvokationException(Exception ex)
		{
			super(ex);
		}
	}
}
