// Copyright: 2010 - 2016 Rory Graves, Sam Halliday
// License: http://www.apache.org/licenses/LICENSE-2.0

// intentionally not in org.ensime.noddy for testing
package org.ensime.pctesting

import org.scalatest._
import org.scalatest.Matchers._

import org.ensime.pcplod._
import org.ensime.testing.Logging

class NoddyPcSpec extends FlatSpec with Logging {

  "@noddy" should "handle definitions of @noddy" in withMrPlod("classes.scala") { mr: MrPlod =>
    mr.messages shouldBe Nil

    mr.symbolAtPoint(sym"me") shouldBe Some("org.ensime.pctesting.Me")
    mr.typeAtPoint(sym"me") shouldBe Some("org.ensime.pctesting.Me")

    mr.symbolAtPoint(sym"myself") shouldBe Some("org.ensime.pctesting.Myself")
    mr.typeAtPoint(sym"myself") shouldBe Some("org.ensime.pctesting.Myself")

    mr.symbolAtPoint(sym"foo") shouldBe Some("org.ensime.pctesting.Myself.foo")
    mr.typeAtPoint(sym"foo") shouldBe Some("String")
  }

}
