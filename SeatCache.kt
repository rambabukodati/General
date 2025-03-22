class SeatCache(private val capacity:Int=100) {

    private val seatCacheMap :LinkedHashMap<String,Boolean> = object : LinkedHashMap<String, Boolean>(capacity,0.75f, true) {
        override fun removeEldestEntry(eldest:Map.Entry<String, Boolean>?) : Boolean {
            return seatCacheMap.size > capacity
        }

    }

    fun put(seatId:String, isReserved:Boolean) {
        seatCacheMap[seatId] = isReserved

    }

    fun get(seatId:String) : Boolean? {
        return seatCacheMap[seatId]
    }
}

fun main() {
    val seatCache = SeatCache()

    seatCache.put("A1", true)
    seatCache.put("A2", false)
    for(i in 1..100) {
        seatCache.put("A$i", i%2 == 1)
    }

    seatCache.put("A101", true)
    seatCache.put("A102", true)

    seatCache.put("A103", true)
    seatCache.put("A104", true)

    println(seatCache.get("A1")) //prints null
    println(seatCache.get("A5")) //prints true
}