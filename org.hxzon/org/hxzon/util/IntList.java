package org.hxzon.util;

import java.util.ArrayList;
import java.util.List;

public class IntList {

    private List<int[]> arrays = new ArrayList<int[]>();
    private int increaseSize;
    private int currentSize;
    private int limitSize = -1;

    public IntList(int increaseSize) {
        int[] array = new int[increaseSize];
        arrays.add(array);
        this.increaseSize = increaseSize;
    }

    private void ensureArraysSize(int index) {
        if (index < currentSize) {
            return;
        }
        try {
            synchronized (arrays) {
                int add = arraysSize(index) - arrays.size();
                for (int i = 0; i < add; i++) {
                    arrays.add(new int[increaseSize]);
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private int arraysSize(int index) {
        return (index / increaseSize) + 1;
    }

    private int arrayIndex(int index) {
        return (index / increaseSize);
    }

    private int indexIndex(int index) {
        return (index % increaseSize);
    }

    public void set(int index, int value) {
        arrays.get(arrayIndex(index))[indexIndex(index)] = value;
        currentSize = Math.max(currentSize, index + 1);
    }

    public void setSafe(int index, int value) {
        if (limitSize != -1 && index > limitSize - 1) {
            return;
        }
        ensureArraysSize(index);
        set(index, value);
    }

    public int get(int index) {
        return arrays.get(arrayIndex(index))[indexIndex(index)];
    }

    public int getSafe(int index) {
        if (limitSize != -1 && index > limitSize - 1) {
            return 0;
        }
        ensureArraysSize(index);
        try {
            return get(index);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void increaseSafe(int index) {
        setSafe(index, getSafe(index) + 1);
    }

    public void decreaseSafe(int index) {
        setSafe(index, getSafe(index) - 1);
    }

    public void addSafe(int index, int add) {
        setSafe(index, getSafe(index) + add);
    }

    public void subSafe(int index, int sub) {
        setSafe(index, getSafe(index) - sub);
    }

    public int[] getArray() {
        int[] result = new int[currentSize];
        if (currentSize == 0) {
            return result;
        }
        DebugTimespend.start("get array");
        int i = 0;
        for (int[] array : arrays) {
            for (int v : array) {
                result[i] = v;
                i++;
                if (i >= currentSize) {
                    DebugTimespend.end("get array");
                    return result;
                }
            }
        }
        return result;
    }

    public int size() {
        return currentSize;
    }

    public void setLimitSize(int limitSize) {
        this.limitSize = limitSize;
        if (currentSize > limitSize) {
            currentSize = limitSize;
        }
    }

    private static void test() {
        IntList a = new IntList(3);
        a.setSafe(1, 1);
        printArray(a.getArray());
        a.setSafe(2, 2);
        printArray(a.getArray());
        a.setSafe(3, 3);
        printArray(a.getArray());
        a.setSafe(5, 5);
        a.setSafe(10, 10);
        printArray(a.getArray());
        a.setLimitSize(6);
        printArray(a.getArray());
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        test();
    }
}
