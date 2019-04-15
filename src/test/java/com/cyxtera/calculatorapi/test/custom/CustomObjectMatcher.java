package com.cyxtera.calculatorapi.test.custom;

import org.mockito.ArgumentMatcher;

public class CustomObjectMatcher<T> implements ArgumentMatcher<T> {
	 
    /**
     * The class to match
     */
    private Class<T> type;
 
    /**
     * The constructor to CustomObjectMatcher
     * @param type the Class to match
     */
    public CustomObjectMatcher(Class<T> type) {
        this.type=type;
    }
 
    /* (non-Javadoc)
     * @see org.mockito.ArgumentMatcher#matches(java.lang.Object)
     */
    @Override
    public boolean matches(T actual) {
    	
    	return type.isInstance(actual);
    }
 
}