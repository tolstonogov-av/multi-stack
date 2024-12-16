package ru.stack;

public class MultiStackImpl<T> implements MultiStack<T> {
    /**
     * Количество стеков в структуре
     */
    final int dimention;

    /**
     * Массив, содержащий элементы всех стеков
     */
    final Object[] stack;

    /**
     * Текущие позиции стеков.
     * Индекс в массиве - номер стека - 1.
     * Например, если нужна позиция для стека 2, то индекс в массиве positionsForStacks[2 - 1].
     * Для пустых стеков позиция < 0.
     */
    final int[] positionsForStacks;

    public MultiStackImpl(int capacityOfOneStack, int dimention) {
        this.dimention = dimention;
        stack = new Object[capacityOfOneStack * dimention];
        positionsForStacks = new int[dimention];
        initializedPositionsForStacks();
    }

    /**
     * Инициализация начальных (отрицательных) значений позиций в стеках.
     */
    private void initializedPositionsForStacks() {
        for (int i = 0; i < positionsForStacks.length; i++) {
            positionsForStacks[i] = positionsForStacks[i] - (i + 1);
        }
    }

    @Override
    public boolean push(int numberStack, T e) {
        int realNumberStack = numberStack - 1;
        boolean result;
        if (checkOverflow(realNumberStack)) {
            result = false;
        } else {
            positionsForStacks[realNumberStack] = positionsForStacks[realNumberStack] + 3;
            stack[positionsForStacks[realNumberStack]] = e;
            result = true;
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T pop(int numberStack) {
        int realNumberStack = numberStack - 1;
        T result;
        if (checkEmpty(realNumberStack)) {
            result = null;
        } else {
            result = (T) stack[positionsForStacks[realNumberStack]];
            positionsForStacks[realNumberStack]
                    = Math.max(positionsForStacks[realNumberStack] - 3, 0);
        }
        return result;
    }

    /**
     * Проверка указанного стека на заполненность.
     *
     * @param numberStack номер проверяемого стека
     * @return true - если стек заполнен, иначе false
     */
    private boolean checkOverflow(int numberStack) {
        return positionsForStacks[numberStack] + 3  > stack.length - 1;
    }

    /**
     * Проверка указанного стека на отсутствие элементов.
     *
     * @param numberStack номер проверяемого стека
     * @return true - если стек пустой, иначе false
     */
    private boolean checkEmpty(int numberStack) {
        return positionsForStacks[numberStack] == 0;
    }
}
