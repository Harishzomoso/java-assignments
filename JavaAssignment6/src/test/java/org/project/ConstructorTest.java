package org.project;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ConstructorTest {

    @Test
    public void testVampireIsTrue() {
        assertTrue(VampireNumbers.isVampire(1260)); // 21 * 60
    }

    @Test
    public void testVampireIsFalse() {
        assertFalse(VampireNumbers.isVampire(1234));
    }

    @Test
    public void testOverloadedConstructor() {
        OverloadedConstructor obj = new OverloadedConstructor();
        assertNotNull(obj);
    }

    @Test
    public void testArrayReferenceWithoutInitialization() {
        ConstructorMessage[] arr = new ConstructorMessage[3];
        for (ConstructorMessage cm : arr) {
            assertNull(cm);
        }
    }

    @Test
    public void testArrayReferenceWithInitialization() {
        ConstructorMessage[] arr = new ConstructorMessage[3];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ConstructorMessage("Test " + i);
        }
        for (ConstructorMessage cm : arr) {
            assertNotNull(cm);
        }
    }
}

