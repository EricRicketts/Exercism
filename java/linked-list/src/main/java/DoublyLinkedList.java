class Node<T> {
    private final T nodeValue;
    private Node<T> nextNode;
    private Node<T> previousNode;

    Node(T value) { this.nodeValue = value; }

    T getNodeValue() { return this.nodeValue; }

    Node<T> getNextNode() { return this.nextNode; }
    void setNextNode(Node<T> nextNode) { this.nextNode = nextNode; }

    Node<T> getPreviousNode() { return this.previousNode; }
    void setPreviousNode(Node<T> previousNode) { this.previousNode = previousNode; }
}

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    private Node<T> getHead() { return head; }
    private Node<T> getTail() { return tail; }
    void setHead(Node<T> node) { this.head = node; }
    void setTail(Node<T> node) { this.tail = node; }
    private boolean listHasNoHead() { return this.head == null; }
    private boolean listHasNoTail() { return this.head != null && this.tail == null; }
    private boolean listHasOnlyHeadAndTail() {
        return this.head.getNextNode() == this.tail && this.tail.getPreviousNode() == this.head;
    }


    public T pop() {
        T nodeValue;
        if (this.listHasNoTail()) {
            nodeValue = this.getHead().getNodeValue();
            this.setHead(null);
        } else if (this.listHasOnlyHeadAndTail()) {
            nodeValue = this.getTail().getNodeValue();
            this.getHead().setNextNode(null);
            this.setTail(null);
        } else {
            nodeValue = this.getTail().getNodeValue();
            this.setTail(this.getTail().getPreviousNode());
            this.getTail().setNextNode(null);
        }
        return nodeValue;
    }

    public void push(T t) {
        Node<T> newNode = new Node<>(t);
        if (this.listHasNoHead()) {
            this.setHead(newNode);
        } else if (this.listHasNoTail()) {
            this.getHead().setNextNode(newNode);
            newNode.setPreviousNode(this.getHead());
            this.setTail(newNode);
        } else {
            this.getTail().setNextNode(newNode);
            newNode.setPreviousNode(this.getTail());
            this.setTail(newNode);
        }
    }

    public T shift() {
        T nodeValue;
        if (this.listHasNoTail()) {
            nodeValue = this.getHead().getNodeValue();
            this.setHead(null);
        } else if (this.listHasOnlyHeadAndTail()) {
            nodeValue = this.getHead().getNodeValue();
            this.setHead(this.getTail());
            this.getHead().setNextNode(null);
            this.setTail(null);
        } else {
            nodeValue = this.getHead().getNodeValue();
            this.setHead(this.getHead().getNextNode());
            this.getHead().setPreviousNode(null);
        }
        return nodeValue;
    }

    public void unshift(T t) {
        Node<T> newNode = new Node<>(t);
        if (this.listHasNoHead()) {
            this.setHead(newNode);
        } else if (this.listHasNoTail()) {
            this.setTail(this.getHead());
            this.setHead(newNode);
            this.getTail().setPreviousNode(this.getHead());
            this.getHead().setNextNode(this.getTail());
        } else {
            this.getHead().setPreviousNode(newNode);
            newNode.setNextNode(this.getHead());
            this.setHead(newNode);
        }
    }
}