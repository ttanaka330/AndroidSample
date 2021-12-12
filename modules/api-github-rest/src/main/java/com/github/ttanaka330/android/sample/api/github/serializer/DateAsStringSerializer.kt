package com.github.ttanaka330.android.sample.api.github.serializer

import android.annotation.SuppressLint
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.text.SimpleDateFormat
import java.util.Date

object DateAsStringSerializer : KSerializer<Date> {

    @SuppressLint("SimpleDateFormat")
    private val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Date", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: Date) {
        val string = formatter.format(value)
        encoder.encodeString(string)
    }

    override fun deserialize(decoder: Decoder): Date {
        val string = decoder.decodeString()
        return formatter.parse(string)
    }
}
