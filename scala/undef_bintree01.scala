//define functions every tree has
abstract class AbstractBinTree{
  // check if tree is empty
  def isEmpty: Boolean
  // get data
  def getData: Int
  //get left child
  def getLeft:AbstractBinTree
  //get right child
  def getRight:AbstractBinTree
  // getString
  def getString(indend: Int):String
  // use getString method for output
  override def toString = getString(1)
}

//represent empty Tree
case object EmptyTree extends AbstractBinTree{
  //an empty tree doesn't contain anything
  def isEmpty: Boolean = true
  def getData: Int = throw new RuntimeException("Cannot get data from empty tree")
  def getLeft:AbstractBinTree= throw new RuntimeException("Cannot get left tree from empty tree")
  def getRight:AbstractBinTree= throw new RuntimeException("Cannot get right tree from empty tree")
  def getString(indend: Int):String = ""
}

//an actual binary tree
//to enforce functional programming, all members are final
case class BinTree(data: Int, left: AbstractBinTree, right: AbstractBinTree) extends AbstractBinTree {
  def isEmpty: Boolean = false
  def getData: Int = data
  def getLeft: AbstractBinTree = left
  def getRight: AbstractBinTree = right
  def getString(indend: Int): String = {
    var dataPart = "|-" + data
    if (!(left isEmpty)) {
      dataPart += "\n" + "   " * indend + left.getString(indend + 1)
    }
    if (!(right isEmpty)) {
      dataPart += "\n" + "   " * indend + right.getString(indend + 1)
    }
    dataPart
  }
}

object Main{ 
  def countLeafs(tree:AbstractBinTree):Int = {
	if (tree.isEmpty) 0
	else {
		1 + countLeafs(tree.getLeft) 
		1 + countLeafs(tree.getRight)
	}
	
  }

  def getMaxDepth(tree:AbstractBinTree):Int = {
	if(tree.isEmpty) 0
	else _getMaxDepth(tree, 0)
  }
  
  def _getMaxDepth(tree: AbstractBinTree, depth: Int): Int = {
	if(tree.isEmpty) depth
	else Math.max(_getMaxDepth(tree.getLeft, depth+1), _getMaxDepth(tree.getRight, depth+1))
  }

  def main(args: Array[String]){
    var tree = BinTree(10,BinTree(20,BinTree(30,EmptyTree,BinTree(40,EmptyTree,EmptyTree)),BinTree(50,EmptyTree,EmptyTree)),BinTree(60,EmptyTree,EmptyTree));

    println(tree)
    println
    println(tree.getLeft)
    println
    println(tree.getLeft.getRight)
    println
    println("should be empty:"+tree.getLeft.getRight.getLeft)
	
	println(countLeafs(tree))
	println(getMaxDepth(tree))
  }
}