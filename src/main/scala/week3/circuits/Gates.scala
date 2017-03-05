package week3.circuits

abstract class Gates extends AbstractSimulation {

  def InverterDelay: Int
  def AndGateDelay: Int
  def OrGateDelay: Int

  class Wire {
    private var sigVal: Boolean = false
    private var actions: List[Action] = List()

    def getSignal: Boolean = sigVal

    def setSignal(signal: Boolean): Unit = {
      if (signal != sigVal) {
        sigVal = signal
        actions.foreach(_ ())
      }
    }

    def addAction(a: Action): Unit = {
      actions = a :: actions
      a()
    }
  }

  def inverter(input: Wire, output: Wire): Unit = {
    def invertAction(): Unit = {
      val inputSig = input.getSignal
      afterDelay(InverterDelay) {
        output.setSignal(!inputSig)
      }
    }

    input.addAction(invertAction)
  }

  def andGate(input1: Wire, input2: Wire, output: Wire): Unit = {
    def andAction(): Unit = {
      val input1Sig = input1.getSignal
      val input2Sig = input2.getSignal
      afterDelay(AndGateDelay) {
        output.setSignal(input1Sig & input2Sig)
      }
    }

    input1.addAction(andAction)
    input2.addAction(andAction)
  }

  def orGate(input1: Wire, input2: Wire, output: Wire): Unit = {
    def andAction(): Unit = {
      val input1Sig = input1.getSignal
      val input2Sig = input2.getSignal
      afterDelay(OrGateDelay) {
        output.setSignal(input1Sig | input2Sig)
      }
    }

    input1.addAction(andAction)
    input2.addAction(andAction)
  }

  def orGateAlt(input1: Wire, input2: Wire, output: Wire): Unit = {
    val notIn1, notIn2, notOut = new Wire
    inverter(input1, notIn1)
    inverter(input2, notIn2)
    andGate(notIn1, notIn2, notOut)
    inverter(notOut, output)
  }

  def probe(name: String, wire: Wire): Unit = {
    def probeAction(): Unit = {
      println(s"$name $currentTime, value = ${wire.getSignal}")
    }

    wire.addAction(probeAction)
  }
}
