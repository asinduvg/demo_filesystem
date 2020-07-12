package com.rtjvm.scala.oop.commands

import com.rtjvm.scala.oop.files.DirEntry
import com.rtjvm.scala.oop.filesystem.State

class Ls extends Command {

  override def apply(state: State): State = {
    val contents = state.wd.contents
    val niceOutput = createNiceOutPut(contents)
    state.setMessage(niceOutput)

  }

  def createNiceOutPut(contents: List[DirEntry]): String = {
    if (contents.isEmpty) ""
    else {
      val entry = contents.head
      entry.name + "[" + entry.getType + "]\n" + createNiceOutPut(contents.tail)
    }
  }
}
