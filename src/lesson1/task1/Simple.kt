@file:Suppress("UNUSED_PARAMETER")

package lesson1.task1

import java.lang.IllegalStateException
import kotlin.math.pow
import kotlin.math.sqrt

// Урок 1: простые функции
// Максимальное количество баллов = 5
// Рекомендуемое количество баллов = 4


/**
 * Пример
 *
 * Вычисление квадрата целого числа
 */
fun sqr(x: Int) = x * x

/**
 * Пример
 *
 * Вычисление квадрата вещественного числа
 */
fun sqr(x: Double) = x * x

/**
 * Пример
 *
 * Вычисление дискриминанта квадратного уравнения
 */
fun discriminant(a: Double, b: Double, c: Double) = sqr(b) - 4 * a * c

/**
 * Пример
 *
 * Поиск одного из корней квадратного уравнения
 */
fun quadraticEquationRoot(a: Double, b: Double, c: Double) =
    (-b + sqrt(discriminant(a, b, c))) / (2 * a)

/**
 * Пример
 *
 * Поиск произведения корней квадратного уравнения
 */
fun quadraticRootProduct(a: Double, b: Double, c: Double): Double {
    val sd = sqrt(discriminant(a, b, c))
    val x1 = (-b + sd) / (2 * a)
    val x2 = (-b - sd) / (2 * a)
    return x1 * x2 // Результат
}

/**
 * Пример главной функции
 */

/**
 * Тривиальная (3 балла).
 *
 * Задача имеет повышенную стоимость как первая в списке.
 *
 * Пользователь задает время в часах, минутах и секундах, например, 8:20:35.
 * Рассчитать время в секундах, прошедшее с начала суток (30035 в данном случае).
 */
fun seconds(hours: Int, minutes: Int, seconds: Int): Int = 60 * (60 * hours + minutes) + seconds

/**
 * Тривиальная (1 балл)
 *
 * Пользователь задает длину отрезка в саженях, аршинах и вершках (например, 8 саженей 2 аршина 11 вершков).
 * Определить длину того же отрезка в метрах (в данном случае 18.98).
 * 1 сажень = 3 аршина = 48 вершков, 1 вершок = 4.445 см.
 */
fun lengthInMeters(sagenes: Int, arshins: Int, vershoks: Int): Double =
    arshins * 0.7112 + vershoks * 0.04445 + sagenes * 2.1336

/**
 * Тривиальная (1 балл)
 *
 * Пользователь задает угол в градусах, минутах и секундах (например, 36 градусов 14 минут 35 секунд).
 * Вывести значение того же угла в радианах (например, 0.63256).
 */
fun angleInRadian(deg: Int, min: Int, sec: Int): Double = TODO()

/**
 * Тривиальная (1 балл)
 *
 * Найти длину отрезка, соединяющего точки на плоскости с координатами (x1, y1) и (x2, y2).
 * Например, расстояние между (3, 0) и (0, 4) равно 5
 */
fun trackLength(x1: Double, y1: Double, x2: Double, y2: Double): Double = TODO()

/**
 * Простая (2 балла)
 *
 * Пользователь задает целое число, большее 100 (например, 3801).
 * Определить третью цифру справа в этом числе (в данном случае 8).
 */
fun thirdDigit(number: Int): Int = TODO()

/**
 * Простая (2 балла)
 *
 * Поезд вышел со станции отправления в h1 часов m1 минут (например в 9:25) и
 * прибыл на станцию назначения в h2 часов m2 минут того же дня (например в 13:01).
 * Определите время поезда в пути в минутах (в данном случае 216).
 */
fun travelMinutes(hoursDepart: Int, minutesDepart: Int, hoursArrive: Int, minutesArrive: Int): Int = TODO()

/**
 * Простая (2 балла)
 *
 * Человек положил в банк сумму в s рублей под p% годовых (проценты начисляются в конце года).
 * Сколько денег будет на счету через 3 года (с учётом сложных процентов)?
 * Например, 100 рублей под 10% годовых превратятся в 133.1 рубля
 */
fun accountInThreeYears(initial: Int, percent: Int): Double =
    initial.toDouble() * ((1 + percent.toDouble() / 100).toDouble()).pow(3)

/**
 * Простая (2 балла)
 *
 * Пользователь задает целое трехзначное число (например, 478).
 * Необходимо вывести число, полученное из заданного перестановкой цифр в обратном порядке (например, 874).
 */
fun numberRevert(number: Int): Int {
    var first = number / 100
    var second = number % 100 / 10
    var third = number % 10
    return (third.toString() + second.toString() + first.toString()).toInt()
}


fun main() {
    val ex = "НЕ X1 ИЛИ X2 ИЛИ X3"
    val vals = "X1 = истина\nX2 = ложь"
    myFun(ex, vals)
}


fun myFun(expr: String, vars: String): String {
//    val reg = Regex("(((НЕ|ИЛИ)\\s..)+(\\s|\$))|(..\\s(НЕ|ИЛИ))(\\s|\$)||(..)")
//    if (!reg.matches(expr)) {
//        throw IllegalStateException("Некорректное выражение")
//    }
    fun revert(x: String) = if (x == "1") "0" else "1"
    fun or(x: String, y: String) = if (x == "1" || y == "1") "1" else "0"

    var expression = expr.split(" ").toMutableList()
    val varsList = vars.split("\n")
    var variables = mutableMapOf<String, Int>()
    for (singleVar: String in varsList) {
        var name = singleVar.split(" ")[0]
        var znach = if (singleVar.split(" = ")[1] == "истина") 1 else 0
        variables[name] = znach
    }

    var expressionInWorkForm = mutableListOf<String>()
    for (element: String in expression) {
        if (variables.containsKey(element)) {
            expressionInWorkForm.add(variables[element].toString())
        } else if(element == "НЕ"|| element == "ИЛИ"){
            expressionInWorkForm.add(element)
        }else{
            throw IllegalStateException("no")
        }
    }
    println(expressionInWorkForm)

    while (expressionInWorkForm.size > 1) {
        if (expressionInWorkForm.contains("НЕ")) {
            expressionInWorkForm[expressionInWorkForm.indexOf("НЕ") + 1] =
                revert(expressionInWorkForm[expressionInWorkForm.indexOf("НЕ") + 1])
            expressionInWorkForm.removeAt(expression.indexOf("НЕ"))
        }
        if (expressionInWorkForm.contains("ИЛИ")) {
            var index = expressionInWorkForm.indexOf("ИЛИ")
            expressionInWorkForm[expressionInWorkForm.indexOf("ИЛИ")] = or(
                expressionInWorkForm[expressionInWorkForm.indexOf("ИЛИ") - 1],
                expressionInWorkForm[expressionInWorkForm.indexOf("ИЛИ") + 1]
            )
            expressionInWorkForm.removeAt(index + 1)
            expressionInWorkForm.removeAt(index - 1)
        }
    }
    println(expressionInWorkForm)
    return if (expressionInWorkForm[0] == "0") "ИСТИНА" else "ЛОЖЬ"
}






























