package exercises

import org.junit.jupiter.api.Test
import exercises.Streams._
import org.junit.jupiter.api.Assertions.assertEquals
import u03.Lists.List._

class StreamsTest {

  @Test def testDrop() = {
    val s = Stream.take(Stream.iterate(0)(_+1))(10) // {0,1,2,...,9}
    assertEquals( Cons(6,Cons(7, Cons(8, Cons(9, Nil())))).toString(),
                  Stream.toList(Stream.drop(s)(6)).toString())
  }


}
