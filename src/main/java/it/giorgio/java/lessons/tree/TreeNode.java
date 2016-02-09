/**
 * ---------------------------------------------------------------------------- Written by Giorgio
 * Desideri.
 * 
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation; either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program; if
 * not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301 USA
 * 
 **/
package it.giorgio.java.lessons.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Giorgio Desideri <giorgio.desideri@gmail.com>
 *
 */
public class TreeNode implements Serializable {

  private static final long serialVersionUID = 1L;

  private final List<TreeNode> children = new ArrayList<>(0);

  private Object data = null;

  /**
   * 
   */
  public TreeNode() {}

  public TreeNode(Object data) {
    this.data = data;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((data == null) ? 0 : data.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    TreeNode other = (TreeNode) obj;
    if (data == null) {
      if (other.data != null) {
        return false;
      }
    }
    else if (!data.equals(other.data)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("TreeNode [");

    if (children != null) {

      builder.append("children=[");
      for (TreeNode child : getChildren()) {
        builder.append(child.toString());
      }

      builder.append("],");
    }

    if (data != null)
      builder.append("data=").append(data);

    builder.append("]");
    return builder.toString();
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public List<TreeNode> getChildren() {
    return children;
  }

  public void addChild(TreeNode node) {
    if (node != null) {
      getChildren().add(node);
    }
  }

}
