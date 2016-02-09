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
package it.giorgio.java.lessons.test.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import it.giorgio.java.lessons.tree.TreeNode;
import it.giorgio.java.lessons.tree.TreeNodeUtil;

/**
 * @author Giorgio Desideri <giorgio.desideri@gmail.com>
 *
 */
public class TreeNodeTest {

  private TreeNode root = null;

  @Before
  public void setUp() {

    // create root
    root = new TreeNode("root");

    // Adiacency List / Matrix
    // root -> b, c
    // b -> d
    // c -> e, f, g

    TreeNode b = new TreeNode("b");
    TreeNode c = new TreeNode("c");
    TreeNode d = new TreeNode("d");
    TreeNode e = new TreeNode("e");
    TreeNode f = new TreeNode("f");
    TreeNode g = new TreeNode("g");

    c.addChild(e);
    c.addChild(f);
    c.addChild(g);

    b.addChild(d);

    // add to root
    root.addChild(b);
    root.addChild(c);

  }

  @Test
  public void testVisitByDeep() {

    System.out.println("\n\nPrint by Deep - 1. START");
    // success case
    TreeNodeUtil.printByDeep(root);

    System.out.println("\nPrint by Deep - 1. END");

    try {
      System.out.println("\n\nPrint by Deep - 2. START");

      // error case
      TreeNodeUtil.printByDeep(null);

      System.out.println("\nPrint by Deep - 2. END");
    }
    catch (Exception e) {
      Assert.fail(e.getMessage());
    }

  }

  @Test
  public void testVisitByLevel() {
    System.out.println("\n\nPrint by Level - 1. START");

    TreeNodeUtil.printByLevel(root);

    System.out.println("\nPrint by Level - 1. END");

    try {
      System.out.println("\nPrint by Level - 2. START");

      // error case
      TreeNodeUtil.printByLevel(null);

      System.out.println("\nPrint by Level - 2. END");
    }
    catch (Exception e) {
      Assert.fail(e.getMessage());
    }
  }
}
