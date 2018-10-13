public class SingleList<T> {
    /**
     * 判断对象相等
     *
     * 方法参数为 Node 时，Node 均需要通过 get 方法获得
     *
     * equals被用来判断两个对象是否相等。
     * equals通常用来比较两个对象的内容是否相等，==用来比较两个对象的地址是否相等。
     * equals方法默认等同于“==”
     * Object类中的equals方法定义为判断两个对象的地址是否相等（可以理解成是否是同一个对象），地址相等则认为是对象相等。
     * 这也就意味着，我们新建的所有类如果没有复写equals方法，那么判断两个对象是否相等时就等同于“==”，也就是两个对象的地址是否相等。
     */
    private Node<T> head = null;

    public Node<T> get(T data) {
        Node<T> p = head;
        while(p != null && !p.data.equals(data)) {
            p = p.next;
        }
        return p;
    }

    public Node<T> get(int index) {
        Node<T> p = head;
        int pos = 0;
        while(p != null && pos != index) {
            p = p.next;
            ++pos;
        }
        return p;
    }

    public boolean addToHead(Node<T> newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        return true;
    }

    public boolean addToHead(T data) {
        Node<T> newNode = new Node<>(data, null);
        return addToHead(newNode);
    }

    public boolean addAfter(Node<T> p, Node<T> newNode) {
        if (p == null) {
            return false;
        }
        newNode.next = p.next;
        p.next = newNode;
        return true;
    }

    public boolean addAfter(Node<T> p, T data) {
        Node<T> newNode = new Node<>(data, null);
        return addAfter(p, newNode);
    }

    public boolean addBefore(Node<T> p, Node<T> newNode) {
        if (p == null) {
            return false;
        }
        if (p == head) {
            return addToHead(newNode);
        }

        Node<T> temp = head;
        while((temp != null) && temp.next != p) {
            temp = temp.next;
        }
        if (temp == null) {
            return false;
        }
        newNode.next = p;
        temp.next = newNode;
        return true;
    }

    public boolean addBefore(Node<T> p, T data) {
        Node<T> newNode = new Node<>(data, null);
        return addBefore(p, newNode);
    }

    public boolean addToTail(Node<T> newNode) {
        if (head == null) {
            head = newNode;
            return true;
        }
        Node<T> p = head;
        while(p.next != null) {
            p = p.next;
        }
        p.next = newNode;
        return true;
    }

    public boolean addToTail(T data) {
        Node<T> newNode = new Node<>(data, null);
        return addToTail(newNode);
    }

    public boolean deleteFirst(Node<Integer> p) {
        if (p == null || head == null) {
            return false;
        }
        if (p == head) {
            head = head.next;
        }

        Node<T> temp = head;
        while(temp != null && temp.next != p) {
            temp = temp.next;
        }
        if (temp == null) {
            return false;
        }
        temp.next = temp.next.next;
        return true;
    }

    public boolean deleteFirst(T data) {
        if (head == null) {
            return false;
        }
        Node<T> present = head;
        Node<T> after = null;
        while(present != null && !present.data.equals(data)){
            after = present;
            present = present.next;
        }
        if (present == null) {
            return false;
        }
        if (after == null) {
            head = head.next;
        } else {
            after.next = after.next.next;
        }
        return true;
    }

    public void deleteAll(T data) {
        if (head != null && head.data.equals(data)) {
            head = head.next;
        }
        Node<T> p = head;
        //需要判断很多位置是否为空
        while(p != null && p.next != null) {
            if (p.next.data.equals(data)) {
                if (p.next.next == null) {
                    p.next = null;
                } else {
                    p.next = p.next.next;
                }
                //若删掉 continue 则末尾的元素不能删除
                continue;
            }
            p = p.next;
        }
    }

    public void printList() {
        Node<T> p = head;
        while(p != null) {
            System.out.print(p.data.toString() + "\t");
            p = p.next;
        }
        System.out.println();
    }

    public static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        SingleList<Integer> list = new SingleList<>();
        list.addToHead(5);
        list.addToHead(new Node<>(1, null));

        list.addBefore(list.get(new Integer(5)),3);
        list.addBefore(list.get(new Integer(3)), new Node<>(2, null));

        list.addAfter(list.get(new Integer(3)), 4);
        list.addAfter(list.get(new Integer(5)), new Node<>(6, null));

        list.printList();

        list.deleteFirst(list.get(new Integer(6)));
        list.deleteFirst(5);
        list.printList();

        list.addToTail(3);
        list.addToTail(3);
        list.printList();

        list.deleteAll(3);
        list.printList();


    }
}
