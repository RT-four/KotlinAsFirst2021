@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson7.task1

import lesson3.task1.digitNumber
import java.io.File
import java.io.InputStream
import kotlin.math.pow


// Урок 7: работа с файлами
// Урок интегральный, поэтому его задачи имеют сильно увеличенную стоимость
// Максимальное количество баллов = 55
// Рекомендуемое количество баллов = 20
// Вместе с предыдущими уроками (пять лучших, 3-7) = 55/103

/**
 * Пример
 *
 * Во входном файле с именем inputName содержится некоторый текст.
 * Вывести его в выходной файл с именем outputName, выровняв по левому краю,
 * чтобы длина каждой строки не превосходила lineLength.
 * Слова в слишком длинных строках следует переносить на следующую строку.
 * Слишком короткие строки следует дополнять словами из следующей строки.
 * Пустые строки во входном файле обозначают конец абзаца,
 * их следует сохранить и в выходном файле
 */

fun main() {
    robot("input.txt")
}

fun alignFile(inputName: String, lineLength: Int, outputName: String) {
    val writer = File(outputName).bufferedWriter()
    var currentLineLength = 0
    fun append(word: String) {
        if (currentLineLength > 0) {
            if (word.length + currentLineLength >= lineLength) {
                writer.newLine()
                currentLineLength = 0
            } else {
                writer.write(" ")
                currentLineLength++
            }
        }
        writer.write(word)
        currentLineLength += word.length
    }
    for (line in File(inputName).readLines()) {
        if (line.isEmpty()) {
            writer.newLine()
            if (currentLineLength > 0) {
                writer.newLine()
                currentLineLength = 0
            }
            continue
        }
        for (word in line.split(Regex("\\s+"))) {
            append(word)
        }
    }
    writer.close()
}

/**
 * Простая (8 баллов)
 *
 * Во входном файле с именем inputName содержится некоторый текст.
 * Некоторые его строки помечены на удаление первым символом _ (подчёркивание).
 * Перенести в выходной файл с именем outputName все строки входного файла, убрав при этом помеченные на удаление.
 * Все остальные строки должны быть перенесены без изменений, включая пустые строки.
 * Подчёркивание в середине и/или в конце строк значения не имеет.
 */
fun deleteMarked(inputName: String, outputName: String) {
    TODO()
}

/**
 * Средняя (14 баллов)
 *
 * Во входном файле с именем inputName содержится некоторый текст.
 * На вход подаётся список строк substrings.
 * Вернуть ассоциативный массив с числом вхождений каждой из строк в текст.
 * Регистр букв игнорировать, то есть буквы е и Е считать одинаковыми.
 *
 */
fun countSubstrings(inputName: String, substrings: List<String>): Map<String, Int> = TODO()


/**
 * Средняя (12 баллов)
 *
 * В русском языке, как правило, после букв Ж, Ч, Ш, Щ пишется И, А, У, а не Ы, Я, Ю.
 * Во входном файле с именем inputName содержится некоторый текст на русском языке.
 * Проверить текст во входном файле на соблюдение данного правила и вывести в выходной
 * файл outputName текст с исправленными ошибками.
 *
 * Регистр заменённых букв следует сохранять.
 *
 * Исключения (жюри, брошюра, парашют) в рамках данного задания обрабатывать не нужно
 *
 */
fun sibilants(inputName: String, outputName: String) {
    TODO()
}

/**
 * Средняя (15 баллов)
 *
 * Во входном файле с именем inputName содержится некоторый текст (в том числе, и на русском языке).
 * Вывести его в выходной файл с именем outputName, выровняв по центру
 * относительно самой длинной строки.
 *
 * Выравнивание следует производить путём добавления пробелов в начало строки.
 *
 *
 * Следующие правила должны быть выполнены:
 * 1) Пробелы в начале и в конце всех строк не следует сохранять.
 * 2) В случае невозможности выравнивания строго по центру, строка должна быть сдвинута в ЛЕВУЮ сторону
 * 3) Пустые строки не являются особым случаем, их тоже следует выравнивать
 * 4) Число строк в выходном файле должно быть равно числу строк во входном (в т. ч. пустых)
 *
 */
fun centerFile(inputName: String, outputName: String) {
    TODO()
}

