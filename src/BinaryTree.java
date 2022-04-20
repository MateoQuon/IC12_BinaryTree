public class BinaryTree<E extends Comparable<E>> {
    private Node<E> mRoot;

    public BinaryTree() {
        mRoot = null;
    }

    public void clear() {
        mRoot = null;
        // Request garbage collection (when you delete a ton of stuff)
        System.gc();
    }

    public boolean add(E element){
        mRoot = addRecursive(mRoot, element);
        return true;
    }

    private Node<E> addRecursive(Node<E> current, E element){
        if (current == null){
            return new Node(element);
        }

        else if (element.compareTo(current.mData) < 0)
            return addRecursive(current.mLeft, element);

        else if (element.compareTo(current.mData) > 0)
            return addRecursive(current.mRight, element);

        else
            return current;
    }

    @Override
    public String toString() {
        Node<E> current = mRoot;
        String output = "[";

        if (current.mLeft != null) {
            current = current.mLeft;
        } else
            output += current;

        return output;
    }

    private class Node<E extends Comparable<E>> {
        private E mData;
        private Node<E> mLeft;
        private Node<E> mRight;

        public Node(E data){
            this(data, null, null)
        }
        public Node(E data, Node<E> left, Node<E> right){
            mData = data;
            mLeft = left;
            mRight = right;
        }

        public boolean isLeaf(){
            return (mLeft == null && mRight == null);
        }
    }

}
