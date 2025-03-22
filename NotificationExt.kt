
data class Notification(val timeStamp:Long , val name:String)

fun List<Notification>.filterRecent() : List<Notification> {

    return this.filter{it.timeStamp > (System.currentTimeMillis() - 24 * 60 * 60 * 1000)} //Filter items within 24 hrs
}
fun main() {
    val recentNotificationsList = listOf(
        Notification(System.currentTimeMillis() - 60 * 1000, "Min Back"),
        Notification(System.currentTimeMillis() - 30 * 60 * 60 * 1000, "30 hours back"),
        Notification(System.currentTimeMillis() - 26 * 60 * 60 * 1000, "26 hours back"),
        Notification(System.currentTimeMillis() - 23 * 60 * 1000, "23 hrs back")
    )

    println(recentNotificationsList.filterRecent())
}