/**
 * Сложная (20 баллов)
 *
 * Во входном файле с именем inputName содержится некоторый текст (в том числе, и на русском языке).
 * Вывести его в выходной файл с именем outputName, выровняв по левому и правому краю относительно
 * самой длинной строки.
 * Выравнивание производить, вставляя дополнительные пробелы между словами: равномерно по всей строке
 *
 * Слова внутри строки отделяются друг от друга одним или более пробелом.
 *
 * Следующие правила должны быть выполнены:
 * 1) Каждая строка входного и выходного файла не должна начинаться или заканчиваться пробелом.
 * 2) Пустые строки или строки из пробелов трансформируются в пустые строки без пробелов.
 * 3) Строки из одного слова выводятся без пробелов.
 * 4) Число строк в выходном файле должно быть равно числу строк во входном (в т. ч. пустых).
 *
 * Равномерность определяется следующими формальными правилами:
 * 5) Число пробелов между каждыми двумя парами соседних слов не должно отличаться более, чем на 1.
 * 6) Число пробелов между более левой парой соседних слов должно быть больше или равно числу пробелов
 *    между более правой парой соседних слов.
 *
 * Следует учесть, что входной файл может содержать последовательности из нескольких пробелов  между слвоами. Такие
 * последовательности следует учитывать при выравнивании и при необходимости избавляться от лишних пробелов.
 * Из этого следуют следующие правила:
 * 7) В самой длинной строке каждая пара соседних слов должна быть отделена В ТОЧНОСТИ одним пробелом
 * 8) Если входной файл удовлетворяет требованиям 1-7, то он должен быть в точности идентичен выходному файлу
 */
fun alignFileByWidth(inputName: String, outputName: String) {
    val inputStream: InputStream = File(inputName).inputStream()
    val writer = File(outputName).bufferedWriter()
    var maxLength = 0

    var lineList = mutableListOf<String>()

//    inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it.trim()) } }
    lineList = File(inputName).readLines() as MutableList<String>
    lineList.forEach { if (it.trim().length > maxLength) maxLength = it.trim().length }
    for (string: String in lineList) {
        string.trim()
        if (string.isNotEmpty()) {
            val wordList = mutableListOf<String>()
            var buffer = ""
            var flag = false
            var length = 0
            var numberOfHoles = 0
            val holeList = mutableListOf<String>()
            for (lat: Char in string) {
                if (lat != ' ') {
                    flag = true
                    length++
                    buffer += lat
                } else {
                    if (flag) {
                        wordList.add(buffer)
                        buffer = ""
                        numberOfHoles++
                    }
                    flag = false
                }
            }
            if (length != 0) {
                if (!flag) {
                    numberOfHoles--
                } else {
                    wordList.add(buffer)
                }
                for (i in 1..numberOfHoles) {
                    holeList.add("")
                }
                var it = length
                if (holeList.isNotEmpty()) {
                    while (it < maxLength) {
                        for (i in holeList.indices) {
                            if (it < maxLength) {
                                holeList[i] = holeList[i] + " "
                                it++
                            } else {
                                break
                            }
                        }
//                        val iterate = holeList.listIterator()
//                        while (iterate.hasNext()) {
//                            val oldValue = iterate.next()
//                            if (it < maxLength) {
//                                iterate.set("$oldValue ")
//                                it++
//                            } else {
//                                break
//                            }
//                    }
                    }
                }




                holeList.sortBy { it.length }
                holeList.reverse()

                var iter = 0
                for (hole: String in holeList) {
                    writer.write(wordList[iter])
                    writer.write(hole)
                    iter++
                }
                writer.write(wordList[iter])
            } else {
                writer.newLine()
            }
        }

        writer.newLine()
    }
    writer.close()
}


/**
 * Средняя (14 баллов)
 *
 * Во входном файле с именем inputName содержится некоторый текст (в том числе, и на русском языке).
 *
 * Вернуть ассоциативный массив, содержащий 20 наиболее часто встречающихся слов с их количеством.
 * Если в тексте менее 20 различных слов, вернуть все слова.
 * Вернуть ассоциативный массив с числом слов больше 20, если 20-е, 21-е, ..., последнее слова
 * имеют одинаковое количество вхождений (см. также тест файла input/onegin.txt).
 *
 * Словом считается непрерывная последовательность из букв (кириллических,
 * либо латинских, без знаков препинания и цифр).
 * Цифры, пробелы, знаки препинания считаются разделителями слов:
 * Привет, привет42, привет!!! -привет?!
 * ^ В этой строчке слово привет встречается 4 раза.
 *
 * Регистр букв игнорировать, то есть буквы е и Е считать одинаковыми.
 * Ключи в ассоциативном массиве должны быть в нижнем регистре.
 *
 */
