package ru.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiStackImplTest {
    MultiStack<Integer> multiStack;

    @BeforeEach
    void setUp() {
        int capacityOfOneStack = 3;
        int dimention = 3;
        multiStack = new MultiStackImpl<>(capacityOfOneStack, dimention);
    }

    @Test
    void pushAndPop() {
        multiStack.push(1, 10);
        multiStack.push(1, 20);
        assertEquals(20, multiStack.pop(1));
        assertEquals(10, multiStack.pop(1));
    }

    @Test
    void pushWithOverflow() {
        System.out.println(multiStack.push(1, 10));
        System.out.println(multiStack.push(1, 20));
        System.out.println(multiStack.push(1, 30));
        assertFalse(multiStack.push(1, 40));
    }

    @Test
    void popWithEmptyStack() {
        multiStack.push(1, 10);
        multiStack.pop(1);
        assertNull(multiStack.pop(1));
    }

    @Test
    void useSeveralStacksSimultaneously() {
        multiStack.push(1, 10);
        multiStack.push(1, 20);
        multiStack.push(2, 30);
        multiStack.push(2, 40);
        multiStack.push(3, 50);
        multiStack.push(3, 60);
        assertEquals(20, multiStack.pop(1));
        assertEquals(40, multiStack.pop(2));
        assertEquals(60, multiStack.pop(3));
    }
}
