import java.awt.geom.AffineTransform
import java.awt.geom.Area
import java.awt.geom.Rectangle2D
import kotlin.math.PI

fun main(args: Array<String>) {

    var calcR2 = Rectangle(Pair(0,0), Pair(0,1), Pair(1,1), Pair(1,0))
    var pivot = Pair(1L,1L)
    val startVector = Pair(1L,1L)
    var endVector  : Pair<Long, Long> = startVector
    println("WIDTH :  1   HEIGHT: 1")
    for (i in 1..100) {
        val shape = calcR2.rotate90degress(pivot)
        endVector = plusVector(endVector, rotateVector(endVector))
        pivot = endVector
        val maxShape = calcR2.maxRectangleOfTwo(shape)
        calcR2 = maxShape
        val maxX = abs(maxShape.getAllX().min()) + abs(maxShape.getAllX().max())
        val maxY = abs(maxShape.getAllY().min()) + abs(maxShape.getAllY().max())
        println("WIDTH :  $maxX   HEIGHT: $maxY")

    }

}

fun calculateBends(n: Int): Int {
    // The number of bends (B) for n is given by B = 2^(n-1).
    return Math.pow(2.0, (n).toDouble()).toInt() - 1

}