fun top20Words(inputName: String): Map<String, Int> = TODO()

/**
 * Средняя (14 баллов)
 *
 * Реализовать транслитерацию текста из входного файла в выходной файл посредством динамически задаваемых правил.

 * Во входном файле с именем inputName содержится некоторый текст (в том числе, и на русском языке).
 *
 * В ассоциативном массиве dictionary содержится словарь, в котором некоторым символам
 * ставится в соответствие строчка из символов, например
 * mapOf('з' to "zz", 'р' to "r", 'д' to "d", 'й' to "y", 'М' to "m", 'и' to "yy", '!' to "!!!")
 *
 * Необходимо вывести в итоговый файл с именем outputName
 * содержимое текста с заменой всех символов из словаря на соответствующие им строки.
 *
 * При этом регистр символов в словаре должен игнорироваться,
 * но при выводе символ в верхнем регистре отображается в строку, начинающуюся с символа в верхнем регистре.
 *
 * Пример.
 * Входной текст: Здравствуй, мир!
 *
 * заменяется на
 *
 * Выходной текст: Zzdrавствуy, mир!!!
 *
 * Пример 2.
 *
 * Входной текст: Здравствуй, мир!
 * Словарь: mapOf('з' to "zZ", 'р' to "r", 'д' to "d", 'й' to "y", 'М' to "m", 'и' to "YY", '!' to "!!!")
 *
 * заменяется на
 *
 * Выходной текст: Zzdrавствуy, mир!!!
 *
 * Обратите внимание: данная функция не имеет возвращаемого значения
 */
fun transliterate(inputName: String, dictionary: Map<Char, String>, outputName: String) {
    TODO()
}

/**
 * Средняя (12 баллов)
 *
 * Во входном файле с именем inputName имеется словарь с одним словом в каждой строчке.
 * Выбрать из данного словаря наиболее длинное слово,
 * в котором все буквы разные, например: Неряшливость, Четырёхдюймовка.
 * Вывести его в выходной файл с именем outputName.
 * Если во входном файле имеется несколько слов с одинаковой длиной, в которых все буквы разные,
 * в выходной файл следует вывести их все через запятую.
 * Регистр букв игнорировать, то есть буквы е и Е считать одинаковыми.
 *
 * Пример входного файла:
 * Карминовый
 * Боязливый
 * Некрасивый
 * Остроумный
 * БелогЛазый
 * ФиолетОвый

 * Соответствующий выходной файл:
 * Карминовый, Некрасивый
 *
 * Обратите внимание: данная функция не имеет возвращаемого значения
 */
fun chooseLongestChaoticWord(inputName: String, outputName: String) {
    TODO()
}

/**
 * Сложная (22 балла)
 *
 * Реализовать транслитерацию текста в заданном формате разметки в формат разметки HTML.
 *
 * Во входном файле с именем inputName содержится текст, содержащий в себе элементы текстовой разметки следующих типов:
 * - *текст в курсивном начертании* -- курсив
 * - **текст в полужирном начертании** -- полужирный
 * - ~~зачёркнутый текст~~ -- зачёркивание
 *
 * Следует вывести в выходной файл этот же текст в формате HTML:
 * - <i>текст в курсивном начертании</i>
 * - <b>текст в полужирном начертании</b>
 * - <s>зачёркнутый текст</s>
 *
 * Кроме того, все абзацы исходного текста, отделённые друг от друга пустыми строками, следует обернуть в теги <p>...</p>,
 * а весь текст целиком в теги <html><body>...</body></html>.
 *
 * Все остальные части исходного текста должны остаться неизменными с точностью до наборов пробелов и переносов строк.
 * Отдельно следует заметить, что открывающая последовательность из трёх звёздочек (***) должна трактоваться как "<b><i>"
 * и никак иначе.
 *
 * При решении этой и двух следующих задач полезно прочитать статью Википедии "Стек".
 *
 * Пример входного файла:
Lorem ipsum *dolor sit amet*, consectetur **adipiscing** elit.
Vestibulum lobortis, ~~Est vehicula rutrum *suscipit*~~, ipsum ~~lib~~ero *placerat **tortor***,

Suspendisse ~~et elit in enim tempus iaculis~~.
 *
 * Соответствующий выходной файл:
<html>
<body>
<p>
Lorem ipsum <i>dolor sit amet</i>, consectetur <b>adipiscing</b> elit.
Vestibulum lobortis. <s>Est vehicula rutrum <i>suscipit</i></s>, ipsum <s>lib</s>ero <i>placerat <b>tortor</b></i>.
</p>
<p>
Suspendisse <s>et elit in enim tempus iaculis</s>.
</p>
</body>
</html>
 *
 * (Отступы и переносы строк в примере добавлены для наглядности, при решении задачи их реализовывать не обязательно)
 */
