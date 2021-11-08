package lapr.project.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TREE<E extends Comparable<E>> extends BST<E>{

    /*
     * @param element A valid element within the tree
     * @return true if the element exists in tree false otherwise
     */
    public boolean contains(E element) {
        if(element== null){
            return false;
        }
        return find(root(),element) != null;
    }


    public boolean isLeaf(E element){
        if(element == null){
            return false;
        }
        Node <E> node = find(root(),element);
        return (node != null && (node.getLeft() == null && node.getRight() == null));
    }

    /*
     * build a list with all elements of the tree. The elements in the
     * left subtree in ascending order and the elements in the right subtree
     * in descending order.
     *
     * @return    returns a list with the elements of the left subtree
     * in ascending order and the elements in the right subtree is descending order.
     */
    public Iterable<E> ascdes(){
        ArrayList<E> list = new ArrayList<>();
        if(root()!=null) {
            LeftSideAsc(root().getLeft(), list);
            list.add(root().getElement());
            RightSideDesc(root().getRight(), list);
        }
        return list;
    }

    private void RightSideDesc(Node<E> node,ArrayList<E> list){
        if(node == null){
            return;
        }
        RightSideDesc(node.getRight(),list);
        list.add(node.getElement());
        RightSideDesc(node.getLeft(),list);
    }

    private void LeftSideAsc(Node<E> node,ArrayList<E> list){
        if(node == null){
            return;
        }
        LeftSideAsc(node.getLeft(),list);
        list.add(node.getElement());
        LeftSideAsc(node.getRight(),list);
    }

    private Node<E> copyRec(Node<E> node){
        if(node == null){
            return null;
        }
        if(node.getLeft() == null && node.getRight() == null){
            return null;
        }
        return new Node(node.getElement(),copyRec(node.getLeft()),copyRec(node.getRight()));
    }

    /**
     * @return the number of nodes by level.
     */
    public int[] numNodesByLevel(){

        int[] result = new int[height() + 1];

        numNodesByLevel(root,result,0);

        return result;

    }

    private void numNodesByLevel(Node<E> node, int[] result, int level){

        Map<Integer,List<E>> map = new HashMap<>();

        map=nodesByLevel();
        int num;

        for(Integer i: map.keySet()){
            level=i;

            result[level] = map.get(i).size();


        }

    }


}
