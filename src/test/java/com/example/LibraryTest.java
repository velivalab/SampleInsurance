/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.lib.Library;

public class LibraryTest {
    @Test public void testSomeLibraryMethod() {
        Library classUnderTest = new Library();
        assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
    }
    @Test public void testAdd()
    {
        Library classUnderTest = new Library();
        assertTrue("1+2 should be 3", classUnderTest.add(1,2)==3);
    }
}
