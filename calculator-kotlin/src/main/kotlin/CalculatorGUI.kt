import javax.swing.*
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class CalculatorGUI : JFrame(), ActionListener {

    // Components of the calculator
    private val textField: JTextField = JTextField()
    private val buttons = arrayOfNulls<JButton>(16)
    private val operators = arrayOf("+", "-", "*", "/", "=")
    private var firstNum = 0.0
    private var secondNum = 0.0
    private var operator = ""

    init {
        // Frame settings
        title = "Kotlin Calculator"
        setSize(400, 400)
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE // Corrected line
        layout = BorderLayout()

        // Create text field
        textField.isEditable = false
        textField.horizontalAlignment = JTextField.RIGHT
        add(textField, BorderLayout.NORTH)

        // Create panel for buttons
        val panel = JPanel()
        panel.layout = GridLayout(4, 4)
        add(panel, BorderLayout.CENTER)

        // Create buttons (0-9 and operations)
        val buttonLabels = arrayOf(
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        )

        for (i in buttons.indices) {
            buttons[i] = JButton(buttonLabels[i])
            panel.add(buttons[i])
            buttons[i]?.addActionListener(this)
        }

        // Make the frame visible
        isVisible = true
    }

    override fun actionPerformed(e: ActionEvent) {
        val command = (e.source as JButton).text

        when {
            command[0] in '0'..'9' || command == "." -> textField.text += command
            command == "=" -> {
                secondNum = textField.text.toDouble()
                calculateResult()
            }
            else -> {
                if (operator.isEmpty()) {
                    firstNum = textField.text.toDouble()
                    operator = command
                    textField.text = ""
                }
            }
        }
    }

    private fun calculateResult() {
        val result = when (operator) {
            "+" -> firstNum + secondNum
            "-" -> firstNum - secondNum
            "*" -> firstNum * secondNum
            "/" -> if (secondNum != 0.0) firstNum / secondNum else "Error: Div by 0"
            else -> "Error"
        }
        textField.text = result.toString()
        operator = ""
        firstNum = 0.0
        secondNum = 0.0
    }
}

fun main() {
    SwingUtilities.invokeLater { CalculatorGUI() }
}