fun markdownToHtmlSimple(inputName: String, outputName: String) {
    TODO()
}

/**
 * Сложная (23 балла)
 *
 * Реализовать транслитерацию текста в заданном формате разметки в формат разметки HTML.
 *
 * Во входном файле с именем inputName содержится текст, содержащий в себе набор вложенных друг в друга списков.
 * Списки бывают двух типов: нумерованные и ненумерованные.
 *
 * Каждый элемент ненумерованного списка начинается с новой строки и символа '*', каждый элемент нумерованного списка --
 * с новой строки, числа и точки. Каждый элемент вложенного списка начинается с отступа из пробелов, на 4 пробела большего,
 * чем список-родитель. Максимально глубина вложенности списков может достигать 6. "Верхние" списки файла начинются
 * прямо с начала строки.
 *
 * Следует вывести этот же текст в выходной файл в формате HTML:
 * Нумерованный список:
 * <ol>
 *     <li>Раз</li>
 *     <li>Два</li>
 *     <li>Три</li>
 * </ol>
 *
 * Ненумерованный список:
 * <ul>
 *     <li>Раз</li>
 *     <li>Два</li>
 *     <li>Три</li>
 * </ul>
 *
 * Кроме того, весь текст целиком следует обернуть в теги <html><body><p>...</p></body></html>
 *
 * Все остальные части исходного текста должны остаться неизменными с точностью до наборов пробелов и переносов строк.
 *
 * Пример входного файла:
///////////////////////////////начало файла/////////////////////////////////////////////////////////////////////////////
 * Утка по-пекински
 * Утка
 * Соус
 * Салат Оливье
1. Мясо
 * Или колбаса
2. Майонез
3. Картофель
4. Что-то там ещё
 * Помидоры
 * Фрукты
1. Бананы
23. Яблоки
1. Красные
2. Зелёные
///////////////////////////////конец файла//////////////////////////////////////////////////////////////////////////////
 *
 *
 * Соответствующий выходной файл:
///////////////////////////////начало файла/////////////////////////////////////////////////////////////////////////////
<html>
<body>
<p>
<ul>
<li>
Утка по-пекински
<ul>
<li>Утка</li>
<li>Соус</li>
</ul>
</li>
<li>
Салат Оливье
<ol>
<li>Мясо
<ul>
<li>Или колбаса</li>
</ul>
</li>
<li>Майонез</li>
<li>Картофель</li>
<li>Что-то там ещё</li>
</ol>
</li>
<li>Помидоры</li>
<li>Фрукты
<ol>
<li>Бананы</li>
<li>Яблоки
<ol>
<li>Красные</li>
<li>Зелёные</li>
</ol>
</li>
</ol>
</li>
</ul>
</p>
</body>
</html>
///////////////////////////////конец файла//////////////////////////////////////////////////////////////////////////////
 * (Отступы и переносы строк в примере добавлены для наглядности, при решении задачи их реализовывать не обязательно)
 */
fun markdownToHtmlLists(inputName: String, outputName: String) {
    TODO()
}

/**
 * Очень сложная (30 баллов)
 *
 * Реализовать преобразования из двух предыдущих задач одновременно над одним и тем же файлом.
 * Следует помнить, что:
 * - Списки, отделённые друг от друга пустой строкой, являются разными и должны оказаться в разных параграфах выходного файла.
 *
 */
