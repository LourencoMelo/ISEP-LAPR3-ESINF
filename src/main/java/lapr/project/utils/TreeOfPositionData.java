package lapr.project.utils;

import lapr.project.model.PositionData;

public class TreeOfPositionData extends AVL<PositionData> {

    /**
     * Returns total of movements of a ship
     * @return total of movements
     */
    public Integer getTotalMovements() {
        return getTotalMovements(root);
    }

    /**
     * Returns total of movements of a ship
     * @return total of movements
     */
    private Integer getTotalMovements(Node<PositionData> node) { // numero total de movimentos vai ser igual ao numero de nos que esta arvore vai ter
        if (root == null) return null;

        if (node == null) return 0;

        return 1 + getTotalMovements(node.getLeft()) + getTotalMovements(node.getRight());
    }

}
