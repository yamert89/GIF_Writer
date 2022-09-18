package softoad.gif


class GIFBuilder {
    private val outBytes: MutableList<Int> = mutableListOf();

    fun build(){
        buildHeader()

    }


    private fun buildHeader(){
        append(0x47, 0x49, 0x46, 0x38, 0x39, 0x61)
    }

    private fun buildScreenData(width: Int, height: Int){ //todo limit size
        val wBytes = width.convertToBytes()
        val hBytes = height.convertToBytes()
        append(wBytes.first, wBytes.second, hBytes.first, hBytes.second)
    }
    /* @return pair of (low byte) to (high byte */
    private fun Int.convertToBytes(): Pair<Int, Int>{
        if (this < 256) return this to 0
        val hex = Integer.toHexString(this)
        val first = hex.substring(hex.lastIndex - 1)
        val second = hex.substringBefore(first)
        return first.toInt(16) to second.toInt(16)
    }

    private fun append(vararg byte: Int) {
        outBytes.addAll(byte.toList())
    }

}