fun markdownToHtml(inputName: String, outputName: String) {
    TODO()
}

/**
 * Средняя (12 баллов)
 *
 * Вывести в выходной файл процесс умножения столбиком числа lhv (> 0) на число rhv (> 0).
 *
 * Пример (для lhv == 19935, rhv == 111):
19935
 *    111
--------
19935
+ 19935
+19935
--------
2212785
 * Используемые пробелы, отступы и дефисы должны в точности соответствовать примеру.
 * Нули в множителе обрабатывать так же, как и остальные цифры:
235
 *  10
-----
0
+235
-----
2350
 *
 */
fun printMultiplicationProcess(lhv: Int, rhv: Int, outputName: String) {
    TODO()
}


/**
 * Сложная (25 баллов)
 *
 * Вывести в выходной файл процесс деления столбиком числа lhv (> 0) на число rhv (> 0).
 *
 * Пример (для lhv == 19935, rhv == 22):
19935 | 22
-198     906
----
13
-0
--
135
-132
----
3


 * Используемые пробелы, отступы и дефисы должны в точности соответствовать примеру.
 *
 */
fun printDivisionProcess(lhv: Int, rhv: Int, outputName: String) {
    val writer = File(outputName).bufferedWriter()
    var result = ""
    var secondLine = "-"
    var activeNumber = getDigit(lhv, 1)
    var firstValue = 0
    var secondValue = 0
    var freeNumber = 1
    var lastLine = ""

    fun writeNewLine(line: String) {
        writer.newLine()
        writer.write(line)
    }

    var firstLine = if (lhv > rhv || lhv.toString().length <= rhv.toString().length) " $lhv | $rhv" else "$lhv | $rhv"

    for (i in 1..digitNumber(lhv)) {
        if (i != 1) activeNumber = (activeNumber.toString() + getDigit(lhv, freeNumber).toString()).toInt()
        freeNumber = i + 1
        if (activeNumber / rhv > 0) {
            result += (activeNumber / rhv).toString()
            secondLine += (rhv * (activeNumber / rhv)).toString()
            firstValue = activeNumber
            secondValue = rhv * (activeNumber / rhv)
            break
        }
    }

    if (secondValue == 0) secondLine += 0

    secondLine =
        if (lhv > rhv || lhv.toString().length <= rhv.toString().length) {
            secondLine.padEnd(
                (firstLine.length - rhv.toString().length),
                ' '
            ) + "${lhv / rhv}"
        } else {
            " ".repeat(
                lhv.toString().length - 2
            ) + "-0   " + "${lhv / rhv}"
        }
    lastLine = if ((lhv < rhv) && (((rhv * (activeNumber / rhv)).toString().length + 1) < generateFirstLine(
            lhv,
            0,
            lastLine
        ).length)
    ) {

        "-".repeat(generateFirstLine(lhv, 0, lastLine).length + 1)
    } else {
        "-".repeat((rhv * (activeNumber / rhv)).toString().length + 1)
    }


    writer.write(firstLine)
    writeNewLine(secondLine)
    writeNewLine(lastLine)

    if (digitNumber(lhv / rhv) > 1) {
        while (freeNumber <= digitNumber(lhv)) {

            firstLine = generateFirstLine(firstValue, secondValue, lastLine) + getDigit(lhv, freeNumber).toString()

            activeNumber = firstLine.trim().toInt()
            result += (activeNumber / rhv).toString()

            firstValue = firstLine.trim().toInt()
            secondValue = rhv * (result.toInt() % 10)

            lastLine = firstLine
            secondLine = generateSecondLine(secondValue, lastLine)

            writeNewLine(firstLine)
            writeNewLine(secondLine)

            if (secondLine.trim().length >= generateFirstLine(firstValue, secondValue, lastLine).trim().length) {
                writeNewLine(createLine(secondLine))
            } else {
                writeNewLine(createLine(generateFirstLine(firstValue, secondValue, lastLine)))
            }

            freeNumber++
        }
    }

    firstLine =
        if (lhv < rhv) generateFirstLine(lhv, 0, lastLine) else generateFirstLine(firstValue, secondValue, lastLine)

    writeNewLine(firstLine)

    writer.close()

}


fun generateSecondLine(secondValue: Int, lastLine: String): String {
    var res = "-$secondValue"
    while (lastLine.length > res.length) {
        res = " $res"
    }
    return res
}

