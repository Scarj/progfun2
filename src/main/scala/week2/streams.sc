import week2.Common._

object streams {


  (1000 to 10000).filter(isPrime)(0)
  (1000 to 10000).toStream

  listRange(1,10)
  streamRange(1,10)

  (1000 to 10000).toStream.filter(isPrime)(1)

}