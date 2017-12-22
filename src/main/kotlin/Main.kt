import java.util.*
import java.util.Random



fun main(args: Array<String>){
    var startTime : Long
    var endTime : Long
    val maxIndex = 10000000
    val maxNumber = 10000

    val random = Random()

    val max = maxNumber
    val min = 1



//    startTime = System.currentTimeMillis()
//    for (index in 0..maxIndex){
//        val numberA = rand.nextInt(maxNumber) + 1
//        val numberB = rand.nextInt(maxNumber) + 1
//        getGreatestCommonDivisor_00( numberA, numberB)
//    }
//    endTime = System.currentTimeMillis()
//    println("getGreatestCommonDivisor_00 use" + (endTime - startTime))

    startTime = System.currentTimeMillis()
    for (index in 0..maxIndex){
        val numberA = random.nextInt(max) % (max - min + 1) + min
        val numberB = random.nextInt(max) % (max - min + 1) + min
        getGreatestCommonDivisor_01(numberA, numberB)
    }
    endTime = System.currentTimeMillis()
    println("getGreatestCommonDivisor_01 use" + (endTime - startTime))

    startTime = System.currentTimeMillis()
    for (index in 0..maxIndex){
        val numberA = random.nextInt(maxNumber) + 1
        val numberB = random.nextInt(maxNumber) + 1
        getGreatestCommonDivisor_02( numberA, numberB)
    }
    endTime = System.currentTimeMillis()
    println("getGreatestCommonDivisor_02 use" + (endTime - startTime))

    startTime = System.currentTimeMillis()
    for (index in 0..maxIndex){
        val numberA = random.nextInt(max) % (max - min + 1) + min
        val numberB = random.nextInt(max) % (max - min + 1) + min
        getGreatestCommonDivisor_03(numberA, numberB)
    }
    endTime = System.currentTimeMillis()
    println("getGreatestCommonDivisor_03 use" + (endTime - startTime))
}



//遍历方法
fun getGreatestCommonDivisor_00(numberA: Int , numberB: Int) : Int{
    val bignumber : Int
    val smallnumber : Int
    var greatestCommonDivisor = 1

    if (numberA > numberB) {
        bignumber = numberA
        smallnumber = numberB
    }else{
        bignumber = numberB
        smallnumber = numberA
    }

    if (bignumber % smallnumber == 0){
        greatestCommonDivisor = smallnumber
    }else{
        for (index in 2..smallnumber / 2 ){
            if( (bignumber % index == 0) && (smallnumber % index == 0) ){
                greatestCommonDivisor = index
            }
        }
    }
    return greatestCommonDivisor
}


//碾转相除法方法入口
fun getGreatestCommonDivisor_01(numberA: Int , numberB: Int) : Int {
    var greatestCommonDivisor : Int
    if (numberA > numberB) {
        greatestCommonDivisor = gcd(numberA, numberB)
    }else {
        greatestCommonDivisor = gcd(numberB, numberA)
    }

    return greatestCommonDivisor
}

//碾转相除法方法递归函数
fun gcd(numberA: Int , numberB: Int) : Int {
    if (numberA % numberB == 0){
        return numberB
    }else{
        return gcd(numberB , numberA % numberB)
    }
}

//更相减损术方法
fun getGreatestCommonDivisor_02(numberA: Int , numberB: Int) : Int {
    if (numberA == numberB) {
        return numberB
    }else if (numberA > numberB) {
        return getGreatestCommonDivisor_02(numberA - numberB , numberB)
    }else{
        return getGreatestCommonDivisor_02(numberB - numberA , numberA)
    }
}

//Stein算法
fun getGreatestCommonDivisor_03(numberA: Int , numberB: Int) : Int {
    if (numberA == numberB) {
        return numberB
    }
    if (numberA < numberB) {
        return getGreatestCommonDivisor_03(numberB, numberA)
    } else {
        if (isEven(numberA) && isEven(numberB)) {
            return getGreatestCommonDivisor_03(numberA.shr(1),
                    numberB.shr(1)).shl(1)
        } else if (isEven(numberA) && !isEven(numberB)) {
            return getGreatestCommonDivisor_03(numberA.shr(1), numberB)
        } else if (!isEven(numberA) && isEven(numberB)) {
            return getGreatestCommonDivisor_03(numberA, numberB.shr(1))
        } else {
            return getGreatestCommonDivisor_03(numberB, numberA - numberB)
        }
    }
}

//判断是否为偶数
fun isEven(number : Int): Boolean {
    return number and 1 == 0
}