fun generateFirstLine(firstValue: Int, secondValue: Int, lastLine: String): String {
    var res = (firstValue - secondValue).toString()
    while (lastLine.length > res.length) {
        res = " $res"
    }
    return res
}

fun createLine(previousLine: String): String {
    var line = buildString {
        for (digit: Char in previousLine) {
            if (digit == ' ') append(" ") else append("-")
        }
    }
    return line
}

fun getDigit(num: Int, position: Int): Int {
    if (num < 10) return num
    val del = (10.0).pow((lesson3.task1.digitNumber(num) - position))
    return if (del < 10) num % 10 else num / del.toInt() % 10
}

fun testOne() {
    val string = "xxt\ndfe\ndff"

    var desk = string.split("\n").map { it.toMutableList() }.toMutableList()
    var maP = mutableMapOf<String, Int>()
    maP["a"] = 2
    val maR = maP.map { it -> it.key }


    val pattern = Regex(".+:.+")
    val eq = pattern.matches("dfdf : dfdf")
    println(maR)
}


fun robot(input: String) {
    var flag = true
    val rows = File(input).readLines().toMutableList()
    var map: MutableList<MutableList<String>> = mutableListOf()
    var startPoint: Pair<Int, Int>? = null
    var finishPoint: Pair<Int, Int>? = null
    for (row: String in rows) {
        map.add(row.chunked(1).toMutableList())
    }
    var d = 1
    for (row: MutableList<String> in map) {
        for (sell: String in row) {
            if (sell == "*") {
                startPoint = Pair(map.indexOf(row), row.indexOf(sell))
            }
            if (sell == "^") {
                finishPoint = Pair(map.indexOf(row), row.indexOf(sell))
            }
        }
    }

    fun printMap() {
        for (row: List<String> in map) {
            println(row)
        }
        println()
    }

    fun asseptive(char: String): Boolean = char == "." || char == "^"

    fun addToWave() {
        flag = false
        for (row: MutableList<String> in map) {
            for (i in 0 until row.size) {
                var triger = Pair(map.indexOf(row), i)
                if (map[map.indexOf(row)][i] == (d - 1).toString()) {
                    if (triger.second + 1 in 0 until map[0].size) {
                        if (asseptive(map[triger.first][triger.second + 1])) {
                            map[triger.first][triger.second + 1] = (d).toString()
                            flag = true
                        }
                    }
                    if (triger.second - 1 in 0 until map[0].size) {
                        if (asseptive(map[triger.first][triger.second - 1])) {
                            map[triger.first][triger.second - 1] = (d).toString()
                            flag = true
                        }
                    }
                    if (triger.first + 1 in 0 until map.size) {
                        if (asseptive(map[triger.first + 1][triger.second])) {
                            map[triger.first + 1][triger.second] = (d).toString()
                            flag = true
                        }
                    }
                    if (triger.first - 1 in 0 until map.size) {
                        if (asseptive(map[triger.first - 1][triger.second])) {
                            map[triger.first - 1][triger.second] = (d).toString()
                            flag = true
                        }
                    }
                }
            }
        }
    }
    if (startPoint != null) {
        if (startPoint.second + 1 in 0 until map[0].size) {
            if (asseptive(map[startPoint.first][startPoint.second + 1])) {
                map[startPoint.first][startPoint.second + 1] = (d).toString()
            }
        }
        if (startPoint.second - 1 in 0 until map[0].size) {
            if (asseptive(map[startPoint.first][startPoint.second - 1])) {
                map[startPoint.first][startPoint.second - 1] = (d).toString()
            }
        }
        if (startPoint.first + 1 in 0 until map.size) {
            if (asseptive(map[startPoint.first + 1][startPoint.second])) {
                map[startPoint.first + 1][startPoint.second] = (d).toString()
            }
        }
        if (startPoint.first - 1 in 0 until map.size) {
            if (asseptive(map[startPoint.first - 1][startPoint.second])) {
                map[startPoint.first - 1][startPoint.second] = (d).toString()
            }
        }
    }

    if (finishPoint != null) {
        while (map[finishPoint.first][finishPoint.second] == "^" && flag) {
            d++
            addToWave()

        }
    }
    printMap()

}



























