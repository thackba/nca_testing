package de.nevercodealone.testing.impl

import de.nevercodealone.testing.Entry

object Fun3 {
  def exec(a: Entry, b: Entry): String = {
    a.a + b.a match {
      case x: Int if x > 0 => s"${b.b}-${b.a}-${a.b}-${a.a}"
      case x: Int if x < 0 => s"${a.b}-${a.a}-${b.b}-${b.a}"
      case _ => throw new IllegalArgumentException("Oh! Found some strange value")
    }
  }
}
