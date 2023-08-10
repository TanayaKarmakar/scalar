package com.scalar.design.lld.cache.algorithms;

import com.scalar.design.lld.cache.exceptions.InvalidElementException;
import java.util.NoSuchElementException;

/**
 * @author t0k02w6 on 09/08/23
 * @project scalar-ds
 */
public class DoublyLinkedList<E> {
  private DoublyLinkedListNode<E> dummyHead;
  private DoublyLinkedListNode<E> dummyTail;

  public DoublyLinkedList() {
    dummyHead = new DoublyLinkedListNode<>(null);
    dummyTail = new DoublyLinkedListNode<>(null);
    dummyHead.next = dummyTail;
    dummyTail.prev = dummyHead;
  }

  public DoublyLinkedListNode<E> addElementAtLast(E element) {
    if(element == null)
      throw new InvalidElementException();
    DoublyLinkedListNode<E> node = new DoublyLinkedListNode<>(element);
    addNodeAtLast(node);
    return node;
  }

  public void addNodeAtLast(DoublyLinkedListNode<E> node) {
    DoublyLinkedListNode<E> tailPrev = dummyTail.prev;
    node.next = dummyTail;
    node.prev = tailPrev;
    tailPrev.next = node;
    dummyTail.prev = node;
  }

  public void detachNode(DoublyLinkedListNode<E> node) {
    if(node != null) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }
  }

  public boolean isItemPresent() {
    return dummyHead.next != dummyTail;
  }

  public DoublyLinkedListNode<E> getFirstNode() throws NoSuchElementException {
    if(!isItemPresent())
      return null;
    return dummyHead.next;
  }

  public DoublyLinkedListNode<E> getLastNode() throws NoSuchElementException {
    if(!isItemPresent())
      return null;
    return dummyTail.prev;
  }

}
