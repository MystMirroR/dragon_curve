import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin


class Rectangle(val A: Pair<Long, Long>, val B: Pair<Long, Long>, val C: Pair<Long, Long>, val D: Pair<Long, Long>) {
    override fun toString(): String {
        return "A : ${A.first} ${A.second} , B ${B.first} ${B.second}, C ${C.first} ${C.second} , D ${D.first} ${D.second}"
    }


    fun getAllX(): List<Long> {

        return listOf(this.A.first, this.B.first, this.C.first, this.D.first)
    }

    fun getAllY(): List<Long> {

        return listOf(this.A.second, this.B.second, this.C.second, this.D.second)
    }
}

fun Rectangle.rotate90degress(pivot: Pair<Long, Long>): Rectangle {
    val ax = this.A.first - pivot.first
    val ay = this.A.second - pivot.second
    val a1x = (ax * cos(3 * PI / 2) + ay * sin(3 * PI / 2) + pivot.first).toLong()
    val a1y = (-ax * sin(3 * PI / 2) + ay * cos(3 * PI / 2) + pivot.second).toLong()

    val bx = this.B.first - pivot.first
    val by = this.B.second - pivot.second
    val b1x = (bx * cos(3 * PI / 2) + by * sin(3 * PI / 2) + pivot.first).toLong()
    val b1y = (-bx * sin(3 * PI / 2) + by * cos(3 * PI / 2) + pivot.second).toLong()

    val cx = this.C.first - pivot.first
    val cy = this.C.second - pivot.second
    val c1x = (cx * cos(3 * PI / 2) + cy * sin(3 * PI / 2) + pivot.first).toLong()
    val c1y = (-cx * sin(3 * PI / 2) + cy * cos(3 * PI / 2) + pivot.second).toLong()

    val dx = this.D.first - pivot.first
    val dy = this.D.second - pivot.second
    val d1x = (dx * cos(3 * PI / 2) + dy * sin(3 * PI / 2) + pivot.first).toLong()
    val d1y = (-dx * sin(3 * PI / 2) + dy * cos(3 * PI / 2) + pivot.second).toLong()

    return Rectangle(Pair(a1x, a1y), Pair(b1x, b1y), Pair(c1x, c1y), Pair(d1x, d1y))
}

private operator fun Pair<Long, Long>.plus(second: Pair<Long, Long>): Pair<Long, Long> {
    return Pair(this.first + second.first, this.second + second.second)
}

fun rotateVector(pair: Pair<Long, Long>): Pair<Long, Long> {
    val first = pair.second
    val second = -pair.first
    return Pair(first, second)
}

fun Rectangle.maxRectangleOfTwo(rect: Rectangle): Rectangle {
    var maxX = this.getAllX().plus(rect.getAllX()).max()
    var maxY = this.getAllY().plus(rect.getAllY()).max()
    var minX = this.getAllX().plus(rect.getAllX()).min()
    var minY = this.getAllY().plus(rect.getAllY()).min()

    return Rectangle(Pair(minX, minY), Pair(minX, maxY), Pair(maxX, maxY), Pair(maxX, minY))
}


fun abs(i: Long): Long {
    return if (i < 0) {
        -i
    } else {
        i
    }
}


fun plusVector(v1: Pair<Long, Long>, v2: Pair<Long, Long>): Pair<Long, Long> {
    return Pair(v1.first + v2.first, v1.second + v2.second)
}