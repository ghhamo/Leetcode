class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        int listsLen = lists.length;
        if (listsLen == 0) return null;
        ListNode root = new ListNode();
        ListNode currentEnd;
        FixedMinHeap<Intermediate> fixedMinHeap = new FixedMinHeap<>(listsLen);
        int countOfNulls = 0;
        for (int i = 0; i < listsLen; i++) {
            if (lists[i] == null) {
                countOfNulls++;
                continue;
            }
            Intermediate intermediate = new Intermediate(lists[i].val, i);
            fixedMinHeap.insert(intermediate);
        }
        if (fixedMinHeap.size == 0) {
            return null;
        }
        Intermediate min = fixedMinHeap.pull();
        root.val = min.nodeVal;
        currentEnd = root;
        lists[min.index] = lists[min.index].next;
        while (true) {
            if (lists[min.index] != null) {
                Intermediate intermediate = new Intermediate(lists[min.index].val, min.index);
                fixedMinHeap.insert(intermediate);
            } else {
                countOfNulls++;
                if (countOfNulls == listsLen) {
                    break;
                }
                min = fixedMinHeap.pull();
                Intermediate intermediate = new Intermediate(lists[min.index].val, min.index);
                fixedMinHeap.insert(intermediate);
            }
            min = fixedMinHeap.pull();
            currentEnd.next = new ListNode(min.nodeVal);
            currentEnd = currentEnd.next;
            lists[min.index] = lists[min.index].next;
        }
        return root;
    }

    interface Comparable<T> {
        Result compareTo(T o);
    }

    enum Result {
        LT, GT, EQUAL
    }

    static class Intermediate implements Comparable<Intermediate> {
        private final int nodeVal;
        private int index;

        public Intermediate(int nodeVal, int index) {
            this.nodeVal = nodeVal;
            this.index = index;
        }

        @Override
        public Result compareTo(Intermediate o) {
            if (o == null) {
                return Result.LT;
            }
            if (this.nodeVal < o.nodeVal) {
                return Result.LT;
            } else if (o.nodeVal < this.nodeVal) {
                return Result.GT;
            } else {
                return Result.EQUAL;
            }
        }
    }

    static class FixedMinHeap<T extends Comparable<T>> {

        private final Object[] data;
        private int size;

        public FixedMinHeap(int size) {
            this.size = 0;
            this.data = new Object[size];
        }

        private void insert(T node) {
            data[size] = node;
            swapUp();
            size++;
        }

        private void swapUp() {
            int currentIndex = size;
            int parentPosition = parent(currentIndex);
            while (getData(currentIndex).compareTo(getData(parentPosition)) == Result.LT) {
                T parent = getData(parentPosition);
                T child = getData(currentIndex);
                data[currentIndex] = parent;
                data[parentPosition] = child;
                currentIndex = parentPosition;
                parentPosition = parent(currentIndex);
            }
        }

        private void swapDown() {
            int currentIndex = 0;
            data[0] = data[size - 1];
            data[size - 1] = null;
            if (data[0] == null) return;
            while (true) {
                int leftChildPosition = leftChildPosition(currentIndex);
                int rightChildPosition = rightChildPosition(currentIndex);
                T current = getData(currentIndex);
                if (leftChildPosition >= size || rightChildPosition >= size) break;
                T leftChild = getData(leftChildPosition);
                T rightChild = getData(rightChildPosition);

                if (leftChild == null && rightChild == null) {
                    break;
                } else {
                    Result smaller = Result.GT;
                    if (leftChild != null) {
                        smaller = leftChild.compareTo(rightChild);
                    }
                    int smallerIndex = switch (smaller) {
                        case EQUAL, LT -> leftChildPosition;
                        case GT -> rightChildPosition;
                    };
                    T tmp = getData(smallerIndex);
                    if (tmp.compareTo(current) != Result.LT) {
                        break;
                    }
                    this.data[smallerIndex] = current;
                    this.data[currentIndex] = tmp;
                    currentIndex = smallerIndex;
                }
            }
        }

        private T getData(int index) {
            return (T) data[index];
        }

        private T pull() {
            T res = getData(0);
            swapDown();
            size--;
            return res;
        }

        private int leftChildPosition(int current) {
            return (current * 2) + 1;
        }

        private int rightChildPosition(int current) {
            return (current * 2) + 2;
        }

        private int parent(int current) {
            return (current - 1) / 2;
        }
    }
}