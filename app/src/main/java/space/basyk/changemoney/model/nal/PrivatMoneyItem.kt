package space.basyk.changemoney.model.nal

data class PrivatMoneyItem(
    val base_ccy: String,
    val buy: String,
    val ccy: String,
    val sale: String
)