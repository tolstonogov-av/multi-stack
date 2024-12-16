package ru.stack;

/**
 * Интерфейс для реализации работы множественного стека (LIFO).
 *
 * @param <T> тип объекта в стеке
 */
public interface MultiStack<T> {
    /**
     * Помещение элемента в указанный стек.
     *
     * @param numberStack номер стека в хранилище
     * @param e добавляемый элемент
     * @return true - если операция прошла успешно, false - если стек заполнен и элемент не добавлен
     */
    public boolean push(int numberStack, T e);

    /**
     * Извлечение элемента из стека.
     *
     * @param numberStack номер стека в хранилище
     * @return извлечённый элемент либо null - если стек пустой
     */
    public T pop(int numberStack);
}
