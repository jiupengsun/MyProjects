package com.samy.geeksforgeeks.algorithm;

/**
 * http://www.geeksforgeeks.org/clone-binary-tree-random-pointers/
 */
public class CloneaBinaryTreewithRandomPointers {

  public RandomTreeNode clone(RandomTreeNode root) {
    if(root == null)
      return null;
    RandomTreeNode copy = helper(root);
    modify(copy, root);
    return copy;
  }

  private void modify(RandomTreeNode copy, RandomTreeNode root) {
    if(copy == null || root == null)
      return;
    RandomTreeNode tmp = copy.random;
    copy.random = copy.random.random;
    root.random = tmp;
    modify(copy.left, root.left);
    modify(copy.right, root.right);
  }

  private RandomTreeNode helper(RandomTreeNode root) {
    if(root == null)
      return null;
    RandomTreeNode copyNode = new RandomTreeNode(root.key);
    copyNode.random = root.random;
    root.random = copyNode;
    copyNode.left = clone(root.left);
    copyNode.right = clone(root.right);
    return root;
  }

}

class RandomTreeNode {
  int key;
  RandomTreeNode left, right, random;

  RandomTreeNode (int v) {
    key = v;
  }
}
