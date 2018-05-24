object Main {

    def concatThree(pre: String)(txt: String)(post: String): String ={
      return pre+txt+post
    }

    def prefix: (String,String) => String ={
        return concatThree(_)(_)("")      
    }

    def postfix: (String,String) => String = (post, txt) => {
        concatThree("")(txt)(post)
    }

    def preAndPostfix: String => String ={
        return concatThree(">>>")(_)("<<<")
    }
    def main(args:Array[String]) {
      val pre = "pre"
      val txt = "txt"
      val post = "post"
      
      val concat = concatThree(pre)(txt)(_)      
      val concat2 = concat(post)
      val concatPre = prefix(pre, txt)
      val concatPost = postfix(post, txt)
	  val concatPrePost = preAndPostfix(txt)
		
      
      println(concat)
      println(concat2)
      println(concatPre)
      println(concatPost)
	  println(concatPrePost)
      
    }
} 