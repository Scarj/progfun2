object test {

  val ping = "ping"
  val pong = "pong"

  val f: String => String = {
    case "ping" => "pong"
    case x => x
  }

  val f1: PartialFunction [String, String] = {
    case "ping" => "pong"
  }

  if(f1.isDefinedAt(ping)) {
    f1(ping)
  }

  val g: PartialFunction[List[Int],String] = {
    case Nil => "one"
    case _ :: rest =>
      rest match {
        case Nil => "two"
      }
  }

  g.isDefinedAt(List(1,2,3))

}