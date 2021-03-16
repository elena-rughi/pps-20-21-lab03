package exercises

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import exercises.Streams._
import exercises.Streams.Stream._
import u03.Lists.List._

class StreamsTest {

  @Test def testDrop() = {
    val s = Stream.take(Stream.iterate(0)(_+1))(10) // {0,1,2,...,9}
    assertEquals( Cons(6,Cons(7, Cons(8, Cons(9, Nil())))).toString(),
                  Stream.toList(Stream.drop(s)(6)).toString())
  }

  @Test def testConstant() = {
    assertEquals(Cons("x", Cons("x", Cons("x", Cons("x", Cons("x", Nil()))))).toString(),
                  Stream.toList(Stream.take(constant("x"))(5)).toString())
  }

}
