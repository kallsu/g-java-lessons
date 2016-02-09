/**
 * -------------------------------------------------------------------------------------------------
 * 
 * Copyright 2015 - Giorgio Desideri
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied.
 * 
 * See the License for the specific language governing permissions and limitations under the
 * License.
 * 
 */
package it.giorgio.java.lessons.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Giorgio Desideri <giorgio.desideri@gmail.com>
 *
 */
public class TreeNodeUtil {

  /**
   * Prints the Tree by deep.
   *
   * @param root the root node {@linkplain TreeNode}
   */
  public static void printByDeep(TreeNode root) {

    // check if is null
    if (root == null) {
      return;
    }

    // check data
    if (root.getData() != null) {
      // print
      System.out.print(root.getData().toString() + ", ");
    }

    // is a leaf ?
    if (root.getChildren().isEmpty()) {
      return;

    } // is a node
    else {

      // continue with recursion
      for (TreeNode child : root.getChildren()) {

        // recursive call
        printByDeep(child);
      }
    }
  }

  /**
   * Prints the by level.
   *
   * @param root the root node{@linkplain TreeNode}
   */
  public static void printByLevel(TreeNode root) {

    final Queue<TreeNode> queue = new LinkedList<>();

    // check the root
    if (root != null) {
      // add root
      queue.add(root);
    }

    // loop
    while (!queue.isEmpty()) {
      // pull from queue
      TreeNode next = queue.remove();

      // print
      System.out.print(next.getData().toString() + ", ");

      // check next
      if (!next.getChildren().isEmpty()) {

        // add to queue
        queue.addAll(next.getChildren());
      }
    }
  }

}
