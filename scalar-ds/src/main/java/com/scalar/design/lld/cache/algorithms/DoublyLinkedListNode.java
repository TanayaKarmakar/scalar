package com.scalar.design.lld.cache.algorithms;

/**
 * @author t0k02w6 on 09/08/23
 * @project scalar-ds
 */
public class DoublyLinkedListNode<E> {
   DoublyLinkedListNode<E> next;
   DoublyLinkedListNode<E> prev;
   E element;

  public DoublyLinkedListNode(E element) {
    this.element = element;
    this.next = null;
    this.prev = null;
  }

  public E getElement() {
    return element;
  }
}
