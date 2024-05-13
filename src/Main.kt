import kotlin.random.Random

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
   //1
   val array = arrayOf(
      arrayOf(2, 5, 0),
      arrayOf(-3, 9, -7),
      arrayOf(4, 8, -4)
   )
   var min = array[0][0]
   for (i in array.indices){
      for (j in array[i].indices){
         if (min > array[i][j])min = array[i][j]
      }
   }
   println("Минимальное число массива = $min")
   //2
   val random = Random
   val array2: Array<Array<Int>> = Array(3) { Array(5) { random.nextInt(-10,10) } }
   for (i in array2.indices){
      for (j in array2[i].indices){
         print("${array2[i][j]}\t")
      }
      println()
   }
   println("Медиана равна ${findMedian(array2)}")
//3
   var massiv: Array<Array<Int>> = Array(5){ Array(5) {0} }
   for (i in massiv.indices){
      for (j in massiv.indices){
         if (i >= j && i + j >= 4) massiv[i][j] = 1
      }
   }
   for (i in massiv.indices){
      for (j in massiv.indices){
         print("${massiv[i][j]}\t")
      }
      println()
   }
//4
   val array3 = IntArray(10){random.nextInt(-10, 10 )}
   for (i in array3.indices){
      for (j in array3.indices){
         if (array3[i] < array3[j]) {
            array3[i] += array3[j]
            array3[j] = array3[i] - array3[j]
            array3[i] -= array3[j]
         }
      }
   }
   var num = 0
   loop@for (i in (array3.size - 1) downTo 0 ){
      if(array3[i] > array3[i-1]){
         num = array3[i-1]
         break@loop
      }
   }
   for (i in array3){
      print("$i ")
   }
   println()
   println("Второе максимальное число = $num")
}
fun findMedian(array: Array<Array<Int>>):Int{
   val newArray = IntArray(15)
   var k = 0
   for (i in array.indices){
      for(j in array[i].indices){
         newArray[k] = array[i][j]
         k++
      }
   }

   for (i in newArray.indices){
      for (j in newArray.indices){
         if (newArray[i] < newArray[j]) {
            newArray[i] += newArray[j]
            newArray[j] = newArray[i] - newArray[j]
            newArray[i] -= newArray[j]
         }
      }
   }
   return newArray[newArray.size / 2]
}