package de.nevercodealone.testing.impl

import de.nevercodealone.testing.{DB, Person}

import scala.collection.immutable.Seq

class SimpleDB extends DB {

  var storedPersons: Seq[Person] = Seq.empty

  override def store(entries: Seq[Person]): Seq[String] = {
    val newPersonIds = entries.map(_.id)
    if (newPersonIds.distinct.size == newPersonIds.size) {
      val storedPersonIds: Seq[String] = storedPersons.map(_.id)
      val newPersons: Seq[Person] = entries.filter(p => !storedPersonIds.contains(p.id))
      storedPersons = storedPersons ++ newPersons
      newPersons.map(_.id)
    } else Seq.empty
  }

  override def get(id: String): Option[Person] =
    storedPersons.find(p => p.id == id)
}
