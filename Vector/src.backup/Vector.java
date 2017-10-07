/*
 * @(#)Vector.java	1.96 04/02/19
 *
 * Copyright 2004 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;

public class Vector<E> extends java.util.AbstractList<E> implements List<E>,
    RandomAccess, Cloneable, java.io.Serializable {

    protected Object[] elementData;
    protected int elementCount;

    protected int capacityIncrement;

    /** use serialVersionUID from JDK 1.0.2 for interoperability */
    private static final long serialVersionUID = -2767605614048989439L;


    public Vector(int initialCapacity, int capacityIncrement) {
        super();
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "
                                               + initialCapacity);
        this.elementData = new Object[initialCapacity];
        this.capacityIncrement = capacityIncrement;
    }

    public Vector(int initialCapacity) {
        this(initialCapacity, 0);
    }

    public Vector() {
        this(10);
    }

    public Vector(Collection<? extends E> c) {
        elementCount = c.size();
        // 10% for growth
        elementData = new Object[(int) Math.min((elementCount * 110L) / 100,
                                                Integer.MAX_VALUE)];
        c.toArray(elementData);
    }

    //four overload function
    
    public void ensureCapacity(int minCapacity) {
        modCount++;
        ensureCapacityHelper(minCapacity);
    }

    private void ensureCapacityHelper(int minCapacity) {
        int oldCapacity = elementData.length;
        if (minCapacity > oldCapacity) {
            Object[] oldData = elementData;
            int newCapacity = (capacityIncrement > 0) ? (oldCapacity + capacityIncrement)
                              : (oldCapacity * 2);
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            elementData = new Object[newCapacity];
            for (int i = 0; i < elementCount; i++) {
                elementData[i] = oldData[i];
            }
            // System.arraycopy(oldData, 0, elementData, 0, elementCount);
        }
    }

    public synchronized int size() {
        return elementCount;
    }


    public boolean contains(Object elem) {
        return indexOf(elem, 0) >= 0;
    }

    public int indexOf(Object elem) {
        return indexOf(elem, 0);
    }

    public int indexOf(Object elem, int index) {
        if (elem == null) {
            for (int i = index; i < elementCount; i++)
                if (elementData[i] == null)
                    return i;
        } else {
            for (int i = index; i < elementCount; i++)
                if (elem == elementData[i])
                    return i;
        }
        return -1;
    }


    public synchronized void setElementAt(E obj, int index) {
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= "
                    + elementCount);
        }
        elementData[index] = obj;
    }

    public void removeElementAt(int index) {
        modCount++;
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(" >= ");
            // throw new ArrayIndexOutOfBoundsException(index + " >= " +
            // elementCount);
        } else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("<0");
        }
        int j = elementCount - index - 1;
        if (j > 0) {
            for (int i = 0; i < j; i++) {
                elementData[index + i] = elementData[index + i + 1];
            }
            // System.arraycopy(elementData, index + 1, elementData, index, j);
        }
        elementCount--;
        elementData[elementCount] = null; /* to let gc do its work */
    }


    public synchronized void addElement(E obj) {
        modCount++;
        ensureCapacityHelper(elementCount + 1);
        elementData[elementCount++] = obj;
    }

    public synchronized boolean removeElement(Object obj) {
        modCount++;
        int i = indexOf(obj);
        if (i >= 0) {
            removeElementAt(i);
            return true;
        }
        return false;
    }
    
    public synchronized E get(int index) {
        if (index >= elementCount)
            throw new ArrayIndexOutOfBoundsException(index);

        return (E) elementData[index];
    }

}
