import com.example.saper.game.Game
import com.example.saper.field.Generator

class FieldGenerator : Generator() {
    private val COLS_EASY = 9
    private val COLS_MIDL = 16

    private val ROWS_EASY = 9
    private val ROWS_MIDL = 16

    private val BOMBS_EASY = 12
    private val BOMBS_MIDL = 45

    fun generateField(rows: Int, cols: Int, bombCount: Int): Array<Array<Game.Cell>> {
        var field = generateField(rows, cols)
        field = generateBombs(bombCount, field)
        field = generateNumbers(field)
        return field
    }

    fun generateEasyField(): Array<Array<Game.Cell>> {
        return generateField(ROWS_EASY, COLS_EASY, BOMBS_EASY)
    }

    fun generateMidlField(): Array<Array<Game.Cell>> {
        return generateField(ROWS_MIDL, COLS_MIDL, BOMBS_MIDL)
    }
}
